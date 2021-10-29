<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>DAR UAEH</title>

        <meta name="description" content="Portal para manejo de Plataforma DAR">
        <meta name="author" content="UAEH-DAR">

        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/style.css" rel="stylesheet">



    </head>
    <body>
        <%
            try {
                String strUsuarioActual = (String) session.getAttribute("empleado");
                if (strUsuarioActual.equals(null)) {
                    response.sendRedirect("http://localhost:8080/PlataformaDARUAEH/resources/jsp/dashboard.jsp");
                } 
            } catch (Exception ex) {
                response.sendRedirect("http://localhost:8080/PlataformaDARUAEH/resources/jsp/dashboard.jsp");
            }

        %>
        <div id="Lheader"></div>
        <div id="Lcontent"></div>
        <div id="Lfooter"></div>

        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/dashboardscripts.js"></script>
    </body>
</html>