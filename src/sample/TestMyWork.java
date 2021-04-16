package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMyWork {

    @Test
    public void Bill() throws Exception {
        ObservableList<bill> billList = FXCollections.observableArrayList();
        billList.add(new bill ( "Иванов Иван Иванович", new Float(0),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Сергей Иванович", new Float(1),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Иванов Александр Иванович", new Float(2),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Сергей Иванович", new Float(3),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Иван Иванович", new Float(4),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        billList.add(new bill ( "Сидоров Александр Иванович", new Float(5),new Float(0),new Float(0),new Float(0),new Float(0),new Float(0)));
        int i=0;
        for (bill b:billList){
            assertEquals(b.getlessons_1(), new Float(i));
            i++;
            b.setlessons_2(new Float(i));
            b.setlessons_3(new Float(i));
            b.setlessons_4(new Float(i));
            b.setlessons_5(new Float(i));
            b.setlessons_6(new Float(i));
        }
        i=1;
        for (bill b:billList){
            assertEquals(b.getlessons_2(), new Float(i));
            assertEquals(b.getlessons_3(), new Float(i));
            assertEquals(b.getlessons_4(), new Float(i));
            assertEquals(b.getlessons_5(), new Float(i));
            assertEquals(b.getlessons_6(), new Float(i));
            i++;
        }
        assertEquals(billList.get(3).getFIO(),"Сидоров Сергей Иванович");
        assertEquals(billList.get(4).getFIO(),"Сидоров Иван Иванович");
        bill b = new bill();
        b.setlessons_1(new Float(-33332));
        b.setlessons_2(new Float(999999999));
        b.setlessons_3(new Float(0));
        assertEquals(b.getlessons_1(), new Float(-33332));
        assertEquals(b.getlessons_2(), new Float(999999999));
        assertEquals(b.getlessons_3(), new Float(0));
    }
}