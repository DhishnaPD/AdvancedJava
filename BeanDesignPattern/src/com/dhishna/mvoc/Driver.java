package com.dhishna.mvoc;

public class Driver {
public static void main(String[] args) {
Student student = new Student();
student.setName("TestName");
student.setRollNumber(1);
student.setAge(23);
student.setSubject("Test Subject");
System.out.println("Name : "+student.getName());
System.out.println("Age : "+student.getAge());
System.out.println("RollNumber : "+student.getRollNumber());
System.out.println("Subject : "+student.getSubject());
}

}
