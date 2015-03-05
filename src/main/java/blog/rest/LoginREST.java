package blog.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.validator.constraints.NotEmpty;

import blog.security.MeuUser;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.util.Beans;

@Path("login")
public class LoginREST {

	@POST
	@Produces("application/json")
	public MeuUser logar(LoginBody body) {
		Credentials credentials = Beans.getReference(Credentials.class);
		credentials.setUsername(body.username);
		credentials.setPassword(body.password);

		SecurityContext securityContext = Beans.getReference(SecurityContext.class);
		securityContext.login();

		return (MeuUser) securityContext.getUser();
	}

	public static class LoginBody {

		@NotEmpty
		public String username;

		@NotEmpty
		public String password;
	}
}
