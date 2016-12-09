import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import sun.rmi.runtime.Log;

import java.util.HashMap;

/**
 * Created by dduvacher on 09/12/16.
 */
public class Visualizer2 extends Application implements Runnable{

    private static boolean stayAwake = true;
    private static VBox panelRoot;
    private static TreeItem<String> treeRoot;

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");
        panelRoot = new VBox();

        treeRoot = new TreeItem<String>();
        treeRoot.setExpanded(true);

        TreeTableColumn<String,String> column = new TreeTableColumn<String,String>("Column1");
        column.setPrefWidth(150);

        TreeTableColumn<String,String> column2 = new TreeTableColumn<String,String>("Column2");
        column2.setPrefWidth(150);

        TreeTableColumn<String,String> column3 = new TreeTableColumn<String,String>("Column3");
        column2.setPrefWidth(150);

        column.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> p) {
                return new ReadOnlyStringWrapper(p.getValue().getValue());
            }
        });

        column2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> p) {
                return new ReadOnlyStringWrapper(p.getValue().getValue());
            }
        });

        column3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> p) {
                return new ReadOnlyStringWrapper(p.getValue().getValue());
            }
        });

        final TreeTableView<String> treeTableView = new TreeTableView<String>(treeRoot);
        treeTableView.setShowRoot(false);
        treeTableView.getColumns().add(column);
        treeTableView.getColumns().add(column2);
        treeTableView.getColumns().add(column3);


        treeTableView.setPrefWidth(152);
        treeTableView.setShowRoot(true);
        panelRoot.getChildren().add(treeTableView);

        addRoot();
        //Creating tree items
        //final TreeItem<String> childNode1 = new TreeItem<String>("Child Node 1");
        //final TreeItem<String> childNode2 = new TreeItem<String>("Child Node 2");
        //final TreeItem<String> childNode3 = new TreeItem<String>("Child Node 3");

        //Adding tree items to the root
        //treeRoot.getChildren().setAll(childNode1, childNode2, childNode3);


        // set close event
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                stayAwake = false;
            }
        });

        primaryStage.setScene(new Scene(panelRoot, 650, 250));

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

    public void addRoot(){
        //Creating tree items
        final TreeItem<String> childNode1 = new TreeItem<String>("Child Node 1");
        final TreeItem<String> childNode2 = new TreeItem<String>("Child Node 2");
        final TreeItem<String> childNode3 = new TreeItem<String>("Child Node 3");

        childNode2.getChildren().add(childNode3);

        //Adding tree items to the root
        treeRoot.getChildren().addAll(childNode1, childNode2);

    }

}

