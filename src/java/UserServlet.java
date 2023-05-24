import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
        
                case "/checkStatus":
                    checkStatus(request, response);
                    break;    
                default:
                    //listUser(request, response);
                    listViolation(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listViolation(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Violation > listViolation = userDAO.selectAllViolations();
        request.setAttribute("listViolation", listViolation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("violation-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void checkStatus(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String country = request.getParameter("country");
        String city = request.getParameter("city");
          String violation = request.getParameter("violation");
        
        
        String status = userDAO.selectAllStatus(country, city, violation);
        request.setAttribute("status", status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("status.jsp");
        dispatcher.forward(request, response);
    }

    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

}