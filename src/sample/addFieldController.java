package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class addFieldController {

    ObservableList<bill> billList;
    @FXML TextField addName;

    public void addField(MouseEvent event) {
        billList.add(new bill(addName.getText()));
    }

    public void init(ObservableList<bill> billList) {
        this.billList = billList;
    }
}
