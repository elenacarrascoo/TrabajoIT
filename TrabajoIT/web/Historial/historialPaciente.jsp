<%-- 
    Document   : historialPaciente
    Created on : 27-abr-2024, 16:48:40
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial del Paciente</title>
    </head>
    <body>
        <h1>Historial del paciente: <s:property value="#session.paciente.nombre"/></h1>
        
        Numero de Historial: <s:property value="#session.historialPaciente.numHistorial"/>
        Id del Paciente: <s:property value="#session.historialPaciente.idPaciente"/>
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
                    <tr>
                        <td><s:property value="#session.historialPaciente.cita.id"/></td>
                        <td><s:property value="#session.historialPaciente.cita.fecha"/></td>
                        <td><s:property value="#session.historialPaciente.cita.hora"/></td>
                        <td><s:property value="#session.historialPaciente.cita.motivo"/></td>
                        <td><s:property value="#session.historialPaciente.cita.veterinario.nombre"/></td>   
                        <td><s:property value="#session.historialPaciente.cita.tratamiento.tipo"/></td>
                        <td><s:property value="#session.historialPaciente.cita.receta.dosis"/></td>
                        <td><s:property value="#session.historialPaciente.cita.factura.numFactura"/></td>
                    </tr>
                </tbody>
        </table>
    </body>
</html>
