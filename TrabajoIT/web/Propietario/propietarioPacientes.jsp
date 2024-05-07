<%-- 
    Document   : propietarioPacientes
    Created on : 27-abr-2024, 16:42:59
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus mascotas</title>
    </head>
    <body>
        <h1>Tus mascotas:</h1>
        <table border="1" class="wwFormTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Especie</th>
                    <th>Raza</th>
                    <th>Sexo</th>
                    <th>Edad</th>
                    <th>Fecha de nacimiento</th>
                    <th>Propietario</th>
                    <th>Historial</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator var="paciente" value="listaPacientes">
                    <tr>
                        <td><s:property value="#paciente.id"/></td>
                        <td><s:property value="#paciente.nombre"/></td>
                        <td><s:property value="#paciente.especie"/></td>
                        <td><s:property value="#paciente.raza"/></td>
                        <td><s:property value="#paciente.sexo"/></td>
                        <td><s:property value="#paciente.edad"/></td>
                        <td><s:property value="#paciente.fechaNacimiento"/></td>
                        <td><s:property value="#paciente.historial.numHistorial"/></td>
                        <td>
                            <s:form action="cogerCita" method="post">
                                <s:submit name="cogerCita">Goger cita</s:submit>
                                <s:hidden name="numHistorial" value="%{#paciente.historial}"/>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="consultarHistorial" method="post">
                                <s:hidden name="pacienteConsultar" value="%{#paciente.id}"/>
                                <s:submit name="consultarHistorial">Ver historial mascota</s:submit>
                            </s:form>
                        </td>
                        <td>
                            <!-- Mirar este hidden -->
                            <s:form action="gestionCitas" method="post">
                                <s:hidden name="historialConsultar" value="%{#paciente.historial}"/>
                                <s:submit name="gestionCitas">Gestionar Citas</s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="eliminarPaciente" method="post">
                                <s:submit name="eliminarPaciente" value="Eliminar mascota"/>
                                <s:hidden name="idPaciente" value="%{#paciente.id}"/>
                            </s:form>
                        </td>                      
                        <td>
                            <s:form action="formModificarPaciente" method="post">
                                <s:submit name="modificarPaciente" value="Modificar mascota"/>
                                <s:hidden name="idPaciente" value="%{#paciente.id}"></s:hidden>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
                     
            </tbody>             
        </table>
    </body>
</html>
