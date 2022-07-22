<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>criando voo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
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
<div class="container">
    <h1 style="text-align: center">REGISTRO DE VOOS</h1>
    <div class="row align-items-center">
        <div class="col align-self-start">
        </div>
        <div style="padding-top: 80px" class="col align-self-center">
            <div  class="container" style=" text-align: center">
                <form style="width: 400px" action="Entrada?acao=AcoesGerente" method="post">
                    <div class="row ">
                        <div class="col align-self-center">
                            <div>
                                <label class="form-label">Data do voo</label>
                                <input type="text" class="form-control" name="data" required>
                            </div>
                            <div>
                                <label class="form-label">Preço</label>
                                <input type="number" class="form-control" name="preco" step=".01" required>
                            </div>
                            <div>
                                <label class="form-label">Origem</label>
                                <select name="origem">
                                    <c:forEach items="${aeroportos}" var="aeroporto">
                                        <option  value="${aeroporto.codigo}">${aeroporto.cidade}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <label class="form-label">Destino</label>
                                <select name="destino">
                                    <c:forEach items="${aeroportos}" var="aeroporto">
                                        <option  value="${aeroporto.codigo}">${aeroporto.cidade}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <label  class="form-label">Numero de Assentos</label><br>
                                <select name="assento">
                                    <option  value="300">300</option>
                                    <option  value="489">489</option>
                                    <option  value="747">747</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" value="criar" name="criar">
                    <div style="padding-top: 20px">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col align-self-end">
        </div>
    </div>
</div>

</body>
</html>

