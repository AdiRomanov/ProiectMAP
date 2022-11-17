import Repository.Repository;
import Repository.RepositoryInMemory;
import Service.FriendshipService;
import Service.UserService;
import UserInterface.UserInterface;
import Validator.UserValidator;

public class Main {
    public static void main(String[] args) {

        RepositoryInMemory userRepo = new RepositoryInMemory();
        RepositoryInMemory friendshipRepo = new RepositoryInMemory();

        UserService userService = new UserService(userRepo);
        FriendshipService friendshipService = new FriendshipService(friendshipRepo, userRepo);

        UserValidator userValidator = new UserValidator();

        UserInterface userInterface = new UserInterface(userService, userValidator, friendshipService);

        userInterface.run();

    }
}