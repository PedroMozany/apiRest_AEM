<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Comprar Passagem</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>

<body>
<H1 style="text-align: center; margin-top: 30px;">Finalizar compra</H1>
<p style="text-align: center; font-weight: 600; font-size: larger; margin-top: 50px;">Informações sobre sua viagem:</p>
<div>
  <c:forEach items="${listaVoo}" var="voo">
    <p style="text-align: center; font-weight: 400; font-size: large;">Data: ${voo.data}</p>
    <p style="text-align: center; font-weight: 400; font-size: large;">Origem do Voo: ${voo.origem}</p>
    <p style="text-align: center; font-weight: 400; font-size: large;">Destino do Voo: ${voo.destino}</p>
    <p style="text-align: center; font-weight: 400; font-size: large;">Duração da viagem: ${voo.duracao}</p>
    <p style="text-align: center; font-weight: 400; font-size: large;">Preço: ${voo.preco}</p>
  </c:forEach>
</div>
<br>
<br>
<div class="container">
  <div class="row justify-content-evenly">
    <div class="col-2">
      <form action="MUDAR A AÇÃO AQUI, NAO PODE ESQUECER NAO PESSOAL, SE NAO NAO FUNCIONA O PROGRAMA EM" method="post">
        <button type="submit" class="btn btn-primary">Voltar</button>
      </form>
    </div>
    <div class="col-2">
      <form action="MUDAR A AÇÃO AQUI, NAO PODE ESQUECER NAO PESSOAL, SE NAO NAO FUNCIONA O PROGRAMA EM" method="post">
        <button type="submit" class="btn btn-primary">Confirmar compra</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>