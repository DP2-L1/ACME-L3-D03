
package acme.form;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityDashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	protected Integer			totalActivities;
	protected Double			avgActivitieTime;
	protected Double			devActivitieTime;
	protected Double			minActivitieTime;
	protected Double			maxActivitieTime;
	protected Double			avgCourseTime;
	protected Double			devCourseTime;
	protected Double			minCourseTime;
	protected Double			maxCourseTime;

}
