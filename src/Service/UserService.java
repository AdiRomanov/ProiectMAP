package Service;


import Domain.Entity;
import Domain.User;
import Exceptions.InvalidId;
import Repository.RepositoryInMemory;

public class UserService {
    RepositoryInMemory repo;


    public UserService(RepositoryInMemory repo) {
        this.repo = repo;
    }


    public void addUser(Integer id, String firstName, String lastName, String email, String password, int age) throws InvalidId {
        Entity check = repo.getEntity(id);
        if(check != null)
            throw new InvalidId("Id exists already!");
        User user = new User(id, firstName, lastName, email, password, age);
        repo.add(user);

    }


    public void deleteUser(Integer id) throws InvalidId {
        Entity check =  repo.getEntity(id);
        if(check == null)
            throw new InvalidId("Given id does not exist!");
        repo.delete(check.getId());

    }


    public void showUsers(){
        for(int i = 0; i < repo.getEntities().size(); i++)
            System.out.println(repo.getEntities().elementAt(i).toString());
    }

    public Entity getUser(int id1) {
        return repo.getEntity(id1);
    }
}
