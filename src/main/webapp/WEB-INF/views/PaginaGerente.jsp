<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Voos, model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Area Restrita</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 15px;">
  Red Area Restrita
</h1>
<h4 style="text-align: center; margin-top: 15px;">
  Voos disponiveis
</h4>
<div  style="padding-top:15px; text-align: center;">
  <form action="Entrada?acao=MostraVoos" method="post">
  <button type="button" class="btn btn-success">Adicionar Voo</button>
  </form>
</div>
<div style="padding-top:30px; padding-left: 100px; padding-right: 100px;">
    
    <form method="post" class="row g-6">
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
        <c:forEach items="${lista}" var="voo">
          <tr class="table-light">
            <th scope="row">${voo.numeroVoo}</th>
            <td>${voo.data}</td>
            <td>${voo.origem}</td>
            <td>${voo.destino}</td>
            <td>${voo.duracaoVoo}</td>
            <td>${voo.preco}</td>
            <td>${voo.numeroAssentos}</td>
            <td>
              <button type="button" class="btn btn-danger" action="Entrada?acao=CancelarVOOgerente">Cancelar</button>
              <button type="button" class="btn btn-warning" action="Entrada?acao=AlterarVoo">Alterar</button>
            </td>
          </tr>
      </c:forEach>
      </tbody>
    </table>
    </form>
  </div>
</body>
</html>