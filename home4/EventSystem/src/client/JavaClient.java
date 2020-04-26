package client;

import event.grpc.gen.Event;
import event.grpc.gen.EventSubscribeGrpc;
import event.grpc.gen.SubscribeRequest;
import event.grpc.gen.Type;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaClient {
    private final ManagedChannel channel;
    private final EventSubscribeGrpc.EventSubscribeBlockingStub eventSubscribeStub;

    public JavaClient(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        eventSubscribeStub = EventSubscribeGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args)throws Exception{
        JavaClient client = new JavaClient("localhost", 50051);
        client.start();
    }

    private void start() throws  IOException, InterruptedException{
        BufferedReader br = new BufferedReader((new java.io.InputStreamReader(System.in)));
        System.out.print("Enter city >>");
        String city = br.readLine();
        System.out.println("Available types of events:");
        for(int i=0;i<Type.values().length-1;i++){
            System.out.println(i+": "+Type.forNumber(i));
        }
        System.out.print("Enter type numbers, separated with space: >>");
        String[] typesStr = br.readLine().split(" ");
        List<Type> types = new ArrayList<>();
        for(int i=0;i<typesStr.length-1;i++){
            types.add(Type.forNumber(Integer.valueOf(typesStr[i])));
        }

        SubscribeRequest request = SubscribeRequest.newBuilder()
                .setCity(city)
                .addAllType(types)
                .build();
        while(true){
            manageSubscribe(request);
            Thread.sleep(5000);
            System.out.println("Subscribtion restart!");

        }
    }

    private void manageSubscribe(SubscribeRequest request){
        Iterator<Event> events;
        events = eventSubscribeStub.subscribe(request);
        while(events.hasNext()){
            System.out.println("New Event!");
            Event event = events.next();

            System.out.print("Type: ");
            for(Type t : event.getTypeList()){
                System.out.print(t+" ");
            }
            System.out.println("Address: "+ event.getAddress().getCountry() + " "+event.getAddress().getCity()
                    +" "+event.getAddress().getStreet()+" "+event.getAddress().getHouseNumber());
            System.out.println("Date: "+event.getDate().getYear()+ "."+event.getDate().getMonth()+"."+event.getDate().getDay());
            System.out.println("Time: "+event.getDate().getHour()+ ":"+event.getDate().getMin());


        }
    }
}
