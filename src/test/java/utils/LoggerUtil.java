package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class LoggerUtil {

    private static final String LOG_FILE = "logs/automation.log";
    private static PrintWriter writer;

    static {
        try {
            new File("logs").mkdirs();
            writer = new PrintWriter(new FileWriter(LOG_FILE, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message) {
        String log = getTimeStamp() + " [INFO] " + message;
        System.out.println(log);
        if (writer != null) {
            writer.println(log);
            writer.flush();
        }
    }

    public static void error(String message) {
        String log = getTimeStamp() + " [ERROR] " + message;
        System.err.println(log);
        if (writer != null) {
            writer.println(log);
            writer.flush();
        }
    }

    private static String getTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}