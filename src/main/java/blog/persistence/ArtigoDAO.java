package blog.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import blog.entity.Artigo;
import blog.entity.Status;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@Transactional
public class ArtigoDAO extends JPACrud<Artigo, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Artigo> findAll() {
		StringBuffer jpql = new StringBuffer();
		jpql.append(" select ");
		jpql.append("        new Artigo ( ");
		jpql.append("            a.id, ");
		jpql.append("            a.slug, ");
		jpql.append("            a.titulo, ");
		jpql.append("            a.conteudo, ");
		jpql.append("            s.id, ");
		jpql.append("            s.descricao ");
		jpql.append("        ) ");
		jpql.append("   from Artigo a ");
		jpql.append("   join a.status s ");

		TypedQuery<Artigo> query = getEntityManager().createQuery(jpql.toString(), Artigo.class);

		return query.getResultList();
	}

	public List<Artigo> find(Status status) {
		StringBuffer jpql = new StringBuffer();
		jpql.append(" select ");
		jpql.append("        new Artigo ( ");
		jpql.append("            a.id, ");
		jpql.append("            a.slug, ");
		jpql.append("            a.titulo, ");
		jpql.append("            a.conteudo, ");
		jpql.append("            s.id, ");
		jpql.append("            s.descricao ");
		jpql.append("        ) ");
		jpql.append("   from Artigo a ");
		jpql.append("   join a.status s ");
		jpql.append("  where s = :status ");

		TypedQuery<Artigo> query = getEntityManager().createQuery(jpql.toString(), Artigo.class);
		query.setParameter("status", status);

		return query.getResultList();
	}

}
