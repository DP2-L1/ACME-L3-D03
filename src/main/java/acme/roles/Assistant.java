
package acme.roles;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import acme.entities.Tutorial.Tutorial;
import acme.framework.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assistant extends AbstractRole {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Size(max = 76)
	private String				supervisor;

	@NotBlank
	@Size
	private String				expertise;

	@NotBlank
	@Size(max = 101)
	private String				resume;

	@ManyToOne
	private Tutorial			tutorial;
}
