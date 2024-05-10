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
        <h1>Listado de Citas de <s:property value="#session.veterinario.nombre"/></h1>

        <!-- Verificar si la lista no es nula y tiene al menos un elemento -->
        <s:if test="%{!citasVeterinario.isEmpty()}">  
            <table border="1">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Motivo</th>
                        <th>Número de Historial</th>
                        <th>DNI del Veterinario</th>
                        <th>Num de la Factura</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de citas -->
                    <s:iterator value="citasVeterinario" var="cita">
                        <tr>
                            <td><s:property value="#cita.fecha" /></td>
                            <td><s:property value="#cita.hora" /></td>
                            <td><s:property value="#cita.motivo" /></td>
                            <td><s:property value="#cita.historial.numHistorial" /></td>
                            <td><s:property value="#cita.veterinario.dni" /></td>
                            <td><s:property value="#cita.factura.numFactura" /></td>
                            <td>
                                <!-- Formularios con acciones para cada cita -->
                                <s:form action="verPaciente" method="post">
                                    <s:hidden name="numHistorialCita" value="%{#cita.historial.numHistorial}" />
                                    <s:submit name="verPaciente" value="Ver Paciente" />
                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta Tratamiento" />
                                    <s:hidden name="idCita" value="{%cita.idCita}" />

                                </s:form>
                                
                                
                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta Receta" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Alta Medicamento" />

                                </s:form>

                                <s:form action="opcionesAgenda" method="post">

                                    <s:submit name="boton" value="Gestión Medicamentos" />

                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>

                    <!-- Opciones adicionales -->
                    <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Gestión Recetas" />
                        <s:submit name="boton" value="Generar Factura" />
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

    </body>
</html>
