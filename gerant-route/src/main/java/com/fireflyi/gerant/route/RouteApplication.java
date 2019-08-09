package com.fireflyi.gerant.route;

import com.fireflyi.gerant.route.ucenter.service.impl.UcenterServiceImpl;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public class RouteApplication {
    private static final Logger logger = LoggerFactory.getLogger(RouteApplication.class);

    @Inject
    @Named("route.server.prot")
    private Integer port;

    private Server server;

    @Inject
    private UcenterServiceImpl ucenterService;

    @Inject
    private void start() throws IOException, InterruptedException {
        server = ServerBuilder.forPort(port)
                .addService(ucenterService)
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("*** shutting down gRPC RouteApplication since JVM is shutting down");
                RouteApplication.this.stop();
                logger.info("*** RouteApplication shut down");
            }
        });

        blockUntilShutdown();
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

}
