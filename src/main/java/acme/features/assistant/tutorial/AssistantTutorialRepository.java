
package acme.features.assistant.tutorial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.course.Course;
import acme.entities.tutorial.Tutorial;
import acme.entities.tutorial.TutorialSession;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Assistant;

@Repository
public interface AssistantTutorialRepository extends AbstractRepository {

	@Query("select t from Tutorial t where t.id = :id")
	Tutorial findOneTutorialById(int id);

	@Query("select t from Tutorial t")
	Collection<Tutorial> findAllTutorials();

	@Query("select t from Tutorial t where t.assistant.id = :assistantId")
	Collection<Tutorial> findManyTutorialsByAssistantId(int assistantId);

	@Query("select a from Assistant a where a.id = :id")
	Assistant findOneAssistantById(int id);

	@Query("select c from Course c where c.id = :courseId")
	Course findOneCourseById(int courseId);

	@Query("select t from Tutorial t where t.code = :code")
	Tutorial findOneTutorialByCode(String code);

	@Query("select c from Course c")
	Collection<Course> findAllCourses();

	@Query("select ts from TutorialSession ts where ts.tutorial.id = :tutorialId")
	Collection<TutorialSession> findManyTutorialSessionByTutorialId(int tutorialId);
}
