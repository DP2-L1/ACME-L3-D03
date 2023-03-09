
package acme.forms;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Query attributes --------------------------------------

	// Response attributes------------------------------------
	//LT = Learning Time

	public Integer				nTotalTeoria;

	public Integer				nTotalHandsOn;

	public Double				mediaLTLectures;

	public Double				desviacionLTLectures;

	public Integer				minLTLectures;

	public Integer				maxLTLectures;

	public Double				mediaLTCourses;

	public Double				desviacionLTCourses;

	public Integer				minLTCourses;

	public Integer				maxLTCourses;

}
