
package acme.features.company.practicum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.practicum.Practicum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanyPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.company.id = :id")
	Collection<Practicum> findManyPracticumsByCompanyId(int id);

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOnePracticumById(int id);
}
