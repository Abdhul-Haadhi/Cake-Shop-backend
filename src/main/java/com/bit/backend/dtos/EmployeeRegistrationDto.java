package com.bit.backend.dtos;

import java.time.LocalDate;

public class EmployeeRegistrationDto {

    private long id;
    private String employeeNumber;
    private String fullName;
//    private String callingName;
    private String nic;
    private LocalDate birthday;
//    private Integer age;
    private String address;
    private String contactNumber;
    private String gender;
    private String email;
//    private String emergencyContact;
    private String jobRole;

    public EmployeeRegistrationDto() {
    }

    public EmployeeRegistrationDto(long id, String employeeNumber, String fullName, String callingName, String nic, LocalDate birthday, Integer age, String address, String contactNumber, String gender, String email, String emergencyContact, String jobRole) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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


