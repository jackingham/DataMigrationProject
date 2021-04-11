package com.sparta.jack.utilities;

import com.sparta.jack.database.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CSVReader {

    private  static HashMap<String, EmployeeDTO> employeesMap = new HashMap<>();
    private  static HashMap<String, EmployeeDTO> duplicateMap = new HashMap<>();

    public static HashMap<String, EmployeeDTO> readFromFile(String inputFile) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader((new FileInputStream(inputFile))))) {
            String line;
            br.readLine(); //removes first line with column names
            com.sparta.jack.utilities.Timer.startTimer();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (employeesMap.containsKey(values[0])) {
                    duplicateMap.put(values[0], new EmployeeDTO(values));
                } else {
                    employeesMap.put(values[0], new EmployeeDTO(values));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeesMap;
    }

    public static HashMap<String, EmployeeDTO> returnDuplicates(){
        return duplicateMap;
    }
}
