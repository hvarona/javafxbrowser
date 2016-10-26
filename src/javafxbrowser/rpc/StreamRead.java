// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: net.proto

package javafxbrowser.rpc;

/**
 * Protobuf type {@code rpcurlconn.StreamRead}
 */
public  final class StreamRead extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcurlconn.StreamRead)
    StreamReadOrBuilder {
  // Use StreamRead.newBuilder() to construct.
  private StreamRead(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StreamRead() {
    amount_ = 0;
    array_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private StreamRead(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            amount_ = input.readInt32();
            break;
          }
          case 18: {

            array_ = input.readBytes();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_StreamRead_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_StreamRead_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            javafxbrowser.rpc.StreamRead.class, javafxbrowser.rpc.StreamRead.Builder.class);
  }

  public static final int AMOUNT_FIELD_NUMBER = 1;
  private int amount_;
  /**
   * <code>optional int32 amount = 1;</code>
   */
  public int getAmount() {
    return amount_;
  }

  public static final int ARRAY_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString array_;
  /**
   * <code>optional bytes array = 2;</code>
   */
  public com.google.protobuf.ByteString getArray() {
    return array_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (amount_ != 0) {
      output.writeInt32(1, amount_);
    }
    if (!array_.isEmpty()) {
      output.writeBytes(2, array_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (amount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, amount_);
    }
    if (!array_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, array_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof javafxbrowser.rpc.StreamRead)) {
      return super.equals(obj);
    }
    javafxbrowser.rpc.StreamRead other = (javafxbrowser.rpc.StreamRead) obj;

    boolean result = true;
    result = result && (getAmount()
        == other.getAmount());
    result = result && getArray()
        .equals(other.getArray());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getAmount();
    hash = (37 * hash) + ARRAY_FIELD_NUMBER;
    hash = (53 * hash) + getArray().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static javafxbrowser.rpc.StreamRead parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static javafxbrowser.rpc.StreamRead parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.StreamRead parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.StreamRead parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(javafxbrowser.rpc.StreamRead prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code rpcurlconn.StreamRead}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcurlconn.StreamRead)
      javafxbrowser.rpc.StreamReadOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_StreamRead_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_StreamRead_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              javafxbrowser.rpc.StreamRead.class, javafxbrowser.rpc.StreamRead.Builder.class);
    }

    // Construct using javafxbrowser.rpc.StreamRead.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      amount_ = 0;

      array_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_StreamRead_descriptor;
    }

    public javafxbrowser.rpc.StreamRead getDefaultInstanceForType() {
      return javafxbrowser.rpc.StreamRead.getDefaultInstance();
    }

    public javafxbrowser.rpc.StreamRead build() {
      javafxbrowser.rpc.StreamRead result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public javafxbrowser.rpc.StreamRead buildPartial() {
      javafxbrowser.rpc.StreamRead result = new javafxbrowser.rpc.StreamRead(this);
      result.amount_ = amount_;
      result.array_ = array_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof javafxbrowser.rpc.StreamRead) {
        return mergeFrom((javafxbrowser.rpc.StreamRead)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(javafxbrowser.rpc.StreamRead other) {
      if (other == javafxbrowser.rpc.StreamRead.getDefaultInstance()) return this;
      if (other.getAmount() != 0) {
        setAmount(other.getAmount());
      }
      if (other.getArray() != com.google.protobuf.ByteString.EMPTY) {
        setArray(other.getArray());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      javafxbrowser.rpc.StreamRead parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (javafxbrowser.rpc.StreamRead) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int amount_ ;
    /**
     * <code>optional int32 amount = 1;</code>
     */
    public int getAmount() {
      return amount_;
    }
    /**
     * <code>optional int32 amount = 1;</code>
     */
    public Builder setAmount(int value) {
      
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 amount = 1;</code>
     */
    public Builder clearAmount() {
      
      amount_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString array_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>optional bytes array = 2;</code>
     */
    public com.google.protobuf.ByteString getArray() {
      return array_;
    }
    /**
     * <code>optional bytes array = 2;</code>
     */
    public Builder setArray(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      array_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bytes array = 2;</code>
     */
    public Builder clearArray() {
      
      array_ = getDefaultInstance().getArray();
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:rpcurlconn.StreamRead)
  }

  // @@protoc_insertion_point(class_scope:rpcurlconn.StreamRead)
  private static final javafxbrowser.rpc.StreamRead DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new javafxbrowser.rpc.StreamRead();
  }

  public static javafxbrowser.rpc.StreamRead getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StreamRead>
      PARSER = new com.google.protobuf.AbstractParser<StreamRead>() {
    public StreamRead parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new StreamRead(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StreamRead> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StreamRead> getParserForType() {
    return PARSER;
  }

  public javafxbrowser.rpc.StreamRead getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

