/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
@WebServlet(urlPatterns = {"/ConsultaTodasAdhesion"})
public class ConsultaTodasAdhesion extends HttpServlet {

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
            
            out.println(sendMessage4Json(Integer.valueOf(request.getParameter("formato")), Integer.valueOf(request.getParameter("estatus"))));

        }
    }
    public String sendMessage4Json(int formato, int estatus){
		String jsonData = "";
	        
        OutputStreamWriter out = null ;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        String url = "http://10.50.5.155:5000/ConsultaTodasAdhesion";
//                 logger.info ("URL de solicitud:" + url);
        try {
            URL realUrl = new URL(url);
                         // abre la conexión a la URL
            URLConnection conn = realUrl.openConnection();
                         // Establecer propiedades generales de encabezado de solicitud
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                         // El envío de una solicitud POST debe establecer las siguientes dos líneas, o se generará una excepción (java.net.ProtocolException: no se puede escribir en una URLConnection si doOutput = false-call setDoOutput (true))
            conn.setDoOutput(true);
            conn.setDoInput(true);
                         // Obtenga la secuencia de salida correspondiente al objeto URLConnection y comience a enviar parámetros
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                         // Agregar parámetros
            String json = "{\"formato\":"+formato+",\"estatus\":"+estatus+"}";
            out.write(new String(json.getBytes("UTF-8")));
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
           // logger.info(e.getMessage());
                 } finally {// usa finalmente el bloque para cerrar la secuencia de salida, secuencia de entrada
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
              //  logger.info(ex.getMessage());
            }
        }
              //   logger.info ("Recibir comentarios:" + result.toString ());
        jsonData = result.toString();
	        
		
		return jsonData;
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
