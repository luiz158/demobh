var ArtigoProxy = {

	url : App.getBaseURL() + "/api/artigos",

	criar : function(artigo) {
		return $.ajax({
			url : this.url,
			type : "POST",
			data : JSON.stringify(artigo),
			contentType : "application/json",
		});
	},

	listar : function() {
		return $.ajax({
			url : this.url,
			type : "GET"
		});
	},

	carregar : function(id) {
		return $.ajax({
			url : this.url + "/" + id,
			type : "GET"
		});
	},
	
	listarPorStatus : function(status) {
		return $.ajax({
			url : this.url + "?status=" + status,
			type : "GET"
		});
	}

}
