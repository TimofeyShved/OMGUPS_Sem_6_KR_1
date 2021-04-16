package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class addColumnController {
    Group groups;
    @FXML TextField addName;

    public void addField(MouseEvent event) { // добавление названий групп
        groups.getGroup().add(addName.getText()); // добавляем в нашу коллекцию, данные из текстового поля
        File file = new File("group/"+addName.getText()); // файл с таким именем
        if (!file.exists()) {file.mkdir();} // если нету папки, то создать!
        addName.setText(""); // очистить поле
    }

    public void init(Group groups) {
        this.groups = groups;
    }
}
