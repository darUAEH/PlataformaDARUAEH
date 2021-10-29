<%-- 
    Document   : headerdashboard
    Created on : 13/10/2021, 04:13:17 PM
    Author     : Administrador
--%>

<!DOCTYPE html>
<div class="container-fluid" >
    <div class="row" id="cabecera">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4" id="Tdireccion">
                    <h2>
                        Direccion de Ahorro para el Retiro
                    </h2>
                </div>
                <div class="col-md-4">
                </div>
                <div class="col-md-4" id="Garza">
                    <img alt="UAEH" src="../img/logo.png" width="176" height="117">
                </div>
            </div>

        </div>
    </div>
    <div class="row" id="seccionSupLogin">
        <div class="col-md-4">
            <div id="nombreU">Bienvenid@ : 
                <%
                    try {
                        String strUsuarioActual = (String) session.getAttribute("empleado");
                        if (strUsuarioActual.equals(null)) {
                            response.sendRedirect("http://localhost:8080/PlataformaDARUAEH/resources/jsp/dashboard.jsp");
                        } else {
                            out.println(strUsuarioActual);
                        }
                    } catch (Exception ex) {
                        response.sendRedirect("http://localhost:8080/PlataformaDARUAEH/resources/jsp/dashboard.jsp");
                    }

                %>
                <input id="numeroEmpleadoSession" name="numeroEmpleadoSession" type="hidden" value=<%String strUsuarioActual = (String) session.getAttribute("empleado"); out.println(strUsuarioActual);%>>
            </div>
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-4">

            <!--<button type="button" class="btn btn-danger btn-block" id="CerrarSesion">Cerrar sesión</button>-->
            <form role="form" action="/PlataformaDARUAEH/CerrarSesion" method="POST">
                <button class="btn btn-danger btn-block" id="CerrarSesion">
                    Cerrar sesión
                </button>
            </form>

        </div>
    </div>
    <div class="row" id="seccionSupLogout">
        <div class="col-md-4">
            <div id="nombreU">Bienvenid@ : Luis</div>
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
            <button type="button" class="btn btn-danger btn-block" id="CerrarSesion">Cerrar sesión</button>
        </div>
    </div>
</div>
