import java.util.HashMap;

/**
 * Created by alexandre on 28/11/16.
 */

/*
Receive call from running code which is visualized and forward it to Visualizer.
Methods open() and close() must called before and after all call to log().
 */
public class Logger{

    private static Visualizer visualizer;

    // keep data on each Logger call to apply some logic before forwarding to visualizer.
    private static HashMap<String, Integer> numberOfClassInstance;
    private static HashMap<Long, Long> creationTime;
    private static HashMap<Long, Long> totalCreationTime;

    // Initialize static variables and run visualizer in a separate thread.
    public static void open(){
        try{
            numberOfClassInstance = new HashMap<String, Integer>();
            creationTime = new HashMap<Long, Long>();
            totalCreationTime = new HashMap<Long, Long>();

            // Run a javafx window in the background during all tests
            visualizer = new Visualizer();
            new Thread(visualizer).start();
        }
        catch (Exception exception){
            System.out.println(exception);
        }
    }

    // Warn the javafx window that it can close, so it can wait exit order by user.
    public static void close(){
        visualizer.close();
    }

    // Send formatted data to the javafx application (Vizualiser).
    public static void log(String actionType, String className, String objectName, long id){

        if(actionType.equals("Begin object creation")){
            // set beginning of creation time of the object
            creationTime.put(id, System.nanoTime());
        }

        if(actionType.equals("End object creation")) {
            // update number of instance
            if (numberOfClassInstance.containsKey(className))
                numberOfClassInstance.put(className, numberOfClassInstance.get(className) + 1);
            else
                numberOfClassInstance.put(className, 1);

            // compute creation time
            long creationTimeTemp = System.nanoTime() - creationTime.get(id);

            // update average time
            if(totalCreationTime.containsKey(id))
                totalCreationTime.put(id, totalCreationTime.get(id) + creationTimeTemp);
            else
                totalCreationTime.put(id, creationTimeTemp);

            // display result
            visualizer.setRecentLogTest(
                    className,
                    ""+numberOfClassInstance.get(className),
                    ""+(totalCreationTime.get(id)/numberOfClassInstance.get(className))/1000000.0
            );

        }

    }
}
