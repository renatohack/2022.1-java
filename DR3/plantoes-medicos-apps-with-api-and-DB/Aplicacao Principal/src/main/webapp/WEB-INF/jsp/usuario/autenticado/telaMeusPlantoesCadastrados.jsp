<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Consulta de Meus Plantões</title>
</head>

<body>
<div class="container">

    <h1>Consulta de Meus Plantões</h1>

    <c:set var = "mensagemSucesso" scope = "session" value = "${msgSucesso}"/>
    <c:set var = "msgSucesso" scope = "session" value = ""/>
    <c:if test="${not empty mensagemSucesso}">
        <div class="alert alert-success">
            <strong>Sucesso: </strong> ${mensagemSucesso}
        </div>
    </c:if>

    <c:set var = "mensagemErro" scope = "session" value = "${msgErro}"/>
    <c:set var = "msgErro" scope = "session" value = ""/>
    <c:if test="${not empty mensagemErro}">
        <div class="alert alert-danger">
            <strong>Erro: </strong> ${mensagemErro}
        </div>
    </c:if>



    <form method="post" action="/usuario/autenticado/procurarMeusPlantoesCadastrados">
        <input type="text" name="keyword" id="keyword"/>
        <input type="submit" value="Procurar plantão"/>
    </form>

    <h3><a href="/usuario/autenticado/telaCadastroPlantao">Novo Plantão</a></h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Valor</th>
            <th scope="col">Local</th>
            <th scope="col">Dia</th>
            <th scope="col">Hora de Início</th>
            <th scope="col">Período</th>
            <th scope="col">Previsão de Pagamento</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaPlantoes}" var="plantao">
            <tr>
                <td>${plantao.valor}</td>
                <td>${plantao.local}</td>
                <td>${plantao.data}</td>
                <td>${plantao.horaInicio}</td>
                <td>${plantao.periodo}</td>
                <td>${plantao.previsaoPagamento}</td>
                <td>
                    <a href="/usuario/autenticado/telaAlterarMeuPlantao?idPlantao=${plantao.idPlantao}">Alterar</a>
                    <a href="/usuario/autenticado/excluirMeuPlantao?idPlantao=${plantao.idPlantao}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/usuario/autenticado/mainPage" class="btn btn-primary">Voltar</a>

</div>
</body>
</html>

