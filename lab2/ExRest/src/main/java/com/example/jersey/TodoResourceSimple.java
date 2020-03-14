package com.example.jersey;

import com.example.jersey.model.Todo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/todosimple")
public class TodoResourceSimple {

    @GET
    @Produces({MediaType.TEXT_XML})
    public Todo getHTML(){
        Todo todo = new Todo();
        todo.setSummary("This is my first todo summary");
        todo.setDescription("Description of my first todo");
        return todo;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Todo getXML(){
        Todo todo = new Todo();
        todo.setSummary("This is my first todo summary");
        todo.setDescription("Description of my first todo");
        return todo;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Todo getJSON(){
        Todo todo = new Todo();
        todo.setSummary("This is my first todo summary");
        todo.setDescription("Description of my first todo");
        return todo;
    }
}
