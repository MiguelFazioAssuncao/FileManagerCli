package commands;

import picocli.CommandLine;

import java.io.File;
import java.util.Objects;

@CommandLine.Command(name = "clear", description = "Remove todos os arquivos do diretório")
public class Clear implements Runnable {

    @Override
    public void run() {
        if (!State.checkInit()) return;

        File dir = new File(Objects.requireNonNull(State.getBaseDir()));
        File[] files = dir.listFiles();
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.delete()) {
                    count++;
                }
            }
        }

        System.out.println("Arquivos removidos: " + count);
    }
}
