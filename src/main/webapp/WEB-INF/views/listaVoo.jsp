<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Voos, model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Voos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<form class="row g-6">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Numero do Voo</th>
      <th scope="col">Data</th>
      <th scope="col">Origem</th>
      <th scope="col">Destino</th>
      <th scope="col">Duração</th>
      <th scope="col">Preço</th>
      <th scope="col">Assentos</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${lista}" var="voo">
  		<tr>
	      <th scope="row">${voo.numeroVoo}</th>
	      <td>${voo.data}</td>
	      <td>${voo.origem}</td>
	      <td>${voo.destino}</td>
	      <td>${voo.duracaoVoo}</td>
	      <td>${voo.preco}</td>
	      <td>${voo.numeroAssentos}</td>
	      <td><a href="caminho para pagina de compra passando ${Usuario} e ${voo.numeroVoo}">Comprar</a></td>
    	</tr>
	</c:forEach>
  </tbody>
</table>
</form>
</body>
</html>