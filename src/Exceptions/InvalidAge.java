package Exceptions;

public class InvalidAge extends Exception{

    InvalidAge(){
    }
    public InvalidAge(String message){
        super(message);
    }

}
