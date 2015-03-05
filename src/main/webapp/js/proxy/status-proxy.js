var StatusProxy = {

	url : App.getBaseURL() + "/api/status",

	listar : function() {
		return $.ajax({
			url : this.url,
			type : "GET"
		});
	}


}
