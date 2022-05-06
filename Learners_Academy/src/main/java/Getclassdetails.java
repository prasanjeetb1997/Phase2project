

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class Getclass1details
 */
@WebServlet("/getclassdetails")
public class Getclassdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getclassdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SessionFactory faqctory=Hibernateutil.getSessionFactory();
	       Session session=faqctory.openSession();
	       PrintWriter out=response.getWriter();
	       
	       List<StudentTable> list1= session.createQuery("from StudentTable").list();
	       out.print("<html><body>");
         for(StudentTable p: list1) {
             out.println("Student Name: "+p.getNAME()+"<br>");
            }
         out.print("<br>");
         List<SubjectTable> list2= session.createQuery("from SubjectTable").list();
	       out.print("<html><body>");
       for(SubjectTable p: list2) {
           out.println("Subject Name: "+p.getNAME()+"<br>");
             }
       out.print("<br>");
       List<TeacherTable> list3= session.createQuery("from TeacherTable").list();
	       out.print("<html><body>");
     for(TeacherTable p: list3) {
         out.println("Teacher Name: "+p.getNAME()+"<br>");
           }
         out.print("</body></html>");
         session.close();
	       
	       
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
