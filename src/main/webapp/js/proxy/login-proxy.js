var LoginProxy = {

	url : App.getBaseURL() + "/api/login",

	logar : function(user) {
		return $.ajax({
			url : this.url,
			type : "POST",
			data : JSON.stringify(user),
			contentType : "application/json"
		});
	}


}
