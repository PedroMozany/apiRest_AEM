<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">
    Login
</h1>
<div style="padding-top:100px; padding-left: 400px ">
    <form action="Entrada?acao=Login" method="post" class="row g-3">
        <div class="col-3">
            <input type="email" class="form-control"  name="email" placeholder="Email" >
        </div>
        <div class="col-3">
            <input type="password" class="form-control" name="senha" placeholder="Senha">
        </div>
        <div style="padding-left: 150px" class="col-12">
            <button style="width: 250px" type="submit" class="btn btn-primary">Sign in</button>
        </div>
        <div style="padding-left: 150px" class="col-12">
            <div id="g_id_onload"
                 data-client_id="1018281432326-e4sdi7eikd89vf17bhivcce3hskbujns.apps.googleusercontent.com"
                 data-login_uri="https://localhost:8080"
                 data-auto_prompt="false">
            </div>
            <div class="g_id_signin"
                 data-type="standard"
                 data-size="large"
                 data-theme="outline"
                 data-text="sign_in_with"
                 data-shape="rectangular"
                 data-logo_alignment="left">
            </div>
        </div>
    </form>
</div>

</body>
</html>
