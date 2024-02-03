<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Consulta de Plantões</title>
</head>

<body>
<div class="container">

    <h1>Consulta de Plantões</h1>

    <form method="post" action="/cadastrarUsuario">
        <input type="text" name="email" id="email"/>
        <input type="text" name="senha" id="senha"/>
        <input type="submit" value="Cadastrar Usuário"/>
    </form>

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
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

