package com.sparta.jack.database;

import com.sparta.jack.utilities.CSVReader;
import com.sparta.jack.utilities.Printer;
import com.sparta.jack.utilities.Timer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeesHashMap {


    private static HashMap<String, EmployeeDTO> employeesMap;

    public static void populateMap(String fileDirectory){
        employeesMap=  CSVReader.readFromFile(fileDirectory);
    }

    public static HashMap<String, EmployeeDTO> getEmployeesMap() {
        return employeesMap;
    }


}
