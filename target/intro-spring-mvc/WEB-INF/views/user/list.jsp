<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Usuarios</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
</head>
<body>
<div class="container">
    <h1>Lista de Usuários</h1>
    <hr>
    <div>

      <spring:url value="/usuario/cadastro" var="cadastro"/>
        <a class="btn btn-default" href="${cadastro }">Novo Usuário</a>
    </div>
    <hr>

    <div class="panel-default">

        <div class="panel-heading">
            <span>${mensagem == null ? '&nbsp;' : mensagem}</span>
        </div>

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                 <th>Dt. Nascimento</th>
                <th>AÇÃO</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${usuarios }">
                <tr>
                    <td>${usuario.id }</td>
                    <td>${usuario.nome }&nbsp;${usuario.sobrenome }</td>
                     <td>${usuario.dtNascimento }</td>
                    <td>
                    <td>
                    	<spring:url value="/usuario/update/${usuario.id }" var="update"/>                        
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/usuario/remove/${usuario.id }" var="remove" />
                        <a class="btn btn-danger" href="${remove }" >Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
</div>
</body>
</html>