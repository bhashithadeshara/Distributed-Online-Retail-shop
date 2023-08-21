package ds.tutorial.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: BankService.proto")
public final class CheckAvailableQuantityServiceGrpc {

  private CheckAvailableQuantityServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.tutorial.communication.grpc.generated.CheckAvailableQuantityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest,
      ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> getCheckAvailableQuantityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkAvailableQuantity",
      requestType = ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest,
      ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> getCheckAvailableQuantityMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest, ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> getCheckAvailableQuantityMethod;
    if ((getCheckAvailableQuantityMethod = CheckAvailableQuantityServiceGrpc.getCheckAvailableQuantityMethod) == null) {
      synchronized (CheckAvailableQuantityServiceGrpc.class) {
        if ((getCheckAvailableQuantityMethod = CheckAvailableQuantityServiceGrpc.getCheckAvailableQuantityMethod) == null) {
          CheckAvailableQuantityServiceGrpc.getCheckAvailableQuantityMethod = getCheckAvailableQuantityMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest, ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkAvailableQuantity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckAvailableQuantityServiceMethodDescriptorSupplier("checkAvailableQuantity"))
              .build();
        }
      }
    }
    return getCheckAvailableQuantityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckAvailableQuantityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceStub>() {
        @java.lang.Override
        public CheckAvailableQuantityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckAvailableQuantityServiceStub(channel, callOptions);
        }
      };
    return CheckAvailableQuantityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckAvailableQuantityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceBlockingStub>() {
        @java.lang.Override
        public CheckAvailableQuantityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckAvailableQuantityServiceBlockingStub(channel, callOptions);
        }
      };
    return CheckAvailableQuantityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckAvailableQuantityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckAvailableQuantityServiceFutureStub>() {
        @java.lang.Override
        public CheckAvailableQuantityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckAvailableQuantityServiceFutureStub(channel, callOptions);
        }
      };
    return CheckAvailableQuantityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CheckAvailableQuantityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkAvailableQuantity(ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckAvailableQuantityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckAvailableQuantityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest,
                ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse>(
                  this, METHODID_CHECK_AVAILABLE_QUANTITY)))
          .build();
    }
  }

  /**
   */
  public static final class CheckAvailableQuantityServiceStub extends io.grpc.stub.AbstractAsyncStub<CheckAvailableQuantityServiceStub> {
    private CheckAvailableQuantityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckAvailableQuantityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckAvailableQuantityServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkAvailableQuantity(ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckAvailableQuantityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CheckAvailableQuantityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CheckAvailableQuantityServiceBlockingStub> {
    private CheckAvailableQuantityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckAvailableQuantityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckAvailableQuantityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse checkAvailableQuantity(ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckAvailableQuantityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CheckAvailableQuantityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CheckAvailableQuantityServiceFutureStub> {
    private CheckAvailableQuantityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckAvailableQuantityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckAvailableQuantityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse> checkAvailableQuantity(
        ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckAvailableQuantityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_AVAILABLE_QUANTITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CheckAvailableQuantityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CheckAvailableQuantityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_AVAILABLE_QUANTITY:
          serviceImpl.checkAvailableQuantity((ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse>) responseObserver);
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

  private static abstract class CheckAvailableQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckAvailableQuantityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.tutorial.communication.grpc.generated.BankService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckAvailableQuantityService");
    }
  }

  private static final class CheckAvailableQuantityServiceFileDescriptorSupplier
      extends CheckAvailableQuantityServiceBaseDescriptorSupplier {
    CheckAvailableQuantityServiceFileDescriptorSupplier() {}
  }

  private static final class CheckAvailableQuantityServiceMethodDescriptorSupplier
      extends CheckAvailableQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CheckAvailableQuantityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CheckAvailableQuantityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckAvailableQuantityServiceFileDescriptorSupplier())
              .addMethod(getCheckAvailableQuantityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
