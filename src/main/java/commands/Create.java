package commands;

import picocli.CommandLine;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;

@CommandLine.Command(name = "create", description = "Cria um novo arquivo")
public class Create implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Nome do arquivo")
    private String fileName;

    @Override
    public void run() {
        if (!State.checkInit()) return;

        if (!fileName.contains(".")) {
            fileName += ".txt";
        }

        if (!FileUtils.isTextFile(fileName)) {
            System.out.println("Extensão não permitida. Apenas arquivos de texto são suportados.");
            return;
        }

        File file = new File(State.getBaseDir(), fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Arquivo criado: " + file.getName());
            } else {
                System.out.println("Arquivo já existente");
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

}
