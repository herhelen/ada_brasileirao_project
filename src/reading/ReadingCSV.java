package src.reading;
import src.model.Dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadingCSV<T extends Dados> {
    private final String csvFile;

    String splitBy = ",";

    public ReadingCSV(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<T> Reading(Function<String[],T> mapper) {
        List<T> listaDados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            listaDados = br.lines()
                    .skip(1) // Pula o cabeçalho
                    .map(line -> line.split(splitBy))
                    .map(mapper)
                    .collect(Collectors.toList());
//            String line;
//            while((line = br.readLine()) != null) {
//                String[] data = line.split(splitBy);
//                for (String item : data) {
//                    System.out.print(item + " ");
//                }
//                System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDados;
    }
}
