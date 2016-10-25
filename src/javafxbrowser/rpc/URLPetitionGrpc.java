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
    comments = "Source: net.proto")
public class URLPetitionGrpc {

  private URLPetitionGrpc() {}

  public static final String SERVICE_NAME = "rpcurlconn.URLPetition";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.StringObject,
      javafxbrowser.rpc.ID> METHOD_CONSTRUCTOR =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "constructor"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.ID.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Void> METHOD_CONNECT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "connect"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Int,
      javafxbrowser.rpc.Void> METHOD_SET_CONNECT_TIMEOUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setConnectTimeout"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Int> METHOD_GET_CONNECT_TIMEOUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getConnectTimeout"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Int,
      javafxbrowser.rpc.Void> METHOD_SET_READ_TIMEOUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setReadTimeout"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Int> METHOD_GET_READ_TIMEOUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getReadTimeout"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Int> METHOD_GET_CONTENT_LENGTH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getContentLength"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Long> METHOD_GET_CONTENT_LENGTH_LONG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getContentLengthLong"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.StringObject> METHOD_GET_CONTENT_TYPE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getContentType"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.StringObject> METHOD_GET_CONTENT_ENCODING =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getContentEncoding"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Long> METHOD_GET_EXPIRATION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getExpiration"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Long> METHOD_GET_DATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDate"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Long> METHOD_GET_LAST_MODIFIED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getLastModified"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.StringObject,
      javafxbrowser.rpc.StringObject> METHOD_GET_HEADER_FIELD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getHeaderField"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.FieldInt,
      javafxbrowser.rpc.Int> METHOD_GET_HEADER_FIELD_INT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getHeaderFieldInt"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.FieldInt.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.FieldLong,
      javafxbrowser.rpc.Long> METHOD_GET_HEADER_FIELD_LONG =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getHeaderFieldLong"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.FieldLong.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.FieldLong,
      javafxbrowser.rpc.Long> METHOD_GET_HEADER_FIELD_DATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getHeaderFieldDate"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.FieldLong.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Int,
      javafxbrowser.rpc.StringObject> METHOD_GET_HEADER_FIELD_KEY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getHeaderFieldKey"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.StringObject> METHOD_TO_STRING_OBJECT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "toStringObject"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_DO_INPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setDoInput"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_DO_INPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDoInput"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_DO_OUTPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setDoOutput"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_DO_OUTPUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDoOutput"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_ALLOW_USER_INTERACTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setAllowUserInteraction"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_ALLOW_USER_INTERACTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getAllowUserInteraction"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setDefaultAllowUserInteraction"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDefaultAllowUserInteraction"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_USE_CACHES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setUseCaches"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_USE_CACHES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getUseCaches"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Long,
      javafxbrowser.rpc.Void> METHOD_SET_IF_MODIFIED_SINCE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setIfModifiedSince"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Long> METHOD_GET_IF_MODIFIED_SINCE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getIfModifiedSince"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_GET_DEFAULT_USE_CACHES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDefaultUseCaches"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Boolean,
      javafxbrowser.rpc.Void> METHOD_SET_DEFAULT_USE_CACHES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setDefaultUseCaches"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.KeyValue,
      javafxbrowser.rpc.Void> METHOD_SET_REQUEST_PROPERTY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setRequestProperty"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.KeyValue.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.KeyValue,
      javafxbrowser.rpc.Void> METHOD_ADD_REQUEST_PROPERTY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "addRequestProperty"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.KeyValue.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.StringObject,
      javafxbrowser.rpc.StringObject> METHOD_GET_REQUEST_PROPERTY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getRequestProperty"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.KeyValue,
      javafxbrowser.rpc.Void> METHOD_SET_DEFAULT_REQUEST_PROPERTY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "setDefaultRequestProperty"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.KeyValue.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.StringObject,
      javafxbrowser.rpc.StringObject> METHOD_GET_DEFAULT_REQUEST_PROPERTY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "getDefaultRequestProperty"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.StringObject,
      javafxbrowser.rpc.StringObject> METHOD_GUESS_CONTENT_TYPE_FROM_NAME =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "guessContentTypeFromName"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.StringObject.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Void> METHOD_INPUT_STREAM_CLOSE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamClose"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Int> METHOD_INPUT_STREAM_READ =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamRead"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.ByteArray,
      javafxbrowser.rpc.Int> METHOD_INPUT_STREAM_READ_ARRAY =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamReadArray"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.ByteArray.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.ByteArrayOffset,
      javafxbrowser.rpc.Int> METHOD_INPUT_STREAM_READ_ARRAY_OFF =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamReadArrayOff"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.ByteArrayOffset.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Long,
      javafxbrowser.rpc.Long> METHOD_INPUT_STREAM_SKIP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamSkip"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Long.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Int> METHOD_INPUT_STREAM_AVAILABLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamAvailable"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Int,
      javafxbrowser.rpc.Void> METHOD_INPUT_STREAM_MARK =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamMark"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Int.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Void> METHOD_INPUT_STREAM_RESET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamReset"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<javafxbrowser.rpc.Void,
      javafxbrowser.rpc.Boolean> METHOD_INPUT_STREAM_MARK_SUPPORTED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rpcurlconn.URLPetition", "InputStreamMarkSupported"),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Void.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(javafxbrowser.rpc.Boolean.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static URLPetitionStub newStub(io.grpc.Channel channel) {
    return new URLPetitionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static URLPetitionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new URLPetitionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static URLPetitionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new URLPetitionFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class URLPetitionImplBase implements io.grpc.BindableService {

    /**
     */
    public void constructor(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.ID> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONSTRUCTOR, responseObserver);
    }

