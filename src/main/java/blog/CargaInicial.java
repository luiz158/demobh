package blog;

import javax.inject.Inject;

import blog.business.ArtigoBC;
import blog.business.StatusBC;
import blog.entity.Artigo;
import blog.entity.Status;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.transaction.Transactional;

public class CargaInicial {

	@Inject
	private StatusBC statusBC;

	@Inject
	private ArtigoBC artigoBC;

	@Startup
	@Transactional
	public void cargaInicial() {

		Status[] statuses = new Status[3];
		Status status;

		status = new Status();
		status.setDescricao("Rascunho");
		statusBC.insert(status);
		statuses[0] = status;

		status = new Status();
		status.setDescricao("Publicado");
		statusBC.insert(status);
		statuses[1] = status;

		status = new Status();
		status.setDescricao("Aprovado");
		statusBC.insert(status);
		statuses[2] = status;

		for (int i = 0; i < 10; i++) {
			Artigo artigo = new Artigo();
			artigo.setTitulo("Título " + i);
			artigo.setSlug("titulo" + i);
			artigo.setConteudo("Conteúdo teste " + i);
			artigo.setStatus(statuses[i % 3]);
			artigoBC.insert(artigo);
		}
	}
}
