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

/**
 * Created by alexandre on 28/11/16.
 */
public class Visualizer extends Application implements Runnable{

    private static boolean stayAwake = true;

    private static Text recentLog = new Text("Here goes recent log");
    private static TableView<LogForTable> table;
    private static final ObservableList<LogForTable> data = FXCollections.observableArrayList();

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
        TableColumn oNameCol = new TableColumn("Object Name");
        oNameCol.setMinWidth(100);
        oNameCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("objectName"));

        TableColumn cNameCol = new TableColumn("Class Name");
        cNameCol.setMinWidth(100);
        cNameCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("className"));

        TableColumn aNameCol = new TableColumn("Action Name");
        aNameCol.setMinWidth(100);
        aNameCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("actionName"));

        TableColumn timeCol = new TableColumn("Creation Date");
        timeCol.setMinWidth(100);
        timeCol.setCellValueFactory(new PropertyValueFactory<LogForTable, String>("currentTime"));

        table.setItems(data);
        table.getColumns().addAll(oNameCol,cNameCol,aNameCol,timeCol);

        root.getChildren().add(table);

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

    public void setRecentLogTest(String aName, String cName, String oName, String time){
        data.add(new LogForTable(oName,cName,aName,time));
    }
}
