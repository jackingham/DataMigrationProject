package com.sparta.jack;

import com.sparta.jack.database.EmployeesHashMap;
import com.sparta.jack.utilities.Printer;
import com.sparta.jack.utilities.Task;
import com.sparta.jack.utilities.Timer;


public class App {

    static final String inputFile = "resources/employees.csv";

    public static void main(String[] args) {
        Timer.startTimer();
        EmployeesHashMap.populateMap(inputFile);
        double readingTime = Timer.stopTimerAndGetTime();
        Printer.printMessage("Reading from file took "+readingTime+" seconds");

        Task task = new Task();
        Thread thread1 = new Thread(task);
        thread1.setName("thread1");

        Thread thread2 = new Thread(task);
        thread2.setName("thread2");

        Thread thread3 = new Thread(task);
        thread3.setName("thread3");

        Thread thread4 = new Thread(task);
        thread4.setName("thread4");

        Thread thread5 = new Thread(task);
        thread5.setName("thread5");

        Thread thread6 = new Thread(task);
        thread6.setName("thread6");

        Thread thread7 = new Thread(task);
        thread7.setName("thread7");

        Thread thread8 = new Thread(task);
        thread8.setName("thread8");


        Timer.startTimer();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

    }


}