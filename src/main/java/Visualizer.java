import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sun.rmi.runtime.Log;

import java.util.HashMap;

/**
 * Created by alexandre on 28/11/16.
 */
public class Visualizer extends Application implements Runnable{

    private static boolean stayAwake = true;

    private static Text recentLog = new Text("Here goes recent log");
    private static TableView<LogForTable> table;
    private static final ObservableList<LogForTable> data = FXCollections.observableArrayList();

    private static HashMap<String, LogForTable> rowMemory = new HashMap<String, LogForTable>();

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");

        table = new TableView<LogForTable>();
        StackPane root = new StackPane();
        root.getChildren().add(recentLog);

        table.setEditable(true);

        //Association de l'attribut "objectName" à la colonne correspondante

        TableColumn cNameCol = new TableColumn("Class Name");
        cNameCol.setMinWidth(200);
        cNameCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("className"));

        TableColumn numberOfInstanceCol = new TableColumn("Number of Instances");
        numberOfInstanceCol.setMinWidth(200);
        numberOfInstanceCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("numberOfInstance"));

        TableColumn timeCol = new TableColumn("Average creation time (ms)");
        timeCol.setMinWidth(250);
        timeCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("averageTime"));

        table.setItems(data);
        table.getColumns().addAll(cNameCol, numberOfInstanceCol ,timeCol);

        root.getChildren().add(table);

        // set close event
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                stayAwake = false;
            }
        });

        primaryStage.setScene(new Scene(root, 650, 250));

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

    public void setRecentLogTest(String cName, String nInstance, String time){

        if(data.contains(rowMemory.get(cName))){
            int index = data.indexOf(rowMemory.get(cName));
            rowMemory.put(cName, new LogForTable(cName,nInstance,time));
            data.set(index, rowMemory.get(cName));
        }
        else {
            rowMemory.put(cName, new LogForTable(cName,nInstance,time));
            data.add(rowMemory.get(cName));
        }
    }
}
