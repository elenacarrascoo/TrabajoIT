<%-- 
    Document   : actualizarMedicamento
    Created on : 27-abr-2024, 16:44:16
    Author     : ecarr
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar medicamento</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Formulario de Actualización de Medicamento</h1>
        
        <s:form action="actualizarMedicamento" method="post">
            <s:textfield name="nombre" label="Nombre" required="true"/>
            <s:textfield name="fechaCaducidad" label="Fecha de Caducidad" required="true"/>
            <s:submit  name="Enviar" value="Actualizar medicamento" key="actualizarMedicamento"/>
        </s:form>
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
