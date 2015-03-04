package blog.entity;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

@Entity
public class Artigo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Index(name = "IDX_ARTIGO_SLUG")
	private String slug;

	private String titulo;

	private String conteudo;

	@ManyToOne(fetch = LAZY)
	@Index(name = "IDX_ARTIGO_STATUS")
	private Status status;

	public Artigo() {
	}

	public Artigo(Integer id, String slug, String titulo, String conteudo, Integer statusId, String statusDescricao) {
		this.id = id;
		this.slug = slug;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.status = new Status();
		this.status.setId(statusId);
		this.status.setDescricao(statusDescricao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Artigo)) {
			return false;
		}
		Artigo other = (Artigo) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
