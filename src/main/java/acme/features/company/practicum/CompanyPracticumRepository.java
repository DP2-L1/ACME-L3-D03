
package acme.features.company.practicum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.course.Course;
import acme.entities.practicum.Practicum;
import acme.entities.practicum.PracticumSession;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Company;

@Repository
public interface CompanyPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.company.id = :id")
	Collection<Practicum> findManyPracticumsByCompanyId(int id);

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOnePracticumById(int id);

	@Query("select c from Company c where c.id = :id")
	Company findOneCompanyById(int id);

	@Query("select ps from PracticumSession ps where ps.practicum.id = :id")
	Collection<PracticumSession> findManySessionsByPracticumId(int id);

	@Query("select c from course c where c.id=:id")
	Course findOneCourseById(int id);

	@Query("select p from Practicum p where p.code = :code")
	Practicum findOnePracticumByCode(String code);
}
