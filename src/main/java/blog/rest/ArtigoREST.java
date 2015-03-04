package blog.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotEmpty;

import blog.business.ArtigoBC;
import blog.entity.Artigo;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Cache;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("artigos")
public class ArtigoREST {

	@GET
	@Cache("max-age=60")
	@Produces("application/json")
	public List<ArtigoBody> listar() throws Exception {
		ArrayList<ArtigoBody> result = new ArrayList<ArtigoBody>();

		for (Artigo artigo : ArtigoBC.getInstance().findAll()) {
			ArtigoBody body = new ArtigoBody();
			body.id = artigo.getId();
			body.slug = artigo.getSlug();
			body.titulo = artigo.getTitulo();
			body.conteudo = artigo.getConteudo();
			body.status = artigo.getStatus().getDescricao();

			result.add(body);
		}

		return result.isEmpty() ? null : result;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public ArtigoBody carregar(@PathParam("id") Integer id) throws Exception {
		Artigo artigo = ArtigoBC.getInstance().load(id);

		if (artigo == null) {
			throw new NotFoundException();
		}

		ArtigoBody body = new ArtigoBody();
		body.id = artigo.getId();
		body.slug = artigo.getSlug();
		body.titulo = artigo.getTitulo();
		body.conteudo = artigo.getConteudo();
		return body;
	}

	@POST
	@Transactional
	@ValidatePayload
	@Consumes("application/json")
	@Produces("text/plain")
	public Response criar(ArtigoBody body) {
		ArtigoBC artigoBC = ArtigoBC.getInstance();

		Artigo artigo = new Artigo();
		artigo.setSlug(body.slug);
		artigo.setTitulo(body.titulo);
		artigo.setConteudo(body.conteudo);
		artigoBC.insert(artigo);

		URI location = URI.create("http://localhost:8080/blog/api/artigos/" + artigo.getId());
		return Response.created(location).entity(artigo.getId()).build();
	}

	public static class ArtigoBody {

		public Integer id;

		public String slug;

		@NotEmpty
		public String titulo;

		public String conteudo;

		public String status;
	}
}
