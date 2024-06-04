<%-- 
    Document   : agenda
    Created on : 27-abr-2024, 16:43:23
    Author     : ecarr
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Citas</title>
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
                background-color: #009879;
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
                border-bottom: 2px solid #009879;
            }
            table tbody tr:hover {
                background-color: #f1f1f1;
            }
        </style>
    </head>
    <body>
        <jsp:include page="../HEADER.jsp" />
        <h1>Listado de Citas de <s:property value="#session.veterinario.nombre"/></h1>

        <!-- Verificar si la lista no es nula y tiene al menos un elemento -->
        <s:if test="%{!citasVeterinario.isEmpty()}">  
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Motivo</th>
                        <th>DNI del Veterinario</th>
                        <th>Num de la Factura</th>
                        <th>Medicamento (si lo hubiera)</th>
                        <th>Tratamiento (si lo hubiera)</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de citas -->
                    <s:iterator value="citasVeterinario" var="cita">
                        <tr>
                            <td><s:property value="#cita.id"/></td>
                            <td><s:property value="#cita.fecha" /></td>
                            <td><s:property value="#cita.hora" /></td>
                            <td><s:property value="#cita.motivo" /></td>
                            <td><s:property value="#cita.veterinario.dni" /></td>
                            <td><s:property value="#cita.factura.numFactura" /></td>
                            <td><s:property value="#cita.medicamento.nombre" /></td>
                            <td><s:property value="#cita.tratamiento.tipo" /></td>
                            <td>
                                <!-- Formularios con acciones para cada cita -->
                                <s:form action="verPaciente" method="post">
                                    <s:hidden name="idCita" value="%{#cita.id}" />
                                    <s:submit name="verPaciente" value="Ver Paciente" key="submit_verPaciente" />
                                </s:form>

                                <s:form action="opcionesAgenda" method="post">
                                    <s:hidden name="idCita" value="%{#cita.id}" />
                                    <s:submit name="boton" value="Alta Tratamiento" key="submit_altaVeterinario"/>
                                </s:form>
                                
                                <s:form action="formAltaMedicamento" method="post">
                                    <s:hidden name="idCita" value="%{#cita.id}" />
                                    <s:submit name="formAltaMedicamento" value="Alta Medicamento" key="submit_altaMedicamento"/>
                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Gestión Medicamentos" key="submit_gestionMedicamentos" />
                                    <s:hidden name="idCita" value="%{#cita.id}" />

                                </s:form>

                            </td>
                        </tr>
                    </s:iterator>

                    <!-- Opciones adicionales -->
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                        <s:submit name="boton" value="LogOut"/>

                    </s:form>
                </tbody>
            </table>
        </s:if>

        <!-- Si la lista es nula o está vacía -->
        <s:else>
            <p>No hay citas disponibles.</p>


            <s:form action="opcionesAdicionales" method="post">
                <s:submit name="boton" value="Volver"/>
                <s:submit name="boton" value="LogOut"/>

            </s:form>
        </s:else>

        <jsp:include page="../FOOTER.jsp" />

    </body>
</html>
