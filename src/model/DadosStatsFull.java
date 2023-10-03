package src.model;

public class DadosStatsFull implements Dados{

    private String matchId;
    private String round;
    private String team;
    private int shots;
    private int shotsOnTarget;
    private String ballPossession;
    private int passes;
    private String passesPrecision;
    private int fouls;
    private int yellowCards;
    private int redCards;
    private int offSide;
    private int corners;

    public static DadosStatsFull createInstance(String[] data){
        DadosStatsFull stats = new DadosStatsFull();
        stats.matchId = data[0];
        stats.round = data[1];
        stats.team = data[2];
        stats.shots = Integer.valueOf(data[3]);
        stats.shotsOnTarget = Integer.valueOf(data[4]);
        stats.ballPossession = data[5];
        stats.passes = Integer.valueOf(data[6]);
        stats.passesPrecision = data[7];
        stats.fouls = Integer.valueOf(data[8]);
        stats.yellowCards = Integer.valueOf(data[9]);
        stats.redCards = Integer.valueOf(data[10]);
        stats.offSide = Integer.valueOf(data[11]);
        stats.corners = Integer.valueOf(data[12]);

        return stats;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getRound() {
        return round;
    }

    public String getTeam() {
        return team;
    }

    public int getShots() {
        return shots;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public String getBallPossession() {
        return ballPossession;
    }

    public int getPasses() {
        return passes;
    }

    public String getPassesPrecision() {
        return passesPrecision;
    }

    public int getFouls() {
        return fouls;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getOffSide() {
        return offSide;
    }

    public int getCorners() {
        return corners;
    }

    @Override
    public String toString() {
        return "DadosStatsFull{" +
                "matchId='" + matchId + '\'' +
                ", round='" + round + '\'' +
                ", team='" + team + '\'' +
                ", shots=" + shots +
                ", shotsOnTarget=" + shotsOnTarget +
                ", ballPossession='" + ballPossession + '\'' +
                ", passes=" + passes +
                ", passesPrecision='" + passesPrecision + '\'' +
                ", fouls=" + fouls +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                ", offSide=" + offSide +
                ", corners=" + corners +
                '}';
    }
}
