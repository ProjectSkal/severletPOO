/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juros.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author helio
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples"})
public class JurosSimplesServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Integrantes - Juros POO</title>");    
            out.println("<link rel=\"shortcut icon\" href=\"imagens/images.png\">");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/estilo.css\">");
            out.println("<meta name=viewport content=width=device-width, initial-scale=1.0>");
            out.println("</head>");
            out.println("<body>");
            out.println(" <ul>");
            out.println("<li><a href='index.html'>Juros</a></li>");
            out.println("<li><a href=home>Home</a></li>");
            out.println("<li><a href=#>Juros Simples</a></li>");
            out.println("<li><a href=juros-composto>Juros Compostos</a></li>");
            out.println("</ul>");   
            out.println("<div class=\"container\">");
            out.println("<h2>Juros Simples</h2>");
            out.println("<form name=\"juros-simples-form\" method=\"post\" action=\"montante-juros-simples\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"valorPresente\"><span class=\"text-danger\">* </span>Valor presente (R$)</label>");
            out.println("<input type=\"number\" style=\"width:300px;\" class=\"form-control\" name=\"valorPresente\"  required></br>");
            out.println("<label for=\"taxaMensal\"><span class=\"text-danger\">* </span>Taxa de juros mensal (%)</label>");
            out.println("<input type=\"number\" style=\"width:300px;\" class=\"form-control\" name=\"taxaMensal\" required></br>");
            out.println("<label for=\"periodo\"><span class=\"text-danger\">* </span>Período (mês)</label>");
            out.println("<input type=\"number\" style=\"width:300px;\" class=\"form-control\" name=\"periodo\"  required></br>");
            out.println("<a href='home' class=\"btn btn-outline-success\">Home</a> &nbsp");
            out.println("<input type=\"submit\" class=\"btn btn-outline-success\" value=\"Enviar\" />");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
