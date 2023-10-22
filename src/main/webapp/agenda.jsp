<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> contatos = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<a href="novo.html" class="botao1">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>E-mail</td>
			</tr>
		</thead>
		<tbody>
			<%for (JavaBeans contato : contatos) {%>
			<tr>
				<td><%= contato.getIdcon() %></td>
				<td><%= contato.getNome() %></td>
				<td><%= contato.getFone() %></td>
				<td><%= contato.getEmail() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>