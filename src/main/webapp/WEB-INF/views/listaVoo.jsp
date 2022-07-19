<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Voos, model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Voos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 30px;">
  Red Companhia Aérea
</h1>

<h3 style="text-align: center; margin-top: 15px;">
  Voos Disponiveis
</h3>
<div  style="padding-top:15px; text-align: center;">
  <form action="Entrada?acao=MostraLogin" method="post">
    <button type="submit" class="btn btn-info">Login/Cadastro</button>
  </form>
</div>
<div  style="text-align: center;">
  <form action="Entrada?acao=MostraPerfil" method="post">
    <button type="submit" class="btn btn-info">Perfil do Usuario</button>
  </form>
</div>
<div style="padding-top:30px; padding-left: 100px; padding-right: 100px;">

  <form action="Entrada?acao=VerificaLogin" method="post" class="row g-6">
    <table class="table table-striped-columns table-hover table-sm align-middle">
      <thead>
      <tr class="table-dark">
        <th scope="col">Data</th>
        <th scope="col">Origem</th>
        <th scope="col">Destino</th>
        <th scope="col">Duração</th>
        <th scope="col">Preço</th>
        <th scope="col">Ações</th>
      </tr>
      </thead>
      <tbody >
      <c:forEach items="${lista}" var="voo">
        <tr class="table-light">
          <td>${voo.data}</td>
          <td>${voo.origem.cidade}</td>
          <td>${voo.destino.cidade}</td>
          <td>${voo.duracaoVoo}</td>
          <td>${voo.precoForm}</td>
          <form action="Entrada?acao=MostrarPaginaCompra" method="post">
            <input type="hidden" name="numVoo" value="${voo.nmrDoVoo}">
            <input type="hidden" name="cpf" value="${logado.cpf}">
            <input type="hidden" name="email" value="${logado.email}">
            <td><button type="submit" class="btn btn-success">Comprar</button></td>
          </form>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </form>
</div>
</body>
</html>