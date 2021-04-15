package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.*;

// Используется для сохранения списка адресатов в XML.
@XmlRootElement(name = "bills")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "bills", propOrder = {
        "FIO",
        "lessons_1",
        "lessons_2",
        "lessons_3",
        "lessons_4",
        "lessons_5",
        "lessons_6",
        "ball",
        "rating"
})
public class bill {
    //--------------------------------------------------------------------------------- переменные ------------------------------------------------------------
     StringProperty FIO = new SimpleStringProperty(""); // имя
     FloatProperty lessons_1 = new SimpleFloatProperty( 0 ) ; // предмет 1
    FloatProperty lessons_2 = new SimpleFloatProperty( 0 ) ; // предмет 2
     FloatProperty lessons_3 = new SimpleFloatProperty( 0 ) ; // предмет 3
     FloatProperty lessons_4 = new SimpleFloatProperty( 0 ) ; // предмет 4
     FloatProperty lessons_5 = new SimpleFloatProperty( 0 ) ; // предмет 5
    FloatProperty lessons_6 = new SimpleFloatProperty( 0 ) ; // предмет 6
     FloatProperty ball = new SimpleFloatProperty( 0 ) ; //
     FloatProperty rating = new SimpleFloatProperty( 0 ) ; // рейтинг

    public bill (){
    }
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
        this.FIO = new SimpleStringProperty(name); // добавить имя в класс
        this.lessons_1 = new SimpleFloatProperty(lessons_1); // добавить предмет в класс
        this.lessons_2 = new SimpleFloatProperty(lessons_2); // добавить предмет в класс
        this.lessons_3 = new SimpleFloatProperty(lessons_3); // добавить предмет в класс
        this.lessons_4 = new SimpleFloatProperty(lessons_4); // добавить предмет в класс
        this.lessons_5 = new SimpleFloatProperty(lessons_5); // добавить предмет в класс
        this.lessons_6 = new SimpleFloatProperty(lessons_6); // добавить предмет в класс
        this.ball = new SimpleFloatProperty(
                (lessons_1+lessons_2+lessons_3+lessons_4+lessons_5+lessons_6)/6
        );
        this.rating  = new SimpleFloatProperty(0); // добавить предмет в класс
    }

    public bill(String text) {
        this.FIO = new SimpleStringProperty(text); // добавить имя в класс
    }

    // --------------------------------------------------------------------------------- обработка событый -------------------------------------------------------

    //---------------------------------------------------------- ИМЯ
    //@XmlElement(name = "name")
    public String getFIO () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return FIO.get();
    }// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public StringProperty nameProperty () { // вернуть значение-строку с именем
        return FIO;
    }

    public void setFIO (String name) { // записать имя (ещё не использовали, но вдруг пригодиться)
        this.FIO.set(name);
    }
    //-----------------------------------------------------------  предмет 1
    @XmlElement(name = "lessons_1")
    public Float getlessons_1() {return lessons_1.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_1(Float lessons_1) {this.lessons_1.set(lessons_1);}

    public FloatProperty Lessons_1 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_1;
    }
    //-----------------------------------------------------------  предмет 2
    @XmlElement(name = "lessons_2")
    public Float getlessons_2() {return lessons_2.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_2(Float lessons_2) {this.lessons_2.set(lessons_2);}

    public FloatProperty Lessons_2 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_2;
    }
    //-----------------------------------------------------------  предмет 3
    @XmlElement(name = "lessons_3")
    public Float getlessons_3() {return lessons_3.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_3(Float lessons_3) {this.lessons_3.set(lessons_3);}

    public FloatProperty Lessons_3 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_3;
    }
    //-----------------------------------------------------------  предмет 4
    @XmlElement(name = "lessons_4")
    public Float getlessons_4() {return lessons_4.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_4(Float lessons_4) {this.lessons_4.set(lessons_4);}

    public FloatProperty Lessons_4 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_4;
    }
    //-----------------------------------------------------------  предмет 5
    @XmlElement(name = "lessons_5")
    public Float getlessons_5() {return lessons_5.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_5(Float lessons_5) {this.lessons_5.set(lessons_5);}

    public FloatProperty Lessons_5 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_5;
    }
    //-----------------------------------------------------------  предмет 6
    @XmlElement(name = "lessons_6")
    public Float getlessons_6() {return lessons_6.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setlessons_6(Float lessons_6) {this.lessons_6.set(lessons_6);}

    public FloatProperty Lessons_6 () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return lessons_6;
    }
    //-----------------------------------------------------------  рейтинг
    @XmlElement(name = "ball")
    public Float getball() {return ball.get();} // необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setball(Float ball) {this.ball.set(ball);}

    public FloatProperty getBall () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return ball;
    }
    @XmlElement(name = "rating")
    public Float getrating() {return rating.get();}// необходимо для сериализации в file.xml(marshaller/Unmarshaller)
    public void setrating(Float rating) {this.rating.set(rating);}

    public FloatProperty getRating () { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        return rating;
    }
    public void setRating (float rating) { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        this.rating=new SimpleFloatProperty(rating);
    }
    public void setBall(float ball) { // вернуть имя (ещё не использовали, но вдруг пригодиться)
        this.ball=new SimpleFloatProperty(ball);
    }
}
