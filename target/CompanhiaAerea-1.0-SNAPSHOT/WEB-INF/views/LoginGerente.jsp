<%--
  Created by IntelliJ IDEA.
  User: mfort
  Date: 13/07/2022
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Gerente</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>

<body>
<H1 style="text-align: center; margin-top: 30px;">Fazer Login</H1>
<p style="text-align: center; margin-top: 5px" > Pagina do gerente</p>
<div class="container">
  <br>
  <form class="row align-items-center" action="MUDAR AQUI A AÇÃO CUIDADO NA HORA QUE TIVER FZND EM A IMPLEMENTACAO EM" method="post">
    <div class="col">
      <label for="validationServer01" class="form-label">Matricula:</label>
      <input type="text" class="form-control" id="validationServer01" name="nome" required>
    </div>
    <br>
    <div class="col">
      <label for="validationServer07" class="form-label">Senha:</label>
      <input type="password" class="form-control" id="validationServer07" name="senha" required>
    </div>
    <br>
  </form>
  <br>
  <div class="row">
    <div class="col align-self-start">
    </div>
    <div class="col-1 align-self-center">
      <button type="submit" class="btn btn-primary">Cadastrar</button>
    </div>
    <div class="col align-self-end">
    </div>
  </div>
</div>
</body>

</html>