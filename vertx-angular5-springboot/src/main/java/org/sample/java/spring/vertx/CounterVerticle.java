package org.sample.java.spring.vertx;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.handler.sockjs.SockJSHandler;
import org.sample.java.spring.vertx.service.CounterService;
import org.sample.java.spring.vertx.service.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CounterVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterVerticle.class);
    private static final String CONFIG_HTTP_SERVER_PORT = "http.server.port";

    @Autowired
    CounterService counterService;

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        LOGGER.info("Start it...");

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
        BridgeOptions bridgeOptions = new BridgeOptions()
                .addInboundPermitted(new PermittedOptions().setAddress("counter::actions"))
                .addInboundPermitted(new PermittedOptions().setAddress("counter::total"))
                .addOutboundPermitted(new PermittedOptions().setAddress("counter::actions"));

//        sockJSHandler.bridge(bridgeOptions);
        sockJSHandler.bridge(bridgeOptions, bridgeEvent -> {
            LOGGER.info("type: " + bridgeEvent.type().name() + " message: " + bridgeEvent.getRawMessage());
            if (bridgeEvent.type() == BridgeEventType.PUBLISH) {
                JsonObject message = bridgeEvent.getRawMessage();
                String event = message.getJsonObject("body").getValue("type").toString();
                counterService.handleEvent(EventType.fromString(event));
            }
            bridgeEvent.complete(true);

        });

        router.route("/eventbus/*").handler(sockJSHandler);

        // todo: wieso ist hier der SockJSHandler notwendig?
        // warum nicht einfach nur
        // EventBus eb = vertx.eventBus();

        // WO WIRD HIER DIE ADRESSE UUID IN DEM REPLY GESETZT? 34533-SARAR-234234-23423 ?????
        vertx.eventBus().<JsonObject>consumer("counter::total", msg -> {
            LOGGER.info("got message: " + msg.body().encode());
            int count = counterService.getTotal();
            ReplyMessage replyMessage = new ReplyMessage(count);
            LOGGER.info("count: " + String.valueOf(count));
            msg.reply(JsonObject.mapFrom(replyMessage));
        });

        // warum hier config().... wie kann ich die Konfiguration setzen? http.server.port
        int portNumber = config().getInteger(CONFIG_HTTP_SERVER_PORT, 8080);
        server
                .requestHandler(router::accept)
                .rxListen(portNumber)
                .subscribe(s -> {
                    LOGGER.info("HTTP server running on port " + portNumber);
//                    startFuture.complete();
                }, t -> {
                    LOGGER.error("Could not start a HTTP server", t);
//                    startFuture.fail(t);
                });


    }
}
