
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
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
public class AwesomeServiceClient {

    private static final Logger logger = Logger.getLogger(AwesomeServiceClient.class.getName());

    private final ManagedChannel channel;
    private final AwesomeServiceGrpc.AwesomeServiceBlockingStub blockingStub;

    /**
     * Construct client connecting to HelloWorld server at {@code host:port}.
     */
    public AwesomeServiceClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();
        blockingStub = AwesomeServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Say hello to server.
     */
    public void addPerson() {
        AwesomeServiceOuterClass.Person person = AwesomeServiceOuterClass.Person.newBuilder().build();
        AwesomeServiceOuterClass.RequestType request = AwesomeServiceOuterClass.RequestType.newBuilder().build();
        AwesomeServiceOuterClass.ResponseType response;
        try {
            response = blockingStub.addPerson(person);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name
     * to use in the greeting.
     */
    public static void main(String[] args) throws Exception {
        AwesomeServiceClient client = new AwesomeServiceClient("localhost", 50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "world";
            if (args.length > 0) {
                user = args[0];
                /* Use the arg as the name to greet if provided */
            }
            client.addPerson();
        } finally {
            client.shutdown();
        }
    }
}
