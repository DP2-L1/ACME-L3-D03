
package acme.features.authenticated.note;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.note.Note;
import acme.framework.components.accounts.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedNoteRepository extends AbstractRepository {

	@Query("Select n from Note n where n.instationMoment >= :deadline")
	Collection<Note> findRecentNotes(Date deadline);

	@Query("Select u from UserAccount u where u.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("Select n from Note n where n.id = :id")
	Note findOneNoteById(int id);

}
