
package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	// Atributes

	@NotBlank
	@Max(value = 76)
	protected String statement;

	@NotBlank
	@Max(value = 101)
	protected String listStrongFeatures;

	@NotBlank
	@Max(value = 101)
	protected String listWeakFeatures;

	protected String link;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
