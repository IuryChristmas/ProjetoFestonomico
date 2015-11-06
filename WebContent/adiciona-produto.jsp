<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adição de Produto</title>
</head>
<body>
	<h1>Adiciona Produtos</h1>
	<form action="adicionaProduto" method="post">
		Nome: <input type="text" name="nome"/><br/>
		Valor do Produto: <input type="text" name="valor"/><br/>
		Quantidade: <input type="text" name="quantidade" maxlength="5"/><br/>
		
		<!--  <input type="hidden" name="logica" value="AdicionaProdutoLogica"/>-->
		<input type="submit" value="Adicionar Produto"/>
	</form>
</body>
</html>
