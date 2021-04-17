package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class addFieldController {

    ObservableList<bill> billList;
    @FXML TextField addName;

    public void addField(MouseEvent event) { // добавление полей учеников
        String s=addName.getText();
        s = s.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        if (!s.equals("")){
            billList.add(new bill(s)); // добавляем в нашу коллекцию, данные из текстового поля
            addName.setText(""); // очистить поле
        }
    }

    public void init(ObservableList<bill> billList) {
        this.billList = billList;
    }
}
