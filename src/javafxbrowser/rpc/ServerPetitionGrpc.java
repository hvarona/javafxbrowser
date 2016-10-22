package javafxbrowser.rpc;

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
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.1)",
    comments = "Source: grpc.proto")
public class ServerPetitionGrpc {

  private ServerPetitionGrpc() {}

  public static final String SERVICE_NAME = "internalrpc.ServerPetition";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Config,
      javafxbrowser.rpc.Config> METHOD_GET_CONFIG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "internalrpc.ServerPetition", "GetConfig"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Config.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Config.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Config,
      javafxbrowser.rpc.Config> METHOD_SET_CONFIG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "internalrpc.ServerPetition", "SetConfig"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Config.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Config.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerPetitionStub newStub(io.grpc.Channel channel) {
    return new ServerPetitionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerPetitionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServerPetitionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ServerPetitionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServerPetitionFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ServerPetitionImplBase implements io.grpc.BindableService {

    /**
     */
    public void getConfig(javafxbrowser.rpc.Config request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONFIG, responseObserver);
    }

    /**
     */
    public void setConfig(javafxbrowser.rpc.Config request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_CONFIG, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_CONFIG,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Config,
                javafxbrowser.rpc.Config>(
                  this, METHODID_GET_CONFIG)))
          .addMethod(
            METHOD_SET_CONFIG,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Config,
                javafxbrowser.rpc.Config>(
                  this, METHODID_SET_CONFIG)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerPetitionStub extends io.grpc.stub.AbstractStub<ServerPetitionStub> {
    private ServerPetitionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerPetitionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerPetitionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerPetitionStub(channel, callOptions);
    }

    /**
     */
    public void getConfig(javafxbrowser.rpc.Config request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONFIG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setConfig(javafxbrowser.rpc.Config request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_CONFIG, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerPetitionBlockingStub extends io.grpc.stub.AbstractStub<ServerPetitionBlockingStub> {
    private ServerPetitionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerPetitionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerPetitionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerPetitionBlockingStub(channel, callOptions);
    }

    /**
     */
    public javafxbrowser.rpc.Config getConfig(javafxbrowser.rpc.Config request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONFIG, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Config setConfig(javafxbrowser.rpc.Config request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_CONFIG, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ServerPetitionFutureStub extends io.grpc.stub.AbstractStub<ServerPetitionFutureStub> {
    private ServerPetitionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServerPetitionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerPetitionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServerPetitionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Config> getConfig(
        javafxbrowser.rpc.Config request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONFIG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Config> setConfig(
        javafxbrowser.rpc.Config request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_CONFIG, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CONFIG = 0;
  private static final int METHODID_SET_CONFIG = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServerPetitionImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ServerPetitionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CONFIG:
          serviceImpl.getConfig((javafxbrowser.rpc.Config) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config>) responseObserver);
          break;
        case METHODID_SET_CONFIG:
          serviceImpl.setConfig((javafxbrowser.rpc.Config) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Config>) responseObserver);
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

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_GET_CONFIG,
        METHOD_SET_CONFIG);
  }

}
