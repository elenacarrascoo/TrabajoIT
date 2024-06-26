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
        <s:head/>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
                font-size: 1em;
                font-family: 'Arial', sans-serif;
                text-align: left;
            }
            table thead tr {
                background-color: #3C6E71;
                color: #ffffff;
                text-align: left;
            }
            table th, table td {
                padding: 12px 15px;
                border: 1px solid #dddddd;
            }
            table tbody tr {
                border-bottom: 1px solid #dddddd;
            }
            table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }
            table tbody tr:last-of-type {
                border-bottom: 2px solid #3C6E71;
            }
            table tbody tr:hover {
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Gesti&oacute;n de citas del paciente <s:property value="#historialConsultar.paciente.nombre"/></h1>
        <s:form action="cogerCita" method="post">
            <s:submit value="altaCita" name="Alta Cita"></s:submit>
        </s:form>

        <s:if test="%{!citasPendientes.isEmpty()}">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Motivo</th>
                        <th>Veterinatio responsable</th>
                        <th>Tratamiento realizado</th>
                        <th>Medicamento</th>
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
                            <td><s:property value="#cita.veterinario.dni"/></td>
                            <td><s:property value="#cita.medicamento.nombre" /></td>
                            <td><s:property value="#cita.tratamiento.tipo" /></td>
                            <td><s:property value="#cita.factura.numFactura"/></td>
                            <td>
                                <s:form action="actualizarCita" method="post">
                                    <s:hidden name="idCitaModificar" value="%{#cita.id}"/>
                                    <s:submit name="actualizarCita" key="submit_actualizarCita"></s:submit>
                                </s:form>
                            </td>
                            <td>
                                <s:form action="eliminarCita" method="post">
                                    <s:hidden name="idCitaModificar" value="%{#cita.id}"/>
                                    <s:submit name="eliminarCita" key="submit_eliminarCita"></s:submit>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p><s:text name="mensajeErrorCitas"/></p>
        </s:else>
        <s:form action="opcionesAdicionalesCita" method="post">
            <s:submit name="boton" value="Volver"/>
            <s:submit name="boton" value="LogOut"/>
        </s:form>
            <jsp:include page="../FOOTER.jsp" />
    </body>
</html>

