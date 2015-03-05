package blog.security;

import java.security.Principal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.TokenAuthenticator;

@RequestScoped
public class MeuAutenticador extends TokenAuthenticator {

	private static final long serialVersionUID = 1L;

	@Inject
	private Credentials credentials;

	@Override
	protected Principal customAuthentication() throws Exception {
		Principal principal = null;

		if (credentials.getUsername().equals("cleverson") && credentials.getPassword().equals("segredo")) {
			principal = new MeuUser(credentials.getUsername());
		}

		return principal;
	}
}
