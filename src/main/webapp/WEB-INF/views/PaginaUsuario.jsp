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
    <button type="submit" class="btn btn-info">Voltar para voos disponiveis</button>
  </form>
  <button class="btn btn-danger"><a style="text-decoration: none; color: black" href="Entrada?acao=Logout">Logout</a></button>
</div>
<div style="padding-top:30px; padding-left: 100px; padding-right: 100px;">


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
        <td>
          <form action="Entrada?acao=CalcularClima" method="post" style="margin-top:5%;">
            <input type="hidden" name="cidade" value="${voo.destino.cidade}">
            <button type="submit" class="btn btn-link">${voo.destino.cidade}</button>
          </form>
        </td>
        <td>${voo.duracaoVoo}</td>
        <td>${voo.precoForm}</td>
        <td>${voo.numeroAssentos}</td>


        <td>
          <form action="Entrada?acao=AcoesUsuario" method="post" class="row g-6">
            <input type="hidden" name="cpf" value="${usuario.cpf}">
            <input type="hidden" name="numVoo" value="${voo.nmrDoVoo}">
            <input type="hidden" name="cancelar" value="cancelar">
            <button type="submit" class="btn btn-danger">Cancelar</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</div>
</body>
</html>