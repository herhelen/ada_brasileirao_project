package src.model;

public class DadosCards implements Dados{
    private String id;
    private String round;
    private String team;
    private String card;
    private String athleteName;
    private String shirtID;
    private String position;
    private String minute;

    public static DadosCards createInstance(String[] data){
        DadosCards dataset = new DadosCards();
        dataset.id = data[0];
        dataset.round = data[1];
        dataset.team = data[2];
        dataset.card = data[3];
        dataset.athleteName = data[4];
        dataset.shirtID = data[5];
        dataset.position = data[6];
        dataset.minute = data[7];

        return dataset;
    }

    public String getId() {
        return id;
    }

    public String getRound() {
        return round;
    }

    public String getTeam() {
        return team;
    }

    public String getCard() {
        return card;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getShirtID() {
        return shirtID;
    }

    public String getPosition() {
        return position;
    }

    public String getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return "DadosCards{" +
                "id='" + id + '\'' +
                ", round='" + round + '\'' +
                ", team='" + team + '\'' +
                ", card='" + card + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", shirtID='" + shirtID + '\'' +
                ", position='" + position + '\'' +
                ", minute='" + minute + '\'' +
                '}';
    }
}
