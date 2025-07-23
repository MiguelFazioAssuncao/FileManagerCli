package commands;

import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(name = "delete", description = "Deleta um arquivo")
public class Delete implements Runnable {

    @CommandLine.Parameters(index = "0", description = "Nome do arquivo")
    private String fileName;

    @Override
    public void run() {
        File file = State.getFileOrWarn(fileName);
        if (file == null) return;

        if (file.delete()) {
            System.out.println("Arquivo deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar arquivo: " + file.getAbsolutePath());
        }
    }
}
