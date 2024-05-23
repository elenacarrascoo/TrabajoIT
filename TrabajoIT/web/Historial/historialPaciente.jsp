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
        <h1>Historial del paciente: <s:property value="historialPaciente[0].paciente.nombre"/></h1>
        Numero de Historial: <s:property value="historialPaciente[0].numHistorial"/>
        <br>
        Id del Paciente: <s:property value="historialPaciente[0].paciente.id"/> 
        <br>
        Historial de Citas: 
        <s:if test="%{!historialPaciente.isEmpty()}">
            <table>
                <thead>
                <table>
                    <thead>
                        <tr>
                            <th>Id Cita</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Motivo</th>
                            <th>Veterinario</th>
                            <th>Tratamiento</th>
                            <th>Medicamento</th>
                            <th>Factura</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator var="historial" value="historialPaciente">
                            <tr>
                                <td><s:property value="#historial.cita.id"/></td>
                                <td><s:property value="#historial.cita.fecha"/></td>
                                <td><s:property value="#hsitorial.cita.hora"/></td>
                                <td><s:property value="#historial.cita.motivo"/></td>
                                <td><s:property value="#historial.cita.veterinario.dni"/></td>   
                                <td><s:property value="#historial.cita.tratamiento.tipo"/></td>
                                <td><s:property value="#historial.cita.medicamento.nombre"/></td>
                                <td><s:property value="#historial.cita.factura.numFactura"/></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <p>No se encontraron citas asociadas a este historial.</p>
            </s:else> 
            <s:form action="opcionesAdicionalesHistorial" method="post">
                <s:submit name="boton" value="Volver"/>
                <s:submit name="boton" value="LogOut"/>
            </s:form>
    </body>
</html>
