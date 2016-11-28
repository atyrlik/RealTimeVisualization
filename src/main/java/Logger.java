import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by alexandre on 28/11/16.
 */
public class Logger{

    private static PrintWriter pw;

    public static void open(){
        try{
            File logFile = new File("src/toVisualize/main-logged/log.txt");
            pw = new PrintWriter(new FileOutputStream(logFile,true));

        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static void close(){
        pw.close();
    }

    public static void log(String message){
        pw.append(message + "\n");
    }
}
