<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Alterar Venda de Plantão</title>
</head>
<body>
<div class="container">
    <div class="col-md-6 cadastro">
        <h1>Alterar Venda de Plantão</h1>
        <br>
        <div class="form-group">
            <form action="/usuario/autenticado/salvarAlteracaoPlantao?idPlantao=${plantao.idPlantao}" method="post">
                <div class="form-group">
                    Valor a ser pago
                    <input type="number" min="0" name="valor" id="valor" class="form-control" value="${plantao.valor}" required="">
                </div>
                <div class="form-group">
                    Local
                    <input type="text" name="local" id="local" class="form-control" value="${plantao.local}" required="">
                </div>
                <div class="form-group">
                    Data
                    <input type="date" name="data" id="data" class="form-control" value="${plantao.data}" required="">
                </div>
                <div class="form-group">
                    Hora de início
                    <input type="time" name="horaInicio" id="horaInicio" class="form-control" value="${plantao.horaInicio}" required="">
                </div>
                <div class="form-group">
                    Periodo (Quantidade de horas do plantão)
                    <input type="text" name="periodo" id="periodo" class="form-control" value="${plantao.periodo}" required="">
                </div>
                <div class="form-group">
                    Previsão de Pagamento
                    <input type="text" name="previsaoPagamento" id="previsaoPagamento" class="form-control" value="${plantao.previsaoPagamento}" required="">
                </div>
                <div class="form-group">
                    <input type="submit" id="submit" class="btn-primary" value="Salvar Alterações">
                </div>
            </form>
            <a href="/usuario/autenticado/telaMeusPlantoesCadastrados" class="btn btn-primary">Voltar</a>
        </div>
    </div>
</div>
</body>
</html>
