package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableFloatProperty;

import java.util.jar.Attributes;

public class bill {
    public Attributes lessons;
    //--------------------------------------------------------------------------------- переменные ------------------------------------------------------------
    StringProperty name = new SimpleStringProperty(""); // имя
    FloatProperty lessons_1 = new SimpleFloatProperty( 0 ) ; // предмет 1
    FloatProperty lessons_2 = new SimpleFloatProperty( 0 ) ; // предмет 2
    FloatProperty lessons_3 = new SimpleFloatProperty( 0 ) ; // предмет 3
    FloatProperty lessons_4 = new SimpleFloatProperty( 0 ) ; // предмет 4
    FloatProperty lessons_5 = new SimpleFloatProperty( 0 ) ; // предмет 5
    FloatProperty lessons_6 = new SimpleFloatProperty( 0 ) ; // предмет 6
    FloatProperty rating = new SimpleFloatProperty( 0 ) ; // рейтинг

    //-------------------------------------------------------------------------------------конструтор -----------------------------------------------
    public bill (
            String name,
            Float lessons_1,
            Float lessons_2,
            Float lessons_3,
            Float lessons_4,
            Float lessons_5,
            Float lessons_6
        )
    {
        this.name = new SimpleStringProperty(name); // добавить имя в класс
        this.lessons_1 = new SimpleFloatProperty(lessons_1); // добавить предмет в класс
        this.lessons_2 = new SimpleFloatProperty(lessons_2); // добавить предмет в класс
        this.lessons_3 = new SimpleFloatProperty(lessons_3); // добавить предмет в класс
        this.lessons_4 = new SimpleFloatProperty(lessons_4); // добавить предмет в класс
        this.lessons_5 = new SimpleFloatProperty(lessons_5); // добавить предмет в класс
        this.lessons_6 = new SimpleFloatProperty(lessons_6); // добавить предмет в класс
        this.rating = new SimpleFloatProperty(
                (lessons_1+lessons_2+lessons_3+lessons_4+lessons_5+lessons_6)/6
        );
    }

    // --------------------------------------------------------------------------------- обработка событый -------------------------------------------------------

    //----------------------------- ИМЯ
    public String getName () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return name.get();
    }
    public StringProperty nameProperty () { // вернуть значение-строку с именем
        return name;
    }
    public void setName (String name) { // записать имя (ещё не использовали, но вдруг пригодиться)
        this.name.set(name);
    }
    //------------------------------  предмет 1
    public FloatProperty getLessons_1 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_1;
    }
    //------------------------------  предмет 2
    public FloatProperty getLessons_2 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_2;
    }
    //------------------------------  предмет 3
    public FloatProperty getLessons_3 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_3;
    }
    //------------------------------  предмет 4
    public FloatProperty getLessons_4 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_4;
    }
    //------------------------------  предмет 5
    public FloatProperty getLessons_5 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_5;
    }
    //------------------------------  предмет 6
    public FloatProperty getLessons_6 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_6;
    }
    //------------------------------  рейтинг
    public FloatProperty rating () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return rating;
    }
}
