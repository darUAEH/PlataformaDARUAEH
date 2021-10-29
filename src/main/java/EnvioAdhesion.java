/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jboss.resteasy.spi.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Administrador
 */
@WebServlet(urlPatterns = {"/EnvioAdhesion"})
@MultipartConfig
public class EnvioAdhesion extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnvioAdhesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnvioAdhesion at -" + request.getContextPath() + request.getParameter("dato") + request.getParameter("archivo") + request.getParameter("formato") + request.getParameter("estatus") + "</h1>");
            out.println("</body>");
            out.println("</html>");
            postSubeAdhesion(request.getParameter("dato"), 
                    request.getParameter("archivo"), 
                    Integer.valueOf(request.getParameter("formato")),
                    Integer.valueOf(request.getParameter("estatus"))); 

        }
    }

    public void postSubeAdhesion(String dato, String archivo, int formato, int estatus) {
String jsonData = "";
        try {
            String respuesta = "";
            
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("http://10.50.5.155:5000/SubeAdhesion");
            post.addHeader("Content-Type", "application/json; charset=utf-8");
            // Establecer información del cuerpo de la solicitud
            JSONObject body = new JSONObject();
            body.put("dato", dato);
            body.put("archivo", archivo);
            body.put("formato", formato);
            body.put("estatus", estatus);
            
            post.setEntity(new StringEntity(body.toString()));
            CloseableHttpResponse response = httpClient.execute(post);
            jsonData = EntityUtils.toString(response.getEntity());
            //jsonData = UnicodeUtil.decodeUnicode(jsonData);
            //System.out.println("Recibir comentarios:" + jsonData);
            
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EnvioAdhesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnvioAdhesion.class.getName()).log(Level.SEVERE, null, ex);
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
