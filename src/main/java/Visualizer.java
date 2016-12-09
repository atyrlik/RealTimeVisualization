import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

    private static Label labelObject;
    private static Label labelMethod;
    private static TableView<LogForTable> tableObject;
    private static TableView<LogForTable> tableMethod;
    private static final ObservableList<LogForTable> dataObject = FXCollections.observableArrayList();
    private static final ObservableList<LogForTable> dataMethod = FXCollections.observableArrayList();

    private static HashMap<String, LogForTable> rowMemoryObject = new HashMap<String, LogForTable>();
    private static HashMap<String, LogForTable> rowMemoryMethod = new HashMap<String, LogForTable>();

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");

        tableObject = new TableView<LogForTable>();
        tableMethod = new TableView<LogForTable>();
        labelObject = new Label("Object Creation");
        labelMethod = new Label("Method Calls");
        VBox root = new VBox();

        tableObject.setEditable(true);
        tableMethod.setEditable(true);

        //Pour le tableau de création d'objet
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

        //Même association pour les appels de méthodes

        TableColumn cNameColMethod = new TableColumn("Method Name");
        cNameColMethod.setMinWidth(200);
        cNameColMethod.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("className"));

        TableColumn numberOfInstanceColMethod = new TableColumn("Number of Instances");
        numberOfInstanceColMethod.setMinWidth(200);
        numberOfInstanceColMethod.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("numberOfInstance"));

        TableColumn timeColMethod = new TableColumn("Average creation time (ms)");
        timeColMethod.setMinWidth(250);
        timeColMethod.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("averageTime"));

        tableObject.setItems(dataObject);
        tableObject.getColumns().addAll(cNameCol, numberOfInstanceCol, timeCol);

        tableMethod.setItems(dataMethod);
        tableMethod.getColumns().addAll(cNameColMethod, numberOfInstanceColMethod, timeColMethod);

        root.getChildren().add(labelObject);
        root.getChildren().add(tableObject);

        root.getChildren().add(labelMethod);
        root.getChildren().add(tableMethod);

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

    public void setRecentLogObject(String cName, String nInstance, String time){

        if(dataObject.contains(rowMemoryObject.get(cName))){
            int index = dataObject.indexOf(rowMemoryObject.get(cName));
            rowMemoryObject.put(cName, new LogForTable(cName,nInstance,time));
            dataObject.set(index, rowMemoryObject.get(cName));
        }
        else {
            rowMemoryObject.put(cName, new LogForTable(cName,nInstance,time));
            dataObject.add(rowMemoryObject.get(cName));
        }
    }

    public void setRecentLogMethod(String cName, String nInstance, String time){

        if(dataMethod.contains(rowMemoryMethod.get(cName))){
            int index = dataMethod.indexOf(rowMemoryMethod.get(cName));
            rowMemoryMethod.put(cName, new LogForTable(cName,nInstance,time));
            dataMethod.set(index, rowMemoryMethod.get(cName));
        }
        else {
            rowMemoryMethod.put(cName, new LogForTable(cName,nInstance,time));
            dataMethod.add(rowMemoryMethod.get(cName));
        }
    }
}
