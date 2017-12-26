package org.sample.java.vertx;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;
import rx.Single;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        Single<String> dbVerticleDeployment = vertx.rxDeployVerticle("org.sample.java.vertx.database.WikiDatabaseVerticle");

        dbVerticleDeployment.flatMap(id -> {
            return vertx.rxDeployVerticle("org.sample.java.vertx.http.HttpServerVerticle",
                    new DeploymentOptions().setInstances(2));
        }).subscribe(
                id -> startFuture.complete(),
                startFuture::fail);
    }
}