/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ActorDAO;
import daoImpl.ActorDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.Actor;

/**
 *
 * @author USER
 */
@WebServlet(name = "ActorServlet", urlPatterns = {"/ActorServlet"})
public class ActorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer actor_id = 0;
            String first_name = "";
            String last_name = "";
            try {
                actor_id = Integer.parseInt(request.getParameter("ActorID"));
                first_name = request.getParameter("ActorFirstName");
                last_name = request.getParameter("ActorLastName");
            } catch (Exception e) {
                this.getServletContext().getRequestDispatcher("/insertar.jsp").forward(request, response);
                JOptionPane.showMessageDialog(null, "DATOS INCOMPLETOS");                
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
            Date last_update = null;
            try {
               last_update = sdf.parse(request.getParameter("LastUpdate")); 
            } catch (Exception e) {
                this.getServletContext().getRequestDispatcher("/insertar.jsp").forward(request, response);
                JOptionPane.showMessageDialog(null, "FORMATO DE FECHA INCORRECTA");                
                return;
            }
            ActorDAO x = new ActorDAOImplement();
            Actor a = new Actor(first_name,last_name);
            a.setActor_id(actor_id);
            a.setLast_update(last_update);
            try {
                x.insertar(a);
            } catch (Exception e) {
                this.getServletContext().getRequestDispatcher("/insertar.jsp").forward(request, response);
                JOptionPane.showMessageDialog(null, "ID REPETIDO");               
                return;
            }
            System.out.println("GAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            this.getServletContext().getRequestDispatcher("/insertar.jsp").forward(request, response);
            JOptionPane.showMessageDialog(null, "INSERCION EXITOSA");
            return;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
