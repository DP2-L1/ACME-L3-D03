
package acme.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Note {

	private Date	instation_moment;

	@NotBlank
	@Length(max = 75)
	private String	title;

	@NotBlank
	@Length(max = 100)
	private String	message;

	@Email
	private String	email;

	@URL
	private String	link;

}
