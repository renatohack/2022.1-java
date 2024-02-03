<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Cadastrar Venda de Plantão</title>
</head>
<body>
<div class="container">
    <div class="col-md-6 cadastro">
        <h1>Cadastrar Venda de Plantão</h1>
        <br>
        <div class="form-group">
            <form action="/usuario/autenticado/cadastrarPlantao" method="post">
                <div class="form-group">
                    Valor a ser pago
                    <input type="number" min="0" name="valor" id="valor" class="form-control" required="">
                </div>
                <div class="form-group">
                    Local
                    <input type="text" name="local" id="local" class="form-control" required="">
                </div>
                <div class="form-group">
                    Data
                    <input type="date" name="data" id="data" class="form-control" required="">
                </div>
                <div class="form-group">
                    Hora de início
                    <input type="time" name="horaInicio" id="horaInicio" class="form-control" required="">
                </div>
                <div class="form-group">
                    Periodo (Quantidade de horas do plantão)
                    <input type="text" name="periodo" id="periodo" class="form-control" required="">
                </div>
                <div class="form-group">
                    Previsão de Pagamento
                    <input type="text" name="previsaoPagamento" id="previsaoPagamento" class="form-control" required="">
                </div>
                <div class="form-group">
                    <input type="submit" id="submit" class="btn-primary" value="Cadastrar Plantão">
                </div>
            </form>
            <a href="/usuario/autenticado/mainPage" class="btn btn-primary">Voltar</a>
        </div>
    </div>
</div>
</body>
</html>
