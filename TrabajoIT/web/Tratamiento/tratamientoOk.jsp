<%-- 
    Document   : tratamientoOk
    Created on : 16-may-2024, 11:22:58
    Author     : Usuario
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
        <h1>El tratamiento se ha dado de alta en el historial del paciente y en la base de datos de manera satisfactoria</h1>
        
        <s:form action="Tratamiento" method="post">
            <s:submit name="boton" value="Volver a Agenda"></s:submit>
        </s:form>
        
        <jsp:include page="../FOOTER.jsp" />
    </body>
</html>
