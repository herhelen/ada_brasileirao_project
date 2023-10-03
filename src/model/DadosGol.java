package src.model;

public class DadosGol implements Dados {
    private String partidaId;
    private String rodata;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipoDeGol;

    public static DadosGol createInstance(String[] data){
        DadosGol dadosGol = new DadosGol();
        dadosGol.partidaId = data[0];
        dadosGol.rodata = data[1];
        dadosGol.clube = data[2];
        dadosGol.atleta = data[3];
        dadosGol.minuto = data[4];
        dadosGol.tipoDeGol = data[5];

        return dadosGol;
    }

    public String getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(String partidaId) {
        this.partidaId = partidaId;
    }

    public String getRodata() {
        return rodata;
    }

    public void setRodata(String rodata) {
        this.rodata = rodata;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getAtleta() {
        return atleta;
    }

    public void setAtleta(String atleta) {
        this.atleta = atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getTipoDeGol() {
        return tipoDeGol;
    }

    public void setTipoDeGol(String tipoDeGol) {
        this.tipoDeGol = tipoDeGol;
    }

    @Override
    public String toString() {
        return "DadosPartida{" +
                "partidaId=" + partidaId +
                ", rodata=" + rodata +
                ", clube='" + clube + '\'' +
                ", atleta='" + atleta + '\'' +
                ", minuto=" + minuto +
                ", tipoDeGol='" + tipoDeGol + '\'' +
                '}';
    }
}
