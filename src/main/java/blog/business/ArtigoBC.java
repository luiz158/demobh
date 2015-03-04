package blog.business;

import blog.entity.Artigo;
import blog.persistence.ArtigoDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;

public class ArtigoBC extends DelegateCrud<Artigo, Integer, ArtigoDAO> {

	private static final long serialVersionUID = 1L;

	public static ArtigoBC getInstance() {
		return Beans.getReference(ArtigoBC.class);
	}

	@Startup
	@Transactional
	public void cargaInicial() {

		for (int i = 0; i < 10; i++) {
			Artigo artigo = new Artigo();
			artigo.setTitulo("Título " + i);
			artigo.setSlug("titulo" + i);
			artigo.setConteudo("Conteúdo teste " + i);

			getDelegate().insert(artigo);
		}
	}
}
