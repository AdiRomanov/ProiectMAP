package Exceptions;

public class InvalidName extends Exception{

    InvalidName(){
    }
    public InvalidName(String message){
        super(message);
    }

}
