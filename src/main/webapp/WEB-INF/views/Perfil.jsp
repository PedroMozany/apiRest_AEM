<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Meu perfil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top:50px;">
    <h3>Meu perfil</h3>

    <p style="margin-top: 30px;">Nome: ${usuario.nome}</p>

    <p style="margin-top: 50px;">Lista de Voos:</p>
    <c:forEach items="${VoosUsuario}" var="voos">
        <ul class="list-group">
            <li class="list-group-item">
                <form action="Entrada?acao=CancelarVooUsuario" method="post">
                    Origem: ${voos.origem} - Destino: ${voos.destino} - Data: ${voos.data}
                    <input type="hidden" name="acao" value="CancelarVooUsuario">
                    <button type="submit" class="btn btn-primary">Cancelar Voo</button>
                </form>
            </li>
        </ul>
    </c:forEach>
</div>
<div class="container" style="margin-top: 100px; padding-left: 550px;">
    <form action="Entrada?acao=MostraVoos" method="post">
        <button type="submit" class="btn btn-primary">Listar Voos disponíveis</button>
    </form>
</div>

</body>
</html>