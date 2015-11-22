<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Cadastrar Usuário</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
    </head>
    <body>
        <div class="container">
'		<jsp:include page="./template/barra_superior.jspf"></jsp:include>
		
		<section class="container col-md-9 col col-sm-8 col-xs-8">
			<div class= "row" style="padding-top: 10%">
				<div class="col-md-12 col">
					
					<div class="row">
						<div class="col-md-12 col">
							<header>
								<h2>Cadastrar Usuário</h2>
								<span>Nessa sessão, preencha seuss dados pessoais.</span>
							</header>
						</div>
					</div>	
					<div class="form-horizontal col-md-8 col">
						<form  action="#" method="post">
							<div class="form-group">
								<label for="campoNome" class="control-label">Nome:</label> 
								<input id="campoNome" class="form-control" type="text" name="nome"/>
							</div>
							<div class="form-group">
								<label for="campoEmail" class="control-label">Email:</label> 
								<input id="campoEmail" class="form-control" type="email" name="email"/>
							</div>
							<div class="form-group">
								<label for="campoSenha" class="control-label">Senha:</label> 
								<input id="campoSenha" class="form-control" type="text" name="senha" maxlength="6"/>
							</div>
							<div class="form-group">
								<label for="campoConfSenha" class="control-label">Confirmar Senha:</label> 
								<input id="campoConfSenha" class="form-control" type="text"  name="confirmaSenha" maxlength="6"/>
							</div>
							
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
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

</HTML>