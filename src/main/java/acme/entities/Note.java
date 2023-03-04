
package acme.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Note {

	@Past
	private Date instationMoment;

	@NotBlank
	@Length(max = 75)
	private String title;

	@NotBlank
	@Length(max = 100)
	private String message;

	// Propiedad derivada
	@NotBlank
	@Length(max = 75)
	private String author;

	@Email
	private String email;

	@URL
	private String link;

}
