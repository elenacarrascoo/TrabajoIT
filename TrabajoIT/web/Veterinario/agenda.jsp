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
    </head>
    <body>
        <h1>Listado de Citas</h1>

        <!-- Verificar si la lista no es nula y tiene al menos un elemento -->
        <s:if test="%{#citasVeterinario} != null && #citasVeterinario.size() > 0}">  
            <table border="1">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Motivo</th>
                        <th>Número de Historial</th>
                        <th>ID del Veterinario</th>
                        <th>ID de la Factura</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de citas -->
                    <s:iterator value="#citasVeterinario" var="cita">
                        <tr>
                            <td><s:property value="#cita.fecha" /></td>
                            <td><s:property value="#cita.hora" /></td>
                            <td><s:property value="#cita.motivo" /></td>
                            <td><s:property value="#cita.numHistorial" /></td>
                            <td><s:property value="#cita.idFactura" /></td>
                            <td>
                                <!-- Formularios con acciones para cada cita -->
                                <s:form action="opcionesAgenda" method="post">

                                    <s:hidden name="idCita" value="cita.id" />
                                    <!-- campo hidden para identificar la cita -->
                                    <s:submit name="boton" value="Ver_Paciente" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta_Tratamiento" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta_Receta" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta_Medicamento" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Gestión_Medicamentos" />

                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>

                    <!-- Opciones adicionales -->
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Gestión_Recetas" />
                        <s:submit name="boton" value="Generar_Factura" />
                    </s:form>
                </tbody>
            </table>
        </s:if>

        <!-- Si la lista es nula o está vacía -->
        <s:else>
            <p>No hay citas disponibles.</p>
        </s:else>

    </body>
</html>
