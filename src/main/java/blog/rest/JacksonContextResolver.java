package blog.rest;

import static org.codehaus.jackson.map.SerializationConfig.Feature.INDENT_OUTPUT;
import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Consumes("application/json")
@Produces("application/json")
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

	private final ObjectMapper objectMapper;

	public JacksonContextResolver() throws Exception {
		objectMapper = new ObjectMapper();
		objectMapper.configure(INDENT_OUTPUT, true);
		objectMapper.setSerializationInclusion(NON_NULL);
	}

	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		return objectMapper;
	}
}
