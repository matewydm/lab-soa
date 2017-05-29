package pl.edu.agh.kis.soa.consume.dean.pl.edu.agh.kis.soa.consume;

import pl.edu.agh.kis.soa.consume.dean.DeanRestConsume;

public class RestConsume {

    public static void main(String[] args) {
        DeanRestConsume deanRestConsume = new DeanRestConsume();
        deanRestConsume.getStudent(275789);
        deanRestConsume.deleteStudent(275789);
        deanRestConsume.getStudent(275789);
        deanRestConsume.getStudentPathParam(275252);
        deanRestConsume.saveStudent();
        deanRestConsume.getAllStudent();
    }
}
