
package acme.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Note {

	protected Date		instation_moment;

	@NotBlank
	@Length(max = 75)
	protected String	title;

	@NotBlank
	@Length(max = 100)
	protected String	message;

	@Email
	protected String	email;

	@URL
	protected String	link;

	@Valid
	protected User		author;

}
