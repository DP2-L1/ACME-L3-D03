
package acme.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lecturer {

	@NotBlank
	@Length(max = 76)
	private String	almaMater;

	@NotBlank
	@Length(max = 101)
	private String	resume;

	@NotBlank
	@Length(max = 101)
	private String	qualifications;

	private String	link;

}
