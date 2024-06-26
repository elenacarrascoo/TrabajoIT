<%-- 
    Document   : veterinario
    Created on : 27-abr-2024, 13:14:18
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opciones del Veterinario</title>
        <style>
            .centered-container {
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            .form-container {
                margin: 10px 0;
            }
        </style>

    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <div class="row mt-2 text-center">
                <h1>Bienvenido <s:property value="#session.veterinario.nombre"/>. Especializado en <s:property value="#session.veterinario.especialidad"/></h1>
                <h2>¿Qué acción deseas realizar?</h2>
            </div>

            <div class="centered-container">
               

                <div class="form-container">
                    <s:form action="consultaragenda" method="post">
                        <s:submit name="boton" value="Consultar Agenda" />
                    </s:form>
                </div>

                <div class="form-container">

                    <s:form action="veterinarioActions" method="post">
                        <s:submit name="boton" value="Modificar Datos" />
                    </s:form>
                </div>
                <div class="form-container">


                    <s:form action="veterinarioActions" method="post">
                        <s:submit name="boton" value="Consultar Compañeros" />
                    </s:form>

                </div>

                <div class="form-container">

                    <s:form action="Tratamiento" method="post">
                        <s:submit name="boton" value="Consultar Tratamientos" />
                    </s:form>
                </div>
                
                <div class="form-container">

                    <s:form action="consultaFacturas" method="post">
                        <s:submit name="gestionFacturas" value="Gestion Facturas" />
                    </s:form>

                </div>

                <div class="form-container">

                    <s:form action="veterinarioActions" method="post">
                        <s:submit name="boton" value="Baja Veterinario" />
                    </s:form>

                </div>

                <div class="form-container">

                    <s:form action="veterinarioActions" method="post">
                        <s:submit name="boton" value="LogOut" />
                    </s:form>

                </div>

            </div>

        </div>


        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>