
package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Note extends Message {

	@NotBlank
	@Length(max = 75)
	private String	author;

	@Email
	private String	email;

	@URL
	private String	link;

}
