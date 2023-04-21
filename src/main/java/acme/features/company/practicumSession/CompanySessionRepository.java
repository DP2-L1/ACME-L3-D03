
package acme.features.company.practicumSession;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.practicum.Practicum;
import acme.entities.practicum.PracticumSession;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanySessionRepository extends AbstractRepository {

	@Query("select ps from PracticumSession ps where ps.practicum.id = :masterId")
	Collection<PracticumSession> findManyPracticumSessionsByPracticumId(int masterId);

	@Query("select ps from PracticumSession ps where ps.id = :id")
	PracticumSession findOneSessionByPracticumId(int id);

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOnePracticumById(int id);

	@Query("select ps.practicum from PracticumSession ps where ps.id = :id")
	Practicum findOnePracticumBySessionId(int id);

	@Query("select sum(ps.timePeriodEnd-ps.timePeriodStart) from PracticumSession ps where ps.practicum.id = :id")
	Date ComputeEstimatedTimeOfPractica(int id);

	@Query("select ps from PracticumSession ps where ps.id = :id")
	PracticumSession findOneSessionById(int id);

}
