package org.sample.java.vertx.database;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.serviceproxy.ServiceBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class WikiDatabaseVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiDatabaseVerticle.class);

    private static final String CONFIG_WIKIDB_JDBC_URL = "wikidb.jdbc.url";
    private static final String CONFIG_WIKIDB_JDBC_DRIVER_CLASS = "wikidb.jdbc.driver_class";
    private static final String CONFIG_WIKIDB_JDBC_MAX_POOL_SIZE = "wikidb.jdbc.max_pool_size";
    private static final String CONFIG_WIKIDB_SQL_QUERIES_RESOURCE_FILE = "wikidb.sqlqueries.resource.file";
    private static final String CONFIG_WIKIDB_QUEUE = "wikidb.queue";

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        LOGGER.info("Start it...");

        HashMap<SqlQuery, String> sqlQueries = loadSqlQueries();

        JDBCClient dbClient = JDBCClient.createShared(vertx, new JsonObject()
                .put("url", config().getString(CONFIG_WIKIDB_JDBC_URL, "jdbc:hsqldb:file:db/wiki"))
                .put("driver_class", config().getString(CONFIG_WIKIDB_JDBC_DRIVER_CLASS, "org.hsqldb.jdbcDriver"))
                .put("max_pool_size", config().getInteger(CONFIG_WIKIDB_JDBC_MAX_POOL_SIZE, 30)));

        WikiDatabaseService.create(dbClient, sqlQueries, ready -> {
            if (ready.succeeded()) {
                new ServiceBinder(vertx)
                        .setAddress(CONFIG_WIKIDB_QUEUE)
                        .register(WikiDatabaseService.class, ready.result());
                startFuture.complete();
            } else {
                startFuture.fail(ready.cause());
            }
        });
    }

    /*
     * Note: this uses blocking APIs, but data is small...
     */
    private HashMap<SqlQuery, String> loadSqlQueries() throws IOException {

        String queriesFile = config().getString(CONFIG_WIKIDB_SQL_QUERIES_RESOURCE_FILE);
        InputStream queriesInputStream;
        if (queriesFile != null) {
            queriesInputStream = new FileInputStream(queriesFile);
        } else {
            queriesInputStream = getClass().getResourceAsStream("/db-queries.properties");
        }

        Properties queriesProps = new Properties();
        queriesProps.load(queriesInputStream);
        queriesInputStream.close();

        HashMap<SqlQuery, String> sqlQueries = new HashMap<>();
        sqlQueries.put(SqlQuery.CREATE_PAGES_TABLE, queriesProps.getProperty("create-pages-table"));
        sqlQueries.put(SqlQuery.ALL_PAGES, queriesProps.getProperty("all-pages"));
        sqlQueries.put(SqlQuery.GET_PAGE, queriesProps.getProperty("get-page"));
        sqlQueries.put(SqlQuery.CREATE_PAGE, queriesProps.getProperty("create-page"));
        sqlQueries.put(SqlQuery.SAVE_PAGE, queriesProps.getProperty("save-page"));
        sqlQueries.put(SqlQuery.DELETE_PAGE, queriesProps.getProperty("delete-page"));
        sqlQueries.put(SqlQuery.ALL_PAGES_DATA, queriesProps.getProperty("all-pages-data"));
        sqlQueries.put(SqlQuery.GET_PAGE_BY_ID, queriesProps.getProperty("get-page-by-id"));
        return sqlQueries;
    }
}
