
package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	// Atributes

	@NotBlank
	@Length(max = 75)
	protected String statement;

	@NotBlank
	@Length(max = 100)
	protected String strongFeatures;

	@NotBlank
	@Length(max = 100)
	protected String weakFeatures;

	@URL
	protected String link;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
