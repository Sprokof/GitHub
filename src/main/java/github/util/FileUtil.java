package github.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {
    private static final Logger logger = Logger.getAnonymousLogger();
    public static String FILE_PATH_KEY = "file.path";
    public static final String FILE_NAME_KEY = "file.name";
    private FileUtil() {

    }
    public static File createOrGetFile(String path, String name) throws IOException {
        String fileLocation = String.format("%s%s%s%s", path, "/Рабочий стол/", name, ".txt");
        File file = new File(fileLocation);
        if (file.createNewFile()) {
            logger.log(Level.SEVERE, "File " + name + " created");
        } else {
            logger.log(Level.SEVERE, "File " + name + " already exists");
        }
        return file;
    }

    public static void writeToFile(File file, String text) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(appendText(text).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String appendText(String accessLink) {
        return String.format("%s - %s", LocalDate.now(), accessLink);
    }

}
