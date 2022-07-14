<%--
  Created by IntelliJ IDEA.
  User: Atropall
  Date: 13/07/2022
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>criando voo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row align-items-center">
        <div class="col align-self-start">
        </div>
        <div class="col align-self-center">
            <div class="container" style=" text-align: center"  >
                <form style="width: 400px" action="MUDAR AQUI, COLOCAR A ACTION PARA FUNCIONAR CERTINHO" method="post">
                    <div class="row " >


                        <div class="col align-self-center" >

                            <div>
                                <label for="destino" class="form-label">Data do voo</label>
                                <input type="date" class="form-control" id="destino" aria-describedby="destinoVoo" >
                            </div>
                            <div >
                                <label for="precoVoo" class="form-label">Preço</label>
                                <input type="number"  class="form-control" id="precoVoo"  >
                            </div>

                            <div >
                                <label for="origem" class="form-label">Origem</label>
                                <select id="origem">
                                    <option value="teste A">teste A-O</option>
                                    <option value="teste B">teste B-O</option>
                                    <option value="teste C">teste C-O</option>
                                </select>
                            </div>
                            <div >
                                <label for="destinoVoo" class="form-label">Destino</label>
                                <select id="destinoVoo">
                                    <option value="teste A">teste A-D</option>
                                    <option value="teste B">teste B-D</option>
                                    <option value="teste C">teste C-D</option>
                                </select>
                            </div>
                            <div  >
                                <label for="duracaoVoo" class="form-label">Duracao</label>
                                <input type="time"  class="form-control" id="duracaoVoo"  >
                            </div>
                            <div >
                                <label for="numeroAssentos" class="form-label">Numero de Assentos</label>

                                <select id="numeroAssentos">
                                    <option value="100">100</option>
                                    <option value="180">180</option>
                                    <option value="220">220</option>
                                </select>
                            </div>

                        </div>

                    </div>


                    <button type="submit" class="btn btn-primary" >Cadastrar</button>
                </form>


            </div>

        </div>
        <div class="col align-self-end">
        </div>
    </div>
</div>

</body>
</html>

