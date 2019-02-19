package com.siddu.config;

public class Student {
String firstName,lastName,phoneNumber,updatedTimeStamp;

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

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

@Override
public String toString() {
	return "Student [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
}

public String getUpdatedTimeStamp() {
	return updatedTimeStamp;
}

public void setUpdatedTimeStamp(String updatedTimeStamp) {
	this.updatedTimeStamp = updatedTimeStamp;
}


}
