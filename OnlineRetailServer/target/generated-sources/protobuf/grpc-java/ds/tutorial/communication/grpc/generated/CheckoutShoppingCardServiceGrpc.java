package ds.tutorial.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: BankService.proto")
public final class CheckoutShoppingCardServiceGrpc {

  private CheckoutShoppingCardServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.tutorial.communication.grpc.generated.CheckoutShoppingCardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest,
      ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> getCheckoutShoppingCardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckoutShoppingCard",
      requestType = ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest,
      ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> getCheckoutShoppingCardMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest, ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> getCheckoutShoppingCardMethod;
    if ((getCheckoutShoppingCardMethod = CheckoutShoppingCardServiceGrpc.getCheckoutShoppingCardMethod) == null) {
      synchronized (CheckoutShoppingCardServiceGrpc.class) {
        if ((getCheckoutShoppingCardMethod = CheckoutShoppingCardServiceGrpc.getCheckoutShoppingCardMethod) == null) {
          CheckoutShoppingCardServiceGrpc.getCheckoutShoppingCardMethod = getCheckoutShoppingCardMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest, ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckoutShoppingCard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckoutShoppingCardServiceMethodDescriptorSupplier("CheckoutShoppingCard"))
              .build();
        }
      }
    }
    return getCheckoutShoppingCardMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckoutShoppingCardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceStub>() {
        @java.lang.Override
        public CheckoutShoppingCardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutShoppingCardServiceStub(channel, callOptions);
        }
      };
    return CheckoutShoppingCardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckoutShoppingCardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceBlockingStub>() {
        @java.lang.Override
        public CheckoutShoppingCardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutShoppingCardServiceBlockingStub(channel, callOptions);
        }
      };
    return CheckoutShoppingCardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckoutShoppingCardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckoutShoppingCardServiceFutureStub>() {
        @java.lang.Override
        public CheckoutShoppingCardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckoutShoppingCardServiceFutureStub(channel, callOptions);
        }
      };
    return CheckoutShoppingCardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CheckoutShoppingCardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkoutShoppingCard(ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckoutShoppingCardMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckoutShoppingCardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest,
                ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse>(
                  this, METHODID_CHECKOUT_SHOPPING_CARD)))
          .build();
    }
  }

  /**
   */
  public static final class CheckoutShoppingCardServiceStub extends io.grpc.stub.AbstractAsyncStub<CheckoutShoppingCardServiceStub> {
    private CheckoutShoppingCardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutShoppingCardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutShoppingCardServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkoutShoppingCard(ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckoutShoppingCardMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CheckoutShoppingCardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CheckoutShoppingCardServiceBlockingStub> {
    private CheckoutShoppingCardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutShoppingCardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutShoppingCardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse checkoutShoppingCard(ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckoutShoppingCardMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CheckoutShoppingCardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CheckoutShoppingCardServiceFutureStub> {
    private CheckoutShoppingCardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutShoppingCardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckoutShoppingCardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse> checkoutShoppingCard(
        ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckoutShoppingCardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECKOUT_SHOPPING_CARD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CheckoutShoppingCardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CheckoutShoppingCardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECKOUT_SHOPPING_CARD:
          serviceImpl.checkoutShoppingCard((ds.tutorial.communication.grpc.generated.CheckoutShoppingCardRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckoutShoppingCardResponse>) responseObserver);
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

  private static abstract class CheckoutShoppingCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckoutShoppingCardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.tutorial.communication.grpc.generated.BankService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckoutShoppingCardService");
    }
  }

  private static final class CheckoutShoppingCardServiceFileDescriptorSupplier
      extends CheckoutShoppingCardServiceBaseDescriptorSupplier {
    CheckoutShoppingCardServiceFileDescriptorSupplier() {}
  }

  private static final class CheckoutShoppingCardServiceMethodDescriptorSupplier
      extends CheckoutShoppingCardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CheckoutShoppingCardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CheckoutShoppingCardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckoutShoppingCardServiceFileDescriptorSupplier())
              .addMethod(getCheckoutShoppingCardMethod())
              .build();
        }
      }
    }
    return result;
  }
}
