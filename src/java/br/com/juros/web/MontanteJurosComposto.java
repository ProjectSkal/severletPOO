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

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Montante Juros Composto</title>");
            out.println("<link rel=\"shortcut icon\" href=\"imagens/images.png\">");
            out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"css/estilo.css\">");
            out.println("<meta name=viewport content=width=device-width, initial-scale=1.0>");          
            out.println("</head>");
            double valorInicial =0;
            double taxaMensal =0;
            double periodoMensal =0;
            try {
                valorInicial = Double.parseDouble(request.getParameter("valorInicial"));
                taxaMensal = Double.parseDouble(request.getParameter("taxaMensal"));
                periodoMensal = Integer.parseInt(request.getParameter("periodo"));            
            } catch (Exception e) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Preencha todos os campos');");
                out.println("location='juros-composto';");
                out.println("</script>");
//                response.sendRedirect("juros-composto");
            }

            double montante = 0;
            double tx = taxaMensal/100;   
            double juros = tx+1;
            tx = tx+1;
            montante = valorInicial*juros;
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
            out.println("<li><a href=juros-simples>Juros Simples</a></li>");
            out.println("<li><a href=juros-composto>Juros Compostos</a></li>");
            out.println("</ul>"); 
            out.println("<div class=\"container\">");
            out.println("<h2>Juros Compostos</h2>");
            out.println("<table class=table>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Mês</th>");
            out.println("<th>Montante</th>");
            out.println("</tr>");           
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<th>1</th>");
            out.println("<td>R$ "+fmt.format(montante)+"</td>");
            out.println("</tr>"); 
           
            for (int i = 2; i <= periodoMensal; i++) {
                juros *= tx;
                montante = valorInicial*juros;
                out.println("<tr>");
                out.println("<th>"+i+"</th>");
                out.println("<td>R$ "+fmt.format(montante)+"</td>");
                out.println("</tr>");  
            }
            out.println("</tbody>"); 
            out.println("</table></br>"); 
            out.println("<a href='juros-composto' class=\"btn btn-outline-success\">Voltar</a> &nbsp");
            out.println("<a href='home' class=\"btn btn-outline-success\">Home</a></br> ");
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e) {
            
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
