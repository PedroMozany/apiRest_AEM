<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 30px;">
    Login
</h1>
<div style="padding-top:100px; padding-left: 475px ">
    <form action="Entrada?acao=Login" method="post" class="row g-3">
        <div class="col-3" style="margin-left: 310px">
            <input type="email" class="form-control"  name="email" value="${validar.email}"  placeholder="Email" required >
        </div>
        <div class="col-3" style="margin-top: 60px; margin-left: -365px">
            <input type="password" class="form-control" name="senha" value="${validar.senha}" placeholder="Senha" required>
        </div>
        <div style="padding-left: 400px" class="col-12">
            <button style="width: 200px" type="submit" class="btn btn-primary">Fazer Login</button>
        </div>
        <div style="padding-left: 380px" class="col-5">
            <div id="g_id_onload"
                 data-client_id="1018281432326-e4sdi7eikd89vf17bhivcce3hskbujns.apps.googleusercontent.com"
                 data-login_uri="CompanhiaAerea/Entrada?acao=LoginGoogle"
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
    <form action="Entrada?acao=MostraCadastro" method="post" class="row g-3">
        <div style="padding-left: 400px; margin-top: 100px;" class="col-12">
            <p >Ainda nao tem conta no site?</p>
            <button style="width: 200px" type="submit" class="btn btn-primary">Fazer cadastro</button>
        </div>
    </form>
</div>

</body>
</html>