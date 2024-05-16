package database;

import java.sql.Date;

public class Student {

    int id;
    String firstname, lastname, gender, phone, department, email;
    Date birthdate;

    public Student(int id, String firstname, String lastname, String gender, String phone, String department, String email,
            Date birthdate) {

                this.id = id;
                this.firstname = firstname;
                this.lastname = lastname;
                this.gender = gender;
                this.phone = phone;
                this.department = department;
                this.email = email;
                this.birthdate = birthdate;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }

    public int getId(){
        return id;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getGender(){
        return gender;
    }
    public String getPhone(){
        return phone;
    }
    public String getDepartment(){
        return department;
    }
    public String getEmail(){
        return email;
    }
    public Date getBirthdate(){
        return birthdate;
    }


     
}
