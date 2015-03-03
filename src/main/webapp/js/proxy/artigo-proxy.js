var ArtigoProxy = {
		
	url : "api/artigos",
	
	criar : function(artigo){
		return $.ajax({
		  url: this.url,
		  type: "POST",
		  data: JSON.stringify(artigo),
		  contentType: "application/json",
		});
	},
	
	listar : function(){
		return $.ajax({
			  url: this.url,
			  type: "GET"
			});
		} 
		
}