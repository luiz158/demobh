$(function(){
	
	ArtigoProxy.listar().done(listarOk).fail(listarFail);
	
	$("#link2artigo").click(function(event){
		event.preventDefault();
		
		location.href="artigo-form.html";
		
	});
	
});

function listarOk(data){
	
	$.each(data, function(i, artigo){
		console.log(artigo);
		var row = "";
		row += '<div class="panel panel-default">';
		row += '<div class="panel-heading">';
		row += artigo.titulo + ' <a href="artigo-form.html?id=' + artigo.id + '">Editar</a>';
		row += '</div>';
		row += '<div class="panel-body">';
		row += artigo.conteudo;
		row += '</div>';
		row += '</div>';
		
		$("#posts").append(row);
	});
	
}

function listarFail(jqXHR){
	console.log(jqXHR);
}