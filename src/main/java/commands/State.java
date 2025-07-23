package commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class State {
    private static final String CONFIG_FILE = "basedir.config";
    private static String baseDir;

    public static void setBaseDir(String path) {
        baseDir = path;
        try {
            Files.writeString(Path.of(CONFIG_FILE), baseDir);
        } catch (IOException e) {
            System.out.println("Erro ao salvar baseDir no arquivo de configuração.");
        }
    }

    public static String getBaseDir() {
        if (baseDir == null) {
            try {
                baseDir = Files.readString(Path.of(CONFIG_FILE)).trim();
            } catch (IOException e) {
                return null;
            }
        }
        return baseDir;
    }

    public static boolean isInitialized() {
        return getBaseDir() != null;
    }

    public static boolean checkInit() {
        if (!isInitialized()) {
            System.out.println("Use 'run init <caminho>' primeiro.");
            return false;
        }
        return true;
    }

    public static File getFileOrWarn(String fileName) {
        if (!checkInit()) return null;

        File file = new File(getBaseDir(), fileName);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + fileName);
            return null;
        }

        return file;
    }
}
