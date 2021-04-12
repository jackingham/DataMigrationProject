package com.sparta.jack.database;

import com.sparta.jack.utilities.CSVReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeesHashMap {

    public static Iterator it;

    private static ConcurrentHashMap<String, EmployeeDTO> employeesMap;

    public static void populateMap(String fileDirectory){
        employeesMap=  CSVReader.readFromFile(fileDirectory);
        it= employeesMap.entrySet().iterator();
    }



}
