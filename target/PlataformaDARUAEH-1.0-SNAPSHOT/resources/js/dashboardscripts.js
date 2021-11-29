// Empty JS for your own code to be here
$(document).ready(function ()
{
    let cargaelementos = new Promise(function (resolve, reject) {
        $.get("headerdashboard.jsp", function (htmlexterno) {
            $("#Lheader").html(htmlexterno);
            $.get("dashboardContent.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                $.get("../html/footer.html", function (htmlexterno) {
                    $("#Lfooter").html(htmlexterno);
                    resolve = "cargado";
                    menu_adhesion();
                    menu_Admin();
                    menuAdmin_Revision();
                    scrollea();
                    menu_EstadosCuenta();
                });
            });
        });


    });
    cargaelementos.then(
            function (value) { /* code if successful */
                if (value === "cargado") {
                    menu_adhesion();
                    menu_Admin();
                    menuAdmin_Revision();
                    scrollea();
                    menu_EstadosCuenta();
                }
            },
            function (error) { /* code if some error */
                alert("Error al cargar los elementos del menù, por favor reinicie su navegador para volver a entrar, gracias.")
            }
    );

});
function menu_adhesion() {
    $("#img_AP").click(function () {
        valida("#img_AP", "#Lcontent", "dashboardContent.jsp", "Menu de Opciones", "Ahesion al Plan", "../img/ap.png");
    });
}
function menu_Admin() {
    $("#img_ADM").click(function () {
        valida("#img_ADM", "#Lcontent", "dashboardContent.jsp", "Menu de Opciones", "Administrador", "../img/sett.png");
    });
}
function menu_EstadosCuenta() {
    $("#img_EC").click(function () {
        valida("#img_EC", "#Lcontent", "dashboardContent.jsp", "Menu de Opciones", "Mis Estados de Cuenta", "../img/MEC.png");
    });
}
function menuAdmin_Revision() {
    $("#img_REV").click(function () {
        valida("#img_REV", "#Lcontent", "dashboardContentAdmin.jsp", "Menu de Opciones Administrador", "Revision de Adhesion", "../img/REV.png");
    });
}
function Admin_Menu() {
    $("#img_PR").click(function () {
        valida("#img_PR", "#Lcontent", "dashboardContent.jsp", "Menu de Opciones", "", "");
    });
}

//Elemento al que dio clic, componente del que viene css,jsp que va a pintar, texto del hipervinculo,texto a donde vas 

