public enum EGameStatus {
    WAITING("attente", 0),
    STARTING("Lancement", 1),
    PLAYING("jeux", 2),
    ENDING("fin", 3);
    private final String statusName;
    private final Integer statusInt;


    EGameStatus(String StatusName, Integer statusInt) {
        statusName = StatusName;
        this.statusInt = statusInt;
    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusInt(){
        return statusInt;
    }
}
