import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by alexandre on 28/11/16.
 */
public class Visualizer extends Application implements Runnable{

    private static boolean stayAwake = true;

    private Text recentLog = new Text("Here goes recent log");;

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");

        StackPane root = new StackPane();
        root.getChildren().add(recentLog);


        // set close event
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                stayAwake = false;
            }
        });

        primaryStage.setScene(new Scene(root, 300, 250));

        primaryStage.show();
    }

    public void close(){
        // check every second if user want to exit
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (stayAwake);
    }

    public void setRecentLogTest(String log){
        recentLog.setText(log);
    }
}