function valida(clic, component, jsp, texto, estoy, rutaImagen)
{
    switch (clic) {
        case "#img_AP":
            //Declaraciones ejecutadas cuando el resultado de expresión coincide con el valor1
            $("#Lcontent").html("");
            $.get("navegacion-bar.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                var botonRegresar = "<div class='container-fluid'><div class='row'><div class='col-md-4'><button type='button' class='btn btn-link' id='back' > <- Regresar a " + texto + "</button></div><div class='col-md-4'></div><div class='col-md-4'><img id='img_P' name='img_P' src='" + rutaImagen + "' alt=''/><p>Estoy en " + estoy + "</p></div></div></div>";
                $("#header-column-from").append(botonRegresar);
                $("#back").click(function () {
                    regresar(component, jsp);

                });
                $.get("AP.jsp", function (htmlexterno) {
                    $("#Lcontent").append(htmlexterno);
                    validarCarga()
                });

            });
            break;
        case "#img_EC":
            //Declaraciones ejecutadas cuando el resultado de expresión coincide con el valor1
            $("#Lcontent").html("");
            $.get("navegacion-bar.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                var botonRegresar = "<div class='container-fluid'><div class='row'><div class='col-md-4'><button type='button' class='btn btn-link' id='back' > <- Regresar a " + texto + "</button></div><div class='col-md-4'></div><div class='col-md-4'><img id='img_P' name='img_P' src='" + rutaImagen + "' alt=''/><p>Estoy en " + estoy + "</p></div></div></div>";
                $("#header-column-from").append(botonRegresar);
                $("#back").click(function () {
                    regresar(component, jsp);

                });
                $.get("EC.jsp", function (htmlexterno) {
                    $("#Lcontent").append(htmlexterno);
                });

            });
            break;
        case "#img_PR":
            //Declaraciones ejecutadas cuando el resultado de expresión coincide con el valor1
            $("#Lcontent").html("");
            $.get("dashboardContent.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                menu_adhesion();
                menu_Admin();
                scrollea();
                menu_EstadosCuenta();
            });
            break;
        case "#img_ADM":
            //Declaraciones ejecutadas cuando el resultado de expresión coincide con el valor1
            $("#Lcontent").html("");
            $.get("dashboardContentAdmin.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                menuAdmin_Revision();
                Admin_Menu()
                scrollea();
                menu_EstadosCuenta();

            });
            break;
        case "#img_REV":

            //Declaraciones ejecutadas cuando el resultado de expresión coincide con el valor1
            $("#Lcontent").html("");
            $.get("navegacion-bar.jsp", function (htmlexterno) {
                $("#Lcontent").html(htmlexterno);
                var botonRegresar = "<div class='container-fluid'><div class='row'><div class='col-md-4'><button type='button' class='btn btn-link' id='back' > <- Regresar a " + texto + "</button></div><div class='col-md-4'></div><div class='col-md-4'><img id='img_P' name='img_P' src='" + rutaImagen + "' alt=''/><p>Estoy en " + estoy + "</p></div></div></div>";
                $("#header-column-from").append(botonRegresar);
                $("#back").click(function () {
                    regresar(component, jsp);

                });
                $.get("REV.jsp", function (htmlexterno) {
                    $("#Lcontent").append(htmlexterno);
                    ConsultaTodasAdhesion();
                    $("#Lfooter").html("");
                });
            });
            break;

        default:
            //Declaraciones ejecutadas cuando ninguno de los valores coincide con el valor de la expresión
            console.log("default")
            break;
    }
}
function regresar(coponent, page) {
    $(coponent).html("");
    $.get(page, function (htmlexterno) {
        $(coponent).html(htmlexterno);
        menu_adhesion();
        menu_Admin();
        menuAdmin_Revision();
        Admin_Menu();
        scrollea();
        menu_EstadosCuenta();
    });
}

function subeArchivo() {
    var file = $('#file')[0].files[0];
    getBase64(file).then(data => enviaB64(data));
}
var datosjson;
function enviaB64(file) {
    var ne = $("#numeroEmpleadoSession").val()

    var settings = {
        "url": "../../EnvioAdhesion",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "dato": ne,
            "archivo": file,
            "formato": "1",
            "estatus": "1"
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        $("#mensaje").text("Validando Carga , un momento");
        validarCarga();
    });

}
var re = "";
function validarCarga() {
    var ne = $("#numeroEmpleadoSession").val()

    var settings = {
        "url": "../../validaAdhesion",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "dato": ne,
            "formato": 1
        }
    };

    $.ajax(settings).done(function (response) {
        re = response
        var resp = JSON.parse(response);
        console.log(response);

        if (resp['codigo'] === 1) {
            $('#btnCargarAviso').hide();
            $("#file").prop('disabled', true);
          
            $("#mensaje").text(resp['estatus']);
            $("#mensaje").append(" <br> el " + resp['MT'] );
            
        }
        if (resp['codigo'] === 2) {
            $('#btnCargarAviso').hide();
            $("#file").prop('disabled', true);
          
            $("#mensaje").text(resp['estatus']);
            $("#mensaje").append(" <br> el " + resp['MT'] );
            
        }
        if (resp['codigo'] === 3) {
            $('#btnCargarAviso').hide();
            $("#file").prop('disabled', true);
          
            $("#mensaje").text(resp['estatus']);
            $("#mensaje").append(" <br> el " + resp['MT'] );
            
        }
        if (resp['codigo'] === 0) {

            $("#mensaje").text(resp['estatus']);
        }
    });

}
function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
}
function ConsultaTodasAdhesion() {
    var settings = {
        "url": "../../ConsultaTodasAdhesion",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "formato": "1",
            "estatus": "1"
        }
    };

    $.ajax(settings).done(function (response) {
        //console.log(response);
        dataAd = JSON.parse(response);
        var reg = JSON.parse(dataAd)
        for (let i = 0; i < reg['Registros'].length; i++) {

            var chain = "<tr id='Fila" + reg['Registros'][i].NumeroEmpleado + "'>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + reg['Registros'][i].NumeroEmpleado + "</td>" +
                    "<td>" + reg['Registros'][i].FechaHora + "</td>" +
                    "<td>" +
                    "<button class='btn btn-outline-info btn-sm' id='btn-" + reg['Registros'][i].NumeroEmpleado + "V' >Ver Formato</button> &nbsp " +
                    "<button class='btn btn-outline-success btn-sm' id ='btn-'" + reg['Registros'][i].NumeroEmpleado + "A'>Aprobar Formato</button> &nbsp" +
                    "<button class='btn btn-outline-danger btn-sm' id ='btn-'" + reg['Registros'][i].NumeroEmpleado + "R'>Rechazar Formato</button>";
            //console.log("chain "+chain)
            
            
            $("#TablaPendientes > tbody").append(chain)

            $("#btn-" + reg['Registros'][i].NumeroEmpleado+"V").click(function () {
                reconoce(i,2);
            });
            $("#btn-" + reg['Registros'][i].NumeroEmpleado+"A").click(function () {
                reconoceA(i,3);
            });
            $("#btn-" + reg['Registros'][i].NumeroEmpleado+"R").click(function () {
                reconoceA(i,4);
            });
            $("#Fila"+ reg['Registros'][i].NumeroEmpleado).css("text-align", "left"); 
        }
        console.log("dataAd " + dataAd);

        //
    });

}

