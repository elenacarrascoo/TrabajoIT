<%-- 
    Document   : citas
    Created on : 27-abr-2024, 16:48:29
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
    </head>
    <body>
        <h1>Gesti&oacute;n de citas del paciente <s:property value="#session.paciente.nombre"/></h1>
    <s:form action="" method="post">
        <s:submit value="altaCita" name="Alta Cita"></s:submit>
    </s:form>

    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Motivo</th>
                <th>Precio</th>
                <th>Numero de Historial Asociado</th>
                <th>Veterinatio responsable</th>
                <th>Tratamiento realizado</th>
                <th>Receta</th>
                <th>Factura</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator var="cita" value="citasPendientes">
                <tr>
                    <td><s:property value="#cita.id"/></td>
                    <td><s:property value="#cita.fecha"/></td>
                    <td><s:property value="#cita.hora"/></td>
                    <td><s:property value="#cita.motivo"/></td>
                    <td><s:property value="#cita.precio"/></td>
                    <td><s:property value="#cita.historial.numHistorial"/></td>
                    <td><s:property value="#cita.veterinario.nombre"/></td>
                    <td><s:property value="#cita.tratamiento.tipo"/></td>
                    <td><s:property value="#cita.receta.dosis"/></td>
                    <td><s:property value="#cita.factura.id"/></td>
                    <td>
                        <s:form action="actualizarCita" method="post">
                            <s:hidden name="idCitaModificar" value="%{#cita.id}"/>
                            <button type="submit">Actualizar</button>
                        </s:form>
                    </td>
                    <td>
                    <s:form action="eliminarCita" method="post">
                        <s:hidden name="idCitaModificar" value="%{#cita.id}"/>
                        <button type="submit">Eliminar</button>
                    </s:form>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>

