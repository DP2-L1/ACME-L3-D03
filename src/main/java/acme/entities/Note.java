
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

<<<<<<< HEAD
	@Past
	private Date instationMoment;
=======
	protected Date		instation_moment;
>>>>>>> branch 'master' of https://github.com/DP2-L1/ACME-L3-D02.git

	@NotBlank
	@Length(max = 75)
<<<<<<< HEAD
	private String title;
=======
	protected String	title;
>>>>>>> branch 'master' of https://github.com/DP2-L1/ACME-L3-D02.git

	@NotBlank
	@Length(max = 100)
<<<<<<< HEAD
	private String message;

	// Propiedad derivada
	@NotBlank
	@Length(max = 75)
	private String author;
=======
	protected String	message;
>>>>>>> branch 'master' of https://github.com/DP2-L1/ACME-L3-D02.git

	@Email
<<<<<<< HEAD
	private String email;
=======
	protected String	email;
>>>>>>> branch 'master' of https://github.com/DP2-L1/ACME-L3-D02.git

	@URL
<<<<<<< HEAD
	private String link;
=======
	protected String	link;

	@Valid
	protected User		author;
>>>>>>> branch 'master' of https://github.com/DP2-L1/ACME-L3-D02.git

}
