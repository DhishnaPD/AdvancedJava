package com.dhishna.mvoc;
public class Driver {
public static void main(String[] args) {
Person person = new PersobBuilder()
.firstName("Dhishna")
.age(24)
.lastName("PD")
.id(1)
.build();
System.out.println("Name : "+person.getFirstName()+person.getLastName());
System.out.println("Age : "+person.getAge());
System.out.println("Id : "+person.getId());
}
}
