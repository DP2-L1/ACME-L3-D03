
package acme.form;

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

	protected Integer			totalTheory;

	protected Integer			totalHandsOn;

	protected Statistic			lectureTime;

	protected Statistic			courseTime;

}
