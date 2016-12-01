import javafx.beans.property.SimpleStringProperty;

/**
 * Created by dduvacher on 01/12/16.
 */
public class LogForTable {
    private SimpleStringProperty label;

    public LogForTable(String label)
    {
        this.label= new SimpleStringProperty(label);
    }

    public String getLabel(){
        return label.get();
    }

    public void setLabel(String label){
        this.label = new SimpleStringProperty(label);
    }
}
