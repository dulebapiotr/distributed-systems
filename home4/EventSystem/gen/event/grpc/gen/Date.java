// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package event.grpc.gen;

/**
 * Protobuf type {@code event.Date}
 */
public  final class Date extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:event.Date)
    DateOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Date.newBuilder() to construct.
  private Date(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Date() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Date();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Date(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            year_ = input.readInt32();
            break;
          }
          case 16: {

            month_ = input.readInt32();
            break;
          }
          case 24: {

            day_ = input.readInt32();
            break;
          }
          case 32: {

            hour_ = input.readInt32();
            break;
          }
          case 40: {

            min_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return event.grpc.gen.EventProto.internal_static_event_Date_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return event.grpc.gen.EventProto.internal_static_event_Date_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            event.grpc.gen.Date.class, event.grpc.gen.Date.Builder.class);
  }

  public static final int YEAR_FIELD_NUMBER = 1;
  private int year_;
  /**
   * <code>int32 year = 1;</code>
   * @return The year.
   */
  public int getYear() {
    return year_;
  }

  public static final int MONTH_FIELD_NUMBER = 2;
  private int month_;
  /**
   * <code>int32 month = 2;</code>
   * @return The month.
   */
  public int getMonth() {
    return month_;
  }

  public static final int DAY_FIELD_NUMBER = 3;
  private int day_;
  /**
   * <code>int32 day = 3;</code>
   * @return The day.
   */
  public int getDay() {
    return day_;
  }

  public static final int HOUR_FIELD_NUMBER = 4;
  private int hour_;
  /**
   * <code>int32 hour = 4;</code>
   * @return The hour.
   */
  public int getHour() {
    return hour_;
  }

  public static final int MIN_FIELD_NUMBER = 5;
  private int min_;
  /**
   * <code>int32 min = 5;</code>
   * @return The min.
   */
  public int getMin() {
    return min_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (year_ != 0) {
      output.writeInt32(1, year_);
    }
    if (month_ != 0) {
      output.writeInt32(2, month_);
    }
    if (day_ != 0) {
      output.writeInt32(3, day_);
    }
    if (hour_ != 0) {
      output.writeInt32(4, hour_);
    }
    if (min_ != 0) {
      output.writeInt32(5, min_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (year_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, year_);
    }
    if (month_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, month_);
    }
    if (day_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, day_);
    }
    if (hour_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, hour_);
    }
    if (min_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, min_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof event.grpc.gen.Date)) {
      return super.equals(obj);
    }
    event.grpc.gen.Date other = (event.grpc.gen.Date) obj;

    if (getYear()
        != other.getYear()) return false;
    if (getMonth()
        != other.getMonth()) return false;
    if (getDay()
        != other.getDay()) return false;
    if (getHour()
        != other.getHour()) return false;
    if (getMin()
        != other.getMin()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + YEAR_FIELD_NUMBER;
    hash = (53 * hash) + getYear();
    hash = (37 * hash) + MONTH_FIELD_NUMBER;
    hash = (53 * hash) + getMonth();
    hash = (37 * hash) + DAY_FIELD_NUMBER;
    hash = (53 * hash) + getDay();
    hash = (37 * hash) + HOUR_FIELD_NUMBER;
    hash = (53 * hash) + getHour();
    hash = (37 * hash) + MIN_FIELD_NUMBER;
    hash = (53 * hash) + getMin();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static event.grpc.gen.Date parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static event.grpc.gen.Date parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static event.grpc.gen.Date parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static event.grpc.gen.Date parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static event.grpc.gen.Date parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static event.grpc.gen.Date parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static event.grpc.gen.Date parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static event.grpc.gen.Date parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static event.grpc.gen.Date parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static event.grpc.gen.Date parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static event.grpc.gen.Date parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static event.grpc.gen.Date parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(event.grpc.gen.Date prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code event.Date}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:event.Date)
      event.grpc.gen.DateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return event.grpc.gen.EventProto.internal_static_event_Date_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return event.grpc.gen.EventProto.internal_static_event_Date_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              event.grpc.gen.Date.class, event.grpc.gen.Date.Builder.class);
    }

    // Construct using event.grpc.gen.Date.newBuilder()
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
    @java.lang.Override
    public Builder clear() {
      super.clear();
      year_ = 0;

      month_ = 0;

      day_ = 0;

      hour_ = 0;

      min_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return event.grpc.gen.EventProto.internal_static_event_Date_descriptor;
    }

    @java.lang.Override
    public event.grpc.gen.Date getDefaultInstanceForType() {
      return event.grpc.gen.Date.getDefaultInstance();
    }

    @java.lang.Override
    public event.grpc.gen.Date build() {
      event.grpc.gen.Date result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public event.grpc.gen.Date buildPartial() {
      event.grpc.gen.Date result = new event.grpc.gen.Date(this);
      result.year_ = year_;
      result.month_ = month_;
      result.day_ = day_;
      result.hour_ = hour_;
      result.min_ = min_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof event.grpc.gen.Date) {
        return mergeFrom((event.grpc.gen.Date)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(event.grpc.gen.Date other) {
      if (other == event.grpc.gen.Date.getDefaultInstance()) return this;
      if (other.getYear() != 0) {
        setYear(other.getYear());
      }
      if (other.getMonth() != 0) {
        setMonth(other.getMonth());
      }
      if (other.getDay() != 0) {
        setDay(other.getDay());
      }
      if (other.getHour() != 0) {
        setHour(other.getHour());
      }
      if (other.getMin() != 0) {
        setMin(other.getMin());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      event.grpc.gen.Date parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (event.grpc.gen.Date) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int year_ ;
    /**
     * <code>int32 year = 1;</code>
     * @return The year.
     */
    public int getYear() {
      return year_;
    }
    /**
     * <code>int32 year = 1;</code>
     * @param value The year to set.
     * @return This builder for chaining.
     */
    public Builder setYear(int value) {
      
      year_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 year = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearYear() {
      
      year_ = 0;
      onChanged();
      return this;
    }

    private int month_ ;
    /**
     * <code>int32 month = 2;</code>
     * @return The month.
     */
    public int getMonth() {
      return month_;
    }
    /**
     * <code>int32 month = 2;</code>
     * @param value The month to set.
     * @return This builder for chaining.
     */
    public Builder setMonth(int value) {
      
      month_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 month = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMonth() {
      
      month_ = 0;
      onChanged();
      return this;
    }

    private int day_ ;
    /**
     * <code>int32 day = 3;</code>
     * @return The day.
     */
    public int getDay() {
      return day_;
    }
    /**
     * <code>int32 day = 3;</code>
     * @param value The day to set.
     * @return This builder for chaining.
     */
    public Builder setDay(int value) {
      
      day_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 day = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDay() {
      
      day_ = 0;
      onChanged();
      return this;
    }

    private int hour_ ;
    /**
     * <code>int32 hour = 4;</code>
     * @return The hour.
     */
    public int getHour() {
      return hour_;
    }
    /**
     * <code>int32 hour = 4;</code>
     * @param value The hour to set.
     * @return This builder for chaining.
     */
    public Builder setHour(int value) {
      
      hour_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 hour = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearHour() {
      
      hour_ = 0;
      onChanged();
      return this;
    }

    private int min_ ;
    /**
     * <code>int32 min = 5;</code>
     * @return The min.
     */
    public int getMin() {
      return min_;
    }
    /**
     * <code>int32 min = 5;</code>
     * @param value The min to set.
     * @return This builder for chaining.
     */
    public Builder setMin(int value) {
      
      min_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 min = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearMin() {
      
      min_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:event.Date)
  }

  // @@protoc_insertion_point(class_scope:event.Date)
  private static final event.grpc.gen.Date DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new event.grpc.gen.Date();
  }

  public static event.grpc.gen.Date getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Date>
      PARSER = new com.google.protobuf.AbstractParser<Date>() {
    @java.lang.Override
    public Date parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Date(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Date> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Date> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public event.grpc.gen.Date getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

