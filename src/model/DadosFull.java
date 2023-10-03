package src.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DadosFull implements Dados {
    private String id;
    private String round;
    private LocalDate date;
    private String hour;
    private String host;
    private String visitor;
    private String hostFormation;
    private String visitorFormation;
    private String hostCoach;
    private String visitorCoach;
    private String winner;
    private String arena;
    private int hostScore;
    private int visitorScore;
    private String hostState;
    private String visitorState;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");


    public static DadosFull createInstance(String[] data) {
        DadosFull dataset = new DadosFull();
        dataset.id = data[0];
        dataset.round = data[1];
        dataset.date = LocalDate.parse(data[2], dataset.dateFormatter);
        dataset.hour = data[3];
        dataset.host = data[4];
        dataset.visitor = data[5];
        dataset.hostFormation = data[6];
        dataset.visitorFormation = data[7];
        dataset.hostCoach = data[8];
        dataset.visitorCoach = data[9];
        dataset.winner = data[10];
        dataset.arena = data[11];
        dataset.hostScore = Integer.valueOf(data[12]);
        dataset.visitorScore = Integer.valueOf(data[13]);
        dataset.hostState = data[14];
        dataset.visitorState = data[15];

        return dataset;
    }

    public String getId() {
        return id;
    }

    public String getRound() {
        return round;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getHost() {
        return host;
    }

    public String getVisitor() {
        return visitor;
    }

    public String getHostFormation() {
        return hostFormation;
    }

    public String getVisitorFormation() {
        return visitorFormation;
    }

    public String getHostCoach() {
        return hostCoach;
    }

    public String getVisitorCoach() {
        return visitorCoach;
    }

    public String getWinner() {
        return winner;
    }

    public String getArena() {
        return arena;
    }

    public int getHostScore() {
        return hostScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    public String getHostState() {
        return hostState;
    }

    public String getVisitorState() {
        return visitorState;
    }

    @Override
    public String toString() {
        return "DadosFull{" +
                "id='" + id + '\'' +
                ", round='" + round + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", host='" + host + '\'' +
                ", visitor='" + visitor + '\'' +
                ", hostFormation='" + hostFormation + '\'' +
                ", visitorFormation='" + visitorFormation + '\'' +
                ", hostCoach='" + hostCoach + '\'' +
                ", visitorCoach='" + visitorCoach + '\'' +
                ", winner='" + winner + '\'' +
                ", arena='" + arena + '\'' +
                ", hostScore=" + hostScore +
                ", visitorScore=" + visitorScore +
                ", hostState='" + hostState + '\'' +
                ", visitorState='" + visitorState + '\'' +
                '}';
    }
}
