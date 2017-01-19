import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by dduvacher on 09/12/16.
 */
public class Visualizer2 extends Application implements Runnable{

    private static boolean stayAwake = true;
    private static VBox panelRoot;
    private static TreeItem<LogForTable> treeRootObject = new TreeItem<>();
    private static TreeItem<LogForTable> treeRootMethod = new TreeItem<>();

    public void run(){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RealTime Visualization");
        final Label objectTitle = new Label("Object Creation");
        final Label methodTitle = new Label("Method Execution");
        panelRoot = new VBox();

        treeRootObject.setExpanded(true);
        treeRootMethod.setExpanded(true);

        TreeTableColumn<LogForTable, String> typeColumn =
                new TreeTableColumn<>("Class Name/Name");
        typeColumn.setPrefWidth(150);
        typeColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getClassName())
        );

        TreeTableColumn<LogForTable, String> timeColumn =
                new TreeTableColumn<>("Average Time/Time");
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

        TreeTableColumn<LogForTable, String> typeColumn2 =
                new TreeTableColumn<>("Method Name");
        typeColumn2.setPrefWidth(150);
        typeColumn2.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getClassName())
        );

        TreeTableColumn<LogForTable, String> timeColumn2 =
                new TreeTableColumn<>("Average Time/Time");
        timeColumn2.setPrefWidth(150);
        timeColumn2.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getAverageTime())
        );

        TreeTableColumn<LogForTable, String> nbiColumn2 =
                new TreeTableColumn<>("Number of instance");
        nbiColumn2.setPrefWidth(150);
        nbiColumn2.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<LogForTable, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getNumberOfInstance())
        );

        final TreeTableView<LogForTable> treeTableViewObject = new TreeTableView<>(treeRootObject);
        treeTableViewObject.setShowRoot(false);
        treeTableViewObject.getColumns().add(typeColumn);
        treeTableViewObject.getColumns().add(timeColumn);
        treeTableViewObject.getColumns().add(nbiColumn);

        final TreeTableView<LogForTable> treeTableViewMethod = new TreeTableView<>(treeRootMethod);
        treeTableViewMethod.setShowRoot(false);
        treeTableViewMethod.getColumns().add(typeColumn2);
        treeTableViewMethod.getColumns().add(timeColumn2);
        treeTableViewMethod.getColumns().add(nbiColumn2);


        treeTableViewObject.setPrefWidth(152);
        treeTableViewObject.setShowRoot(false);
        panelRoot.getChildren().add(objectTitle);
        panelRoot.getChildren().add(treeTableViewObject);

        treeTableViewMethod.setPrefWidth(152);
        treeTableViewMethod.setShowRoot(false);
        panelRoot.getChildren().add(methodTitle);
        panelRoot.getChildren().add(treeTableViewMethod);


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

    public void setRecentLogObject(String cName, String nInstance, String time){
        for(TreeItem<LogForTable> c : treeRootObject.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.setValue(new LogForTable(cName,nInstance,time));
                return;
            }
        }
        final TreeItem<LogForTable> node = new TreeItem<>(new LogForTable(cName,nInstance,time));
        treeRootObject.getChildren().addAll(node);
    }

    public void addLogObject(String cName, String name, String ID, String time){
        for(TreeItem<LogForTable> c : treeRootObject.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.getChildren().add(new TreeItem<>(new LogForTable(name,ID,time)));
                return;
            }
        }
    }


    public void setRecentLogMethod(String cName, String nInstance, String time){

        for(TreeItem<LogForTable> c : treeRootMethod.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.setValue(new LogForTable(cName,nInstance,time));
                return;
            }
        }
        final TreeItem<LogForTable> node = new TreeItem<>(new LogForTable(cName,nInstance,time));
        treeRootMethod.getChildren().addAll(node);
    }

    public void addLogMethod(String cName, String name, String ID, String time){
        for(TreeItem<LogForTable> c : treeRootMethod.getChildren()){
            if(c.getValue().getClassName().equals(cName))
            {
                c.getChildren().add(new TreeItem<>(new LogForTable(name,ID,time)));
                return;
            }
        }
    }


}

