package com.servlet;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.Listener.myLoginListener;
//import javax.servlet.http.HttpSession;  
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
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		/*
		String uri = request.getRequestURI();
				
		if(uri.endsWith("Logout")){
			 HttpSession session=request.getSession(false);  
		      session.invalidate();//invalidating session  
			//request.getSession().invalidate();
			//request.setAttribute("cont",myListener.GetSessions());
		}
		*/
	/*
		request.getRequestDispatcher("Longin.jsp").forward(request, response);
	} 
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�]�i�H�bServlet���Xcontext-param,�A��JSP���X
		//String strError = getServletContext().getInitParameter("ERROR");
		
		//JSP��J���b���K�X
		String name = request.getParameter("name");
		String password= request.getParameter("mypassword");

		//init-paramn�ҳ]�w���b���K�X
		//String secretName = getServletConfig().getInitParameter("name");
		String secretPassword = getInitParameter("password");

	
	    //if(secretName.equals(name) && secretPassword.equals(password) )
		//{
	    //�b�̥u���ұK�X�MDD�̭����O�_�ۦP�N�n,�Ӽ����h�H�b�P��web��case
		if(secretPassword.equals(password) )
		{
			request.setAttribute("myname",name);
			HttpSession session = request.getSession();
			session.setAttribute("myname",name);
			
			request.setAttribute("cont",myLoginListener.GetSessions());
			request.getRequestDispatcher("Index.jsp").forward(request, response);
			return;
		}
		else
		{
			//�]�i�H�bServlet���Xcontext-param,�A��JSP���X
			//request.setAttribute("strMsg",strError);
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}

	}
}
