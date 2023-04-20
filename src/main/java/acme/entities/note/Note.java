
package acme.entities.note;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Note extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@PastOrPresent
	@Temporal(value = TemporalType.TIMESTAMP)
	@NotNull
	private Date				instationMoment;

	@NotBlank
	@Length(max = 75)
	private String				title;

	@NotBlank
	@Length(max = 100)
	private String				message;

	@NotBlank
	@Length(max = 75)
	private String				author;

	@Email
	private String				email;

	@URL
	private String				link;

}
