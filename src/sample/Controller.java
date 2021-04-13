package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class Controller {

    // -------------------------------------------------------------------- переменные ---------------------------------------------

    ObservableList<bill> billList = FXCollections.observableArrayList();

    @FXML TableView<bill> table;
    @FXML TableColumn<bill, String> nameColumn;
    @FXML TableColumn<bill, Number> lessons_1;
    @FXML TableColumn<bill, Number> lessons_2;
    @FXML TableColumn<bill, Number> lessons_3;
    @FXML TableColumn<bill, Number> lessons_4;
    @FXML TableColumn<bill, Number> lessons_5;
    @FXML TableColumn<bill, Number> lessons_6;
    @FXML TableColumn<bill, Number> rating;
    @FXML ComboBox groupColumn;

    // ----------------------------------------- пустая инициализация (если пользователь ничего не передал)----------------------
    public void init() {
        this.testInit();
        this.init(billList);
    }

    // ----------------------------------------- тестовая инициализация---------------------------------------------------------------
    public void testInit() {
        billList.add(new bill ( "Иванов Иван Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        billList.add(new bill ( "Иванов Сергей Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        billList.add(new bill ( "Иванов Александр Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        billList.add(new bill ( "Сидоров Сергей Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        billList.add(new bill ( "Сидоров Иван Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        billList.add(new bill ( "Сидоров Александр Иванович", new Float(30),new Float(30),new Float(30),new Float(30),new Float(30),new Float(30)));
        //ObservableValue<Number> x; // данная строчка не имеет смысла, но может пригодится если переделать на возвращаемую функцию. Но у нас void =D
    }

    // ----------------------------------------------------------------------- инициализация ---------------------------------------
    public void init (ObservableList<bill> billList){
        table.setItems(billList) ;
        table.setEditable(true);

        // добавление строки в столбик (имя)
        nameColumn.setCellValueFactory(cellData ->
                cellData.getValue().nameProperty());

        nameColumn.setCellFactory(TextFieldTableCell.<bill> forTableColumn());

        // добавление строки в столбик (предмет 1)
        lessons_1.setCellValueFactory(cellData -> cellData.getValue().getLessons_1());
        // добавление строки в столбик (предмет 2)
        lessons_2.setCellValueFactory(cellData -> cellData.getValue().getLessons_2());
        // добавление строки в столбик (предмет 3)
        lessons_3.setCellValueFactory(cellData -> cellData.getValue().getLessons_3());
        // добавление строки в столбик (предмет 4)
        lessons_4.setCellValueFactory(cellData -> cellData.getValue().getLessons_4());
        // добавление строки в столбик (предмет 5)
        lessons_5.setCellValueFactory(cellData -> cellData.getValue().getLessons_5());
        // добавление строки в столбик (предмет 6)
        lessons_6.setCellValueFactory(cellData -> cellData.getValue().getLessons_6());

        // запрос на изменение данных
        lessons_1.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_2.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_3.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_4.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_5.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_6.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));

        // подсчёт затрат
        table.setOnMouseClicked(event -> itogoUpdate());
    }

    //--------------------------------------обновление результата! \(＾∀＾)/--------------------------------------------
    private void itogoUpdate(){
        FloatProperty sumCost= new SimpleFloatProperty(0f);
        for (bill e: billList){ // перебор затрат
            //sumCost.setValue(sumCost.getValue()+e.cost.getValue());
        }
        //sum.setText(" Итого: "+sumCost.getValue()+" руб. "); // вывод затрат
    }
}
