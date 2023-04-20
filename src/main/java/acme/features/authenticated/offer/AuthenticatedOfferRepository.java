
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import acme.entities.offer.Offer;
import acme.framework.repositories.AbstractRepository;

@Service
public interface AuthenticatedOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = :id")
	Offer findOneOfferById(int id);

	@Query("select o from Offer o")
	Collection<Offer> findAllOffers();
}
