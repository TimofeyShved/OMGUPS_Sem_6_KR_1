package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    String group = "group/"+groupColumn.getValue(); // путь для группы

    // ----------------------------------------- пустая инициализация (если пользователь ничего не передал)----------------------
    public void init() {
        //this.testInit();
        groupColumn.setValue("101");
        this.loadBill();
        this.init(billList);
    }

    // ----------------------------------------- тестовая инициализация---------------------------------------------------------------
    /*
    public void testInit() {
        billList.add(new bill ( "Иванов Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Сергей Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Александр Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Сергей Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Александр Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        //ObservableValue<Number> x; // данная строчка не имеет смысла, но может пригодится если переделать на возвращаемую функцию. Но у нас void =D
    }
     */

    // ----------------------------------------- тестовая инициализация---------------------------------------------------------------
    public void loadBill() {
        File file = new File(group);
        if (!file.exists()) {file.mkdir();}
        try {
            JAXBContext context = JAXBContext.newInstance(bill.class);
            Unmarshaller um = context.createUnmarshaller();

            billList.clear();

            // Обёртываем наши данные об адресатах.
            int i=1;
            while (file.exists()){
                file = new File(group+"/"+i+".xml");
                if(file.exists()){
                    //InputStream inStream = new FileInputStream( file );
                bill wrapper = (bill) um.unmarshal(file);
                billList.addAll(wrapper);// Чтение XML из файла и демаршализация.
                }
                i++;
            }
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    // ----------------------------------------------------------------------- инициализация ---------------------------------------
    public void init (ObservableList<bill> billList){
        ObservableList<String> groupName = FXCollections.observableArrayList("101", "103", "105","107","109");
        // подгрузка ComboBox, для изменения данных
        groupColumn.setItems(groupName);
        groupColumn.setValue("101"); // устанавливаем выбранный элемент по умолчанию

        // получаем выбранный элемент
        groupColumn.setOnAction(event -> this.loadBill());

        table.setItems(billList) ;
        table.setEditable(true);

        // -------------------------------------------------------------------- имя
        // добавление строки в столбик (имя)
        nameColumn.setCellValueFactory(cellData ->
                cellData.getValue().nameProperty());

        // запрос на изменение данных
        nameColumn.setCellFactory(TextFieldTableCell.<bill> forTableColumn());

        // -------------------------------------------------------------------- занятия
        // добавление строк
        lessons_1.setCellValueFactory(cellData -> cellData.getValue().Lessons_1());// добавление строки в столбик (предмет 1)
        lessons_2.setCellValueFactory(cellData -> cellData.getValue().Lessons_2());// добавление строки в столбик (предмет 2)
        lessons_3.setCellValueFactory(cellData -> cellData.getValue().Lessons_3());// добавление строки в столбик (предмет 3)
        lessons_4.setCellValueFactory(cellData -> cellData.getValue().Lessons_4());// добавление строки в столбик (предмет 4)
        lessons_5.setCellValueFactory(cellData -> cellData.getValue().Lessons_5());// добавление строки в столбик (предмет 5)
        lessons_6.setCellValueFactory(cellData -> cellData.getValue().Lessons_6());// добавление строки в столбик (предмет 6)
        ball.setCellValueFactory(cellData -> cellData.getValue().getBall());// добавление строки в столбик (предмет 6)
        rating.setCellValueFactory(cellData -> cellData.getValue().getRating());// добавление строки в столбик (предмет 6)

        // запрос на изменение данных
        lessons_1.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_2.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_3.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_4.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_5.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));
        lessons_6.setCellFactory(cellData -> new FloatCell (billList, cellData.getId()));

        //-------------------------------------------------------------------- подсчёт и сохранение
        table.setOnMouseClicked(event -> {
            try {
                saveBill(); // вызывает метод сохранения
            } catch (Exception e) {
                e.printStackTrace(); // обработка ошибок
            }
        });
    }

    //--------------------------------------Сохраняет текущую информацию об адресатах в указанном файле.--------------------------------------------
    private void saveBill() throws Exception{

        // настройка пути к файлу
        File file = new File(group);
        if (!file.exists()) {file.mkdir();} // если нету папки, то создать!

        //обработка сохранения
        try {
            JAXBContext context = JAXBContext.newInstance(bill.class); // какой тип данных будем сохранять
            Marshaller marshaller = context.createMarshaller(); // подготовка к расписанию данных

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // для того, что бы не было в одну строчку

            // Обёртываем наши данные об адресатах.
            int i=1;
            for (bill b:billList){ // пока есть данные типа bill
                file = new File(group+"/"+i+".xml"); // указываем путь к файлу
                file.createNewFile(); // при необходимости создаём новый
                marshaller.marshal(b, file); // Маршаллируем и сохраняем XML в файл.
                i++;
            }
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");

            alert.showAndWait();
        }
    }

    //---------------------------------------------------------------------- добавляем новую строку --------------------------------------------
    static Stage dialogStage;
    public void addField(MouseEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(); // создаем загрузку FXML
        loader.setLocation(getClass().getResource("addBill.fxml")); // добавляем нашу FXML

        Pane page = loader.load(); // создание панели
        dialogStage = new Stage();
        dialogStage.initModality( Modality.WINDOW_MODAL); // блокировка предыдущей формы, при открытии новой

        Scene scene = new Scene(page) ; // создание сцены
        dialogStage.setScene(scene);

        addFieldController addF = loader.getController(); // контроллер
        addF.init(billList); // отправка данных этой формы, на новую
        dialogStage.showAndWait();
    }

    //---------------------------------------------------------------------- Удаляем строку --------------------------------------------
    public void deleteField(MouseEvent event) throws Exception {
        int editingIndex = table.getSelectionModel().getFocusedIndex();
        billList.remove(editingIndex);

        File file = new File(group+"/"+editingIndex+".xml");
        if (file.exists()) {
            Files.delete(Paths.get(group+"/"+(billList.size()+1)+".xml"));
        }

        this.saveBill();
    }

    //---------------------------------------------------------------------- добавляем новую группу --------------------------------------------
    public void addColumn(MouseEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(); // создаем загрузку FXML
        loader.setLocation(getClass().getResource("addColumn.fxml")); // добавляем нашу FXML

        Pane page = loader.load(); // создание панели
        dialogStage = new Stage();
        dialogStage.initModality( Modality.WINDOW_MODAL); // блокировка предыдущей формы, при открытии новой

        Scene scene = new Scene(page) ; // создание сцены
        dialogStage.setScene(scene);

        addFieldController addF = loader.getController(); // контроллер
        addF.init(billList); // отправка данных этой формы, на новую
        dialogStage.showAndWait();
    }

    //---------------------------------------------------------------------- Удаляем группу --------------------------------------------
    public void deleteColumn(MouseEvent event) {
    }
}
