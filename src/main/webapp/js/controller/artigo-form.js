$(function(){
	
	if (id = getUrlParameterByName('id')) {
		ArtigoProxy.carregar(id).done(carregarOk).fail(carregarFail);
	}
	
	$("#salvar").click(function(event){
		$('span[id $= "-message"]').empty();
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
		$("#global-message").text("Artigo criado com sucesso.").show();
	}
}

function criarFail(jqXHR, textStatus){
	$.each(jqXHR.responseJSON, function(i, value){
		$("#" + value.property + "-message").text(value.message);
		$("#" + value.property).focus();
	});
}

function carregarOk(data){
	$("#id").val(data.id);
	$("#slug").val(data.slug);
	$("#titulo").val(data.titulo);
	$("#conteudo").val(data.conteudo);
}

function carregarFail(jqXHR){
	console.log(jqXHR.responseJSON);
}

