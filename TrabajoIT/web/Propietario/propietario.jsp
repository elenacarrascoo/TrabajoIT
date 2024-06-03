<%-- 
    Document   : propietario
    Created on : 27-abr-2024, 13:14:07
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Propietario</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
                
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <div class="row mt-2 text-center">
                <h1>Hola <s:property value="#session.propietario.nombre"/></h1>
            </div>
            <div class="row col-12 mt-5">
                <div class="col-6 text-center">
                    <h2>¿Quieres registrar a tu mascota?</h2>
                    <a href="<s:url action='formAltaPaciente'/>" class="btnModificado btn">
                        <s:text name="submit_altaPaciente" />
                    </a>
                </div>
                <div class="col-6 text-center">
                    <h2>Ve toda la información de tus mascotas</h2>
                    <a href="<s:url action='verPacientes'/>" class="btnModificado btn">
                        <s:text name="submit_verPacientes" />
                    </a>   
                </div>
                
            </div>
            <div class="row col-12 mt-5">
                <div class="col-6 mt-3 text-center">
                    <h2>Actualiza tus datos</h2>
                    <a href="<s:url action='actualizarPropietario'/>" class="btnModificado btn">
                        <s:text name="submit_actualizar" />
                    </a>
                </div>
                <div class="col-6 mt-3 text-center">
                    <h2>Ve toda la información de tus facturas</h2>
                    <a href="<s:url action='verFacturas'/>" class="btnModificado btn">
                        <s:text name="submit_verFacturas" />
                    </a>   
                </div>
                
            </div>
            <div class="row col-12 mt-5">
                <div class="col-12 mt-3 text-center">
                    <h2>Borrar cuenta</h2>
                    <a href="<s:url action='borrarPropietario'/>" class="btnModificado btn">
                        <s:text name="submit_eliminarPropietario" />
                    </a>
                </div>
            </div>
        </div>
        
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
