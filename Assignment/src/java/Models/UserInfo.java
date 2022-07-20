/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class UserInfo {

    private int userinfo_id;
    private String name;
    private String gender;
    private String dob;
    private String avatar;
    private String studentID;
    private String phoneNumber;
    private String address;
    private String job;
    private String citizenID;

    public UserInfo() {
    }

    public UserInfo(int userinfo_id, String name, String gender, String dob, String avatar, String studentID, String phoneNumber, String address, String job, String citizenID) {
        this.userinfo_id = userinfo_id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.avatar = avatar;
        this.studentID = studentID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.citizenID = citizenID;
    }

    public int getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(int userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

}
