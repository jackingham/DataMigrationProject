package com.sparta.jack.database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeDTO {
    private String empID;
    private String namePrefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private int salary;

    public EmployeeDTO(String[] recordIn){
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        empID = recordIn[0];
        namePrefix = recordIn[1];
        firstName = recordIn[2];
        middleInitial = recordIn[3].charAt(0);
        lastName = recordIn[4];
        gender = recordIn[5].charAt(0);
        email = recordIn[6];
        try {
            dateOfBirth = formatter.parse(recordIn[7]);
            dateOfJoining = formatter.parse(recordIn[8]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        salary = Integer.parseInt(recordIn[9]);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID='" + empID + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getEmpID() {
        return empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }
}
