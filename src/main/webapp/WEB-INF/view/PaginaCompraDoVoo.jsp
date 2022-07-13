<%--
  Created by IntelliJ IDEA.
  User: mfort
  Date: 13/07/2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Comprar Passagem</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>

<body>
<H1 style="text-align: center; margin-top: 30px;">Finalizar compra</H1>
<div>
  <p style="text-align: center; font-weight: 600; font-size: larger; margin-top: 50px;">Informações sobre sua viagem:</p>
  <p style="text-align: center; font-weight: 400; font-size: large;">Data: ${variavel da data do voo}</p>
  <p style="text-align: center; font-weight: 400; font-size: large;">Origem do Voo: ${variavel da origem do voo}</p>
  <p style="text-align: center; font-weight: 400; font-size: large;">Destino do Voo: ${variavel do destino do voo}</p>
  <p style="text-align: center; font-weight: 400; font-size: large;">Duração da viagem: ${variavel da duração}</p>
  <p style="text-align: center; font-weight: 400; font-size: large;">Preço: ${variavel do preco}</p>
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