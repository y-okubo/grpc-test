
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.logging.Logger;
import proto.AwesomeServiceGrpc;
import proto.AwesomeServiceOuterClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yuki
 */
public class AwesomeServiceServer {

    private static final Logger logger = Logger.getLogger(AwesomeServiceServer.class.getName());

    /* The port on which the server should run */
    private final int port = 50051;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(AwesomeServiceGrpc.bindService(new AwesomeServiceImpl()))
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                AwesomeServiceServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final AwesomeServiceServer server = new AwesomeServiceServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class AwesomeServiceImpl implements AwesomeServiceGrpc.AwesomeService {

        @Override
        public void listPerson(AwesomeServiceOuterClass.RequestType request, StreamObserver<AwesomeServiceOuterClass.Person> responseObserver) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addPerson(AwesomeServiceOuterClass.Person request, StreamObserver<AwesomeServiceOuterClass.ResponseType> responseObserver) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
