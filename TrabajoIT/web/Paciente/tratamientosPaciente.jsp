<%-- 
    Document   : tratamientosPaciente
    Created on : 08-may-2024, 13:26:23
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Los tratamientos son:</h1>

        <s:if test="%{!listaTratamientos.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>Precio</th>
                        <th>Resultados</th>
                        <th>ID Cita</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterar sobre la lista de citas -->
                    <s:iterator value="listaTratamientos" var="tratamiento">
                        <tr>
                            <td><s:property value="#tratamiento.id" /></td>
                            <td><s:property value="#tratamiento.tipo" /></td>
                            <td><s:property value="#tratamiento.fecha" /></td>
                            <td><s:property value="#tratamiento.precio" /></td>
                            <td><s:property value="#tratamiento.resultados" /></td>
                            <td><s:property value="#tratamiento.cita.id" /></td>
                            <td>
                                <s:form action="Tratamiento" method="post">

                                    <s:submit name="boton" value="Modificar_Tratamiento" />
                                    <s:hidden name="idCita" value="%{#tratamiento.cita.id}"/> 

                                </s:form>

                                <s:form action="Tratamiento" method="post">

                                    <s:submit name="boton" value="Eliminar Tratamiento" />

                                </s:form>
                            </td>

                        </tr>
                    </s:iterator>



                </tbody>
            </table>

            <s:form action="opcionesAdicionales" method="post">

                <s:submit name="boton" value="Volver"/>
                <s:submit name="boton" value="LogOut"/>

            </s:form>

        </s:if>
        <s:else>
            <p>Tratamiento no encontrado.</p>
            <s:form action="opcionesAdicionales" method="post">
                <s:submit name="boton" value="Volver"/>
                <s:submit name="boton" value="LogOut"/>

            </s:form>
        </s:else>
    </body>
</html>

