package Validator;

;

import Domain.User;
import Exceptions.InvalidAge;
import Exceptions.InvalidId;
import Exceptions.InvalidName;


import java.util.Objects;

public class UserValidator{
    public void validate(User user) throws InvalidId, InvalidName, InvalidAge {
        if(Objects.equals(user.getId(), "")) {
            throw new InvalidId("the id cannot be an empty string. Reenter id: ");
        }
        if(Objects.equals(user.getFirstName(), "")){
            throw new InvalidName("the first name cannot be an empty string");
        }
        if(Objects.equals(user.getLastName(), "")){
            throw new InvalidName("the last name cannot be an empty string");
        }
        if(Objects.equals(user.getPassword(), "")){
            throw new InvalidName("password cannot be an empty string");
        }if(Objects.equals(user.getEmail(), "")){
            throw new InvalidName("email cannot be an empty string");
        }
        if(user.getAge() <= 0){
            throw new InvalidAge("the age must be a number greater than 0");
        }
    }
}
