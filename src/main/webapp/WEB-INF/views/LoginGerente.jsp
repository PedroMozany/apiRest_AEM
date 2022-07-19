<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Gerente</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<style>
  input::-webkit-outer-spin-button,
  input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
  }
  input[type=number] {
    -moz-appearance: textfield;
  }
</style>
<body>
<H1 style="text-align: center; margin-top: 30px;">Fazer Login</H1>
<p style="text-align: center; margin-top: 5px" > Pagina do gerente</p>
<div class="container">

  <br>
  <form class="row align-items-center" action="Entrada?acao=Login" method="post">
    <div class="col" >
      <input type="number" class="form-control" name="matricula"  placeholder="Matricula" required>
    </div>
    <br>
    <div class="col">
      <input type="password" class="form-control"  name="senha" placeholder="Senha" required>
    </div>
    <br>
    <div style="padding-top: 30px" class="row">
      <div class="col align-self-start">
      </div>
      <div class="col-1 align-self-center">
        <button type="submit" class="btn btn-primary">Login</button>
      </div>
      <div class="col align-self-end">
      </div>
    </div>
  </form>

</div>
</body>

</html>