<%-- 
    Document   : modificarTratamiento
    Created on : 09-may-2024, 9:20:40
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificación de tratamiento </h1>


        <s:form name="Tratamiento" action="Tratamiento" method="post">
            <table class="wwFormTable">
                <tbody>

                    <tr>

                            <td class="tdLabel">
                            <s:textfield name="tipo" label="Tipo"  required="true" value="%{#session.tratamiento.tipo}" required="true"/>
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="fecha" label="Fecha" type="date" value="%{#session.tratamiento.fecha}" required="true" />
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="precio" label="Precio" value="%{#session.tratamiento.precio}" required="true"/>
                            </td>

                            <td class="tdLabel">
                            <s:textfield name="resultados" label="Resultados" value="%{#session.tratamiento.resultados}" required="true"/>
                            </td>                          


                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                <s:submit name="boton" value="Modificar"></s:submit>
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
