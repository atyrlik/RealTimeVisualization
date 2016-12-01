import javafx.beans.property.SimpleStringProperty;

/**
 * Created by dduvacher on 01/12/16.
 */
public class LogForTable {
    private SimpleStringProperty objectName;
    private SimpleStringProperty className;
    private SimpleStringProperty currentTime;

    public LogForTable(String oName,String cName,String time)
    {
        this.objectName= new SimpleStringProperty(oName);
        this.className = new SimpleStringProperty(cName);
        this.className = new SimpleStringProperty(time);
    }

    public String getObjectName(){
        return objectName.get();
    }

    public void setObjectName(String oName){
        objectName= new SimpleStringProperty(oName);
    }

    public String getClassName(){
        return className.get();
    }

    public void setclassName(String cName){
        className= new SimpleStringProperty(cName);
    }

    public String getCurrentTime(){
        return currentTime.get();
    }

    public void setCurrentTime(String time){
        currentTime= new SimpleStringProperty(time);
    }
}
