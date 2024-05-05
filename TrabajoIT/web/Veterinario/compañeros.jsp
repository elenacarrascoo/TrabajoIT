<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Veterinarios</title>
    </head>
    <body>
        <h1>Lista de Veterinarios </h1>
        
        <!-- Verifica que la lista no sea nula y tenga elementos -->
        <s:if test="%{!listaVeterinarios.isEmpty()}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Especialidad</th>
                        <th>Experiencia</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                        <th>dni</th>
                        <th>Contraseña</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Itera sobre la lista de veterinarios -->
                    <s:iterator value="listaVeterinarios" var="veterinario">
                        <tr>
                            <td><s:property value="#veterinario.nombre"></s:property></td>
                            <td><s:property value="#veterinario.especialidad"></s:property></td>
                            <td><s:property value="#veterinario.experiencia"></s:property></td>
                            <td><s:property value="#veterinario.telefono"></s:property></td>
                            <td><s:property value="#veterinario.correo"></s:property></td>
                            <td><s:property value="#veterinario.dni"></s:property></td>
                            <td><s:property value="#veterinario.contraseña"></s:property></td>
                            
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            
            <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                        <s:submit name="boton" value="LogOut"/>
                        
                    </s:form>
        </s:if>
        
        <!-- Si la lista es nula o está vacía -->
        <s:else>
            <p>No se encontraron veterinarios.</p>
            
            <s:form action="opcionesAdicionales" method="post">
                        <s:submit name="boton" value="Volver"/>
                        <s:submit name="boton" value="LogOut"/>
                        
                    </s:form>
        </s:else>
        
    </body>
</html>
