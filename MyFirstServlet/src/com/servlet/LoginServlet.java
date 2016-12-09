package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("Longin.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//也可以在Servlet取出context-param,再由JSP取出
		//String strError = getServletContext().getInitParameter("ERROR");
		
		//JSP輸入的帳號密碼
		String name = request.getParameter("name");
		String password= request.getParameter("mypassword");

		//init-paramn所設定的帳號密碼
		String secretName = getServletConfig().getInitParameter("name");
		String secretPassword = getInitParameter("password");


	    if(secretName.equals(name) && secretPassword.equals(password) )
		{
			request.setAttribute("myname",name);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
			return;
		}
		else
		{
			//也可以在Servlet取出context-param,再由JSP取出
			//request.setAttribute("strMsg",strError);
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}

	}
}
