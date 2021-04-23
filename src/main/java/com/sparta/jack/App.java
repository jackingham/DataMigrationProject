package com.sparta.jack;

import com.sparta.jack.database.EmployeeDAO;
import com.sparta.jack.database.EmployeesHashMap;
import com.sparta.jack.utilities.Printer;
import com.sparta.jack.utilities.Task;
import com.sparta.jack.utilities.Timer;

import java.util.ArrayList;
import java.util.Scanner;


public class App {

    static final String inputFile = "resources/employees.csv";

    public static void main(String[] args) {
        EmployeeDAO myEmployeeDAO = new EmployeeDAO();
        myEmployeeDAO.truncateTable();

        Timer.startTimer();
        EmployeesHashMap.populateMap(inputFile);
        double readingTime = Timer.stopTimerAndGetTime();
        Printer.printMessage("Reading from file took "+readingTime+" seconds");

        ArrayList<Thread> threadArrayList = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        Printer.printMessage("How many threads?: ");
        int numberOfThreads = myScanner.nextInt();
        for( int i = 1; i<numberOfThreads+1; i++){
            Task task = new Task();
            Thread newThread = new Thread(task);
            newThread.setName("thread"+i);
            threadArrayList.add(newThread);

        }
        Timer.startTimer();

        for (Thread thread : threadArrayList){
            thread.start();
        }


    }


}