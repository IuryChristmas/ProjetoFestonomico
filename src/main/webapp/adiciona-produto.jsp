<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Adicionar Produto</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
	</head>
	<body>
	<div class="container">
		<jsp:include page="./template/barra_superior.jspf"></jsp:include>
		
		<section class="container col-md-9 col col-sm-8 col-xs-8">
			<div class= "row" style="padding-top: 10%">
				<div class="col-md-12 col">
					<div id="cabecalhoForm" class="form-group">
						<div class="page-header">
							<h3><span class="label label-default">Adicionar Produtos</span></h3>
						</div>
					</div>
					<div class="form-horizontal col-md-8 col">
						<form  action="festonomica" method="post">
							<div class="form-group">
								<label for="campoNome" class="col-sm-2 control-label">Nome</label>
								<div class="col-sm-10">
									<input id="campoNome" placeholder="Quantidade" class="form-control" type="text" name="nome"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="campoQuantidade" class="col-sm-2 control-label">Quantidade</label>
								<div class="col-sm-10">
									<input id="campoQuantidade" placeholder="Quantidade" class="form-control" type="text" name="quantidade"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="campoValor" class="col-sm-2 control-label">Valor</label>
								<div class="col-sm-10">
									<input id="campoValor" placeholder="Valor do Produto" class="form-control" type="text" name="valor"/>
								</div>
							</div>
							
							<div id="divButton" class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">Adicionar Produto</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- JS & JQUERY -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>