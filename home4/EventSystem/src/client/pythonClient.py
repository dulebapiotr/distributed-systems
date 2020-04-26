import grpc
import time
import sys

from grpc._channel import _MultiThreadedRendezvous

sys.path.append('C:\\Users\\Piotrek\\Desktop\\distributed-systems\\home4\\EventSystem\\gen')
import event_pb2 as event
import event_pb2_grpc as eventgrpc

channel = grpc.insecure_channel('localhost:50051')
stub = eventgrpc.EventSubscribeStub(channel)


city = input("Enter city >> ")

print("Avaliable types:")
for i,t in enumerate(event._TYPE.values_by_name):
    print(str(i)+' '+str(t))

eTypes = input("Enter events type (numbers separated with space) >> ").split(" ")

types = []
for i in eTypes:
    if i=="0":
        types.append(0)
    if i=="1":
        types.append(1)
    if i=="2":
        types.append(2)
    if i=="3":
        types.append(3)

request = event.SubscribeRequest(city = city, type = types)

def subscribe(request):
    stream = stub.subscribe(request)
    try:
        for e in stream:
            print("---------------------------------------")
            print(e)
    except _MultiThreadedRendezvous:
        return

while True:
    subscribe(request)
    time.sleep(2)
    print("renewing connection")