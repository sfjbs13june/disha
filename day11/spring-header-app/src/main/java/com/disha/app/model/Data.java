package com.disha.app.model;

public class Data{



    String id;
    String message;


    public Data(){

    }

    public Data(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return "data[id=" +id + ", message=" + message + "]";
    }
}
