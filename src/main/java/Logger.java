import java.util.HashMap;

/**
 * Created by alexandre on 28/11/16.
 */

/*
Receive call from running code which is visualized and forward it to Visualizer.
Methods open() and close() must called before and after all call to log().
 */
public class Logger{

    private static Visualizer2 visualizer;

    // keep data on each Logger call to apply some logic before forwarding to visualizer.
    private static HashMap<String, Integer> ObjectNumberInstance;
    private static HashMap<Integer, Long> ObjectCreationTime;
    private static HashMap<Integer, Long> ObjectTotalCreationTime;

    private static HashMap<String, Integer> MethodNumberInstance;
    private static HashMap<String, Long> MethodCreationTime;
    private static HashMap<String, Long> MethodTotalCreationTime;

    // Initialize static variables and run visualizer in a separate thread.
    public static void open(){
        try{
            ObjectNumberInstance = new HashMap<String, Integer>();
            ObjectCreationTime = new HashMap<Integer, Long>();
            ObjectTotalCreationTime = new HashMap<Integer, Long>();

            MethodNumberInstance = new HashMap<String, Integer>();
            MethodCreationTime = new HashMap<String, Long>();
            MethodTotalCreationTime = new HashMap<String, Long>();

            // Run a javafx window in the background during all tests
            visualizer = new Visualizer2();
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

    // To call when an object begin to be created
    public static void logBeginObjectCreation(int id){
        // set beginning of creation time of the object
        ObjectCreationTime.put(id, System.nanoTime());
    }

    // To call when an object finish to be created
    public static void logEndObjectCreation(String className, int id, String objectName, int objectId){
        // update number of instance
        if (ObjectNumberInstance.containsKey(className))
            ObjectNumberInstance.put(className, ObjectNumberInstance.get(className) + 1);
        else
            ObjectNumberInstance.put(className, 1);

        // compute creation time
        long creationTimeTemp = System.nanoTime() - ObjectCreationTime.get(id);

        // update average time
        if(ObjectTotalCreationTime.containsKey(id))
            ObjectTotalCreationTime.put(id, ObjectTotalCreationTime.get(id) + creationTimeTemp);
        else
            ObjectTotalCreationTime.put(id, creationTimeTemp);

        // display result
        visualizer.setRecentLogObject(
                className,
                ""+ ObjectNumberInstance.get(className),
                ""+(ObjectTotalCreationTime.get(id)/ ObjectNumberInstance.get(className))/1000000.0
        );

        visualizer.addLogObject(className,objectName,objectId+"",creationTimeTemp/1000000.0+"");
    }

    // To call at the beginning of a method
    public static void logBeginMethodCall(String methodName){
        // set time of the method beginning
        MethodCreationTime.put(methodName, System.nanoTime());
    }

    // To call at the end of a method
    public static void logEndMethodCall(String methodName){
        // update number of instance
        if (MethodNumberInstance.containsKey(methodName))
            MethodNumberInstance.put(methodName, MethodNumberInstance.get(methodName) + 1);
        else
            MethodNumberInstance.put(methodName, 1);

        // compute creation time
        long creationTimeTemp = System.nanoTime() - MethodCreationTime.get(methodName);

        // update average time
        if(MethodTotalCreationTime.containsKey(methodName))
            MethodTotalCreationTime.put(methodName, MethodTotalCreationTime.get(methodName) + creationTimeTemp);
        else
            MethodTotalCreationTime.put(methodName, creationTimeTemp);

        // display result
        visualizer.setRecentLogMethod(
                methodName,
                ""+MethodNumberInstance.get(methodName),
                ""+(MethodTotalCreationTime.get(methodName)/ MethodNumberInstance.get(methodName))/1000000.0
        );

        visualizer.addLogMethod(methodName,methodName,1+"",creationTimeTemp/1000000.0+"");

    }
}
