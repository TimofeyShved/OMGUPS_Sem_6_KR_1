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
        String s=addName.getText();
        s = s.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        for (String g:groups.getGroup()){
            if(g.equals(s))s="";
        }
        if (!s.equals("")) {
            groups.getGroup().add(s); // добавляем в нашу коллекцию, данные из текстового поля
            File file = new File("group/"+s); // файл с таким именем
            if (!file.exists()) {file.mkdir();} // если нету папки, то создать!
            addName.setText(""); // очистить поле
        }
    }

    public void init(Group groups) {
        this.groups = groups;
    }
}
