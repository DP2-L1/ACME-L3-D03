
package acme.features.authenticated.lecturer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.components.accounts.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Lecturer;

@Repository
public interface AuthenticatedLecturerRepository extends AbstractRepository {

	@Query("Select u from UserAccount u where u.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("Select l from Lecturer l where l.userAccount.id = :id")
	Lecturer findOneLecturerByUserAccountId(int id);

}
