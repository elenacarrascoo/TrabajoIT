<%-- 
    Document   : actualizarPaciente
    Created on : 27-abr-2024, 16:47:34
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Paciente</title>
        <s:head/>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <div class="container-fluid pt-3 pb-3" style="min-height: 70vh">
            <h1>Actualiza los datos de tu mascota con id <s:property value="#session.pacienteModificar.id" />:</h1>

            <s:form action="actualizarPaciente" method="post">
                <s:textfield name="nombre" label="Nombre" value="%{#session.pacienteModificar.nombre}"/>
                <s:textfield name="especie" label="Especie" value="%{#session.pacienteModificar.especie}"/>
                <s:textfield name="raza" label="Raza" value="%{#session.pacienteModificar.raza}"/>
                <s:textfield name="sexo" label="Sexo" value="%{#session.pacienteModificar.sexo}"/>
                <s:textfield name="edad" label="Edad" value="%{#session.pacienteModificar.edad}"/>
                <s:textfield name="fechaNacimiento" label="Fecha de nacimiento" type="date" value="%{#session.pacienteModificar.fechaNacimiento}"/>
                <s:submit name="actualizarPaciente" value="Actualizar datos"/>
            </s:form>
        </body>
        <a href="<s:url action='volverPropietarioPacientes'/>" class="btnModificado btn mt-5">
            <s:text name="submit_volver" />
        </a> 
        </div>
        
    <jsp:include page="../FOOTER.jsp" />
</html>
