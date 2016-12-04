import javafx.beans.property.SimpleStringProperty;

/**
 * Created by dduvacher on 01/12/16.
 */

/*
Contains data model of logs.
Useful to display logs in a Tableview.
 */
public class LogForTable {
    private SimpleStringProperty className;
    private SimpleStringProperty numberOfInstance;
    private SimpleStringProperty averageTime;


    public LogForTable(String cName,String nInstance,String time)
    {
        this.className = new SimpleStringProperty(cName);
        this.numberOfInstance= new SimpleStringProperty(nInstance);
        this.averageTime= new SimpleStringProperty(time);
    }

    public String getNumberOfInstance(){
        return numberOfInstance.get();
    }

    public void setObjectName(String oName){
        numberOfInstance= new SimpleStringProperty(oName);
    }

    public String getClassName(){
        return className.get();
    }

    public void setclassName(String cName){
        className= new SimpleStringProperty(cName);
    }

    public String getAverageTime(){
        return averageTime.get();
    }

    public void setAverageTime(String time){
        averageTime= new SimpleStringProperty(time);
    }
}
