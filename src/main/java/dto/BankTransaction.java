package dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankTransaction {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
int id;
double deposit;
double withdraw;
double balance;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
}
public double getWithdraw() {
	return withdraw;
}
public void setWithdraw(double withdraw) {
	this.withdraw = withdraw;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public LocalDateTime getDatetime() {
	return datetime;
}
public void setDatetime(LocalDateTime datetime) {
	this.datetime = datetime;
}
LocalDateTime datetime;


}