    /**
     */
    public void connect(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONNECT, responseObserver);
    }

    /**
     */
    public void setConnectTimeout(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_CONNECT_TIMEOUT, responseObserver);
    }

    /**
     */
    public void getConnectTimeout(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONNECT_TIMEOUT, responseObserver);
    }

    /**
     */
    public void setReadTimeout(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_READ_TIMEOUT, responseObserver);
    }

    /**
     */
    public void getReadTimeout(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_READ_TIMEOUT, responseObserver);
    }

    /**
     */
    public void getContentLength(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONTENT_LENGTH, responseObserver);
    }

    /**
     */
    public void getContentLengthLong(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONTENT_LENGTH_LONG, responseObserver);
    }

    /**
     */
    public void getContentType(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONTENT_TYPE, responseObserver);
    }

    /**
     */
    public void getContentEncoding(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONTENT_ENCODING, responseObserver);
    }

    /**
     */
    public void getExpiration(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EXPIRATION, responseObserver);
    }

    /**
     */
    public void getDate(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATE, responseObserver);
    }

    /**
     */
    public void getLastModified(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_LAST_MODIFIED, responseObserver);
    }

    /**
     */
    public void getHeaderField(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEADER_FIELD, responseObserver);
    }

    /**
     */
    public void getHeaderFieldInt(javafxbrowser.rpc.FieldInt request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEADER_FIELD_INT, responseObserver);
    }

    /**
     */
    public void getHeaderFieldLong(javafxbrowser.rpc.FieldLong request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEADER_FIELD_LONG, responseObserver);
    }

    /**
     */
    public void getHeaderFieldDate(javafxbrowser.rpc.FieldLong request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEADER_FIELD_DATE, responseObserver);
    }

    /**
     */
    public void getHeaderFieldKey(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEADER_FIELD_KEY, responseObserver);
    }

    /**
     * <pre>
     *  rpc getHeaderField(Int) returns (StringObject){}
     * </pre>
     */
    public void toStringObject(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TO_STRING_OBJECT, responseObserver);
    }

    /**
     */
    public void setDoInput(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_DO_INPUT, responseObserver);
    }

    /**
     */
    public void getDoInput(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DO_INPUT, responseObserver);
    }

    /**
     */
    public void setDoOutput(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_DO_OUTPUT, responseObserver);
    }

    /**
     */
    public void getDoOutput(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DO_OUTPUT, responseObserver);
    }

    /**
     */
    public void setAllowUserInteraction(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_ALLOW_USER_INTERACTION, responseObserver);
    }

    /**
     */
    public void getAllowUserInteraction(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALLOW_USER_INTERACTION, responseObserver);
    }

    /**
     */
    public void setDefaultAllowUserInteraction(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION, responseObserver);
    }

    /**
     */
    public void getDefaultAllowUserInteraction(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION, responseObserver);
    }

    /**
     */
    public void setUseCaches(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_USE_CACHES, responseObserver);
    }

    /**
     */
    public void getUseCaches(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_USE_CACHES, responseObserver);
    }

    /**
     */
    public void setIfModifiedSince(javafxbrowser.rpc.Long request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_IF_MODIFIED_SINCE, responseObserver);
    }

    /**
     */
    public void getIfModifiedSince(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_IF_MODIFIED_SINCE, responseObserver);
    }

    /**
     */
    public void getDefaultUseCaches(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DEFAULT_USE_CACHES, responseObserver);
    }

    /**
     */
    public void setDefaultUseCaches(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_DEFAULT_USE_CACHES, responseObserver);
    }

    /**
     */
    public void setRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_REQUEST_PROPERTY, responseObserver);
    }

    /**
     */
    public void addRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_REQUEST_PROPERTY, responseObserver);
    }

    /**
     */
    public void getRequestProperty(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_REQUEST_PROPERTY, responseObserver);
    }

    /**
     */
    public void setDefaultRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_DEFAULT_REQUEST_PROPERTY, responseObserver);
    }

    /**
     */
    public void getDefaultRequestProperty(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DEFAULT_REQUEST_PROPERTY, responseObserver);
    }

    /**
     */
    public void guessContentTypeFromName(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GUESS_CONTENT_TYPE_FROM_NAME, responseObserver);
    }

    /**
     */
    public void inputStreamClose(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_CLOSE, responseObserver);
    }

    /**
     */
    public void inputStreamRead(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_READ, responseObserver);
    }

    /**
     */
    public void inputStreamReadArray(javafxbrowser.rpc.ByteArray request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_READ_ARRAY, responseObserver);
    }

    /**
     */
    public void inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_READ_ARRAY_OFF, responseObserver);
    }

    /**
     */
    public void inputStreamSkip(javafxbrowser.rpc.Long request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_SKIP, responseObserver);
    }

    /**
     */
    public void inputStreamAvailable(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_AVAILABLE, responseObserver);
    }

    /**
     */
    public void inputStreamMark(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_MARK, responseObserver);
    }

    /**
     */
    public void inputStreamReset(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_RESET, responseObserver);
    }

    /**
     */
    public void inputStreamMarkSupported(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INPUT_STREAM_MARK_SUPPORTED, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CONSTRUCTOR,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.StringObject,
                javafxbrowser.rpc.ID>(
                  this, METHODID_CONSTRUCTOR)))
          .addMethod(
            METHOD_CONNECT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Void>(
                  this, METHODID_CONNECT)))
          .addMethod(
            METHOD_SET_CONNECT_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Int,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_CONNECT_TIMEOUT)))
          .addMethod(
            METHOD_GET_CONNECT_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Int>(
                  this, METHODID_GET_CONNECT_TIMEOUT)))
          .addMethod(
            METHOD_SET_READ_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Int,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_READ_TIMEOUT)))
          .addMethod(
            METHOD_GET_READ_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Int>(
                  this, METHODID_GET_READ_TIMEOUT)))
          .addMethod(
            METHOD_GET_CONTENT_LENGTH,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Int>(
                  this, METHODID_GET_CONTENT_LENGTH)))
          .addMethod(
            METHOD_GET_CONTENT_LENGTH_LONG,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_CONTENT_LENGTH_LONG)))
          .addMethod(
            METHOD_GET_CONTENT_TYPE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_CONTENT_TYPE)))
          .addMethod(
            METHOD_GET_CONTENT_ENCODING,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_CONTENT_ENCODING)))
          .addMethod(
            METHOD_GET_EXPIRATION,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_EXPIRATION)))
          .addMethod(
            METHOD_GET_DATE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_DATE)))
          .addMethod(
            METHOD_GET_LAST_MODIFIED,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_LAST_MODIFIED)))
          .addMethod(
            METHOD_GET_HEADER_FIELD,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.StringObject,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_HEADER_FIELD)))
          .addMethod(
            METHOD_GET_HEADER_FIELD_INT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.FieldInt,
                javafxbrowser.rpc.Int>(
                  this, METHODID_GET_HEADER_FIELD_INT)))
          .addMethod(
            METHOD_GET_HEADER_FIELD_LONG,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.FieldLong,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_HEADER_FIELD_LONG)))
          .addMethod(
            METHOD_GET_HEADER_FIELD_DATE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.FieldLong,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_HEADER_FIELD_DATE)))
          .addMethod(
            METHOD_GET_HEADER_FIELD_KEY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Int,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_HEADER_FIELD_KEY)))
          .addMethod(
            METHOD_TO_STRING_OBJECT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_TO_STRING_OBJECT)))
          .addMethod(
            METHOD_SET_DO_INPUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_DO_INPUT)))
          .addMethod(
            METHOD_GET_DO_INPUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_DO_INPUT)))
          .addMethod(
            METHOD_SET_DO_OUTPUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_DO_OUTPUT)))
          .addMethod(
            METHOD_GET_DO_OUTPUT,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_DO_OUTPUT)))
          .addMethod(
            METHOD_SET_ALLOW_USER_INTERACTION,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_ALLOW_USER_INTERACTION)))
          .addMethod(
            METHOD_GET_ALLOW_USER_INTERACTION,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_ALLOW_USER_INTERACTION)))
          .addMethod(
            METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_DEFAULT_ALLOW_USER_INTERACTION)))
          .addMethod(
            METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_DEFAULT_ALLOW_USER_INTERACTION)))
          .addMethod(
            METHOD_SET_USE_CACHES,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_USE_CACHES)))
          .addMethod(
            METHOD_GET_USE_CACHES,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_USE_CACHES)))
          .addMethod(
            METHOD_SET_IF_MODIFIED_SINCE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Long,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_IF_MODIFIED_SINCE)))
          .addMethod(
            METHOD_GET_IF_MODIFIED_SINCE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Long>(
                  this, METHODID_GET_IF_MODIFIED_SINCE)))
          .addMethod(
            METHOD_GET_DEFAULT_USE_CACHES,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_GET_DEFAULT_USE_CACHES)))
          .addMethod(
            METHOD_SET_DEFAULT_USE_CACHES,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Boolean,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_DEFAULT_USE_CACHES)))
          .addMethod(
            METHOD_SET_REQUEST_PROPERTY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.KeyValue,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_REQUEST_PROPERTY)))
          .addMethod(
            METHOD_ADD_REQUEST_PROPERTY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.KeyValue,
                javafxbrowser.rpc.Void>(
                  this, METHODID_ADD_REQUEST_PROPERTY)))
          .addMethod(
            METHOD_GET_REQUEST_PROPERTY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.StringObject,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_REQUEST_PROPERTY)))
          .addMethod(
            METHOD_SET_DEFAULT_REQUEST_PROPERTY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.KeyValue,
                javafxbrowser.rpc.Void>(
                  this, METHODID_SET_DEFAULT_REQUEST_PROPERTY)))
          .addMethod(
            METHOD_GET_DEFAULT_REQUEST_PROPERTY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.StringObject,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GET_DEFAULT_REQUEST_PROPERTY)))
          .addMethod(
            METHOD_GUESS_CONTENT_TYPE_FROM_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.StringObject,
                javafxbrowser.rpc.StringObject>(
                  this, METHODID_GUESS_CONTENT_TYPE_FROM_NAME)))
          .addMethod(
            METHOD_INPUT_STREAM_CLOSE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Void>(
                  this, METHODID_INPUT_STREAM_CLOSE)))
          .addMethod(
            METHOD_INPUT_STREAM_READ,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Int>(
                  this, METHODID_INPUT_STREAM_READ)))
          .addMethod(
            METHOD_INPUT_STREAM_READ_ARRAY,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.ByteArray,
                javafxbrowser.rpc.Int>(
                  this, METHODID_INPUT_STREAM_READ_ARRAY)))
          .addMethod(
            METHOD_INPUT_STREAM_READ_ARRAY_OFF,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.ByteArrayOffset,
                javafxbrowser.rpc.Int>(
                  this, METHODID_INPUT_STREAM_READ_ARRAY_OFF)))
          .addMethod(
            METHOD_INPUT_STREAM_SKIP,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Long,
                javafxbrowser.rpc.Long>(
                  this, METHODID_INPUT_STREAM_SKIP)))
          .addMethod(
            METHOD_INPUT_STREAM_AVAILABLE,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Int>(
                  this, METHODID_INPUT_STREAM_AVAILABLE)))
          .addMethod(
            METHOD_INPUT_STREAM_MARK,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Int,
                javafxbrowser.rpc.Void>(
                  this, METHODID_INPUT_STREAM_MARK)))
          .addMethod(
            METHOD_INPUT_STREAM_RESET,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Void>(
                  this, METHODID_INPUT_STREAM_RESET)))
          .addMethod(
            METHOD_INPUT_STREAM_MARK_SUPPORTED,
            asyncUnaryCall(
              new MethodHandlers<
                javafxbrowser.rpc.Void,
                javafxbrowser.rpc.Boolean>(
                  this, METHODID_INPUT_STREAM_MARK_SUPPORTED)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class URLPetitionStub extends io.grpc.stub.AbstractStub<URLPetitionStub> {
    private URLPetitionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private URLPetitionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected URLPetitionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new URLPetitionStub(channel, callOptions);
    }

    /**
     */
    public void constructor(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.ID> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CONSTRUCTOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void connect(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CONNECT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setConnectTimeout(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_CONNECT_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConnectTimeout(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONNECT_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setReadTimeout(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_READ_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReadTimeout(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_READ_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getContentLength(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_LENGTH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getContentLengthLong(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_LENGTH_LONG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getContentType(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_TYPE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getContentEncoding(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_ENCODING, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getExpiration(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_EXPIRATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDate(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLastModified(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_MODIFIED, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeaderField(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeaderFieldInt(javafxbrowser.rpc.FieldInt request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_INT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeaderFieldLong(javafxbrowser.rpc.FieldLong request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_LONG, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeaderFieldDate(javafxbrowser.rpc.FieldLong request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_DATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHeaderFieldKey(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_KEY, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *  rpc getHeaderField(Int) returns (StringObject){}
     * </pre>
     */
    public void toStringObject(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TO_STRING_OBJECT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDoInput(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_DO_INPUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDoInput(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DO_INPUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDoOutput(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_DO_OUTPUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDoOutput(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DO_OUTPUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setAllowUserInteraction(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_ALLOW_USER_INTERACTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllowUserInteraction(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALLOW_USER_INTERACTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDefaultAllowUserInteraction(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDefaultAllowUserInteraction(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setUseCaches(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_USE_CACHES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUseCaches(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_USE_CACHES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setIfModifiedSince(javafxbrowser.rpc.Long request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_IF_MODIFIED_SINCE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIfModifiedSince(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_IF_MODIFIED_SINCE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDefaultUseCaches(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_USE_CACHES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDefaultUseCaches(javafxbrowser.rpc.Boolean request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_USE_CACHES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_REQUEST_PROPERTY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_REQUEST_PROPERTY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRequestProperty(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_REQUEST_PROPERTY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDefaultRequestProperty(javafxbrowser.rpc.KeyValue request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_REQUEST_PROPERTY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDefaultRequestProperty(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_REQUEST_PROPERTY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void guessContentTypeFromName(javafxbrowser.rpc.StringObject request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GUESS_CONTENT_TYPE_FROM_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamClose(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_CLOSE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamRead(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamReadArray(javafxbrowser.rpc.ByteArray request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ_ARRAY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ_ARRAY_OFF, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamSkip(javafxbrowser.rpc.Long request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_SKIP, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamAvailable(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_AVAILABLE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamMark(javafxbrowser.rpc.Int request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_MARK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamReset(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_RESET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void inputStreamMarkSupported(javafxbrowser.rpc.Void request,
        io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_MARK_SUPPORTED, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class URLPetitionBlockingStub extends io.grpc.stub.AbstractStub<URLPetitionBlockingStub> {
    private URLPetitionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private URLPetitionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected URLPetitionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new URLPetitionBlockingStub(channel, callOptions);
    }

    /**
     */
    public javafxbrowser.rpc.ID constructor(javafxbrowser.rpc.StringObject request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CONSTRUCTOR, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void connect(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CONNECT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setConnectTimeout(javafxbrowser.rpc.Int request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_CONNECT_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int getConnectTimeout(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONNECT_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setReadTimeout(javafxbrowser.rpc.Int request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_READ_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int getReadTimeout(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_READ_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int getContentLength(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONTENT_LENGTH, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getContentLengthLong(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONTENT_LENGTH_LONG, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getContentType(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONTENT_TYPE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getContentEncoding(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONTENT_ENCODING, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getExpiration(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_EXPIRATION, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getDate(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DATE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getLastModified(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LAST_MODIFIED, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getHeaderField(javafxbrowser.rpc.StringObject request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEADER_FIELD, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int getHeaderFieldInt(javafxbrowser.rpc.FieldInt request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEADER_FIELD_INT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getHeaderFieldLong(javafxbrowser.rpc.FieldLong request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEADER_FIELD_LONG, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getHeaderFieldDate(javafxbrowser.rpc.FieldLong request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEADER_FIELD_DATE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getHeaderFieldKey(javafxbrowser.rpc.Int request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEADER_FIELD_KEY, getCallOptions(), request);
    }

    /**
     * <pre>
     *  rpc getHeaderField(Int) returns (StringObject){}
     * </pre>
     */
    public javafxbrowser.rpc.StringObject toStringObject(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_TO_STRING_OBJECT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setDoInput(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_DO_INPUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getDoInput(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DO_INPUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setDoOutput(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_DO_OUTPUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getDoOutput(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DO_OUTPUT, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setAllowUserInteraction(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_ALLOW_USER_INTERACTION, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getAllowUserInteraction(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALLOW_USER_INTERACTION, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setDefaultAllowUserInteraction(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getDefaultAllowUserInteraction(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setUseCaches(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_USE_CACHES, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getUseCaches(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_USE_CACHES, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setIfModifiedSince(javafxbrowser.rpc.Long request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_IF_MODIFIED_SINCE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long getIfModifiedSince(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_IF_MODIFIED_SINCE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean getDefaultUseCaches(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DEFAULT_USE_CACHES, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setDefaultUseCaches(javafxbrowser.rpc.Boolean request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_DEFAULT_USE_CACHES, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setRequestProperty(javafxbrowser.rpc.KeyValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_REQUEST_PROPERTY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void addRequestProperty(javafxbrowser.rpc.KeyValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_REQUEST_PROPERTY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getRequestProperty(javafxbrowser.rpc.StringObject request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_REQUEST_PROPERTY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void setDefaultRequestProperty(javafxbrowser.rpc.KeyValue request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_DEFAULT_REQUEST_PROPERTY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject getDefaultRequestProperty(javafxbrowser.rpc.StringObject request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DEFAULT_REQUEST_PROPERTY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.StringObject guessContentTypeFromName(javafxbrowser.rpc.StringObject request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GUESS_CONTENT_TYPE_FROM_NAME, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void inputStreamClose(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_CLOSE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int inputStreamRead(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_READ, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int inputStreamReadArray(javafxbrowser.rpc.ByteArray request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_READ_ARRAY, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_READ_ARRAY_OFF, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Long inputStreamSkip(javafxbrowser.rpc.Long request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_SKIP, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Int inputStreamAvailable(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_AVAILABLE, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void inputStreamMark(javafxbrowser.rpc.Int request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_MARK, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Void inputStreamReset(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_RESET, getCallOptions(), request);
    }

    /**
     */
    public javafxbrowser.rpc.Boolean inputStreamMarkSupported(javafxbrowser.rpc.Void request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INPUT_STREAM_MARK_SUPPORTED, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class URLPetitionFutureStub extends io.grpc.stub.AbstractStub<URLPetitionFutureStub> {
    private URLPetitionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private URLPetitionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected URLPetitionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new URLPetitionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.ID> constructor(
        javafxbrowser.rpc.StringObject request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CONSTRUCTOR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> connect(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CONNECT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setConnectTimeout(
        javafxbrowser.rpc.Int request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_CONNECT_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> getConnectTimeout(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONNECT_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setReadTimeout(
        javafxbrowser.rpc.Int request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_READ_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> getReadTimeout(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_READ_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> getContentLength(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_LENGTH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getContentLengthLong(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_LENGTH_LONG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getContentType(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_TYPE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getContentEncoding(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONTENT_ENCODING, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getExpiration(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_EXPIRATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getDate(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getLastModified(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_MODIFIED, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getHeaderField(
        javafxbrowser.rpc.StringObject request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> getHeaderFieldInt(
        javafxbrowser.rpc.FieldInt request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_INT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getHeaderFieldLong(
        javafxbrowser.rpc.FieldLong request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_LONG, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getHeaderFieldDate(
        javafxbrowser.rpc.FieldLong request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_DATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getHeaderFieldKey(
        javafxbrowser.rpc.Int request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEADER_FIELD_KEY, getCallOptions()), request);
    }

    /**
     * <pre>
     *  rpc getHeaderField(Int) returns (StringObject){}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> toStringObject(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_TO_STRING_OBJECT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setDoInput(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_DO_INPUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getDoInput(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DO_INPUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setDoOutput(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_DO_OUTPUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getDoOutput(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DO_OUTPUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setAllowUserInteraction(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_ALLOW_USER_INTERACTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getAllowUserInteraction(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALLOW_USER_INTERACTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setDefaultAllowUserInteraction(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getDefaultAllowUserInteraction(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setUseCaches(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_USE_CACHES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getUseCaches(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_USE_CACHES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setIfModifiedSince(
        javafxbrowser.rpc.Long request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_IF_MODIFIED_SINCE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> getIfModifiedSince(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_IF_MODIFIED_SINCE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> getDefaultUseCaches(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_USE_CACHES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setDefaultUseCaches(
        javafxbrowser.rpc.Boolean request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_USE_CACHES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setRequestProperty(
        javafxbrowser.rpc.KeyValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_REQUEST_PROPERTY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> addRequestProperty(
        javafxbrowser.rpc.KeyValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_REQUEST_PROPERTY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getRequestProperty(
        javafxbrowser.rpc.StringObject request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_REQUEST_PROPERTY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> setDefaultRequestProperty(
        javafxbrowser.rpc.KeyValue request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_DEFAULT_REQUEST_PROPERTY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> getDefaultRequestProperty(
        javafxbrowser.rpc.StringObject request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DEFAULT_REQUEST_PROPERTY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.StringObject> guessContentTypeFromName(
        javafxbrowser.rpc.StringObject request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GUESS_CONTENT_TYPE_FROM_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> inputStreamClose(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_CLOSE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> inputStreamRead(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> inputStreamReadArray(
        javafxbrowser.rpc.ByteArray request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ_ARRAY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> inputStreamReadArrayOff(
        javafxbrowser.rpc.ByteArrayOffset request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_READ_ARRAY_OFF, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Long> inputStreamSkip(
        javafxbrowser.rpc.Long request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_SKIP, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Int> inputStreamAvailable(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_AVAILABLE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> inputStreamMark(
        javafxbrowser.rpc.Int request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_MARK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Void> inputStreamReset(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_RESET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<javafxbrowser.rpc.Boolean> inputStreamMarkSupported(
        javafxbrowser.rpc.Void request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INPUT_STREAM_MARK_SUPPORTED, getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSTRUCTOR = 0;
  private static final int METHODID_CONNECT = 1;
  private static final int METHODID_SET_CONNECT_TIMEOUT = 2;
  private static final int METHODID_GET_CONNECT_TIMEOUT = 3;
  private static final int METHODID_SET_READ_TIMEOUT = 4;
  private static final int METHODID_GET_READ_TIMEOUT = 5;
  private static final int METHODID_GET_CONTENT_LENGTH = 6;
  private static final int METHODID_GET_CONTENT_LENGTH_LONG = 7;
  private static final int METHODID_GET_CONTENT_TYPE = 8;
  private static final int METHODID_GET_CONTENT_ENCODING = 9;
  private static final int METHODID_GET_EXPIRATION = 10;
  private static final int METHODID_GET_DATE = 11;
  private static final int METHODID_GET_LAST_MODIFIED = 12;
  private static final int METHODID_GET_HEADER_FIELD = 13;
  private static final int METHODID_GET_HEADER_FIELD_INT = 14;
  private static final int METHODID_GET_HEADER_FIELD_LONG = 15;
  private static final int METHODID_GET_HEADER_FIELD_DATE = 16;
  private static final int METHODID_GET_HEADER_FIELD_KEY = 17;
  private static final int METHODID_TO_STRING_OBJECT = 18;
  private static final int METHODID_SET_DO_INPUT = 19;
  private static final int METHODID_GET_DO_INPUT = 20;
  private static final int METHODID_SET_DO_OUTPUT = 21;
  private static final int METHODID_GET_DO_OUTPUT = 22;
  private static final int METHODID_SET_ALLOW_USER_INTERACTION = 23;
  private static final int METHODID_GET_ALLOW_USER_INTERACTION = 24;
  private static final int METHODID_SET_DEFAULT_ALLOW_USER_INTERACTION = 25;
  private static final int METHODID_GET_DEFAULT_ALLOW_USER_INTERACTION = 26;
  private static final int METHODID_SET_USE_CACHES = 27;
  private static final int METHODID_GET_USE_CACHES = 28;
  private static final int METHODID_SET_IF_MODIFIED_SINCE = 29;
  private static final int METHODID_GET_IF_MODIFIED_SINCE = 30;
  private static final int METHODID_GET_DEFAULT_USE_CACHES = 31;
  private static final int METHODID_SET_DEFAULT_USE_CACHES = 32;
  private static final int METHODID_SET_REQUEST_PROPERTY = 33;
  private static final int METHODID_ADD_REQUEST_PROPERTY = 34;
  private static final int METHODID_GET_REQUEST_PROPERTY = 35;
  private static final int METHODID_SET_DEFAULT_REQUEST_PROPERTY = 36;
  private static final int METHODID_GET_DEFAULT_REQUEST_PROPERTY = 37;
  private static final int METHODID_GUESS_CONTENT_TYPE_FROM_NAME = 38;
  private static final int METHODID_INPUT_STREAM_CLOSE = 39;
  private static final int METHODID_INPUT_STREAM_READ = 40;
  private static final int METHODID_INPUT_STREAM_READ_ARRAY = 41;
  private static final int METHODID_INPUT_STREAM_READ_ARRAY_OFF = 42;
  private static final int METHODID_INPUT_STREAM_SKIP = 43;
  private static final int METHODID_INPUT_STREAM_AVAILABLE = 44;
  private static final int METHODID_INPUT_STREAM_MARK = 45;
  private static final int METHODID_INPUT_STREAM_RESET = 46;
  private static final int METHODID_INPUT_STREAM_MARK_SUPPORTED = 47;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final URLPetitionImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(URLPetitionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSTRUCTOR:
          serviceImpl.constructor((javafxbrowser.rpc.StringObject) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.ID>) responseObserver);
          break;
        case METHODID_CONNECT:
          serviceImpl.connect((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_SET_CONNECT_TIMEOUT:
          serviceImpl.setConnectTimeout((javafxbrowser.rpc.Int) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_CONNECT_TIMEOUT:
          serviceImpl.getConnectTimeout((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_SET_READ_TIMEOUT:
          serviceImpl.setReadTimeout((javafxbrowser.rpc.Int) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_READ_TIMEOUT:
          serviceImpl.getReadTimeout((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_GET_CONTENT_LENGTH:
          serviceImpl.getContentLength((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_GET_CONTENT_LENGTH_LONG:
          serviceImpl.getContentLengthLong((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_CONTENT_TYPE:
          serviceImpl.getContentType((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_GET_CONTENT_ENCODING:
          serviceImpl.getContentEncoding((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_GET_EXPIRATION:
          serviceImpl.getExpiration((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_DATE:
          serviceImpl.getDate((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_LAST_MODIFIED:
          serviceImpl.getLastModified((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_HEADER_FIELD:
          serviceImpl.getHeaderField((javafxbrowser.rpc.StringObject) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_GET_HEADER_FIELD_INT:
          serviceImpl.getHeaderFieldInt((javafxbrowser.rpc.FieldInt) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_GET_HEADER_FIELD_LONG:
          serviceImpl.getHeaderFieldLong((javafxbrowser.rpc.FieldLong) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_HEADER_FIELD_DATE:
          serviceImpl.getHeaderFieldDate((javafxbrowser.rpc.FieldLong) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_HEADER_FIELD_KEY:
          serviceImpl.getHeaderFieldKey((javafxbrowser.rpc.Int) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_TO_STRING_OBJECT:
          serviceImpl.toStringObject((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_SET_DO_INPUT:
          serviceImpl.setDoInput((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_DO_INPUT:
          serviceImpl.getDoInput((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_DO_OUTPUT:
          serviceImpl.setDoOutput((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_DO_OUTPUT:
          serviceImpl.getDoOutput((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_ALLOW_USER_INTERACTION:
          serviceImpl.setAllowUserInteraction((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_ALLOW_USER_INTERACTION:
          serviceImpl.getAllowUserInteraction((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_DEFAULT_ALLOW_USER_INTERACTION:
          serviceImpl.setDefaultAllowUserInteraction((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_DEFAULT_ALLOW_USER_INTERACTION:
          serviceImpl.getDefaultAllowUserInteraction((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_USE_CACHES:
          serviceImpl.setUseCaches((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_USE_CACHES:
          serviceImpl.getUseCaches((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_IF_MODIFIED_SINCE:
          serviceImpl.setIfModifiedSince((javafxbrowser.rpc.Long) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_IF_MODIFIED_SINCE:
          serviceImpl.getIfModifiedSince((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_GET_DEFAULT_USE_CACHES:
          serviceImpl.getDefaultUseCaches((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
          break;
        case METHODID_SET_DEFAULT_USE_CACHES:
          serviceImpl.setDefaultUseCaches((javafxbrowser.rpc.Boolean) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_SET_REQUEST_PROPERTY:
          serviceImpl.setRequestProperty((javafxbrowser.rpc.KeyValue) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_ADD_REQUEST_PROPERTY:
          serviceImpl.addRequestProperty((javafxbrowser.rpc.KeyValue) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_REQUEST_PROPERTY:
          serviceImpl.getRequestProperty((javafxbrowser.rpc.StringObject) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_SET_DEFAULT_REQUEST_PROPERTY:
          serviceImpl.setDefaultRequestProperty((javafxbrowser.rpc.KeyValue) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_GET_DEFAULT_REQUEST_PROPERTY:
          serviceImpl.getDefaultRequestProperty((javafxbrowser.rpc.StringObject) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_GUESS_CONTENT_TYPE_FROM_NAME:
          serviceImpl.guessContentTypeFromName((javafxbrowser.rpc.StringObject) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.StringObject>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_CLOSE:
          serviceImpl.inputStreamClose((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_READ:
          serviceImpl.inputStreamRead((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_READ_ARRAY:
          serviceImpl.inputStreamReadArray((javafxbrowser.rpc.ByteArray) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_READ_ARRAY_OFF:
          serviceImpl.inputStreamReadArrayOff((javafxbrowser.rpc.ByteArrayOffset) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_SKIP:
          serviceImpl.inputStreamSkip((javafxbrowser.rpc.Long) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Long>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_AVAILABLE:
          serviceImpl.inputStreamAvailable((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Int>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_MARK:
          serviceImpl.inputStreamMark((javafxbrowser.rpc.Int) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_RESET:
          serviceImpl.inputStreamReset((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Void>) responseObserver);
          break;
        case METHODID_INPUT_STREAM_MARK_SUPPORTED:
          serviceImpl.inputStreamMarkSupported((javafxbrowser.rpc.Void) request,
              (io.grpc.stub.StreamObserver<javafxbrowser.rpc.Boolean>) responseObserver);
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
        METHOD_CONSTRUCTOR,
        METHOD_CONNECT,
        METHOD_SET_CONNECT_TIMEOUT,
        METHOD_GET_CONNECT_TIMEOUT,
        METHOD_SET_READ_TIMEOUT,
        METHOD_GET_READ_TIMEOUT,
        METHOD_GET_CONTENT_LENGTH,
        METHOD_GET_CONTENT_LENGTH_LONG,
        METHOD_GET_CONTENT_TYPE,
        METHOD_GET_CONTENT_ENCODING,
        METHOD_GET_EXPIRATION,
        METHOD_GET_DATE,
        METHOD_GET_LAST_MODIFIED,
        METHOD_GET_HEADER_FIELD,
        METHOD_GET_HEADER_FIELD_INT,
        METHOD_GET_HEADER_FIELD_LONG,
        METHOD_GET_HEADER_FIELD_DATE,
        METHOD_GET_HEADER_FIELD_KEY,
        METHOD_TO_STRING_OBJECT,
        METHOD_SET_DO_INPUT,
        METHOD_GET_DO_INPUT,
        METHOD_SET_DO_OUTPUT,
        METHOD_GET_DO_OUTPUT,
        METHOD_SET_ALLOW_USER_INTERACTION,
        METHOD_GET_ALLOW_USER_INTERACTION,
        METHOD_SET_DEFAULT_ALLOW_USER_INTERACTION,
        METHOD_GET_DEFAULT_ALLOW_USER_INTERACTION,
        METHOD_SET_USE_CACHES,
        METHOD_GET_USE_CACHES,
        METHOD_SET_IF_MODIFIED_SINCE,
        METHOD_GET_IF_MODIFIED_SINCE,
        METHOD_GET_DEFAULT_USE_CACHES,
        METHOD_SET_DEFAULT_USE_CACHES,
        METHOD_SET_REQUEST_PROPERTY,
        METHOD_ADD_REQUEST_PROPERTY,
        METHOD_GET_REQUEST_PROPERTY,
        METHOD_SET_DEFAULT_REQUEST_PROPERTY,
        METHOD_GET_DEFAULT_REQUEST_PROPERTY,
        METHOD_GUESS_CONTENT_TYPE_FROM_NAME,
        METHOD_INPUT_STREAM_CLOSE,
        METHOD_INPUT_STREAM_READ,
        METHOD_INPUT_STREAM_READ_ARRAY,
        METHOD_INPUT_STREAM_READ_ARRAY_OFF,
        METHOD_INPUT_STREAM_SKIP,
        METHOD_INPUT_STREAM_AVAILABLE,
        METHOD_INPUT_STREAM_MARK,
        METHOD_INPUT_STREAM_RESET,
        METHOD_INPUT_STREAM_MARK_SUPPORTED);
  }

}
