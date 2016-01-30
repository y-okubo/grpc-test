package proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class AwesomeServiceGrpc {

  private AwesomeServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.AwesomeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<proto.AwesomeServiceOuterClass.RequestType,
      proto.AwesomeServiceOuterClass.Person> METHOD_LIST_PERSON =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "proto.AwesomeService", "ListPerson"),
          io.grpc.protobuf.ProtoUtils.marshaller(proto.AwesomeServiceOuterClass.RequestType.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(proto.AwesomeServiceOuterClass.Person.getDefaultInstance()));
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<proto.AwesomeServiceOuterClass.Person,
      proto.AwesomeServiceOuterClass.ResponseType> METHOD_ADD_PERSON =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "proto.AwesomeService", "AddPerson"),
          io.grpc.protobuf.ProtoUtils.marshaller(proto.AwesomeServiceOuterClass.Person.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(proto.AwesomeServiceOuterClass.ResponseType.getDefaultInstance()));

  public static AwesomeServiceStub newStub(io.grpc.Channel channel) {
    return new AwesomeServiceStub(channel);
  }

  public static AwesomeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AwesomeServiceBlockingStub(channel);
  }

  public static AwesomeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AwesomeServiceFutureStub(channel);
  }

  public static interface AwesomeService {

    public void listPerson(proto.AwesomeServiceOuterClass.RequestType request,
        io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.Person> responseObserver);

    public void addPerson(proto.AwesomeServiceOuterClass.Person request,
        io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.ResponseType> responseObserver);
  }

  public static interface AwesomeServiceBlockingClient {

    public java.util.Iterator<proto.AwesomeServiceOuterClass.Person> listPerson(
        proto.AwesomeServiceOuterClass.RequestType request);

    public proto.AwesomeServiceOuterClass.ResponseType addPerson(proto.AwesomeServiceOuterClass.Person request);
  }

  public static interface AwesomeServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<proto.AwesomeServiceOuterClass.ResponseType> addPerson(
        proto.AwesomeServiceOuterClass.Person request);
  }

  public static class AwesomeServiceStub extends io.grpc.stub.AbstractStub<AwesomeServiceStub>
      implements AwesomeService {
    private AwesomeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AwesomeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwesomeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AwesomeServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void listPerson(proto.AwesomeServiceOuterClass.RequestType request,
        io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.Person> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_PERSON, getCallOptions()), request, responseObserver);
    }

    @java.lang.Override
    public void addPerson(proto.AwesomeServiceOuterClass.Person request,
        io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.ResponseType> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_PERSON, getCallOptions()), request, responseObserver);
    }
  }

  public static class AwesomeServiceBlockingStub extends io.grpc.stub.AbstractStub<AwesomeServiceBlockingStub>
      implements AwesomeServiceBlockingClient {
    private AwesomeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AwesomeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwesomeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AwesomeServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public java.util.Iterator<proto.AwesomeServiceOuterClass.Person> listPerson(
        proto.AwesomeServiceOuterClass.RequestType request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_PERSON, getCallOptions(), request);
    }

    @java.lang.Override
    public proto.AwesomeServiceOuterClass.ResponseType addPerson(proto.AwesomeServiceOuterClass.Person request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_PERSON, getCallOptions(), request);
    }
  }

  public static class AwesomeServiceFutureStub extends io.grpc.stub.AbstractStub<AwesomeServiceFutureStub>
      implements AwesomeServiceFutureClient {
    private AwesomeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AwesomeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AwesomeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AwesomeServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<proto.AwesomeServiceOuterClass.ResponseType> addPerson(
        proto.AwesomeServiceOuterClass.Person request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_PERSON, getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_PERSON = 0;
  private static final int METHODID_ADD_PERSON = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AwesomeService serviceImpl;
    private final int methodId;

    public MethodHandlers(AwesomeService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_PERSON:
          serviceImpl.listPerson((proto.AwesomeServiceOuterClass.RequestType) request,
              (io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.Person>) responseObserver);
          break;
        case METHODID_ADD_PERSON:
          serviceImpl.addPerson((proto.AwesomeServiceOuterClass.Person) request,
              (io.grpc.stub.StreamObserver<proto.AwesomeServiceOuterClass.ResponseType>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final AwesomeService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_LIST_PERSON,
          asyncServerStreamingCall(
            new MethodHandlers<
              proto.AwesomeServiceOuterClass.RequestType,
              proto.AwesomeServiceOuterClass.Person>(
                serviceImpl, METHODID_LIST_PERSON)))
        .addMethod(
          METHOD_ADD_PERSON,
          asyncUnaryCall(
            new MethodHandlers<
              proto.AwesomeServiceOuterClass.Person,
              proto.AwesomeServiceOuterClass.ResponseType>(
                serviceImpl, METHODID_ADD_PERSON)))
        .build();
  }
}
