package com.sparta.jack.utilities;

import com.sparta.jack.database.EmployeeDAO;
import com.sparta.jack.database.EmployeeDTO;
import com.sparta.jack.database.EmployeesHashMap;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.NoSuchElementException;


public class Task implements Runnable {



    @Override
    public void run() {
        EmployeeDAO myEmployeeDAO = new EmployeeDAO();
        PreparedStatement ps = myEmployeeDAO.makePreparedStatement();
        Timer.startTimer();
        int recordsInserted=0;
        while (EmployeesHashMap.it.hasNext()) {
            try {
                EmployeeDTO newEmployee = getNextEmployee();
                myEmployeeDAO.InsertEmployee(newEmployee, ps);
                recordsInserted++;
            } catch (NullPointerException e) {
                System.out.println("null pointer caught");
            }
        }

        Printer.printMessage(Thread.currentThread().getName()+" finished in "+Timer.stopTimerAndGetTime()+" seconds and inserted "+recordsInserted);
    }

    public synchronized static EmployeeDTO getNextEmployee() throws NullPointerException{
        if (EmployeesHashMap.it.hasNext()){
            Map.Entry pair = (Map.Entry) EmployeesHashMap.it.next();
            return (EmployeeDTO) pair.getValue();
        } else {
            throw new NullPointerException();
        }
    }


}
