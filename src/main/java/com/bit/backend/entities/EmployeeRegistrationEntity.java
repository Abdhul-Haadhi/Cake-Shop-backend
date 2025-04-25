package com.bit.backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Emp_Reg")

public class EmployeeRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_number")
    private String employeeNumber;

    @Column(name = "full_name")
    private String fullName;

//    @Column(name = "calling_name")
//    private String callingName;

    @Column(name = "nic")
    private String nic;

    @Column(name = "birthday")
    private LocalDate birthday;

//    @Column(name = "age")
//    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

//    @Column(name = "emergency_contact")
//    private String emergencyContact;

    @Column(name = "job_role")
    private String jobRole;


    public EmployeeRegistrationEntity() {
    }

    public EmployeeRegistrationEntity(Long id, String employeeNumber, String fullName, String callingName, String nic, LocalDate birthday, Integer age, String address, String contactNumber, String gender, String email, String emergencyContact, String jobRole) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
//        this.callingName = callingName;
        this.nic = nic;
        this.birthday = birthday;
//        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.email = email;
//        this.emergencyContact = emergencyContact;
        this.jobRole = jobRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

//    public String getCallingName() {
//        return callingName;
//    }

//    public void setCallingName(String callingName) {
//        this.callingName = callingName;
//    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getEmergencyContact() {
//        return emergencyContact;
//    }
//
//    public void setEmergencyContact(String emergencyContact) {
//        this.emergencyContact = emergencyContact;
//    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
