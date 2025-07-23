package cli;

import picocli.CommandLine;
import commands.*;

@CommandLine.Command(
        name = "runCLI",
        version = "1.0",
        description = "CLI para manipulação de arquivos de texto",
        mixinStandardHelpOptions = true,
        subcommands = {
                Init.class, Create.class, List.class, Write.class,
                Read.class, Delete.class, Clear.class
        }
)
public class FileCLI {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new FileCLI()).execute(args);
        System.exit(exitCode);
    }
}
