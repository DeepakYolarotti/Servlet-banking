package dto;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Customer 
{
@Id
@SequenceGenerator(initialValue=12110111,allocationSize=1,sequenceName="custid",name="custid")
@GeneratedValue(generator="custid")

int cust_id;
String name;
String email;
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
String password;
long mobile;
Date date;
String gender;

@OneToMany
List<BankAccount> accounts;
public List<BankAccount> getAccounts() {
	return accounts;
}
public void setAccounts(List<BankAccount> accounts) {
	this.accounts = accounts;
}


}
