$(function(){
	
	$("#salvar").click(function(event){
		
		var artigo = {
			slug : $("#slug").val(),
			titulo : $("#titulo").val(),
			conteudo : $("#conteudo").val(),
		}
		
		ArtigoProxy.criar(artigo).done(criarOk).fail(criarFail);
		
	});
	
});

function criarOk(data, textStatus, jqXHR){
	if (jqXHR.status === 201){
		alert('Artigo criado com id = ' + data);
	}
}

function criarFail(jqXHR, textStatus){
	console.log(textStatus);
}