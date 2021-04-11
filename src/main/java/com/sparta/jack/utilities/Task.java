package com.sparta.jack.utilities;

import com.sparta.jack.database.EmployeeDAO;
import com.sparta.jack.database.EmployeeDTO;
import com.sparta.jack.database.EmployeesHashMap;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Task implements Runnable {

    private static HashMap<String, EmployeeDTO> employeesMap;
    private int insertionCount = 0;
    Object key = new Object();



    @Override
    public void run() {
        EmployeeDAO myEmployeeDAO = new EmployeeDAO();
        PreparedStatement ps = myEmployeeDAO.makePreparedStatement();
        Timer.startTimer();
        while (EmployeesHashMap.it.hasNext()) {
            ++insertionCount;
            //Printer.printMessage("Thread "+Thread.currentThread().getName()+" is inserting record number"+(insertionCount));
            EmployeeDTO newEmployee = getNextEmployee();
            myEmployeeDAO.InsertEmployee(newEmployee, ps);
        }

        Printer.printMessage(Thread.currentThread().getName()+" finished "+Timer.stopTimerAndGetTime()+" seconds and inserted "+insertionCount+" records");
    }

    public synchronized static EmployeeDTO getNextEmployee(){
        Map.Entry pair = (Map.Entry)EmployeesHashMap.it.next();
        return (EmployeeDTO) pair.getValue();
    }


}
