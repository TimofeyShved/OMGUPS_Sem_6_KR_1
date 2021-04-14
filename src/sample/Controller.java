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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import java.io.File;

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
    @FXML TableColumn<bill, Number> ball;
    @FXML TableColumn<bill, Number> rating;
    @FXML ComboBox groupColumn;

    // ----------------------------------------- пустая инициализация (если пользователь ничего не передал)----------------------
    public void init() {
        this.testInit();
        this.init(billList);
    }

    // ----------------------------------------- тестовая инициализация---------------------------------------------------------------
    public void testInit() {
        billList.add(new bill ( "Иванов Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Сергей Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Александр Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Сергей Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Александр Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
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
        lessons_1.setCellValueFactory(cellData -> cellData.getValue().Lessons_1());
        // добавление строки в столбик (предмет 2)
        lessons_2.setCellValueFactory(cellData -> cellData.getValue().Lessons_2());
        // добавление строки в столбик (предмет 3)
        lessons_3.setCellValueFactory(cellData -> cellData.getValue().Lessons_3());
        // добавление строки в столбик (предмет 4)
        lessons_4.setCellValueFactory(cellData -> cellData.getValue().Lessons_4());
        // добавление строки в столбик (предмет 5)
        lessons_5.setCellValueFactory(cellData -> cellData.getValue().Lessons_5());
        // добавление строки в столбик (предмет 6)
        lessons_6.setCellValueFactory(cellData -> cellData.getValue().Lessons_6());
        // добавление строки в столбик (предмет 6)
        ball.setCellValueFactory(cellData -> cellData.getValue().getBall());
        // добавление строки в столбик (предмет 6)
        rating.setCellValueFactory(cellData -> cellData.getValue().getRating());

        // запрос на изменение данных
        lessons_1.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_2.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_3.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_4.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_5.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_6.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));

        // подсчёт затрат
        table.setOnMouseClicked(event -> {
            try {
                itogoUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Сохраняет текущую информацию об адресатах в указанном файле.
     *
     * @param(file)
     */
    //--------------------------------------обновление результата! \(＾∀＾)/--------------------------------------------
    private void itogoUpdate() throws Exception{
        File file = new File("101.xml");
        //try {
            JAXBContext context = JAXBContext.newInstance(bill.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные об адресатах.
            bill wrapper = new bill ( "Иванов Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0));
            //wrapper.setPersons(personData);

            // Маршаллируем и сохраняем XML в файл.
            marshaller.marshal(wrapper, file);
            //marshaller.marshal(wrapper, System.out);

            // Сохраняем путь к файлу в реестре.
            //setPersonFilePath(file);
        /*
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }

         */
    }
}
