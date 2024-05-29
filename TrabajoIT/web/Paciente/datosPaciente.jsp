<%-- 
    Document   : datosPaciente
    Created on : 27-abr-2024, 16:46:25
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        
        <h1>Datos de la mascota <s:property value="#session.paciente.nombre"/>:</h1>
        <div>
            <p><strong>ID:</strong> <s:property value="#session.paciente.id"/></p>
            <p><strong>Nombre:</strong> <s:property value="#session.paciente.nombre"/></p>
            <p><strong>Especie:</strong> <s:property value="#session.paciente.especie"/></p>
            <p><strong>Raza:</strong> <s:property value="#session.paciente.raza"/></p>
            <p><strong>Sexo:</strong> <s:property value="#session.paciente.sexo"/></p>
            <p><strong>Edad:</strong> <s:property value="#session.paciente.edad"/></p>
            <p><strong>Fecha de nacimiento:</strong> <s:property value="#session.paciente.fechaNacimiento"/></p>
            <p><strong>Nombre Propietario:</strong> <s:property value="#session.paciente.propietario.nombre"/></p>
        </div>
    </body>
    <s:form action="volverPacienteActual" method="post">
        <s:submit name="volverPacienteActual" key="submit_volver"/>
    </s:form>
    <jsp:include page="../FOOTER.jsp" />
</html>
