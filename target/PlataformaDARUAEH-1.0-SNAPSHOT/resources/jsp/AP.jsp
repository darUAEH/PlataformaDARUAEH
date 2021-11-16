<%-- 
    Document   : AP
    Created on : 14/10/2021, 02:16:06 PM
    Author     : Administrador
--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-10">
            <h2>Solicitud de Incorporación al Plan de Ahorro para el Retiro</h2><!-- comment -->
            <br>
            <p>Con fundamento en el artículo 4 del Reglamento del Plan de Ahorro para el retiro, 
                en atención a que cumplo con los requisitos establecidos; solicito la incorporación 
                al plan autorizando para ello el descuento vía nómina por un 5% de mi salario quincenal</p>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <button class="btn btn-outline-info" id="btnDescargarAviso" name="btnDescargarAviso" type="submit" onclick="window.open('../pdf/adhesion.pdf')">Descargar <br/> Solicitud de incorporacion</button>
                    </div>
                    <div class="col-md-6">
                        <form enctype="multipart/form-data" id="formuploadajax" method="post">
                            <input  type="file" name="file" id="file" class="btn btn-outline-success"  Subir solicitud de incorporacion />
                            <br>
                            <br>
                            <button class="btn btn-outline-info" id="btnCargarAviso" name="btnCargarAviso" type="button" onclick="subeArchivo()">Cargar <br/> Solicitud de incorporacion</button>
                        </form>
                    </div>
                    <div class="col-md-3">
                        <p>Estatus del documento:<div id="mensaje"></div></p>
                    </div>
                </div>
            </div>



        </div>
        <div class="col-md-1">
        </div>
    </div>
</div>