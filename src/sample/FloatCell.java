package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import sample.FloatField;

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
                                case  ("lessons_1"): number.setText(myBill.getLessons_1().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_2"): number.setText(myBill.getLessons_2().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_3"): number.setText(myBill.getLessons_3().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_4"): number.setText(myBill.getLessons_4().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_5"): number.setText(myBill.getLessons_5().getValue().toString()); // вставляем наш текст
                                        break;
                                case  ("lessons_6"): number.setText(myBill.getLessons_6().getValue().toString()); // вставляем наш текст
                                        break;
                        }
                        setGraphic(number); //отображаем число
                }
        }

        @Override
        public void cancelEdit() { // отмена редактирования
                super.cancelEdit();
                int index = billList.indexOf(myBill); // узнаем индекс
                float newCost = Float.parseFloat(number.getText()); // переводим число в Float
                bill newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),myBill.lessons_6.getValue()); // подгружаем таблицу
                switch (nameLessons){
                        case  ("lessons_1"): newExpense = new bill(myBill.getName(), newCost, myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),myBill.lessons_6.getValue());break; // подгружаем таблицу
                        case  ("lessons_2"): newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), newCost, myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),myBill.lessons_6.getValue());break; // подгружаем таблицу
                        case  ("lessons_3"): newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), newCost,myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),myBill.lessons_6.getValue());break; // подгружаем таблицу
                        case  ("lessons_4"): newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),newCost,myBill.lessons_5.getValue(),myBill.lessons_6.getValue());break; // подгружаем таблицу
                        case  ("lessons_5"): newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),newCost,myBill.lessons_6.getValue());break; // подгружаем таблицу
                        case  ("lessons_6"): newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),newCost);break; // подгружаем таблицу
                        default: newExpense=newExpense = new bill(myBill.getName(), myBill.lessons_1.getValue(), myBill.lessons_2.getValue(), myBill.lessons_3.getValue(),myBill.lessons_4.getValue(),myBill.lessons_5.getValue(),myBill.lessons_6.getValue());break; // подгружаем таблицу
                }
                billList.set(index, newExpense); // меняем значение
                setGraphic(null); //не отображаем число
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
