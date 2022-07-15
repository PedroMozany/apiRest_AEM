<%--
  Created by IntelliJ IDEA.
  User: Atropall
  Date: 15/07/2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>alterar voo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous" />
</head>

<body>

<form action="entrada?action=alterarVoo">

    <div class="container" style="width: 400px">
        <h5 style="margin-left: 30px">Alterando voo : numero do voo </h5>
        <br>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">preco inicial PH</span>
            </div>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">

        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Origem PH</span>
            </div>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">

        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Destino PH</span>
            </div>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">

        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Duracao PH</span>
            </div>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">

        </div>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Numero de Assentos PH</span>
            </div>
            <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">

        </div>

        <div class="row">

            <h4 style="padding: 30px" >Confirme seus dados agora</h4>
            <div class="col-md">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Email</span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm">
            </div>

            <div class="col-md">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Senha</span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input"
                       aria-describedby="inputGroup-sizing-sm">
            </div>

        </div>

        <div style="margin-left: 150px">
            <br>
            <button type="button submmit" class="btn btn-primary btn-md">alterar</button>
        </div>
    </div>



</form>

</body>

</html>