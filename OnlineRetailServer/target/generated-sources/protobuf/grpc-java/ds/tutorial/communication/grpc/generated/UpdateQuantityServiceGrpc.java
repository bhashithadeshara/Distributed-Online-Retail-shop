package ds.tutorial.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: BankService.proto")
public final class UpdateQuantityServiceGrpc {

  private UpdateQuantityServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.tutorial.communication.grpc.generated.UpdateQuantityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateQuantityRequest,
      ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> getUpdateQuantityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateQuantity",
      requestType = ds.tutorial.communication.grpc.generated.UpdateQuantityRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.UpdateQuantityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateQuantityRequest,
      ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> getUpdateQuantityMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateQuantityRequest, ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> getUpdateQuantityMethod;
    if ((getUpdateQuantityMethod = UpdateQuantityServiceGrpc.getUpdateQuantityMethod) == null) {
      synchronized (UpdateQuantityServiceGrpc.class) {
        if ((getUpdateQuantityMethod = UpdateQuantityServiceGrpc.getUpdateQuantityMethod) == null) {
          UpdateQuantityServiceGrpc.getUpdateQuantityMethod = getUpdateQuantityMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.UpdateQuantityRequest, ds.tutorial.communication.grpc.generated.UpdateQuantityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateQuantity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.UpdateQuantityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.UpdateQuantityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UpdateQuantityServiceMethodDescriptorSupplier("updateQuantity"))
              .build();
        }
      }
    }
    return getUpdateQuantityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UpdateQuantityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceStub>() {
        @java.lang.Override
        public UpdateQuantityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateQuantityServiceStub(channel, callOptions);
        }
      };
    return UpdateQuantityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UpdateQuantityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceBlockingStub>() {
        @java.lang.Override
        public UpdateQuantityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateQuantityServiceBlockingStub(channel, callOptions);
        }
      };
    return UpdateQuantityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UpdateQuantityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UpdateQuantityServiceFutureStub>() {
        @java.lang.Override
        public UpdateQuantityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UpdateQuantityServiceFutureStub(channel, callOptions);
        }
      };
    return UpdateQuantityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UpdateQuantityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void updateQuantity(ds.tutorial.communication.grpc.generated.UpdateQuantityRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateQuantityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateQuantityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.UpdateQuantityRequest,
                ds.tutorial.communication.grpc.generated.UpdateQuantityResponse>(
                  this, METHODID_UPDATE_QUANTITY)))
          .build();
    }
  }

  /**
   */
  public static final class UpdateQuantityServiceStub extends io.grpc.stub.AbstractAsyncStub<UpdateQuantityServiceStub> {
    private UpdateQuantityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateQuantityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateQuantityServiceStub(channel, callOptions);
    }

    /**
     */
    public void updateQuantity(ds.tutorial.communication.grpc.generated.UpdateQuantityRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQuantityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UpdateQuantityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UpdateQuantityServiceBlockingStub> {
    private UpdateQuantityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateQuantityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateQuantityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.UpdateQuantityResponse updateQuantity(ds.tutorial.communication.grpc.generated.UpdateQuantityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQuantityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UpdateQuantityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UpdateQuantityServiceFutureStub> {
    private UpdateQuantityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdateQuantityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UpdateQuantityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.UpdateQuantityResponse> updateQuantity(
        ds.tutorial.communication.grpc.generated.UpdateQuantityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQuantityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_QUANTITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UpdateQuantityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UpdateQuantityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_QUANTITY:
          serviceImpl.updateQuantity((ds.tutorial.communication.grpc.generated.UpdateQuantityRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateQuantityResponse>) responseObserver);
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

  private static abstract class UpdateQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UpdateQuantityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.tutorial.communication.grpc.generated.BankService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UpdateQuantityService");
    }
  }

  private static final class UpdateQuantityServiceFileDescriptorSupplier
      extends UpdateQuantityServiceBaseDescriptorSupplier {
    UpdateQuantityServiceFileDescriptorSupplier() {}
  }

  private static final class UpdateQuantityServiceMethodDescriptorSupplier
      extends UpdateQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UpdateQuantityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UpdateQuantityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UpdateQuantityServiceFileDescriptorSupplier())
              .addMethod(getUpdateQuantityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
