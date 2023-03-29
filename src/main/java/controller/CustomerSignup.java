package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;
@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		CustomerDao dao=new CustomerDao();
		
//		String name=req.getParameter("name");
//		String password=req.getParameter("password");
//		String gender=req.getParameter("gender");
//		String dob=req.getParameter("dob");
//		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
	
		long mobile=Long.parseLong(req.getParameter("mobile"));

		
		
//		resp.getWriter().print("<h1>"+name+"</h1>+"
//				+"<h1>"+mobile+"</h1>"
//				+"<h1>"+email+"</h1>"
//				+"<h1>"+gender+"</h1>"
//				+"<h1>"+dob+"</h1>"
//				+"<h1>"+password+"</h1>");
		
		
		Date date=Date.valueOf(req.getParameter("dob"));
		
		int age=Period.between(date.toLocalDate() , LocalDate.now()).getYears();
		
		if(age<18)
		{
			resp.getWriter().print("<h1>You have to be 18+ to create an account</h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
		}
		else{
			if(dao.check(mobile).isEmpty() && dao.check(email).isEmpty())
			{
				Customer customer=new Customer();
				customer.setName(req.getParameter("name"));
				customer.setGender(req.getParameter("gender"));
				customer.setPassword(req.getParameter("password"));
				customer.setDate(date);
				customer.setEmail(email);
				customer.setMobile(mobile);
				dao.save(customer);
				
			Customer customer2=dao.check(email).get(0);
				
				
				resp.getWriter().print("<h1>Accounted created successfully</h1>");
				if(customer2.getGender().equals("male"))
				resp.getWriter().print("<h1>Hello Sir<h1>");
				else
				resp.getWriter().print("<h1>Hello Madam</h1>");	
				resp.getWriter().print("<h1>Your Customer Id is:"+customer2.getCust_id()+"</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1>Email or Phone Number already Exists</h1>");
				req.getRequestDispatcher("Signup.html").include(req, resp);
			}
			
			
		}
		
	}

}
