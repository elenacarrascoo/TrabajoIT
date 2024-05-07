<%-- 
    Document   : historialPaciente
    Created on : 27-abr-2024, 16:48:40
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial del Paciente</title>
    </head>
    <body>
        <!-- En la base de datos deberia estar el objeto paciente para acceder a sus cosas, no el id -->
        <h1>Historial del paciente: <s:property value="#session.historialPaciente.paciente.nombre"/></h1>
        Numero de Historial: <s:property value="#session.historialPaciente.id"/>
        <br>
        Id del Paciente: <s:property value="#session.historialPaciente.idPaciente"/>
        <br>
        Historial de Citas: 
        
        <table>
            <thead>
                <tr>
                    <th>Id Cita</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Motivo</th>
                    <th>Veterinario</th>
                    <th>Tratamiento</th>
                    <th>Receta</th>
                    <th>Factura</th>
                </tr>
            </thead>
                <tbody>
                    <s:iterator var="cita" value="listaCitas">
                    <tr>
                        <td><s:property value="#cita.id"/></td>
                        <td><s:property value="#cita.fecha"/></td>
                        <td><s:property value="#cita.hora"/></td>
                        <td><s:property value="#cita.motivo"/></td>
                        <!-- A partir de aqui hay problema por el tipo de relaciones de la BBDD -->
                        <td><s:property value="#cita.veterinario.nombre"/></td>   
                        <td><s:property value="#cita.tratamiento.tipo"/></td>
                        <td><s:property value="#cita.receta.dosis"/></td>
                        <td><s:property value="#cita.factura.numFactura"/></td>
                    </tr>
                    </s:iterator>
                </tbody>
        </table>
    </body>
</html>
