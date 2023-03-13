
package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company extends AbstractRole {

	@NotBlank
	protected String	name;

	@NotBlank
	@Length(min = 0, max = 26)
	protected String	vatNumber;

	@NotBlank
	@Length(min = 0, max = 101)
	protected String	summary;

	@URL
	protected String	optionalLink;

}
