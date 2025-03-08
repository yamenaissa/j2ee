<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultat de la conversion</title>
</head>
<body>
    <h2>Résultat de la conversion</h2>
    
    <%
    Double celsius = (Double)request.getAttribute("celsius");
    Double fahrenheit = (Double)request.getAttribute("fahrenheit");
    %>
    
    <p>Vous avez demandé la conversion en fahrenheit de la valeur en Celsius <%= celsius %></p>
    
    <p>Et le résultat est: <%= fahrenheit %> degrés Fahrenheit !</p>
    
</body>
</html>