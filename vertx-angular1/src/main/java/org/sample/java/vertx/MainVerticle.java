package org.sample.java.vertx;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Single;

public class MainVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        LOGGER.info("Start it...");

        Single<String> dbVerticleDeployment = vertx.rxDeployVerticle("org.sample.java.vertx.database.WikiDatabaseVerticle");

        dbVerticleDeployment.flatMap(id -> {
            return vertx.rxDeployVerticle("org.sample.java.vertx.http.HttpServerVerticle",
                    new DeploymentOptions().setInstances(2));
        }).subscribe(
                id -> startFuture.complete(),
                startFuture::fail
        );
    }
}