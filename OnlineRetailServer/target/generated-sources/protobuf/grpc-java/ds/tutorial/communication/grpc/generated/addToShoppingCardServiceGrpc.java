package ds.tutorial.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: BankService.proto")
public final class addToShoppingCardServiceGrpc {

  private addToShoppingCardServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.tutorial.communication.grpc.generated.addToShoppingCardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest,
      ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> getAddToShoppingCardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addToShoppingCard",
      requestType = ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest,
      ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> getAddToShoppingCardMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest, ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> getAddToShoppingCardMethod;
    if ((getAddToShoppingCardMethod = addToShoppingCardServiceGrpc.getAddToShoppingCardMethod) == null) {
      synchronized (addToShoppingCardServiceGrpc.class) {
        if ((getAddToShoppingCardMethod = addToShoppingCardServiceGrpc.getAddToShoppingCardMethod) == null) {
          addToShoppingCardServiceGrpc.getAddToShoppingCardMethod = getAddToShoppingCardMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest, ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addToShoppingCard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new addToShoppingCardServiceMethodDescriptorSupplier("addToShoppingCard"))
              .build();
        }
      }
    }
    return getAddToShoppingCardMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static addToShoppingCardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceStub>() {
        @java.lang.Override
        public addToShoppingCardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new addToShoppingCardServiceStub(channel, callOptions);
        }
      };
    return addToShoppingCardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static addToShoppingCardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceBlockingStub>() {
        @java.lang.Override
        public addToShoppingCardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new addToShoppingCardServiceBlockingStub(channel, callOptions);
        }
      };
    return addToShoppingCardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static addToShoppingCardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<addToShoppingCardServiceFutureStub>() {
        @java.lang.Override
        public addToShoppingCardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new addToShoppingCardServiceFutureStub(channel, callOptions);
        }
      };
    return addToShoppingCardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class addToShoppingCardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addToShoppingCard(ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddToShoppingCardMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddToShoppingCardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest,
                ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse>(
                  this, METHODID_ADD_TO_SHOPPING_CARD)))
          .build();
    }
  }

  /**
   */
  public static final class addToShoppingCardServiceStub extends io.grpc.stub.AbstractAsyncStub<addToShoppingCardServiceStub> {
    private addToShoppingCardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected addToShoppingCardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new addToShoppingCardServiceStub(channel, callOptions);
    }

    /**
     */
    public void addToShoppingCard(ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddToShoppingCardMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class addToShoppingCardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<addToShoppingCardServiceBlockingStub> {
    private addToShoppingCardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected addToShoppingCardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new addToShoppingCardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse addToShoppingCard(ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddToShoppingCardMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class addToShoppingCardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<addToShoppingCardServiceFutureStub> {
    private addToShoppingCardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected addToShoppingCardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new addToShoppingCardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse> addToShoppingCard(
        ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddToShoppingCardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TO_SHOPPING_CARD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final addToShoppingCardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(addToShoppingCardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_TO_SHOPPING_CARD:
          serviceImpl.addToShoppingCard((ds.tutorial.communication.grpc.generated.AddToShoppingCardRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.AddToShoppingCardResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class addToShoppingCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    addToShoppingCardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.tutorial.communication.grpc.generated.BankService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("addToShoppingCardService");
    }
  }

  private static final class addToShoppingCardServiceFileDescriptorSupplier
      extends addToShoppingCardServiceBaseDescriptorSupplier {
    addToShoppingCardServiceFileDescriptorSupplier() {}
  }

  private static final class addToShoppingCardServiceMethodDescriptorSupplier
      extends addToShoppingCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    addToShoppingCardServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (addToShoppingCardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new addToShoppingCardServiceFileDescriptorSupplier())
              .addMethod(getAddToShoppingCardMethod())
              .build();
        }
      }
    }
    return result;
  }
}
