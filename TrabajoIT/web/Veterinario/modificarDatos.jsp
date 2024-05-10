<%-- 
    Document   : altaplayerForm
    Created on : 07-abr-2024, 19:21:45
    Author     : migue
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificación de datos de  <s:property value="#session.veterinario.nombre"/></h1>


        <s:form name="modificacionVeterinario" action="modificacionVeterinario" method="post">
            <table class="wwFormTable">
                <tbody>

                    <tr>


                        <td class="tdLabel">
                            <s:textfield name="especialidad" label="Especialidad"  required="true" value="%{#session.veterinario.especialidad}"/>
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="experiencia" label="Experiencia" min="0" max="49" value="%{#session.veterinario.experiencia}" required="true"/>
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="telefono" label="Telefono" min="9" max="9" value="%{#session.veterinario.telefono}" required="true" />
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="correo" label="Correo electronico" value="%{#session.veterinario.correo}" required="true"/>
                            </td>

                            <td class="tdLabel">
                            <s:password name="password" label="Password" value="%{#session.veterinario.password}" required="true"/>
                            </td>


                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                <s:submit name="boton" value="Modificacion"></s:submit>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </s:form>
        <s:form action="opcionesAdicionales" method="post">
            <s:submit name="boton" value="Volver"/>
            <s:submit name="boton" value="LogOut"/>

        </s:form>
    </body>
</html>
