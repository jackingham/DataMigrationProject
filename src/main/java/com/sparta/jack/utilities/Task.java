package com.sparta.jack.utilities;

import com.sparta.jack.database.EmployeeDAO;
import com.sparta.jack.database.EmployeeDTO;
import com.sparta.jack.database.EmployeesHashMap;
import com.sparta.jack.exceptions.IteratorAlreadyFinishedException;

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
                myEmployeeDAO.insertEmployee(newEmployee, ps);
                recordsInserted++;
            } catch (IteratorAlreadyFinishedException e) {
                System.out.println(Thread.currentThread().getName()+" tried to get a record but "+e.getMessage());
            }
        }

        Printer.printMessage(Thread.currentThread().getName()+" finished in "+Timer.stopTimerAndGetTime()+" seconds and inserted "+recordsInserted);
    }

    public synchronized static EmployeeDTO getNextEmployee() throws IteratorAlreadyFinishedException{
        if (EmployeesHashMap.it.hasNext()){
            Map.Entry pair = (Map.Entry) EmployeesHashMap.it.next();
            return (EmployeeDTO) pair.getValue();
        } else {
            throw new IteratorAlreadyFinishedException("Iterator already finished");
        }
    }


}
