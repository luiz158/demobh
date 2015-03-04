package blog.business;

import blog.entity.Status;
import blog.persistence.StatusDAO;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.util.Beans;

public class StatusBC extends DelegateCrud<Status, Integer, StatusDAO> {

	private static final long serialVersionUID = 1L;

	public static StatusBC getInstance() {
		return Beans.getReference(StatusBC.class);
	}
}
