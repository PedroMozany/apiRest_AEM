<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Altera voo</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous" />
</head>
<style>
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
<body>

	<form action="Entrada?acao=AcoesGerente" method="post">

		<div class="container" style="width: 400px">
			<h5 style="margin-left: 100px; margin-top: 30px">Alterando voo :
				${voos.nmrDoVoo}</h5>
			<input type="hidden" name="alterar" value="${voos.nmrDoVoo}">
			<br>

			<div class="input-group mb-3">
				<div>
					<span class="input-group-text">Preço inicial PH</span>
				</div>
				<input type="number" class="form-control" aria-label="Username"
					name="preco" value="${voos.precoForm}" step="0.01">
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Origem PH</span>
				</div>
				<%-- 			<input type="hidden" name="origem" value="${voos.origem.codigo}"> --%>
				
				<select name="origem">
					<option value="${voos.origem.codigo}" selected>${voos.origem.codigo}</option>
					<c:forEach items="${aeroportos}" var="aeroporto">
						<option value="${aeroporto.codigo}">${aeroporto.codigo}</option>
					</c:forEach>
				</select>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Destino PH</span>
				</div>
				<%-- 			<input type="hidden" name="destino" value="${voos.destino.codigo}"> --%>
				<select name="destino">
					<option value="${voos.destino.codigo}" selected>${voos.destino.codigo}</option>
					<c:forEach items="${aeroportos}" var="aeroporto">
						<option value="${aeroporto.codigo}">${aeroporto.codigo}</option>
					</c:forEach>
				</select>
			</div>

<!-- 			<div class="input-group mb-3"> -->
<!-- 				<div> -->
<!-- 					<span class="input-group-text">Duracao PH</span> -->
<!-- 				</div> -->
<!-- 				<input type="text" class="form-control" aria-label="Username" -->
<%-- 					name="duracaoVoo" value="${voos.duracaoVoo}"> --%>

<!-- 			</div> -->
			<div class="input-group mb-3">
				<div>
					<span class="input-group-text">Data</span>
				</div>
				<input type="text" class="form-control" aria-label="Username"
					name="data" value="${voos.data}">

			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Numero de
						Assentos PH</span>
				</div>
				<input type="text" class="form-control" aria-label="Username"
					name="assento" value="${voos.numeroAssentos}">

			</div>

			<!--         <div class="row"> -->

			<!--             <h4 style="padding: 30px" >Confirme seus dados agora</h4> -->
			<!--             <div class="col-md"> -->
			<!--                 <input type="number" class="form-control" aria-label="Sizing example input" -->
			<!--                        aria-describedby="inputGroup-sizing-sm" placeholder="Matricula"> -->
			<!--             </div> -->

			<!--             <div class="col-md"> -->
			<!--                 <input type="text" class="form-control" aria-label="Sizing example input" -->
			<!--                        aria-describedby="inputGroup-sizing-sm" placeholder="Senha"> -->
			<!--             </div> -->

			<!--         </div> -->

			<div style="margin-left: 150px">
				<br>
				<button type="submit" class="btn btn-primary btn-md">Alterar</button>
			</div>
		</div>



	</form>

</body>

</html>