package Exceptions;

public class InvalidId extends Exception{

    InvalidId(){
    }
    public InvalidId(String message){
        super(message);
    }

}
