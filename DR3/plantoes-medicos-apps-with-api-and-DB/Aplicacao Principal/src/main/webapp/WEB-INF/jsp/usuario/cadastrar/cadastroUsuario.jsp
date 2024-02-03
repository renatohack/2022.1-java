<%--
  Created by IntelliJ IDEA.
  User: Renat
  Date: 31/05/2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<div class="container">
    <div class="col-md-6 cadastro">
        <h1>Cadastro de Usuário</h1>
        <br>
        <div class="form-group">
            <form action="/usuario/cadastrar/cadastrar_usuario" method="post">
                <div class="form-group">
                    Nome
                    <input type="text" name="nome" id="nome" class="form-control" required="">
                </div>
                <div class="form-group">
                    CRM
                    <input type="text" name="crm" id="crm" class="form-control" required="">
                </div>
                <div class="form-group">
                    Email
                    <input type="text" name="email" id="email" class="form-control" required="">
                </div>
                <div class="form-group">
                    Senha
                    <input type="text" name="senha" id="senha" class="form-control" required="">
                </div>
                <div class="form-group">
                    <input type="submit" id="submit" class="btn-primary" value="Cadastrar">
                </div>
            </form>
            <%--            <form action="/cadastrar_usuario" method="post">
                            <h1>Cadastro de Usuário</h1>
                            <br>
                            <div class="form-group">
                                Nome
                                <input type="text" name="nome" id="nome" class="form-control" required="">
                            </div>
                            <div class="form-group">
                                Email
                                <input type="email" name="email" id="email" class="form-control" required="">
                            </div>
                            <div class="form-group">
                                Senha
                                <input type="password" name="senha" id="senha" class="form-control" required="">
                            </div>
                            <div class="form-group">
                                <input type="submit" id="submit" class="btn-primary" value="Cadastrar">
                            </div>
                        </form>--%>
        </div>
    </div>
</div>
</body>
</html>