var dataAd = [];
var archivoPDF;
function reconoce(fila,valor) {
$("#Lcontent").height('100%')
$("#PDFM").empty();
    console.log("reconoce " + fila)
    var reg = JSON.parse(dataAd);
    console.log("NumeroEmpleado " + reg["Registros"][fila].NumeroEmpleado);
    console.log("NumeroEmpleado " + reg["Registros"][fila].FechaHora);
    console.log("NumeroEmpleado " + reg["Registros"][fila].Estatus);
    console.log("NumeroEmpleado " + reg["Registros"][fila].Formato);

    var settings = {
        "url": "../../ConsultaArchivo",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "NumeroEmpleado": reg["Registros"][fila].NumeroEmpleado,
            "Formato": reg["Registros"][fila].Formato,
            "Estatus": reg["Registros"][fila].Estatus
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        var PDFresponse = JSON.parse(response);
        var cadena = PDFresponse["archivo"];

        var S1 = cadena.slice(0, -1)
        var S2 = S1.slice(2)

        console.log(S2);

        var obj = document.createElement('object');
        obj.style.width = '90%';
        obj.style.height = '350pt';
        obj.type = 'application/pdf';
        obj.data = 'data:application/pdf;base64,' + S2;
        //document.body.appendChild(obj);
       
        $("#PDFM").append(obj);
        reconoceA(i,valor)

    });


}
function reconoceA(fila,valor) {

    console.log("NumeroEmpleado " + reg["Registros"][fila].NumeroEmpleado);
    console.log("NumeroEmpleado " + reg["Registros"][fila].FechaHora);
    console.log("NumeroEmpleado " + reg["Registros"][fila].Estatus);
    console.log("NumeroEmpleado " + reg["Registros"][fila].Formato);

    var settings = {
        "url": "../../InsertaCambioEstatus",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        "data": {
            "NumeroEmpleado": reg["Registros"][fila].NumeroEmpleado,
            "Formato": reg["Registros"][fila].Formato,
            "Estatus": valor
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
        var PDFresponse = JSON.parse(response);
        var cadena = PDFresponse["archivo"];

        var S1 = cadena.slice(0, -1)
        var S2 = S1.slice(2)

        console.log(S2);

        var obj = document.createElement('object');
        obj.style.width = '90%';
        obj.style.height = '350pt';
        obj.type = 'application/pdf';
        obj.data = 'data:application/pdf;base64,' + S2;
        //document.body.appendChild(obj);
       
        $("#PDFM").append(obj);

    });


}
function scrollea() {
    $('#Lcontent').on('scroll', function () { // Evento de Scroll
        if ($('#Lcontent').scrollTop() >= ($('#Lcontent').height() / 3))
        { // Si estamos al final de la página
//console.log("Final de la pagina")
            $('#pie').stop(true).animate({// Escondemos el div
                opacity: 0
            }, 250);
        } else { // Si no
            $('#pie').stop(true).animate({// Mostramos el div
                opacity: 1
            }, 200);
        }
    });
}