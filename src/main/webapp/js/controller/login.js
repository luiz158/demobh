$(function(){
	
	$("form").submit(function(e){
		e.preventDefault();
		
		var user = {
			username : $("#username").val(),
			password : $("#password").val()
		};
		
		LoginProxy.logar(user).done(logarOk).fail(logarFail);
		
	});
	
});

function logarOk(data, status, response){
	
	sessionStorage.setItem("user", JSON.stringify(data));
	sessionStorage.setItem("token", response.getResponseHeader("Set-Token"));
	location.href = App.getBaseURL() + "/artigo/listagem";

}

function logarFail(jqXHR){
	alert('Falha na autenticação');	
}