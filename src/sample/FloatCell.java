package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import sample.FloatField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloatCell extends TableCell<bill,Number> { // наследуем таблицу переменная / число
        FloatField number; // наше поле для числа
        ObservableList<bill> billList;   // список переменных
        String nameLessons="";
        bill myBill; // наше поле для переменной

        // конструктор
        public FloatCell(ObservableList<bill> expenseList, String nameLessons) {
                this.billList = expenseList; // присваиваем список
                this.nameLessons = nameLessons;
        }

        @Override
        public void startEdit() { // начало редактирования
                if(!isEmpty()){
                        super.startEdit();
                        number=new FloatField(); // новое поле FloatField
                        myBill=getTableView().getSelectionModel().getSelectedItem(); // выбранное поле
                        switch (nameLessons){
                                case  ("lessons_1"): number.setText(myBill.Lessons_1().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_2"): number.setText(myBill.Lessons_2().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_3"): number.setText(myBill.Lessons_3().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_4"): number.setText(myBill.Lessons_4().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_5"): number.setText(myBill.Lessons_5().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_6"): number.setText(myBill.Lessons_6().getValue().toString()); // вставляем наш текст
                                        break;
                        }
                        setGraphic(number); //отображаем число
                }
        }

        @Override
        public void cancelEdit() { // отмена редактирования
                try {
                        super.cancelEdit();
                        int index = billList.indexOf(myBill); // узнаем индекс
                        float newCost = Float.parseFloat(number.getText()); // переводим число в Float
                        bill newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), myBill.lessons_6.getValue()); // подгружаем таблицу
                        switch (nameLessons) {
                                case ("lessons_1"):
                                        newExpense = new bill(myBill.getFIO(), newCost, myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                                case ("lessons_2"):
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), newCost, myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                                case ("lessons_3"):
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), newCost, myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                                case ("lessons_4"):
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), newCost, myBill.lessons_5.getValue(), myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                                case ("lessons_5"):
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), newCost, myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                                case ("lessons_6"):
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), newCost);
                                        break; // подгружаем таблицу
                                default:
                                        newExpense = new bill(myBill.getFIO(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(), myBill.lessons_4.getValue(), myBill.lessons_5.getValue(), myBill.lessons_6.getValue());
                                        break; // подгружаем таблицу
                        }
                        billList.set(index, newExpense); // меняем значение
                        setGraphic(null); //не отображаем число
                }catch (Exception e){
                        System.out.println(e);
                }
                //---------------------------------------------------------------------------------------------- sorted ------------------------------------------
                List<Float> ballList = new ArrayList<Float>(); // список баллов
                for (bill b: billList){
                        ballList.add(b.getBall().getValue());
                }
                //Collections.sort(ballList, Collections.reverseOrder());
                this.sort(ballList);
                for (int j = 0; j < billList.size(); j++){
                        for(int i = 0; i < ballList.size(); i++){
                                float f1=ballList.get(i);
                                float f2=billList.get(j).getBall().getValue();
                                if(f1==f2){
                                        bill b = billList.get(j);
                                        b.setRating(i+1);
                                        billList.set(j, b);
                                }
                        }
                }
        }

        public static List<Float> sort(List<Float> array) {
                for (int i = 0; i < array.size(); i++) {
                        for (int j = 0; j < array.size(); j++) {
                                if (array.get(j) < array.get(i)) {
                                        float aj = array.get(j);
                                        float ai = array.get(i);
                                        array.set(j, ai);
                                        array.set(i, aj);
                                }
                        }
                }
                return array;
        }

        @Override
        public void updateItem(Number item, boolean empty) { // обновление поля
                super.updateItem (item, empty);
                if(empty) { // пустое?
                        setText(null); // пустое поле
                        setGraphic(null); ;
                } else
                if(isEditing()) // редаткируем?
                setGraphic(number); //отображаем число
                else {
                        setText(getItem().toString()) ;
                        setGraphic(null) ;
                }
        }
}
