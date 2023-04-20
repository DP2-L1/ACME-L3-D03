
package acme.features.assistant.tutorialSession;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tutorial.Tutorial;
import acme.entities.tutorial.TutorialSession;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AssistantTutorialSessionRepository extends AbstractRepository {

	@Query("select t from Tutorial t where t.id = :id")
	Tutorial findOneTutorialById(int id);

	@Query("select ts from TutorialSession ts where ts.id = :id")
	TutorialSession findOneSessionById(int id);

	@Query("select ts from TutorialSession ts where ts.tutorial.id = :masterId")
	Collection<TutorialSession> findManyTutorialSessionsByMasterId(int masterId);

	@Query("select ts.tutorial from TutorialSession ts where ts.id = :id")
	Tutorial findOneTutorialBySessionId(int id);
}
