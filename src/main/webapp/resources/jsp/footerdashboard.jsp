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
<div class="container-fluid" id="pie">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4">
                    <h5>
                        Coordinación de Administracion y Finanzas
                    </h5>
                </div>
                <div class="col-md-4">
                    <h5>
                        Dirección de Ahorro para el Retiro
                    </h5>
                </div>
                <div class="col-md-4">
                    <h5>
                        Universidad Autónoma del Estado de Hidalgo
                    </h5>
                </div>
            </div>
        </div>
    </div>
</div>