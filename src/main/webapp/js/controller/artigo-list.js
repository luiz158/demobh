$(function() {
	ArtigoProxy.listar().done(listarOk).fail(listarFail);
	
	StatusProxy.listar().done(montarCombo);

	$("#recarregar").click(function() {
		ArtigoProxy.listar().done(listarOk).fail(listarFail);
	});

	$("#link2artigo").click(function(event) {
		event.preventDefault();
		location.href = App.getBaseURL() + "/artigo/new";
	});
	
	$("#status").change(function(){
		ArtigoProxy.listarPorStatus($(this).val()).done(listarOk).fail(listarFail);
	});
});

function montarCombo(data){
	
	var select = document.getElementById("status");
	
	console.log('-----------DIFERENÇA NA BUSCA DO ELEMENTO-----------');
	console.log(document.getElementById("status"));
	console.log('---------------------------------------');
	console.log($("#status"));
	console.log('---------------------------------------');
	
	$.each(data, function(i, value){
	    var option = document.createElement("option");
	    option.value = value.id;	
	    option.text = value.descricao;
	    select.add(option);
	});
}

function listarOk(data) {
	$("#posts").empty();
	
	$.each(data, function(i, artigo) {
		
		var row = "";
		row += '<div class="panel panel-default">';
		row += '<div class="panel-heading">';
		row += artigo.titulo + ' <a href="' + App.getBaseURL() + '/artigo/' + artigo.id + '/edit">Editar</a>';
		row += '</div>';
		row += '<div class="panel-body">';
		row += artigo.conteudo;
		row += '<br/>';
		row += artigo.status.descricao;
		row += '</div>';
		row += '</div>';

		$("#posts").append(row);
	});
}

function listarFail(jqXHR) {
	console.log(jqXHR);
}
