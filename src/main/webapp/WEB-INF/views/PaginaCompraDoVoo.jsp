<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Comprar Passagem</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<H1 style="text-align: center">Finalizar compra</H1>
<p style="text-align: center">Informações sobre sua viagem</p>
<div style="text-align: inherit; padding-left: 400px">
    <p><b>Nome:</b> ${logado.nome} | <b>CPF:</b> ${logado.cpf}</p>
    <p><b>Origem do Voo:</b> ${compra.origem.cidade}</p>
    <p><b>Destino do Voo:</b> ${compra.destino.cidade}</p>
    <p><b>Duração da viagem:</b> ${compra.duracaoVoo}h | <b>Data:</b> ${compra.data} </p>
    <p><b>Preço:</b> R$ ${compra.precoForm}</p>
</div>
<br>
<br>
<div class="container">
  <div class="row justify-content-evenly">
    <div class="col-2">
      <form action="Entrada?acao=MostraVoos" method="post">
        <button type="submit" class="btn btn-primary">Voltar</button>
      </form>
    </div>
    <div class="col-2">
      <form action="Entrada?acao=AcoesUsuario" method="post">
          <input type="hidden" name="numVoo" value="${compra.nmrDoVoo}">
          <input type="hidden" name="cpf" value="${logado.cpf}">
          <input type="hidden" name="finalizar" value="finalizar">
        <button type="submit" class="btn btn-primary">Confirmar compra</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>