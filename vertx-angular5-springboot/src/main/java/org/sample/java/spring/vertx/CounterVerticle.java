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
import org.sample.java.spring.vertx.model.ReplyMessage;
import org.sample.java.spring.vertx.service.CounterService;
import org.sample.java.spring.vertx.service.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CounterVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterVerticle.class);

    @Value("${server.port}")
    private int portNumber;

    @Autowired
    CounterService counterService;

    @Override
    public void start(Future<Void> startFuture) {

        LOGGER.info("Start it...");

        Router router = Router.router(vertx);

        // Allow events for the designated addresses in/out of the event bus bridge
        BridgeOptions bridgeOptions = new BridgeOptions()
                .addInboundPermitted(new PermittedOptions().setAddress("counter::actions"))
                .addInboundPermitted(new PermittedOptions().setAddress("counter::total"))
                .addOutboundPermitted(new PermittedOptions().setAddress("counter::actions"));

        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
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

        // Start the web server and tell it to use the router to handle requests.
        vertx.createHttpServer().requestHandler(router::accept).listen(portNumber);

        // Register to listen for messages coming IN to the server
        vertx.eventBus().<JsonObject>consumer("counter::total", msg -> {
            int count = counterService.getTotal();
            LOGGER.info("got message - address: " + msg.getDelegate().address());
            LOGGER.info("current count: " + String.valueOf(count));
            msg.reply(JsonObject.mapFrom(new ReplyMessage(count)));
        });

    }
}
