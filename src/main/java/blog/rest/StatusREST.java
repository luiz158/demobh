package blog.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import blog.business.StatusBC;
import blog.entity.Status;

@Path("status")
public class StatusREST {

	@GET
	@Produces("application/json")
	public List<Status> listar() throws Exception {
		List<Status> result = StatusBC.getInstance().findAll();
		return result.isEmpty() ? null : result;
	}
}
