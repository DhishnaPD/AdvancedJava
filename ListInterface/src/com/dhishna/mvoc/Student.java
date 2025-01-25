package com.dhishna.mvoc;

public class Student {

		private String firstName;
		private String lastName;
		private String rollNumber;
		private int age;
		public String getFirstName() {
		return firstName;
		}
		public void setFirstName(String firstName) {
		this.firstName = firstName;
		}
		public String getLastName() {
		return lastName;
		}
		public void setLastName(String lastName) {
		this.lastName = lastName;
		}
		public String getRollNumber() {
		return rollNumber;
		}
		public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
		}
		public int getAge() {
		return age;
		}
		public void setAge(int age) {
		this.age = age;
		}
		public Student(String firstName, String lastName, String rollNumber, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
		this.age = age;
		}
		@Override
		public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", rollNumber=" + rollNumber + ", age="
		+ age + "]";

}

}
