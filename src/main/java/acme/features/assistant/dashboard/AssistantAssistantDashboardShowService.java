
package acme.features.assistant.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.form.AssistantDashboard;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Assistant;

@Service
public class AssistantAssistantDashboardShowService extends AbstractService<Assistant, AssistantDashboard> {

	@Autowired
	protected AssistantAssistantDashboardRepository repository;


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		AssistantDashboard dashboard;
		Integer totalTutorials;
		Double averageTimeSession;
		Double deviationTimeSession;
		Double minimumTimeSession;
		Double maximumTimeSession;
		Double averageTimeTutorial;
		Double deviationTimeTutorial;
		Double minimumTimeTutorial;
		Double maximumTimeTutorial;

		totalTutorials = this.repository.totalTutorials();
		averageTimeSession = this.repository.averageTimeSession();
		deviationTimeSession = this.repository.deviationTimeSession();
		minimumTimeSession = this.repository.minimumTimeSession();
		maximumTimeSession = this.repository.maximumTimeSession();
		averageTimeTutorial = this.repository.averageTimeTutorial();
		deviationTimeTutorial = this.repository.deviationTimeTutorial();
		minimumTimeTutorial = this.repository.minimumTimeTutorial();
		maximumTimeTutorial = this.repository.maximumTimeTutorial();

		dashboard = new AssistantDashboard();
		dashboard.setTotalTutorials(totalTutorials);
		dashboard.setAverageTimeSession(averageTimeSession);
		dashboard.setDeviationTimeSession(deviationTimeSession);
		dashboard.setMinimumTimeSession(minimumTimeSession);
		dashboard.setMaximumTimeSession(maximumTimeSession);
		dashboard.setAverageTimeTutorial(averageTimeTutorial);
		dashboard.setDeviationTimeTutorial(deviationTimeTutorial);
		dashboard.setMinimumTimeTutorial(minimumTimeTutorial);
		dashboard.setMaximumTimeTutorial(maximumTimeTutorial);

		super.getBuffer().setData(dashboard);
	}

	@Override
	public void unbind(final AssistantDashboard object) {
		Tuple tuple;

		tuple = super.unbind(object, "totalTutorials", "averageTimeSession", "deviationTimeSession", "minimumTimeSession", "maximumTimeSession", "averageTimeTutorial", "deviationTimeTutorial", "minimumTimeTutorial", "maximumTimeTutorial");

		super.getResponse().setData(tuple);
	}

}
