package utils;

import java.util.Set;

public class FileUtils {
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            "txt", "json", "xml", "csv", "md", "html", "java", "js",
            "log", "yaml", "yml", "ini", "properties", "cfg", "conf"
    );

    public static boolean isTextFile(String fileName) {
        if (fileName == null) return false;
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex < 0) return false;
        String ext = fileName.substring(dotIndex + 1).toLowerCase();
        return ALLOWED_EXTENSIONS.contains(ext);
    }
}
