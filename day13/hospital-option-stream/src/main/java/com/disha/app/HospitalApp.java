package com.disha.app;

import com.disha.app.model.Hospital;

import java.util.HashMap;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class HospitalApp {
    public Optional<Hospital> getCat(String name){

        Hospital h1= new Hospital("n1","3");
        Hospital h2=new Hospital("n2","4");
        Map<String, Hospital;> data = new HashMap<>();
        data.put("n1", h1);
        data.put("n2", h2);
        Hospital result= data.get(name);
        return Optional.ofNullable(result);

    }
}
