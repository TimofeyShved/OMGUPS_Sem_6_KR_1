package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(); // создаем загрузку FXML
        loader.setLocation(getClass().getResource("sample.fxml")); // добавляем нашу FXML

        Parent root = loader.load(); // создаем панель и загружаем наши данные

        Controller controller = loader.getController(); // создаем контроллер
        controller.init(); // запускаем в контроллере метод init

        primaryStage.setTitle("Журнал преподавателя"); // заголовок формы
        primaryStage.setScene(new Scene(root, 1150, 400)); // размеры формы и наша панель, в форму(окно)
        primaryStage.show(); // показать форму

        primaryStage.setOnCloseRequest(event -> { // сохранение, при закрытии формы
            try {
                controller.saveBill();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
