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
    private static Iterator it;
    private int insertionCount = 0;

    static {
        employeesMap = EmployeesHashMap.getEmployeesMap();
        it= employeesMap.entrySet().iterator();

    }
    @Override
    public void run() {
        EmployeeDAO myEmployeeDAO = new EmployeeDAO();
        PreparedStatement ps = myEmployeeDAO.makePreparedStatement();
        Timer.startTimer();
        while (it.hasNext()) {
            ++insertionCount;
            //Printer.printMessage("Thread "+Thread.currentThread().getName()+" is inserting record number"+(insertionCount));
            myEmployeeDAO.InsertEmployee((getNextEmployee()), ps);
        }

        Printer.printMessage(Thread.currentThread().getName()+" finished "+Timer.stopTimerAndGetTime()+" seconds and inserted "+insertionCount+" records");
    }


    public synchronized static EmployeeDTO getNextEmployee(){
            Map.Entry pair = (Map.Entry)it.next();
            return (EmployeeDTO) pair.getValue();
    }
}
