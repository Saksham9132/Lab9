
package ca.sait.lab6.servlets;

import ca.sait.lab6.models.Role;
import ca.sait.lab6.models.User;
import ca.sait.lab6.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Saksham
 */
public class UserServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       UserService service = new UserService();
       
        try {
            List<User> users = service.getAll();
          
            request.setAttribute("users", users);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
  

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserService();
        boolean isActive = false;
         if(request.getParameter("add") != null){
              String email = request.getParameter("email");
             
              String firstName = request.getParameter("firstName");
              String lastName = request.getParameter("lastName");
              String password = request.getParameter("password");
              int intRole= Integer.parseInt(request.getParameter("role"));
              Role role = new Role();
              role.setId(intRole);
                      
            try {
                boolean users = service.insert(email, isActive , firstName, lastName, password, role);
                request.setAttribute("users", users);
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         }else if(request.getParameter("delete") != null){
              String email = request.getParameter("email");
                      
            try {
                boolean users = service.delete(email);
                request.setAttribute("users", users);
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         else if(request.getParameter("update") != null){
              String email = request.getParameter("email");
              String firstName = request.getParameter("firstName");
              String lastName = request.getParameter("lastName");
              String password = request.getParameter("password");
              int intRole= Integer.parseInt(request.getParameter("role"));
              Role role = new Role();
              role.setId(intRole);
              
                      
            try {
                boolean users = service.update(email, isActive , firstName, lastName, password, role);
                request.setAttribute("users", users);
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
            try {
            List<User> users = service.getAll();
          
            request.setAttribute("users", users);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }         

    }

}
