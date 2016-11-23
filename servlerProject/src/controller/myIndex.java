package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myIndex
 */
@WebServlet("/myIndex")
public class myIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

doPost(request,response); 
} */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getRequestDispatcher("WEB-INF/pages/myIndex.jsp").forward(request, response);
} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//request.getRequestDispatcher("WEB-INF/pages/default.jsp").forward(request, response);
	    
		String name = request.getParameter("name");
		String password= request.getParameter("mypassword");
		
		String secretName = getInitParameter("name");
		String secretPassword = getInitParameter("password");
		
		//if(secretName.equals(name) && secretPassword.equals(password) )
		if(secretPassword.equals(password) )
		{
			request.setAttribute("myname",name);
	 		request.getRequestDispatcher("WEB-INF/pages/default.jsp").forward(request, response);
	 		
	 		return;
		}
		
	}

}
