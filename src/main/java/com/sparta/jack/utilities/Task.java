package com.sparta.jack.utilities;

import com.sparta.jack.database.EmployeeDAO;
import com.sparta.jack.database.EmployeeDTO;
import com.sparta.jack.database.EmployeesHashMap;
import java.sql.PreparedStatement;
import java.util.Map;


public class Task implements Runnable {


    @Override
    public void run() {
        EmployeeDAO myEmployeeDAO = new EmployeeDAO();
        PreparedStatement ps = myEmployeeDAO.makePreparedStatement();
        Timer.startTimer();
        while (EmployeesHashMap.it.hasNext()) {
            EmployeeDTO newEmployee = getNextEmployee();
            myEmployeeDAO.InsertEmployee(newEmployee, ps);
        }

        Printer.printMessage(Thread.currentThread().getName()+" finished in "+Timer.stopTimerAndGetTime()+" seconds");
    }

    public synchronized static EmployeeDTO getNextEmployee(){
        Map.Entry pair = (Map.Entry)EmployeesHashMap.it.next();
        return (EmployeeDTO) pair.getValue();
    }


}
