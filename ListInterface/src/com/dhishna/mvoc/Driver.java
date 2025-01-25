package com.dhishna.mvoc;

public class Driver {
public static void main(String[] args) {
ListOperations listOperations = new ListOperations();
listOperations.addToStudentList(new Student("Minu", "PP", "004", 25));
listOperations.addToStudentList(new Student("Miya", "CS", "002", 25));
listOperations.addToStudentList(new Student("Chinnu", "VP", "001", 22));
listOperations.addToStudentList(new Student("Arya", "PK", "003", 23));
listOperations.addToStudentList(new Student("Amaya", "PG", "005", 24));
System.out.println("============ALL STUDENTS===============");
System.out.println(listOperations.getStudents());
System.out.println("=============SORTED STUDENTS===========");
System.out.println(listOperations.sortStudentsByAge());
System.out.println("=============DELETING STUDENT===========");
if(listOperations.deleteStudentByRollNumber("005")) {
System.out.println("Student deleted");
}else {
System.out.println("Student not found");
}
System.out.println("=============UPDATING STUDENT===========");
if(listOperations.updateStudent("001", new Student("Chinnu", "VP", "001", 21))) {
System.out.println("Student updated");
}else {
System.out.println("Student not found");
}
System.out.println("============ALL STUDENTS===============");
System.out.println(listOperations.getStudents());
}
}

