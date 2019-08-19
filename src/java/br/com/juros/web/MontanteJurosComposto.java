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
import java.text.DecimalFormat;

/**
 *
 * @author matus
 */
@WebServlet(name = "MontanteJurosComposto", urlPatterns = {"/montante-juros-composto"})
public class MontanteJurosComposto extends HttpServlet {

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
            DecimalFormat fmt = new DecimalFormat("0.00");
            double valorInicial = Integer.parseInt(request.getParameter("valorInicial"));
            double taxaMensal = Double.parseDouble(request.getParameter("taxaMensal"));
            double periodoMensal = Integer.parseInt(request.getParameter("periodo"));
            double montante = 0;
            double tx = taxaMensal/100;   
            double juros = tx+1;
            montante = valorInicial*juros;
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MontanteJurosComposto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Mês</th>");
            out.println("<th>Montante</th>");
            out.println("</tr>");             
            out.println("<tr>");
            out.println("<th>1</th>");
            out.println("<td>"+montante+"</td>");
            out.println("</tr>"); 
           
            for (int i = 2; i <= periodoMensal; i++) {
                juros *= juros;
                
                montante = valorInicial*juros;
                out.println("<tr>");
                out.println("<th>"+i+"</th>");
                out.println("<td>"+fmt.format(montante)+"</td>");
                out.println("</tr>");  
            }
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
