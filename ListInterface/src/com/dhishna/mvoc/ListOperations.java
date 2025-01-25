package com.dhishna.mvoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListOperations {

    private List<Student> students = new ArrayList<>();

    // Add a student
    public boolean addToStudentList(Student student) {
        try {
            students.add(student);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // Get all students
    public List<Student> getStudents() {
        return this.students;
    }

    // Get student by roll number
    public Student getStudentByRollNumber(String rollNumber) {
        Student requiredStudent = null;
        Iterator<Student> iterator = this.students.iterator(); // Use local iterator
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber().equals(rollNumber)) {
                requiredStudent = student;
                break; // Exit loop once found
            }
        }
        return requiredStudent;
    }

    // Sort students by age
    public List<Student> sortStudentsByAge() {
        Collections.sort(this.students, new StudentComparator());
        return this.students;
    }

    // Delete student by roll number
    public boolean deleteStudentByRollNumber(String rollNumber) {
        boolean deleteSuccess = false;
        Iterator<Student> studentIterator = this.students.iterator();
        while (studentIterator.hasNext()) {
            Student requiredStudent = studentIterator.next();
            if (requiredStudent.getRollNumber().equals(rollNumber)) {
                studentIterator.remove(); // Remove safely using iterator
                deleteSuccess = true;
                break; // Exit loop after deletion
            }
        }
        return deleteSuccess;
    }

    // Update student details
    public boolean updateStudent(String rollNumber, Student student) {
        boolean updateSuccess = false;
        for (int i = 0; i < this.students.size(); i++) {
            Student currentStudent = this.students.get(i);
            if (currentStudent.getRollNumber().equals(rollNumber)) {
                currentStudent.setAge(student.getAge());
                currentStudent.setFirstName(student.getFirstName());
                currentStudent.setRollNumber(student.getRollNumber());
                currentStudent.setLastName(student.getLastName());
                updateSuccess = true;
                break; // Exit loop after update
            }
        }
        return updateSuccess;
    }
}
