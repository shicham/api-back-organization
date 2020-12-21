package com.crm.commun.results;

import com.crm.commun.configs.ConfigProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Response<T> implements IResponse {

    public T data;
    public String apiVersion = ConfigProperties.appVersion;
    public Date date = new Date();
    List<String> messages = new ArrayList<>(0);
    public Response(){
        super();
    }
    public Response(String message){
        super();
        this.messages.add(message);
    }

    public Response(T data) {
        this.data = data;
    }

}
