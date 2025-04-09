package fr.alekesi.manager;
public enum ERanks{
    ADMIN("Admin",3),
    HOST("Hôte",2),
    SECONDHOST("Co-Hôte",1),
    MEMBER("Joueur",0);
    private final String nameStr;
    private final Integer powerInt;

    ERanks(String rankName, Integer rankPower){
        nameStr= rankName;
        this.powerInt= rankPower;
    }

    public String getRankName(){
        return nameStr;
    }

    public Integer getRankPower(){
        return powerInt;
    }
}
