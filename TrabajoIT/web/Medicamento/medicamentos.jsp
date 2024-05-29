<%-- 
    Document   : medicamentos
    Created on : 27-abr-2024, 16:44:27
    Author     : ecarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Medicamentos disponibles</h1>
        <s:if test="%{medicamentos.isEmpty()}">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Fecha Caducidad</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator var="medicamentos" value="medicamento">
                        <tr>
                            <td><s:property value="#medicamento.id"/></td>
                            <td><s:property value="#medicamento.nombre"/></td>
                            <td><s:property value="#medicamento.fechaCaducidad"/></td>
                            <td>
                                <s:form action="actualizarMedicamento" method="post">
                                    <s:hidden name="idMedicamentoActualiza" value="%{#medicamento.id}"/>
                                    <button type="submit">Actualizar</button>
                                </s:form>
                            </td>
                            <td>
                                <s:form action="eliminarMedicamento" method="post">
                                    <s:hidden name="idMedicamentoModificar" value="%{#medicamento.id}"/>
                                    <button type="submit">Eliminar</button>
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p>No se encontraron medicamentos disponibles.</p>
            <s:form action="opcionesAdicionalesMedicamento" method="post">
                <s:submit name="boton" value="Volver"/>
                <s:submit name="boton" value="LogOut"/>
            </s:form>
        </s:else>
    </body>
</html>
