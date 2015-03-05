package blog.security;

import java.security.Principal;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.util.Beans;

public class MeuUser implements Principal {

	private String name;

	public static MeuUser getInstance() {
		return (MeuUser) Beans.getReference(SecurityContext.class).getUser();
	}

	public MeuUser(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
