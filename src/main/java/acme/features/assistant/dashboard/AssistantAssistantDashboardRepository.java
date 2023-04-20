
package acme.features.assistant.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AssistantAssistantDashboardRepository extends AbstractRepository {

	@Query("select count(*) from Tutorial")
	Integer totalTutorials();

	@Query("select count(*) from Tutorial")
	Double averageTimeSession();

	@Query("select count(*) from Tutorial")
	Double deviationTimeSession();

	@Query("select count(*) from Tutorial")
	Double minimumTimeSession();

	@Query("select count(*) from Tutorial")
	Double maximumTimeSession();

	@Query("select avg(estimatedTotalTime) as mediaDuracion from Tutorial")
	Double averageTimeTutorial();

	@Query("select count(*) from Tutorial")
	Double deviationTimeTutorial();

	@Query("select min(estimatedTotalTime) as duracionMinima from Tutorial")
	Double minimumTimeTutorial();

	@Query("select max(estimatedTotalTime) as duracionMinima from Tutorial")
	Double maximumTimeTutorial();
}
