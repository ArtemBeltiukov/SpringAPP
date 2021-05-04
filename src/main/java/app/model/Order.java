package app.model;

import java.util.List;

public class Order {
    private int id;
    private int userID;
    private int counteragent;
    private List<Nomenclature> nomenclatureList;
    private boolean realized;

    public Order(int userID, int counteragent) {
        this.userID = userID;
        this.counteragent = counteragent;
    }

    public Order(int userID, int counteragent, List<Nomenclature> nomenclatureList) {
        this.userID = userID;
        this.counteragent = counteragent;
        this.nomenclatureList = nomenclatureList;
    }

    public Order() {

    }

    public Order(int userID, int counteragent, List<Nomenclature> nomenclatureList, boolean realized) {
        this.userID = userID;
        this.counteragent = counteragent;
        this.nomenclatureList = nomenclatureList;
        this.realized = realized;
    }

    public boolean isRealized() {
        return realized;
    }

    public void setRealized(boolean realized) {
        this.realized = realized;
    }

    public List<Nomenclature> getNomenclatureList() {
        return nomenclatureList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setCounteragent(int counteragent) {
        this.counteragent = counteragent;
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public int getCounteragent() {
        return counteragent;
    }

    public void setNomenclatureList(List<Nomenclature> nomenclatureList) {
        this.nomenclatureList = nomenclatureList;
    }
}
