
package acme.form;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistantDashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	Integer						totalTutorials;
	Double						averageTimeSession;
	Double						deviationTimeSession;
	Double						minimumTimeSession;
	Double						maximumTimeSession;
	Double						averageTimeTutorial;
	Double						deviationTimeTutorial;
	Double						minimumTimeTutorial;
	Double						maximumTimeTutorial;

}
