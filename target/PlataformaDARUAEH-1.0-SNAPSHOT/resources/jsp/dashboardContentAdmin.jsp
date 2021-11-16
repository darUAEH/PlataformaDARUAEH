<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
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
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="padding: 3% 3% 3% 3%;">
            <div class="row">
                <div class="col-md-4">
                    <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                    <div class="tarjeta" >
                        <img id="img_PR" name="img_" src="../img/PR.png" alt=""/>
                        <p class="parrafo">Volver a Menu</p> 
                    </div>
                </div>
                <div class="col-md-4">
                    <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                    <div class="tarjeta" >
                        <img id="img_REV" name="img_" src="../img/REV.png" alt=""/>
                        <p class="parrafo">Revisar Adhesión al Plan</p> 
                    </div>
                </div>
                <div class="col-md-4">
                    <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                    <div class="tarjeta" >
                        <img id="img_" name="img_" src="../img/LAY.png" alt=""/>
                        <p class="parrafo">Revisar Layout Nomina</p> 
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</div>