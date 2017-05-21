package pl.edu.agh.kis.soa.consume.dean.pl.edu.agh.kis.soa.consume;

import pl.edu.agh.kis.soa.consume.dean.DeanRestConsume;

public class RestConsume {

    public static void main(String[] args) {
        DeanRestConsume deanRestConsume = new DeanRestConsume();
        deanRestConsume.getStudentName("275789");
    }
}
