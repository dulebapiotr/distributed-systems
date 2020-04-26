package server;

import event.grpc.gen.Event;
import event.grpc.gen.SubscribeRequest;
import event.grpc.gen.Type;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.stream.Stream;

public class EventStreamObserver implements StreamObserver<Event> {

    private StreamObserver<Event> responseObserver;
    private String city;
    private List<Type> eventTypes;

    public EventStreamObserver(SubscribeRequest request, StreamObserver<Event> responseObserver ){
        this.city = request.getCity();
        this.eventTypes = request.getTypeList();
        this.responseObserver = responseObserver;

    }


    @Override
    public void onNext(Event event) {
        boolean typematch = false;
        for(int i=0; i<eventTypes.size();i++){
            for(int j=0;j<event.getTypeList().size();j++){
                if(eventTypes.get(i).equals(event.getTypeList().get(j))){
                    typematch=true;
                }
            }
        }
        if(city.equals(event.getAddress().getCity())&&typematch){
            responseObserver.onNext(event);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError");
    }

    @Override
    public void onCompleted() {
        responseObserver.onCompleted();
        System.out.println("Added subscription!");
    }
}
