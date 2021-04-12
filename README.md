# DataMigrationProject
A project completed at Sparta to read in a CSV and insert into a MySQL database.
This program is not as refined or user friendly as I'd like, as I spent the majority of time working on the logic, which was a different approach to others.
Instead of splitting the larger hashmap of employess into smaller ones for each thread, my threads share an iterator on the hashmap which is synchonized so cannot be accesses simultaneously.
However, even though the threads do not directly interact with it, hashmaps do not work well in multithreaded environments, so I had to switch to ConcurrentHashMap at the last minute.
##How to use
You will need your own local MySQL database with a table set up as follows:
```CREATE TABLE Employees (
empId INT(6) PRIMARY KEY,
namePrefix VARCHAR(5),
firstName VARCHAR(20),
middleInitial CHAR,
lastName VARCHAR(30),
gender CHAR,
email VARCHAR(50),
dateOfBirth DATE,
dateOfJoining DATE,
SALARY INT(6));
```

It is necessary to drop the table manually after the program is run

## Tools and Technologies Used

- JDK 11
- MySQL
- IntelliJ
- MySQL 
- Git
- Threads
- ConcurrentHashMap
- BufferedReader
- FileReader
