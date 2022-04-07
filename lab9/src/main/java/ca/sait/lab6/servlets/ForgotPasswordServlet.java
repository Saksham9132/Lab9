/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.lab6.servlets;

import ca.sait.lab6.models.User;
import ca.sait.lab6.services.AccountService;
import ca.sait.lab6.dataacess.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.*;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.text.AbstractDocument.Content;


/**
 *
 * @author Saksham
 */
public class ForgotPasswordServlet extends HttpServlet {
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
         getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
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
       UserDB userDB = new UserDB();
       String email = request.getParameter("email");
       String path = getServletContext().getRealPath("/WEB-INF");
       AccountService as = new AccountService();
       as.forgotPassword(email, path);
       request.setAttribute("message","Please check your email");
      
       getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }
}