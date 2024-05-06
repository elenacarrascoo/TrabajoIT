<%-- 
    Document   : altaTratamiento
    Created on : 27-abr-2024, 16:45:03
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
        <h1>Al paciente <s:property value="#paciente.nombre"></s:property> se le ha asignado el siguiente tratamiento:</h1>
         <table border="1">
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Precio</th>
                <th>Resultado</th>
                <th>Tipo</th>
                <th>ID</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iteramos sobre listaTratamientos para crear las filas de la tabla -->
            <s:iterator value="listaTratamientos" var="tratamiento">
                <tr>
                    <td><s:property value="#tratamiento.fecha" /></td>
                    <td><s:property value="#tratamiento.hora" /></td>
                    <td><s:property value="#tratamiento.precio" /></td>
                    <td><s:property value="#tratamiento.resultado" /></td>
                    <td><s:property value="#tratamiento.tipo" /></td>
                    <td><s:property value="#tratamiento.id" /></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    </body>
</html>
