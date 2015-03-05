$(function() {
	ArtigoProxy.listar().done(listarOk).fail(listarFail);

	$("#recarregar").click(function() {
		ArtigoProxy.listar().done(listarOk).fail(listarFail);
	});

	$("#link2artigo").click(function(event) {
		event.preventDefault();
		location.href = App.getBaseURL() + "/artigo/new";
	});
});

function listarOk(data) {
	$.each(data, function(i, artigo) {
		console.log(artigo);
		var row = "";
		row += '<div class="panel panel-default">';
		row += '<div class="panel-heading">';
		row += artigo.titulo + ' <a href="' + App.getBaseURL() + '/artigo/' + artigo.id + '/edit">Editar</a>';
		row += '</div>';
		row += '<div class="panel-body">';
		row += artigo.conteudo;
		row += '</div>';
		row += '</div>';

		$("#posts").append(row);
	});
}

function listarFail(jqXHR) {
	console.log(jqXHR);
}
