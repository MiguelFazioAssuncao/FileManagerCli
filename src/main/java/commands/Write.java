package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import picocli.CommandLine;
import utils.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@CommandLine.Command(name = "write", description = "Escreve no arquivo")
public class Write implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Nome do arquivo")
    private String fileName;

    @CommandLine.Parameters(index = "1", description = "Conteúdo que será escrito")
    private String content;

    @Override
    public void run() {
        if (!FileUtils.isTextFile(fileName)) {
            System.out.println("Extensão não permitida. Apenas arquivos de texto são suportados.");
            return;
        }

        File file = State.getFileOrWarn(fileName);
        if (file == null) return;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            JsonElement jsonElement = JsonParser.parseString(content);

            if (jsonElement.isJsonObject() || jsonElement.isJsonArray()) {
                String prettyJson = gson.toJson(jsonElement);
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(prettyJson + System.lineSeparator());
                    System.out.println("Arquivo JSON escrito com sucesso");
                }
            } else {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(content + System.lineSeparator());
                    System.out.println("Conteúdo primitivo gravado como texto simples");
                }
            }

        } catch (JsonSyntaxException e) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content + System.lineSeparator());
                System.out.println("Conteúdo gravado com sucesso!");
            } catch (IOException ex) {
                System.out.println("Erro ao escrever no arquivo: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
