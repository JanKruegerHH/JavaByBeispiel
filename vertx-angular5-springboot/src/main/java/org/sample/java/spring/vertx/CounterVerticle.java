package org.sample.java.spring.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import org.sample.java.spring.vertx.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;


public class CounterVerticle extends AbstractVerticle {

    @Autowired
    CounterService counterService;

// see https://github.com/benorama/ngrx-realtime-app/blob/master/server/src/main/groovy/CounterVerticle.groovy


    @Override
    public void start(Future<Void> startFuture) throws Exception {

        Future<Void> future = Future.future();

        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

//        router.route().handler(CookieHandler.create());
//        router.route().handler(BodyHandler.create());
//        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));
//
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
//        BridgeOptions bridgeOptions = new BridgeOptions()
//                .addInboundPermitted(new PermittedOptions().setAddress("app.markdown"))
//                .addOutboundPermitted(new PermittedOptions().setAddress("page.saved"));
//
//        sockJSHandler.bridge(bridgeOptions);
//
        router.route("/eventbus/*").handler(sockJSHandler);

//        return future;
    }
}
