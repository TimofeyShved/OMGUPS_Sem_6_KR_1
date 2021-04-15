package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

/**
 * Вспомогательный класс для обёртывания списка адресатов.
 * Используется для сохранения списка адресатов в XML.
 */
@XmlRootElement(name = "Group")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Group", propOrder = {
        "group"
})
public class Group {

    private ObservableList<String> group = FXCollections.observableArrayList();

    //@XmlElement(name = "group")
    public ObservableList<String> getGroup() {
        return group;
    }
    public void setGroup(ObservableList<String> group) {
        this.group = group;
    }
    public void setGroup(String ...group) {
        ObservableList<String> myArray = null;
        for (String s:group){
            myArray.add(s);
        }
        setGroup(myArray);
    }
}
