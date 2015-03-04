package blog.persistence;

import blog.entity.Artigo;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.util.Beans;

public class ArtigoBC extends DelegateCrud<Artigo, Integer, ArtigoDAO> {

	private static final long serialVersionUID = 1L;

	public static ArtigoBC getInstance() {
		return Beans.getReference(ArtigoBC.class);
	}
}
