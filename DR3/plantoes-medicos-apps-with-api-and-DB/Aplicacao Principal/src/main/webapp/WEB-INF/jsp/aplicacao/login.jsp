<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="col-md-6 cadastro">
        <h1>Login do Usuário</h1>
        <br>
        <div class="form-group">
            <form action="/validate_login" method="post">
                <c:if test="${not empty mensagemErro}">
                    <div class="alert alert-danger">
                        <strong>Erro: </strong> ${mensagemErro}
                    </div>
                </c:if>
                <div class="form-group">
                    Email
                    <input type="text" name="email" id="email" class="form-control" required="">
                </div>
                <div class="form-group">
                    Senha
                    <input type="password" name="senha" id="senha" class="form-control" required="">
                </div>
                <div class="form-group">
                    <input type="submit" id="submit" class="btn-primary" value="Logar">
                </div>
            </form>
            <a href="/" class="btn btn-primary">Voltar</a>
        </div>
    </div>
</div>
</body>
</html>
