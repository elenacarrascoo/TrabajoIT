
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de nuevo tratamiento </h1>
        
        
        <s:form name="Tratamiento" action="Tratamiento" method="post">
            <table class="wwFormTable">
                <tbody>
                    <tr>
                        <td class="tdLabel">
                            <s:textfield name="fecha" label="Fecha" type="date"></s:textfield>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdLabel">
                            <s:textfield name="hora" label="Hora" type="time" min="09:00" max="20:00" ></s:textfield>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdLabel">
                            <s:textfield name="precio" label="Precio" ></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                                <s:select 
                            name="tipo" 
                            label="Tipo" 
                            list="{'Quirúrgico','Desparasitación','Exámenes Clínicos', 'Fisioterapia','Vacunación', 'Diagnóstico', 'Terapias Rehabilitativas', 'Esterilización y Castración','Diagnóstico por Imagen','Tratamiento de Enfermedades Crónicas' }" 
                            headerKey="-1" 
                            headerValue="Selecciona un tipo"/>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="tipo" label="Tipo" ></s:textfield>
                            </td>
                            
                            <td class="tdLabel">
                            <s:textfield name="idCita" label="ID Cita" value="idCita" ></s:textfield>
                            </td>
                            
                                                        
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                <s:submit name="boton" value="Registrar Tratamiento"></s:submit>
                                </div>
                            </td>
                        </tr>
                        
                        <s:form action="Tratamiento" method="post">
                        <s:submit name="boton" value="Volver"/>
                        <s:submit name="boton" value="LogOut"/>
                        
                        </s:form>
                    </tbody>
                </table>
        </s:form>
    </body>
</html>
