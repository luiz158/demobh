package blog.rest.persistence;

import blog.rest.entity.Artigo;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@Transactional
public class ArtigoDAO extends JPACrud<Artigo, Integer> {

	private static final long serialVersionUID = 1L;

}
