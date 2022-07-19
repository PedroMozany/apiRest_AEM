<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Voos, model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Seus Voos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 30px;">
  Red Companhia Aérea
</h1>

<h3 style="text-align: center; margin-top: 15px;">
  Seus Voos Comprados
</h3>
<div  style="padding-top:15px; text-align: center;">
  <form action="Entrada?acao=MostraVoos" method="post">
    <button type="submit" class="btn btn-info">Comprar voos disponiveis</button>
  </form>
  <button class="btn btn-info"><a style="text-decoration: none; color: black" href="Entrada?acao=Logout">SAIR</a></button>
</div>
<div style="padding-top:30px; padding-left: 100px; padding-right: 100px;">

  <form action="Entrada?acao=AcoesUsuario" method="post" class="row g-6">
    <table class="table table-striped-columns table-hover table-sm align-middle">
      <thead>
      <tr class="table-dark">
        <th scope="col">Numero do Voo</th>
        <th scope="col">Data</th>
        <th scope="col">Origem</th>
        <th scope="col">Destino</th>
        <th scope="col">Duração</th>
        <th scope="col">Preço</th>
        <th scope="col">N. De Assentos</th>
        <th scope="col">Ações</th>
      </tr>
      </thead>
      <tbody >
      <c:forEach items="${VoosUsuario}" var="voo">
        <tr class="table-light">
          <th scope="row">${voo.nmrDoVoo}</th>
          <td>${voo.data}</td>
          <td>${voo.origem.cidade}</td>
          <td>${voo.destino.cidade}</td>
          <td>${voo.duracaoVoo}</td>
          <td>${voo.precoForm}</td>
          <td>${voo.numeroAssentos}</td>


            <input type="hidden" name="cpf" value="${usuario.cpf}">
            <input type="hidden" name="numVoo" value="${voo.nmrDoVoo}">
            <input type="hidden" name="cancelar" value="cancelar">
            <td><button type="submit" class="btn btn-danger">Cancelar</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </form>
</div>
</body>
</html>