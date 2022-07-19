<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Voos, model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Area Restrita</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
    crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin-top: 15px;">
    Red Area Restrita
</h1>
<h4 style="text-align: center; margin-top: 15px;">
    Voos disponiveis
</h4>
<div  style="padding-top:15px; text-align: center;">
    <form action="Entrada?acao=MostraFormVoo" method="post">
        <button type="submit" class="btn btn-success">Adicionar Voo</button>
    </form>
    <button class="btn btn-danger"><a style="text-decoration: none; color: white" href="Entrada?acao=Logout">LOGOUT</a></button>
</div>
<div style="padding-top:30px; padding-left: 100px; padding-right: 100px;">

        <table class="table table-striped-columns table-hover table-sm align-middle table-responsive">
            <thead>
            <tr class="table-dark">
                <th scope="col">Numero do Voo</th>
                <th scope="col">Data</th>
                <th scope="col">Origem</th>
                <th scope="col">Destino</th>
                <th scope="col">Duração</th>
                <th scope="col">Preço</th>
                <th scope="col">N. De Assentos</th>
                <th scope="col">Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lista}" var="voo">
                <tr class="table-light">
                    <th scope="row">${voo.nmrDoVoo}</th>
                    <td>${voo.data}</td>
                    <td>${voo.origem.cidade}</td>
                    <td>${voo.destino.cidade}</td>
                    <td>${voo.duracaoVoo}</td>
                    <td>${voo.precoForm}</td>
                    <td>${voo.numeroAssentos}</td>
                    <td>
                    	<form action="Entrada?acao=MostraAlterarVoo" method="post"> 
                            <input type="hidden" name="numVoo" value="${voo.nmrDoVoo}">
                            <button style="width: 100px" type="submit" class="btn btn-warning">ALTERAR</button>
                    	</form> 
                        <form action="Entrada?acao=AcoesGerente" method="post">
                            <input type="hidden" name="cancelar" value="${voo.nmrDoVoo}">
                            <button style="width: 100px" type="submit" class="btn btn-danger">CANCELAR</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</body>
</html>

