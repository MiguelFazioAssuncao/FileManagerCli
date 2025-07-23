package commands;

import picocli.CommandLine;
import java.io.File;
import java.util.Objects;

@CommandLine.Command(name = "list", description = "Lista todos os arquivos do diretório")
public class List implements Runnable {

    @Override
    public void run() {
        if (!State.checkInit()) return;

        File dir = new File(Objects.requireNonNull(State.getBaseDir()));

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Diretório base não existe ou não é uma pasta válida: " + dir.getAbsolutePath());
            return;
        }

        File[] files = dir.listFiles(File::isFile);

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo encontrado no diretório: " + dir.getAbsolutePath());
            return;
        }

        for (File file : files) {
            String name = file.getName();
            String extension = name.contains(".") ? name.substring(name.lastIndexOf(".") + 1) : "";
            System.out.println("- " + name + " [" + extension + "]");
        }
    }
}
