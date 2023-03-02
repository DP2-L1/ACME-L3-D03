
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
public class Lecturer {

	@NotBlank
	@Length(max = 75)
	private String	almaMater;

	@NotBlank
	@Length(max = 100)
	private String	resume;

	@NotBlank
	@Length(max = 100)
	private String	qualifications;

	@URL
	private String	link;

}
