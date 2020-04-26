package server;

import event.grpc.gen.*;
import event.grpc.gen.Date;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import server.EventStreamObserver;

import java.util.*;

public class EventSubscribeImpl extends EventSubscribeGrpc.EventSubscribeImplBase implements Runnable{

    private final static HashSet<StreamObserver<Event>> observers  = new LinkedHashSet<>();

    public static HashSet<StreamObserver<Event>> getObservers(){return observers;}

    public void subscribe(SubscribeRequest request, StreamObserver<Event> response){
        observers.add(new EventStreamObserver(request,response));
    }


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try{
                Event event = generateEvent();
                System.out.print("New event: ");
                for(Type t : event.getTypeList()){
                    System.out.print(" "+ t);
                }
                System.out.println(" City: "+event.getAddress().getCity());
                System.out.println(" Time: "+event.getDate().getYear() + " "+event.getDate().getMonth()+" "+event.getDate().getDay());
                Thread.sleep(2000);

                List<StreamObserver<Event>> dead = new ArrayList<>();
                for(StreamObserver oneObserver : observers){
                    try{
                        oneObserver.onNext(event);
                    }catch (StatusRuntimeException e){
                        dead.add(oneObserver);
                    }

                }
                observers.removeAll(dead);


            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

    }

    private Event generateEvent(){
        Random random = new Random();
        Type type1 = null;
        Type type2 = null;
        switch (Math.abs(random.nextInt())%(Type.values().length)){
            case 0: {
                type1 = Type.CONCERT;
                type2 = Type.PARTY;
                break;
            }
            case 1: {
                type1 = Type.CONFERENCE;
                type2 = Type.SPORT;
                break;
            }
            case 3: {
                type1 = Type.CONCERT;
                type2 = Type.SPORT;
                break;
            }
             default:{
                 type1 = Type.PARTY;
                 type2 = Type.SPORT;
                 break;
             }

        }
        String[] cities = new String[]{"Krakow","Lublin","Poznan","Radom","Warszawa","Zakopane"};
        Date date = Date.newBuilder()
                .setYear(2020+Math.abs(random.nextInt())%3)
                .setMonth(Math.abs(random.nextInt())%12)
                .setDay(Math.abs(random.nextInt())%30)
                .setHour(Math.abs(random.nextInt())%24)
                .setMin((Math.abs(random.nextInt())%59))
                .build();
        Address address = Address.newBuilder()
                .setCountry("Poland")
                .setCity(cities[Math.abs(random.nextInt())%(cities.length-1)])
                .setStreet("Rynek")
                .setHouseNumber(String.valueOf((Math.abs(random.nextInt())%59)))
                .build();

        List<Type> eventTypes = new ArrayList<Type>();


        return Event.newBuilder()
                .setDate(date)
                .setAddress(address)
                .addType(type1)
                .addType(type2)
                .build();

    }
}
