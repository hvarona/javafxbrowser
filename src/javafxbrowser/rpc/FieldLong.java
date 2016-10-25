// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: net.proto

package javafxbrowser.rpc;

/**
 * Protobuf type {@code rpcurlconn.FieldLong}
 */
public  final class FieldLong extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rpcurlconn.FieldLong)
    FieldLongOrBuilder {
  // Use FieldLong.newBuilder() to construct.
  private FieldLong(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FieldLong() {
    conId_ = 0L;
    name_ = "";
    default_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private FieldLong(
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

            conId_ = input.readInt64();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 24: {

            default_ = input.readInt64();
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
    return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_FieldLong_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_FieldLong_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            javafxbrowser.rpc.FieldLong.class, javafxbrowser.rpc.FieldLong.Builder.class);
  }

  public static final int CONID_FIELD_NUMBER = 1;
  private long conId_;
  /**
   * <code>optional int64 conId = 1;</code>
   */
  public long getConId() {
    return conId_;
  }

  public static final int NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object name_;
  /**
   * <code>optional string name = 2;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>optional string name = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DEFAULT_FIELD_NUMBER = 3;
  private long default_;
  /**
   * <code>optional int64 default = 3;</code>
   */
  public long getDefault() {
    return default_;
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
    if (conId_ != 0L) {
      output.writeInt64(1, conId_);
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
    }
    if (default_ != 0L) {
      output.writeInt64(3, default_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (conId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, conId_);
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
    }
    if (default_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, default_);
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
    if (!(obj instanceof javafxbrowser.rpc.FieldLong)) {
      return super.equals(obj);
    }
    javafxbrowser.rpc.FieldLong other = (javafxbrowser.rpc.FieldLong) obj;

    boolean result = true;
    result = result && (getConId()
        == other.getConId());
    result = result && getName()
        .equals(other.getName());
    result = result && (getDefault()
        == other.getDefault());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + CONID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getConId());
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + DEFAULT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDefault());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static javafxbrowser.rpc.FieldLong parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static javafxbrowser.rpc.FieldLong parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.FieldLong parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static javafxbrowser.rpc.FieldLong parseFrom(
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
  public static Builder newBuilder(javafxbrowser.rpc.FieldLong prototype) {
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
   * Protobuf type {@code rpcurlconn.FieldLong}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rpcurlconn.FieldLong)
      javafxbrowser.rpc.FieldLongOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_FieldLong_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_FieldLong_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              javafxbrowser.rpc.FieldLong.class, javafxbrowser.rpc.FieldLong.Builder.class);
    }

    // Construct using javafxbrowser.rpc.FieldLong.newBuilder()
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
      conId_ = 0L;

      name_ = "";

      default_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return javafxbrowser.rpc.RPCURLConnection.internal_static_rpcurlconn_FieldLong_descriptor;
    }

    public javafxbrowser.rpc.FieldLong getDefaultInstanceForType() {
      return javafxbrowser.rpc.FieldLong.getDefaultInstance();
    }

    public javafxbrowser.rpc.FieldLong build() {
      javafxbrowser.rpc.FieldLong result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public javafxbrowser.rpc.FieldLong buildPartial() {
      javafxbrowser.rpc.FieldLong result = new javafxbrowser.rpc.FieldLong(this);
      result.conId_ = conId_;
      result.name_ = name_;
      result.default_ = default_;
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
      if (other instanceof javafxbrowser.rpc.FieldLong) {
        return mergeFrom((javafxbrowser.rpc.FieldLong)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(javafxbrowser.rpc.FieldLong other) {
      if (other == javafxbrowser.rpc.FieldLong.getDefaultInstance()) return this;
      if (other.getConId() != 0L) {
        setConId(other.getConId());
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getDefault() != 0L) {
        setDefault(other.getDefault());
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
      javafxbrowser.rpc.FieldLong parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (javafxbrowser.rpc.FieldLong) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long conId_ ;
    /**
     * <code>optional int64 conId = 1;</code>
     */
    public long getConId() {
      return conId_;
    }
    /**
     * <code>optional int64 conId = 1;</code>
     */
    public Builder setConId(long value) {
      
      conId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 conId = 1;</code>
     */
    public Builder clearConId() {
      
      conId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>optional string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string name = 2;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private long default_ ;
    /**
     * <code>optional int64 default = 3;</code>
     */
    public long getDefault() {
      return default_;
    }
    /**
     * <code>optional int64 default = 3;</code>
     */
    public Builder setDefault(long value) {
      
      default_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 default = 3;</code>
     */
    public Builder clearDefault() {
      
      default_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:rpcurlconn.FieldLong)
  }

  // @@protoc_insertion_point(class_scope:rpcurlconn.FieldLong)
  private static final javafxbrowser.rpc.FieldLong DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new javafxbrowser.rpc.FieldLong();
  }

  public static javafxbrowser.rpc.FieldLong getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FieldLong>
      PARSER = new com.google.protobuf.AbstractParser<FieldLong>() {
    public FieldLong parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new FieldLong(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FieldLong> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FieldLong> getParserForType() {
    return PARSER;
  }

  public javafxbrowser.rpc.FieldLong getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
