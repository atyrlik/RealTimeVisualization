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
import org.eclipse.jdt.internal.core.SourceType;
import sun.rmi.runtime.Log;

import java.util.HashMap;

/**
 * Created by dduvacher on 09/12/16.
 */
public class Visualizer2 extends Application implements Runnable{

    private static boolean stayAwake = true;
    private static VBox panelRoot;
    private static TreeItem<LogForTable> treeRoot= new TreeItem<>();

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");
        panelRoot = new VBox();

        treeRoot.setExpanded(true);

        TreeTableColumn<LogForTable, String> typeColumn =
                new TreeTableColumn<>("Type");
        typeColumn.setPrefWidth(150);
        typeColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getClassName())
        );

        TreeTableColumn<LogForTable, String> timeColumn =
                new TreeTableColumn<>("Time");
        timeColumn.setPrefWidth(150);
        timeColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getAverageTime())
        );

        TreeTableColumn<LogForTable, String> nbiColumn =
                new TreeTableColumn<>("Number of instance");
        nbiColumn.setPrefWidth(150);
        nbiColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getNumberOfInstance())
        );

        /*column.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<LogForTable, String>, ObservableValue<LogForTable>>() {
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
        });*/

        final TreeTableView<LogForTable> treeTableView = new TreeTableView<>(treeRoot);
        treeTableView.setShowRoot(false);
        treeTableView.getColumns().add(typeColumn);
        treeTableView.getColumns().add(timeColumn);
        treeTableView.getColumns().add(nbiColumn);


        treeTableView.setPrefWidth(152);
        treeTableView.setShowRoot(false);
        panelRoot.getChildren().add(treeTableView);

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
        final TreeItem<LogForTable> childNode1 = new TreeItem<>(new LogForTable("Test","42","42"));
        final TreeItem<LogForTable> childNode2 = new TreeItem<>(new LogForTable("Test2","42","42"));
        final TreeItem<LogForTable> childNode3 = new TreeItem<>(new LogForTable("Test3","42","42"));
        childNode2.getChildren().add(childNode3);

        //Adding tree items to the root
        treeRoot.getChildren().addAll(childNode1, childNode2);

    }

    public void setRecentLogObject(String cName, String nInstance, String time){
        for(TreeItem<LogForTable> c : treeRoot.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.setValue(new LogForTable(cName,nInstance,time));
                return;
            }
        }
        final TreeItem<LogForTable> node = new TreeItem<>(new LogForTable(cName,nInstance,time));
        treeRoot.getChildren().addAll(node);
    }

    public void addLogObject(String cName, String name, String ID, String time){
        for(TreeItem<LogForTable> c : treeRoot.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.getChildren().add(new TreeItem<>(new LogForTable(name,ID,time)));
                return;
            }
        }
    }


    public void setRecentLogMethod(String cName, String nInstance, String time){

        for(TreeItem<LogForTable> c : treeRoot.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.setValue(new LogForTable(cName,nInstance,time));
                return;
            }
        }
        final TreeItem<LogForTable> node = new TreeItem<>(new LogForTable(cName,nInstance,time));
        treeRoot.getChildren().addAll(node);
    }

    public void addLogMethod(String cName, String name, String ID, String time){
        for(TreeItem<LogForTable> c : treeRoot.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.getChildren().add(new TreeItem<>(new LogForTable(name,ID,time)));
                return;
            }
        }
    }


}

