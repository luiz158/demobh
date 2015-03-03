$(function(){
	
	if (id = getUrlParameterByName('id')) {
		ArtigoProxy.carregar(id).done(carregarOk).fail(carregarFail);
	}
	
	$("#salvar").click(function(event){
		
		var artigo = {
			slug : $("#slug").val(),
			titulo : $("#titulo").val(),
			conteudo : $("#conteudo").val(),
		}
		
		ArtigoProxy.criar(artigo).done(criarOk).fail(criarFail);
		
	});
	
});

function getUrlParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function criarOk(data, textStatus, jqXHR){
	if (jqXHR.status === 201){
		alert('Artigo criado com id = ' + data);
	}
}

function criarFail(jqXHR, textStatus){
	console.log(textStatus);
}

function carregarOk(data){
	$("#id").val(data.id);
	$("#slug").val(data.slug);
	$("#titulo").val(data.titulo);
	$("#conteudo").val(data.conteudo);
}

function carregarFail(jqXHR){
	console.log(jqXHR);
}

