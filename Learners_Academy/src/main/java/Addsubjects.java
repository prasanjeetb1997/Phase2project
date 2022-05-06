

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@WebServlet("/addsubjectservlet")
public class Addsubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Session session=null; 
    
    public Addsubjects() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	 SessionFactory factory=Hibernateutil.getSessionFactory();
    	 session=factory.openSession();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("subjname");
		String class_id=request.getParameter("class_id");
		int classid=Integer.parseInt(class_id);
		 
		PrintWriter out=response.getWriter();
		SubjectTable table=new SubjectTable();
		      table.setNAME(name);
		      table.setCLASS_ID(classid);
		      Transaction trans=session.beginTransaction();
		      try {
		    	  session.save(table);
			       trans.commit();
			} catch (Exception e) {
				trans.rollback();
			}
		       out.print("Successfully stored in database");
		     out.close();  
		    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void destroy() {
		session.close();
	}
}
