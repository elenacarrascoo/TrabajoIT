
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de nuevo veterinario </h1>
        
        
        <s:form name="altaVeterinario" action="altaVeterinario" method="post">
            <table class="wwFormTable">
                <tbody>
                    <tr>
                        <td class="tdLabel">
                            <s:textfield name="dni" label="DNI" required="true"></s:textfield>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdLabel">
                            <s:textfield name="nombre" label="Nombre" required="true"></s:textfield>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdLabel">
                            <s:textfield name="especialidad" label="Especialidad" required="true"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="experiencia" label="Experiencia" required="true"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="telefono" label="Telefono" required="true"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="correo" label="Correo electronico" required="true"></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="password" label="Password" required="true"></s:textfield>
                            </td>
                            
                            
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                <s:submit name="boton" value="registro"></s:submit>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
        </s:form>
        <s:form action="veterinarioActions" method="post">
            <s:submit name="boton" value="Cancelar"></s:submit>
        </s:form>
    </body>
</html>
