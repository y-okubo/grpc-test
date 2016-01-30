
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import proto.AwesomeServiceGrpc;
import proto.AwesomeServiceOuterClass;
import proto.AwesomeServiceOuterClass.Person;
import proto.AwesomeServiceOuterClass.RequestType;
import proto.AwesomeServiceOuterClass.ResponseType;

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
     * Add person.
     */
    public void addPerson() {
        Person.Builder builder = Person.newBuilder();
        builder.setName("Steve Jobs");
        builder.setAge(44);
        Person person = builder.build();

        RequestType request = AwesomeServiceOuterClass.RequestType.newBuilder().build();
        ResponseType response;
        try {
            response = blockingStub.addPerson(person);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
    }

    /**
     * List person.
     */
    public void listPerson() {
        RequestType request = RequestType.newBuilder().build();

        try {
            for (Iterator response = blockingStub.listPerson(request); response.hasNext();) {
                Person person = (Person) response.next();
                logger.log(Level.INFO, "Person: {0} {1}", new Object[]{person.getAge(), person.getName()});
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
    }

    /**
     * Server.
     */
    public static void main(String[] args) throws Exception {
        AwesomeServiceClient client = new AwesomeServiceClient("localhost", 50051);
        try {
            client.addPerson();
            client.listPerson();
        } finally {
            client.shutdown();
        }
    }
}
