
package acme.features.authenticated.peep;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.peep.Peep;
import acme.framework.components.accounts.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedPeepRepository extends AbstractRepository {

	@Query("select a from Peep a where a.id = :id")
	Peep findOnePeepById(int id);

	@Query("select a from Peep a")
	Collection<Peep> findAllPeeps();

	@Query("select ua from UserAccount ua where ua.id = :id")
	UserAccount findUserAcountById(int id);

}
