
package acme.entities;

import javax.persistence.Entity;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class AuditorDashboard extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	private int					totalAudits;

	// Number of auditing records in this audits
	private double				averageAudits;
	private double				deviationAudits;

	private int					minimumAudits;
	private int					maximumAudits;

	// Time of the period lengths in their auditing records
	private double				averageTime;
	private double				deviationTime;

	private int					minimumTime;
	private int					maximumTime;

}
