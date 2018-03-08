package net.qpid.jpatuplemappingexample;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("customers")
public class CustomerEndpoint {

	@Inject
	CustomerDtoMapper	mapper;

	@PersistenceContext
	EntityManager		em;

	@GET
	public List<CustomerDto> all() {
		return mapper.fromTuples(em.createQuery("SELECT customer FROM Customer customer", Tuple.class).getResultList());
	}

}
