<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Forgot Password</title>
        </head>
        <body>
            <form:form id="forgotForm"  action="forgotProcess" method="post">
                <table align="center">
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input  name="email" id="email" />
                        </td>
                    </tr>
                   
                    <tr>
                        <td></td>
                        <td align="left">
                            <input type ="submit" value ="Submit"/>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
        </body>
        </html>