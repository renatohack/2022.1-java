<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tela Inicial</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div class="jumbotron text-center">
    <c:set var = "mensagemSucesso" scope = "session" value = "${msgSucesso}"/>
    <c:set var = "msgSucesso" scope = "session" value = ""/>
    <c:if test="${not empty mensagemSucesso}">
        <div class="alert alert-success">
            <strong>Sucesso: </strong> ${mensagemSucesso}
        </div>
    </c:if>
    <a href="/usuario/autenticado/telaCadastroPlantao" class="btn btn-primary">Cadastrar Venda de Plantão</a>
    <br><br>
    <a href="/usuario/autenticado/telaMeusPlantoesCadastrados" class="btn btn-primary">Meus Plantões Cadastrados</a>
    <br><br>
    <a href="/usuario/autenticado/telaComprarPlantao" class="btn btn-primary">Comprar Plantão</a>
    <br><br>
    <a href="/usuario/autenticado/telaMeusPlantoesInteresse" class="btn btn-primary">Meus Plantões de Interesse</a>
    <br><br>
    <a href="/logout" class="btn btn-danger">Sair</a>
</div>
</body>
</html>