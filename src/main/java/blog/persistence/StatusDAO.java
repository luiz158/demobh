package blog.persistence;

import blog.entity.Status;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@Transactional
public class StatusDAO extends JPACrud<Status, Integer> {

	private static final long serialVersionUID = 1L;

}
