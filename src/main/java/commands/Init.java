package commands;

import picocli.CommandLine;

import java.io.File;
import java.nio.file.Path;

@CommandLine.Command(name = "init", description = "Inicializa o diretório base")
public class Init implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Caminho da pasta")
    private String path;

    @Override
    public void run() {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
            System.out.println("Diretório criado no caminho: " + path);
        }
        State.setBaseDir(String.valueOf(Path.of(dir.getAbsolutePath())));
        System.out.println("Inicializado diretório em: " + dir.getAbsolutePath());
    }
}
