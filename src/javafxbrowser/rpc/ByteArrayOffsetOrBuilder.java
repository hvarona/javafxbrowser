// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: net.proto

package javafxbrowser.rpc;

public interface ByteArrayOffsetOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpcurlconn.ByteArrayOffset)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 conId = 1;</code>
   */
  long getConId();

  /**
   * <code>optional bytes array = 2;</code>
   */
  com.google.protobuf.ByteString getArray();

  /**
   * <code>optional int32 offset = 3;</code>
   */
  int getOffset();

  /**
   * <code>optional int32 len = 4;</code>
   */
  int getLen();
}
