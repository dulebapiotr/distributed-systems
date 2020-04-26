# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import event_pb2 as event__pb2


class EventSubscribeStub(object):
    """Missing associated documentation comment in .proto file"""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.subscribe = channel.unary_stream(
                '/event.EventSubscribe/subscribe',
                request_serializer=event__pb2.SubscribeRequest.SerializeToString,
                response_deserializer=event__pb2.Event.FromString,
                )


class EventSubscribeServicer(object):
    """Missing associated documentation comment in .proto file"""

    def subscribe(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_EventSubscribeServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'subscribe': grpc.unary_stream_rpc_method_handler(
                    servicer.subscribe,
                    request_deserializer=event__pb2.SubscribeRequest.FromString,
                    response_serializer=event__pb2.Event.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'event.EventSubscribe', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class EventSubscribe(object):
    """Missing associated documentation comment in .proto file"""

    @staticmethod
    def subscribe(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(request, target, '/event.EventSubscribe/subscribe',
            event__pb2.SubscribeRequest.SerializeToString,
            event__pb2.Event.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)