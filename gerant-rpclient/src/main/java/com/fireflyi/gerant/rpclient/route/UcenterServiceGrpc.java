package com.fireflyi.gerant.rpclient.route;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0-SNAPSHOT)",
    comments = "Source: UcenterService.proto")
public final class UcenterServiceGrpc {

  private UcenterServiceGrpc() {}

  public static final String SERVICE_NAME = "protocol.route.UcenterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = com.fireflyi.gerant.rpclient.protobuf.Greq.class,
      responseType = com.fireflyi.gerant.rpclient.protobuf.Gres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres> getRegisterMethod;
    if ((getRegisterMethod = UcenterServiceGrpc.getRegisterMethod) == null) {
      synchronized (UcenterServiceGrpc.class) {
        if ((getRegisterMethod = UcenterServiceGrpc.getRegisterMethod) == null) {
          UcenterServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Greq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Gres.getDefaultInstance()))
              .setSchemaDescriptor(new UcenterServiceMethodDescriptorSupplier("register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getOutLineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "outLine",
      requestType = com.fireflyi.gerant.rpclient.protobuf.Greq.class,
      responseType = com.fireflyi.gerant.rpclient.protobuf.Gres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getOutLineMethod() {
    io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres> getOutLineMethod;
    if ((getOutLineMethod = UcenterServiceGrpc.getOutLineMethod) == null) {
      synchronized (UcenterServiceGrpc.class) {
        if ((getOutLineMethod = UcenterServiceGrpc.getOutLineMethod) == null) {
          UcenterServiceGrpc.getOutLineMethod = getOutLineMethod =
              io.grpc.MethodDescriptor.<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "outLine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Greq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Gres.getDefaultInstance()))
              .setSchemaDescriptor(new UcenterServiceMethodDescriptorSupplier("outLine"))
              .build();
        }
      }
    }
    return getOutLineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getGetUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsers",
      requestType = com.fireflyi.gerant.rpclient.protobuf.Greq.class,
      responseType = com.fireflyi.gerant.rpclient.protobuf.Gres.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq,
      com.fireflyi.gerant.rpclient.protobuf.Gres> getGetUsersMethod() {
    io.grpc.MethodDescriptor<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres> getGetUsersMethod;
    if ((getGetUsersMethod = UcenterServiceGrpc.getGetUsersMethod) == null) {
      synchronized (UcenterServiceGrpc.class) {
        if ((getGetUsersMethod = UcenterServiceGrpc.getGetUsersMethod) == null) {
          UcenterServiceGrpc.getGetUsersMethod = getGetUsersMethod =
              io.grpc.MethodDescriptor.<com.fireflyi.gerant.rpclient.protobuf.Greq, com.fireflyi.gerant.rpclient.protobuf.Gres>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Greq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.fireflyi.gerant.rpclient.protobuf.Gres.getDefaultInstance()))
              .setSchemaDescriptor(new UcenterServiceMethodDescriptorSupplier("getUsers"))
              .build();
        }
      }
    }
    return getGetUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UcenterServiceStub newStub(io.grpc.Channel channel) {
    return new UcenterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UcenterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UcenterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UcenterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UcenterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UcenterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void outLine(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnimplementedUnaryCall(getOutLineMethod(), responseObserver);
    }

    /**
     */
    public void getUsers(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUsersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.fireflyi.gerant.rpclient.protobuf.Greq,
                com.fireflyi.gerant.rpclient.protobuf.Gres>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getOutLineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.fireflyi.gerant.rpclient.protobuf.Greq,
                com.fireflyi.gerant.rpclient.protobuf.Gres>(
                  this, METHODID_OUT_LINE)))
          .addMethod(
            getGetUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.fireflyi.gerant.rpclient.protobuf.Greq,
                com.fireflyi.gerant.rpclient.protobuf.Gres>(
                  this, METHODID_GET_USERS)))
          .build();
    }
  }

  /**
   */
  public static final class UcenterServiceStub extends io.grpc.stub.AbstractStub<UcenterServiceStub> {
    private UcenterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UcenterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UcenterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UcenterServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void outLine(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOutLineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsers(com.fireflyi.gerant.rpclient.protobuf.Greq request,
        io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UcenterServiceBlockingStub extends io.grpc.stub.AbstractStub<UcenterServiceBlockingStub> {
    private UcenterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UcenterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UcenterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UcenterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.fireflyi.gerant.rpclient.protobuf.Gres register(com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.fireflyi.gerant.rpclient.protobuf.Gres outLine(com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return blockingUnaryCall(
          getChannel(), getOutLineMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.fireflyi.gerant.rpclient.protobuf.Gres getUsers(com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return blockingUnaryCall(
          getChannel(), getGetUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UcenterServiceFutureStub extends io.grpc.stub.AbstractStub<UcenterServiceFutureStub> {
    private UcenterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UcenterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UcenterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UcenterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.fireflyi.gerant.rpclient.protobuf.Gres> register(
        com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.fireflyi.gerant.rpclient.protobuf.Gres> outLine(
        com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return futureUnaryCall(
          getChannel().newCall(getOutLineMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.fireflyi.gerant.rpclient.protobuf.Gres> getUsers(
        com.fireflyi.gerant.rpclient.protobuf.Greq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_OUT_LINE = 1;
  private static final int METHODID_GET_USERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UcenterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UcenterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.fireflyi.gerant.rpclient.protobuf.Greq) request,
              (io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres>) responseObserver);
          break;
        case METHODID_OUT_LINE:
          serviceImpl.outLine((com.fireflyi.gerant.rpclient.protobuf.Greq) request,
              (io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres>) responseObserver);
          break;
        case METHODID_GET_USERS:
          serviceImpl.getUsers((com.fireflyi.gerant.rpclient.protobuf.Greq) request,
              (io.grpc.stub.StreamObserver<com.fireflyi.gerant.rpclient.protobuf.Gres>) responseObserver);
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

  private static abstract class UcenterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UcenterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.fireflyi.gerant.rpclient.route.UcenterServicePtc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UcenterService");
    }
  }

  private static final class UcenterServiceFileDescriptorSupplier
      extends UcenterServiceBaseDescriptorSupplier {
    UcenterServiceFileDescriptorSupplier() {}
  }

  private static final class UcenterServiceMethodDescriptorSupplier
      extends UcenterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UcenterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UcenterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UcenterServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getOutLineMethod())
              .addMethod(getGetUsersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
