package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class addColumnController {
    ObservableList<bill> billList;
    @FXML TextField addName;

    public void addField(MouseEvent event) {
        billList.add(new bill(addName.getText()));
    }

    public void init(ObservableList<bill> billList) {
        this.billList = billList;
    }
}
