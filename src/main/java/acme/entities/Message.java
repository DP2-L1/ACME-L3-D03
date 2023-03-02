
package acme.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {

	@Past
	private LocalDateTime	instationMoment;

	@NotBlank
	@Length(max = 76)
	private String			title;

	@NotBlank
	@Length(max = 101)
	private String			message;

	private String			link;

}
