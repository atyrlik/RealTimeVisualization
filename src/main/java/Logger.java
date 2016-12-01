import javafx.application.Application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Created by alexandre on 28/11/16.
 */
public class Logger{

    private static PrintWriter pw;
    private static Visualizer visualizer;

    public static void open(){
        try{
            // open writer to write logs in given file
            // File logFile = new File("src/toVisualize/main-logged/log.txt");
            // pw = new PrintWriter(new FileOutputStream(logFile,true));

            // Run a javafx window in the background during all tests
            visualizer = new Visualizer();
            new Thread(visualizer).start();
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void close(){
        // close writer
        pw.close();
        // warn the javafx window that it can close, so it can wait exit order by user
        visualizer.close();
    }

    public static void log(String actionType, String className, String objectName){
        // pw.append(message + "\n");
        visualizer.setRecentLogTest(actionType, className, objectName, LocalDateTime.now().toString());
    }
}
