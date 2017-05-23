<%--
  Created by IntelliJ IDEA.
  User: mucha
  Date: 23.05.17
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>register.jsp</title>
</head>
<body>



<form id="reg" action="/lab-rest/rest/dean/register" method="POST" enctype="multipart/form-data">
    <h2>Student</h2>
    <table>
        <tr>
            <td style="text-align: right;"><label for="index">Index:</label></td>
            <td><input type="text" id=index name="index"/></td>
        </tr>
        <tr>
            <td style="text-align: right;"><label for="firstname">Imie:</label></td>
            <td><input type="text" id=firstname name="firstname"/></td>
        </tr>
        <tr>
            <td style="text-align: right;"><label for="surname">Nazwisko :</label></td>
            <td><input id="surname" name="surname"/></td>
        </tr>
        <tr>
            <td style="text-align: right;"><label for="picture">Plik :</label></td>
            <td> <input type="file" id=picture name="picture" size="50" /> </td>
        </tr>
    </table>
    <p>
        <input id="register" type="submit" value="Register" />
    </p>
    <p>
        <label style="color: green;width: 100%;text-align: left;">${infoMessage}</label>
    </p>
    <p>
        <label style="color: red; width: 100%;text-align: left;">${errorMessage}</label>
    </p>
</form>




</body>
</html>

