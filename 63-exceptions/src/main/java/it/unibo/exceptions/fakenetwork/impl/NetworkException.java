package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException(final String msg){
        super("Network error while sending message:"+  msg);
    }

    public NetworkException(){
        super("Network error: no response");
    }
    
}
