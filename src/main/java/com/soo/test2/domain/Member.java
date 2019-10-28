package com.soo.test2.domain;

import java.sql.Date;

public class Member {

    private int memberNo;
    private Date registeredDate; 
    private String gender;
    private Date dateOfBirth;
    private String id;
    private String email;
    private String name;
    private String password;
    private String addressCity;
    private String addressSuburb;
    private String tel;
    private String profilePhoto;
    private int userEmailChecked;
    private String activationKey;
    
    private MemberType memberType;
    
    

    @Override
    public String toString() {
      return "Member [memberNo=" + memberNo + ", registeredDate=" + registeredDate + ", gender="
          + gender + ", dateOfBirth=" + dateOfBirth + ", id=" + id + ", email=" + email + ", name="
          + name + ", password=" + password + ", addressCity=" + addressCity + ", addressSuburb="
          + addressSuburb + ", tel=" + tel + ", profilePhoto=" + profilePhoto
          + ", userEmailChecked=" + userEmailChecked + ", activationKey=" + activationKey
          + ", memberType=" + memberType + "]";
    }
    public int getMemberNo() {
      return memberNo;
    }
    public void setMemberNo(int memberNo) {
      this.memberNo = memberNo;
    }
    public Date getRegisteredDate() {
      return registeredDate;
    }
    public void setRegisteredDate(Date registeredDate) {
      this.registeredDate = registeredDate;
    }
    public String getGender() {
      return gender;
    }
    public void setGender(String gender) {
      this.gender = gender;
    }
    public Date getDateOfBirth() {
      return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getEmail() {
      return email;
    }
    public void setEmail(String email) {
      this.email = email;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getPassword() {
      return password;
    }
    public void setPassword(String password) {
      this.password = password;
    }
    public String getAddressCity() {
      return addressCity;
    }
    public void setAddressCity(String addressCity) {
      this.addressCity = addressCity;
    }
    public String getAddressSuburb() {
      return addressSuburb;
    }
    public void setAddressSuburb(String addressSuburb) {
      this.addressSuburb = addressSuburb;
    }
    public String getTel() {
      return tel;
    }
    public void setTel(String tel) {
      this.tel = tel;
    }
    public String getProfilePhoto() {
      return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
      this.profilePhoto = profilePhoto;
    }
    public MemberType getMemberType() {
      return memberType;
    }
    public void setMemberType(MemberType memberType) {
      this.memberType = memberType;
    }
    public int getUserEmailChecked() {
      return userEmailChecked;
    }
    public void setUserEmailChecked(int userEmailChecked) {
      this.userEmailChecked = userEmailChecked;
    }
    public String getActivationKey() {
      return activationKey;
    }
    public void setActivationKey(String activationKey) {
      this.activationKey = activationKey;
    }
    
    
}
