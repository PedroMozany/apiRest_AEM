<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>

<body>
<H1 style="text-align: center; margin-top: 30px;">Fazer cadastro</H1>

<div class="container">
    <br>
    <form class="row align-items-center" action="Entrada?acao=Cadastro" method="post">
        <div class="col">
            <label for="nome" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" value="${google.nome}" placeholder="Nome" required>
        </div>
        <br>
        <div class="col">
            <label for="cpf" class="form-label">Cpf:</label>
            <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF" maxlength="11" size="11" required>
        </div>
        <br>
        <div class="col">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${google.email}" placeholder="E-mail" required>
        </div>
        <br>
        <div class="col">
            <label for="senha" class="form-label">Senha:</label>
            <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
        </div>
        <br>
        <div style="padding-top: 20px" class="row">
            <div class="col align-self-start">
            </div>
            <div class="col-1 align-self-center">
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </div>
            <div class="col align-self-end">
            </div>
        </div>
    </form>

    <div class="row">
        <div style="margin-left: -20px" class="col-5 align-self-start">
        </div>
        <div class="col-3 align-self-center">
            <form action="Entrada?acao=MostraLogin" method="post">
                 <div style="margin-top: 30px;" class="col-12">
                        <button style="width: 250px" type="submit" class="btn btn-primary">Voltar para página de login</button>
                 </div>
            </form>
        </div>
        <div class="col align-self-end">
        </div>
    </div>

    <br>
</div>
</body>

</html>
