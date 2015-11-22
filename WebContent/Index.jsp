<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Projeto Festonômico</title>
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
    </head>
    
    <body>
    	<div class="container">
			<jsp:include page="./template/barra_superior.jspf"></jsp:include>
			
			<div class="container col-md-12 col col-sm-12 col-xs-12">
				<div class= "row" style="padding-top: 10%">
					<div class="col-md-12 col">
						<div class="form-horizontal col-md-8 col">
					    	<form action="#" method="post" >
					    	
					    		<div id="cabecalhoForm" class="form-group">
									<div class="page-header">
										<h3><span class="label label-default">Cadastre-se e tenha dicas para ir bem na sua festa!</span></h3>
									</div>	
								</div>
					    	
					    		<div class="form-group">
								<label for="campoLogin" class="col-sm-2 control-label">Usuário</label>
									<div class="col-sm-10">
										<input id="campoLogin" placeholder="Usuario" class="form-control" type="text" name=usuario/>
									</div>
								</div>
								
								<div class="form-group">
								<label for="campoSenha" class="col-sm-2 control-label">Senha</label>
									<div class="col-sm-10">
										<input id="campoSenha" placeholder="Senha" class="form-control" type="text" name=senha/>
									</div>
								</div>
					    		
					    		<div id="divButton" class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button class="btn-danger active" type="submit" >Login</button>
										<button class="btn-default" type="submit" >Cadastrar</button>
										<button class="btn-default" type="submit" >Esqueceu a senha?</button>
									</div>
								</div>
								
					    		
					    	</form>
					    </div>
					</div>
				</div>
			</div>
		</div>
        <!-- JS & JQUERY -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>