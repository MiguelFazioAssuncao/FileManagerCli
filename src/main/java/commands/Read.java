package commands;

import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@CommandLine.Command(name = "read", description = "Lê o contéudo de um arquivo")
public class Read implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Nome do arquivo")
    private String fileName;

    @Override
    public void run() {
        File file = State.getFileOrWarn(fileName);
        if (file == null) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
