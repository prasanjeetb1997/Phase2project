

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/Authenticate")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user");
		String passcode=request.getParameter("pass");
		      
		PrintWriter qw=response.getWriter();
		
		if(username.equals("admin")&&passcode.equals("admin")) {
			
			RequestDispatcher rd=request.getRequestDispatcher("admin_dashboard.html");  
	        rd.forward(request, response);
		
		}else {
			qw.print("<html><body>");
			qw.print("<h4>");
	      qw.print("Incorrect! username or passcode<br>please try again");
	      qw.print("</h4>");
	      qw.print("<br>");
	      qw.print("</body></html>");
	      RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
		}
		qw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
