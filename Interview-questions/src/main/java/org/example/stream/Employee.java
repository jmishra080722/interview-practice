package org.example.stream;

import java.util.Arrays;
import java.util.List;

public class Employee {

    private Integer empId;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private String newJoiner;

    private int salary;

    private int rating;

    public Employee(Integer empId, String firstName, String lastName, String email, String gender, String newJoiner, int salary, int rating) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.newJoiner = newJoiner;
        this.salary = salary;
        this.rating = rating;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNewJoiner() {
        return newJoiner;
    }

    public void setNewJoiner(String newJoiner) {
        this.newJoiner = newJoiner;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", newJoiner='" + newJoiner + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }

    public static List<Employee> getEmpList(){

        return Arrays.asList(

                new Employee(593851088,"Amit","Schwerin","amit@gmail.com","Male","True",101146,0),

                new Employee(732746476,"Jagat","Frudd","jagat@ovh.net","Male","FALSE",29310,2),

                new Employee(859399584,"Sanchi","Gumb","sanchi@twitter.com","Female","FALSE",62291,4),

                new Employee(218252663,"Virat","Batterham","virat3@last.fm","Male","FALSE",142439,4),

                new Employee(218252623,"John","Burrel","john@google.ru","Male","FALSE",128764,5),

                new Employee(66708-5539,"Tailor","Ridding","Ridding","Female","FALSE",152924,4),

                new Employee(816972363,"Kelly","Braybrooke","kelly6@prnewswire.com","Male","TRUE",128907,0),

                new Employee(630191110,"Dhoni","Baverstock","dhoni@ehow.com","Male","TRUE",2510,0)

        );

    }
}
