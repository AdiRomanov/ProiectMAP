package Domain;

public class FriendShip extends Entity {
    private int idUser1, idUser2;

    public FriendShip(int id, int idUser1, int idUser2) {
        super(id);
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "FriendShip{" +
                "idUser1=" + idUser1 +
                ", idUser2=" + idUser2 +
                '}';
    }

    public int getIdUser1() {
        return idUser1;
    }

    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }

    public int getIdUser2() {
        return idUser2;
    }

    public void setIdUser2(int idUser2) {
        this.idUser2 = idUser2;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

}
