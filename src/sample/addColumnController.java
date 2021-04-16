package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class addColumnController {
    Group groups;
    @FXML TextField addName;

    public void addField(MouseEvent event) {
        groups.getGroup().add(addName.getText());
        File file = new File("group/"+addName.getText());
        if (!file.exists()) {file.mkdir();} // если нету папки, то создать!
        addName.setText("");
    }

    public void init(Group groups) {
        this.groups = groups;
    }
}
