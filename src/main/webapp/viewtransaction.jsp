<%@page import="dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto.Customer"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transaction</title>
</head>
<body>
<%
long acno=(Long) session.getAttribute("acno");
BankDao bankDao=new BankDao();
BankAccount account=bankDao.find(acno);
List<BankTransaction> list=account.getTransaction();
%>
<h1>Account Number: <%=acno %></h1>
<h1>Account Type:   <%=account.getType() %></h1>

<table border="1"> 
<tr>
<th>Transaction_Id</th>
<th>Deposit</th>
<th>Withdraw</th>
<th>Balance</th>
<th>Time</th>
</tr>
<%for(BankTransaction transaction:list){ %>
<tr>
<th><%=transaction.getId() %></th>
<th><%=transaction.getDeposit() %></th>
<th><%=transaction.getWithdraw()%></th>
<th><%=transaction.getBalance() %></th>
<th><%=transaction.getDatetime() %></th>
</tr>
<%} %>
</table>
<br>
<br>
<a href="AccountHome.jsp"><button>Back</button></a>
</body>
</html>




  


