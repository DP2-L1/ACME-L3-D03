package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enrolment {

	@Pattern(regexp = "[A-Z]{1,3}[0-9][0-9]{3}")
	@NotBlank
	// @Unique
	private String code;

	@NotBlank
	@Size(max = 75)
	private String motivation;

	@NotBlank
	@Size(max = 100)
	private String goals;

	@PositiveOrZero
	private int workTimeInHours;

}
