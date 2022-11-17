package UserInterface;

import Domain.Entity;
import Domain.User;
import Exceptions.InvalidAge;
import Exceptions.InvalidId;
import Exceptions.InvalidName;
import Service.FriendshipService;
import Service.UserService;
import Validator.UserValidator;

import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
     UserService userService;
     UserValidator userValidator;
     FriendshipService friendshipService;


    public UserInterface(UserService userService, UserValidator userValidator, FriendshipService friendshipService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.friendshipService = friendshipService;
    }

    static void showMenu() {
        System.out.println("1. Add user");
        System.out.println("2. Add friendship");
        System.out.println("3. Delete user");
        System.out.println("4. Delete friendship");
        System.out.println("5. Show users");
        System.out.println("6. Show friendships");
        System.out.println("0. Exit");
    }

    public void run() {
        boolean ok = true;
        Scanner in2 = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String opt;


        while (ok) {
            System.out.println();
            showMenu();
            System.out.println("Dati optiunea: ");
            opt = in.nextLine();


            if (Objects.equals(opt, "1")) {
                try {
                    System.out.println("Dati id: ");
                    String idString = in.nextLine();
                    int id = Integer.parseInt(idString);
                    System.out.println("Dati prenume: ");
                    String firstName = in.nextLine();
                    System.out.println("Dati nume: ");
                    String lastName = in.nextLine();
                    System.out.println("Dati email: ");
                    String email = in.nextLine();
                    System.out.println("Dati parola: ");
                    String password = in.nextLine();
                    System.out.println("Dati varsta: ");
                    int age = in.nextInt();
                    userValidator.validate(new User(id, firstName, lastName, email, password, age));

                    userService.addUser(id, firstName, lastName, email, password, age);
                } catch (InvalidId ex) {
                    System.out.println(ex);
                } catch (InvalidName e) {
                    throw new RuntimeException(e);
                } catch (InvalidAge e) {
                    throw new RuntimeException(e);
                }
            }

            if (Objects.equals(opt, "2")) {
                try {
                    System.out.println("Dati id-ul prieteniei: ");
                    String idFriendshipString = in.nextLine();
                    System.out.println("Dati id-ul primului user: ");
                    String id1String = in.nextLine();
                    System.out.println("Dati id-ul celui de al doilea user: ");
                    String id2String = in.nextLine();
                    int idFriendship = Integer.parseInt(idFriendshipString);
                    int id1 = Integer.parseInt(id1String);
                    int id2 = Integer.parseInt(id2String);

                    Entity user1 = userService.getUser(id1);
                    Entity user2 = userService.getUser(id2);



                    if ((user1 != null) && (user2 != null)) {
                        friendshipService.addFriendship(idFriendship, id1, id2);
                        System.out.println("Friendship added!");
                    }
                } catch (InvalidId ex) {
                    System.out.println(ex);

                }

            }

            if (Objects.equals(opt, "4")) {
                try {

                        System.out.println("Dati id-ul prieteniei: ");
                        String idFriendshipString = in.nextLine();
                        System.out.println("Dati id-ul primului user: ");
                        String id1String = in.nextLine();
                        System.out.println("Dati id-ul celui de al doilea user: ");
                        String id2String = in.nextLine();
                        int idFriendship = Integer.parseInt(idFriendshipString);
                        int id1 = Integer.parseInt(id1String);
                        int id2 = Integer.parseInt(id2String);
                        friendshipService.deleteFriendship(idFriendship, id1, id2);

                } catch (InvalidId id) {
                    System.out.println(id.getMessage());
                }
            }

            if (Objects.equals(opt, "3")) {
                try {
                    System.out.println("Dati id-ul userului: ");
                    String idUserString = in.nextLine();
                    int idUser = Integer.parseInt(idUserString);

                    userService.deleteUser(idUser);


                } catch (InvalidId invalidId) {
                    System.out.println(invalidId.getMessage());
                }
            }

            if (Objects.equals(opt, "5")) {
                System.out.println("The users are: ");
                userService.showUsers();
            }

            if (Objects.equals(opt, "6")) {
                System.out.println("The friendships are: ");
                friendshipService.showFriendships();
            }


            if (Objects.equals(opt, "0"))
                ok = false;


        }

    }
}