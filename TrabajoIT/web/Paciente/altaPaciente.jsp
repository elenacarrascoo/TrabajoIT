<%-- 
    Document   : altaPaciente
    Created on : 02-may-2024, 11:45:51
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <h1><s:property value="#session.propietario.nombre"/>, introduce los datos de tu mascota:</h1>

            <s:form action="registrarPaciente" method="post" enctype="multipart/form-data">
                <s:textfield name="nombre" label="Nombre"/>
                <s:textfield name="especie" label="Especie"/>
                <s:textfield name="raza" label="Raza"/>
                <s:textfield name="sexo" label="Sexo"/>
                <s:textfield name="edad" label="Edad"/>
                <s:textfield name="fechaNacimiento" label="Fecha de nacimiento" type="date"/>
                <s:file name="image" id="imagen" label="Imagen"/>
                <s:submit name="darAltaPaciente" value="Dar de alta"/>
            </s:form>
    </body>

    <a href="<s:url action='volverPropietario'/>" class="btnModificado btn mt-5">
        <s:text name="submit_volver" />
    </a> 
</div>

<jsp:include page="../FOOTER.jsp" />
</html>
