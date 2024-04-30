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
        <h1>Modificación de datos</h1>
        
        
        <s:form name="modificacionVeterinario" action="modificacionVeterinario" method="post">
            <table class="wwFormTable">
                <tbody>
                        
                        <tr>
                            <td class="tdLabel">
                            <s:textfield name="especialidad" label="Especialidad"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="experiencia" label="Experiencia" min="0" max="49"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="telefono" label="Telefono" min="9" max="9"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="correo" label="Correo electronico"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="password" label="Password"></s:textfield>
                            </td>
                            
                            
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                <s:submit name="boton" value="modificacion"></s:submit>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </s:form>
        <s:form id="cancelar" name="cancelar" action="cancelar" method="post">
            <s:submit name="boton" value="Cancelar"></s:submit>
        </s:form>
    </body>
</html>
