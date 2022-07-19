<%--
  Created by IntelliJ IDEA.
  User: mfort
  Date: 19/07/2022
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Destino</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 30px;">
  Red Companhia Aérea
</h1>

<h3 style="text-align: center; margin-top: 15px;">
  Seu Destino: ${cidade}
</h3>

<h3 style="text-align: center; margin-top: 15px;">
  Temperatura do destino hoje: ${temp}
</h3>

<div  style="padding-top:15px; text-align: center;">
  <form action="Entrada?acao=MostraVoos" method="post">
    <button type="submit" class="btn btn-info">Voltar para voos disponiveis</button>
  </form>
  <button class="btn btn-danger"><a style="text-decoration: none; color: black" href="Entrada?acao=Logout">Logout</a></button>
</div>
</body>
</html>
