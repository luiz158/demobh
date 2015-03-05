package blog.business;

import java.util.List;

import blog.entity.Artigo;
import blog.entity.Status;
import blog.persistence.ArtigoDAO;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.util.Beans;

public class ArtigoBC extends DelegateCrud<Artigo, Integer, ArtigoDAO> {

	private static final long serialVersionUID = 1L;

	public static ArtigoBC getInstance() {
		return Beans.getReference(ArtigoBC.class);
	}

	public List<Artigo> find(Status status) {
		return getDelegate().find(status);
	}
}
