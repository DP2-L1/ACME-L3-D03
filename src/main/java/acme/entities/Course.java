
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[a-z]{1,3}+[0,9]{3}$", message = "code must follow pattern")
	private String	code;

	@NotBlank
	@Length(max = 76)
	private String	title;

	@NotBlank
	@Length(max = 101)
	private String	abstracto;

	private Boolean	indicator;

	@PositiveOrZero
	private Double	retailPrice;

	private String	link;
}
