package Service;


import Domain.Entity;
import Domain.FriendShip;
import Domain.User;
import Exceptions.InvalidId;
import Repository.RepositoryInMemory;

import java.util.Objects;

public class FriendshipService {
    RepositoryInMemory repo;
    RepositoryInMemory userRepo;


    public FriendshipService(RepositoryInMemory fRepo, RepositoryInMemory uRepo) {
        this.repo = fRepo;
        this.userRepo = uRepo;
    }



    public void addFriendship(Integer idFriendship, Integer idUser1, Integer idUser2) throws InvalidId {
        Entity u1 = userRepo.getEntity(idUser1);
        Entity u2 = userRepo.getEntity(idUser2);
        Entity check = getFriendship(idFriendship);
        if(check != null)
            throw new InvalidId("Id already exists!");
        if(u1 != null)
            if(u2 != null) {

                FriendShip friendship = new FriendShip(idFriendship, idUser1, idUser2);
                repo.add(friendship);
            }
    }


    public void deleteFriendship(Integer idFriendship, Integer idUser1, Integer idUser2) throws InvalidId {
        Entity friendship = getFriendship(idFriendship);
        if(friendship == null)
            throw new InvalidId("Given id for friendship does not exist!");
        if(userRepo.getEntity(idUser1) != null)
            if(userRepo.getEntity(idUser2) != null) {
                repo.delete(friendship.getId());

            }
    }


    public void showFriendships(){
        for(int i = 0; i < repo.getEntities().size(); i++)
            System.out.println(repo.getEntities().elementAt(i).toString());
    }

    public Entity getFriendship(Integer id){
        for(int i = 0; i< repo.getEntities().size(); i++)
            if(Objects.equals(this.repo.getEntities().elementAt(i).getId(), id))
                return this.repo.getEntities().elementAt(i);
        return null;
    }

//    public void deleteFriendshipsWithUser(User u) throws InvalidId {
//        Friendship friendship;
//        for(int i = 0;i<friendshipRepository.getFriendships().size();i++)
//        {
//            if(Objects.equals(friendshipRepository.getFriendships().get(i).getUser1() , u) || Objects.equals(friendshipRepository.getFriendships().get(i).getUser2(), u)) {
//                friendship = friendshipRepository.getFriendships().get(i);
//                deleteFriendship(friendship.getId(), friendship.getUser1().getId(),friendship.getUser1().getFirstName(), friendship.getUser1().getLastName(), friendship.getUser1().getAge(), friendship.getUser2().getId(), friendship.getUser2().getFirstName(), friendship.getUser2().getLastName(), friendship.getUser2().getAge());
//            }
//
//        }
//    }

}
