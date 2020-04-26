package event.grpc.gen;

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
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: event.proto")
public final class EventSubscribeGrpc {

  private EventSubscribeGrpc() {}

  public static final String SERVICE_NAME = "event.EventSubscribe";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<event.grpc.gen.SubscribeRequest,
      event.grpc.gen.Event> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = event.grpc.gen.SubscribeRequest.class,
      responseType = event.grpc.gen.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<event.grpc.gen.SubscribeRequest,
      event.grpc.gen.Event> getSubscribeMethod() {
    io.grpc.MethodDescriptor<event.grpc.gen.SubscribeRequest, event.grpc.gen.Event> getSubscribeMethod;
    if ((getSubscribeMethod = EventSubscribeGrpc.getSubscribeMethod) == null) {
      synchronized (EventSubscribeGrpc.class) {
        if ((getSubscribeMethod = EventSubscribeGrpc.getSubscribeMethod) == null) {
          EventSubscribeGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<event.grpc.gen.SubscribeRequest, event.grpc.gen.Event>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  event.grpc.gen.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  event.grpc.gen.Event.getDefaultInstance()))
              .setSchemaDescriptor(new EventSubscribeMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventSubscribeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscribeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscribeStub>() {
        @java.lang.Override
        public EventSubscribeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscribeStub(channel, callOptions);
        }
      };
    return EventSubscribeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventSubscribeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscribeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscribeBlockingStub>() {
        @java.lang.Override
        public EventSubscribeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscribeBlockingStub(channel, callOptions);
        }
      };
    return EventSubscribeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventSubscribeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventSubscribeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventSubscribeFutureStub>() {
        @java.lang.Override
        public EventSubscribeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventSubscribeFutureStub(channel, callOptions);
        }
      };
    return EventSubscribeFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EventSubscribeImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(event.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<event.grpc.gen.Event> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                event.grpc.gen.SubscribeRequest,
                event.grpc.gen.Event>(
                  this, METHODID_SUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class EventSubscribeStub extends io.grpc.stub.AbstractAsyncStub<EventSubscribeStub> {
    private EventSubscribeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscribeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscribeStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(event.grpc.gen.SubscribeRequest request,
        io.grpc.stub.StreamObserver<event.grpc.gen.Event> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventSubscribeBlockingStub extends io.grpc.stub.AbstractBlockingStub<EventSubscribeBlockingStub> {
    private EventSubscribeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscribeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscribeBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<event.grpc.gen.Event> subscribe(
        event.grpc.gen.SubscribeRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventSubscribeFutureStub extends io.grpc.stub.AbstractFutureStub<EventSubscribeFutureStub> {
    private EventSubscribeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventSubscribeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventSubscribeFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventSubscribeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventSubscribeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((event.grpc.gen.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<event.grpc.gen.Event>) responseObserver);
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

  private static abstract class EventSubscribeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventSubscribeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return event.grpc.gen.EventProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventSubscribe");
    }
  }

  private static final class EventSubscribeFileDescriptorSupplier
      extends EventSubscribeBaseDescriptorSupplier {
    EventSubscribeFileDescriptorSupplier() {}
  }

  private static final class EventSubscribeMethodDescriptorSupplier
      extends EventSubscribeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventSubscribeMethodDescriptorSupplier(String methodName) {
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
      synchronized (EventSubscribeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventSubscribeFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
