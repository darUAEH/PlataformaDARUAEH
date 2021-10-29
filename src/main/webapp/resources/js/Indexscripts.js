// Empty JS for your own code to be here
$(document).ready(function ()
{
    $.get("../PlataformaDARUAEH/resources/html/header.html", function (htmlexterno) {
        $("#Lheader").html(htmlexterno);
    });
    $.get("../PlataformaDARUAEH/resources/html/formindex.html", function (htmlexterno) {
        $("#Lcontent").html(htmlexterno);
        $("#ingresa").click(function () {
            valida();
        });
    });
    $.get("../PlataformaDARUAEH/resources/html/footer.html", function (htmlexterno) {
        $("#Lfooter").html(htmlexterno);
    });

});
$("#Contrasenia").keypress(function(e) { var code = (e.keyCode ? e.keyCode : e.which); if(code == 13){ valida(); return false; } });
function valida(){
        if(($("#NumeroEmpleado").val().length==0)||($("#Contrasenia").val().length==0))
        {
            alert("Para continuar,llene todos los campos");
        }
    }