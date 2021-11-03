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

        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/style.css" rel="stylesheet">

    </head>
    <body>
        <div id="Lheader"></div>
        <div id="Lcontent"></div>
        <%
            try {
                String msg = (String) session.getAttribute("servletMsg");
                if (msg.equals(null)) {
                    out.println("");
                } else {
                    out.println("<p style='Color: red;' align='center'>" + msg + "</p>");
                }
            } catch (Exception q) {
                out.println("");
            }
        %>
        <div id="Lfooter"></div>

        <script src="resources/js/jquery.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/Indexscripts.js"></script>

    </body>
</html>