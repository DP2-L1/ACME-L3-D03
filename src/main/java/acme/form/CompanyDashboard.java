
package acme.form;

import java.util.Date;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	//Total Number of practica regarding theory or hands-on courses grouped by month during the last year

	private Integer				TotalNumberPracticumTheory;
	private Integer				TotalNumberCoursesHandsOn;

	//average,deviation,minimum,maximum period length of the sessions in the company practica
	private Date				AverageSessionPeriodLength;
	private Date				deviationSessionPeriodLength;
	private Date				MinimunSessionPeriodLength;
	private Date				MaximumSessionPeriodLength;

	//average, deviation, minimum, and maximum period length of their practica

	private Date				AveragePracticumEstimatedLength;
	private Date				deviationPracticumEstimatedLength;
	private Date				MinimunPracticumEstimatedLength;
	private Date				MaximumPracticumEstimatedLength;
}
