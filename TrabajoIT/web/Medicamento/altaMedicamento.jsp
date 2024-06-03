<%-- 
    Document   : altaMedicamento
    Created on : 27-abr-2024, 16:44:42
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta medicamento</title>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Introduce tus datos:</h1>
        
        <s:form action="altaMedicamento" method="post">
            <s:textfield name="nombre" label="Nombre medicamento"/>
            <s:textfield name="fechaCaducidad" label="Fecha de caducidad" type="date"/>
            <s:submit name="altaMedicamento" key="submit_altaMedicamento"/>
        </s:form>
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
