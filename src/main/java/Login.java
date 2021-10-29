/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author Administrador
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + request.getParameter("NumeroEmpleado") + request.getParameter("Contrasenia") + "</h1>");
            String json = sendMessage4Json(String.valueOf(request.getParameter("NumeroEmpleado")), String.valueOf(request.getParameter("Contrasenia")));
            out.write("<p class='parrafo'>" + json + "</p>");

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json);
            String acceso = node.get("acceso").asText();
            String tipo_usuario = node.get("tipo_usuario").asText();
            out.write("<p class='acceso'>" + acceso + "</p>");
            out.write("<p class='tipo_usuario'>" + tipo_usuario + "</p>");

            if (acceso.equals("concedido")) {
                request.getSession().setAttribute("servletMsg", "Usuario o contrasena correctos");
                request.setAttribute("tipo_usuario", tipo_usuario);

//                    request.getRequestDispatcher("/CrearSession")
//                            .forward(request, response);
                HttpSession misession = request.getSession(true);
                LoginParameters usuario = new LoginParameters(request.getParameter("NumeroEmpleado"), tipo_usuario);
                misession.setAttribute("empleado", request.getParameter("NumeroEmpleado"));
                misession.setAttribute("tipo_usuario", tipo_usuario);
                PrintWriter pw = response.getWriter();
                pw.println("<html><body>usuario en session" + request.getParameter("NumeroEmpleado") + "," + tipo_usuario + "</body></html>");
                response.sendRedirect("/PlataformaDARUAEH/resources/jsp/dashboard.jsp");
                pw.close();
            } else {
                request.getSession().setAttribute("servletMsg", "Usuario o contrasena incorrectos");
                response.sendRedirect("/PlataformaDARUAEH/index.jsp");
            }

            /*
            String json_str = this.consultaLogin(request.getParameter("NumeroEmpleado"), request.getParameter("Contrasenia"));
            out.println(json_str);
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode node = mapper.readTree(json_str);
                String acceso = node.get("acceso").asText();
                String tipo_usuario = node.get("tipo_usuario").asText();
                 out.write("<p class='parrafo'>acceso "+acceso+"</p>");
                  out.write("<p class='parrafo'>tipo_usuario "+tipo_usuario+"</p>");
                out.println("" + acceso);
                if (acceso.equals("concedido")) {
                    request.getSession().setAttribute("servletMsg", "Usuario o contrasena correctos");
                    request.setAttribute("tipo_usuario", tipo_usuario);
                   
                    request.getRequestDispatcher("/CrearSession")
                            .forward(request, response);
                } else {
                request.getSession().setAttribute("servletMsg", "Usuario o contrasena incorrectos");
                   response.sendRedirect("/PlataformaDARUAEH/index.jsp");
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
             */
        }
    }

    public String sendMessage4Json(String numeroEmpleado, String password) {
        String jsonData = "";

        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        String url = "http://10.50.5.155:5000/Login";
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
            String json_ = "{\"NumeroEmpleado\":" + numeroEmpleado + ",\"Password\":" + password + "}";

            String json = "{\"NumeroEmpleado\":\"" + numeroEmpleado + "\",\"Password\":\"" + password + "\"}";
            out.write(new String(json.getBytes("UTF-8")));
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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

    public String consultaLogin(String numeroEmpleado, String password) {
//Esta variable res la usaremos únicamente para dar un respuesta final
        String res = "";
        String URL = "http://10.50.5.155:5000/";
        try {
//Creamos el cliente de conexión al API Restful
            Client client = ClientBuilder.newClient();

//Creamos el target lo cuál es nuestra URL junto con el nombre del método a llamar
            WebTarget target = client.target(URL + "Login");

//Creamos nuestra solicitud que realizará el request
            Invocation.Builder solicitud = target.request();

//Creamos y llenamos nuestro objeto BaseReq con los datos que solicita el API
            LoginParameters req = new LoginParameters();
            req.setNumeroEmpleado(numeroEmpleado);
            req.setPassword(password);

//Convertimos el objeto req a un json
            Gson gson = new Gson();
            String jsonString = gson.toJson(req);
            System.out.println(jsonString);

//Enviamos nuestro json vía post al API Restful
            Response post = solicitud.post(Entity.json(jsonString));

//Recibimos la respuesta y la leemos en una clase de tipo String, en caso de que el json sea tipo json y no string, debemos usar la clase de tipo JsonObject.class en lugar de String.class
            String responseJson = post.readEntity(String.class);
            res = responseJson;

//Imprimimos el status de la solicitud
            System.out.println("Estatus: " + post.getStatus());

            switch (post.getStatus()) {
                case 200:
                    res = responseJson;
                    break;
                default:
                    res = "Error";
                    break;
            }

        } catch (Exception e) {
//En caso de un error en la solicitud, llenaremos res con la exceptión para verificar que sucedió
            res = e.toString();
        }
//Imprimimos la respuesta del API Restful
        System.out.println(res);

        return res;
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
