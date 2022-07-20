<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center;padding-top: 2%">
    Login
</h1>
<div style="padding-left: 40%; padding-right:40% ;align-content: center" class="row g-3">
    <form style="align-content: baseline" action="Entrada?acao=Login" method="post" class="row g-3">
        <div  class="col-12">
            <input type="email" class="form-control"  name="email" value="${validar.email}"  placeholder="Email" required >
        </div>
        <div class="col-12">
            <input type="password" class="form-control" name="senha" value="${validar.senha}" placeholder="Senha" required>
        </div>
        <div style="padding-left: 15%" class="col-12">
            <button style="width: 200px" type="submit" class="btn btn-primary">Fazer Login</button>
        </div>
        <div class="col-5">
            <div id="g_id_onload"
                 data-client_id="id cliente aqui"
                 data-login_uri="CompanhiaAerea_war_exploded/Entrada?acao=LoginGoogle"
                 data-auto_prompt="false">
            </div>
            <div class="g_id_signin"
                 data-type="standard"
                 data-size="large"
                 data-theme="filled_blue"
                 data-text="$ {button.text}"
                 data-shape="rectangular"
                 data-logo_alignment="left"
                 data-width="150px">
            </div>
        </div>
    </form>
    <form style="padding-top: 30%" action="Entrada?acao=MostraCadastro" method="post">
        <div style="padding-left: 15%" class="col-12">
            <p>Ainda não tem conta no site?</p>
            <button style="width: 200px" type="submit" class="btn btn-primary">Fazer cadastro</button>
        </div>
    </form>
</div>

</body>
</html>