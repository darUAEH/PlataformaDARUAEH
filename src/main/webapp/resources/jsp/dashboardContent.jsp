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
                        <img id="img_" name="img_" src="../img/mdp.png" alt=""/>
                        <p class="parrafo">Mis Datos Personales</p> 
                    </div>
                </div>
                <div class="col-md-4">
                    <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                    <div class="tarjeta" >
                        <img id="img_AP" name="img_" src="../img/ap.png" alt=""/>
                        <p class="parrafo">Adhesión al Plan</p> 
                    </div>
                </div>
                <div class="col-md-4">
                    <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                    <div class="tarjeta" >
                        <img id="img_" name="img_" src="../img/B.png" alt=""/>
                        <p class="parrafo">Beneficiarios</p> 
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                            <div class="tarjeta" >
                                <img id="img_EC" name="img_" src="../img/MEC.png" alt=""/>
                                <p class="parrafo">Mis Estados de Cuenta</p> 
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                            <div class="tarjeta" >
                                <img id="img_" name="img_" src="../img/SP.png" alt="" style="height: 100px;"/>
                                <p class="parrafo">Solicitud de Préstamo</p> 
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->
                            <div class="tarjeta" >
                                <img id="img_" name="img_" src="../img/AC.png" alt=""/>
                                <p class="parrafo">Agenda una Cita</p> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->

                        </div>
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->

                            <%    try {
                                    String strUsuarioActual = (String) session.getAttribute("tipo_usuario");
                                    if (strUsuarioActual.equals("administrador")) {
                                        out.write("<div class='tarjeta' id='configuracion'>");
                                        out.write("<img id='img_ADM' name='img_' src='../img/sett.png' alt=''/>");
                                        out.write("<p class='parrafo'>Configuracion</p>");
                                        out.write("</div>");
                            
                                    }
                                } catch (Exception ex) {
                                    out.write("<p class='parrafo'>No Disponible"+ex.getMessage()+"</p>");
                                }

                            %>

                        </div>
                        <div class="col-md-4">
                            <!--<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />-->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>