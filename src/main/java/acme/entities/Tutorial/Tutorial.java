
package acme.entities.Tutorial;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tutorial extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Pattern(regexp = "^[A-Z]{1,3}[0-9][0-9]{3}$")
	@Column(unique = true)
	private String				code;

	@NotBlank
	@Size(max = 75)
	private String				title;

	@NotBlank
	@Size(max = 100)
	private String				abstractText;

	@NotBlank
	@Size(max = 100)
	private String				goals;

	@NotNull
	private Integer				estimatedTotalTime;

	@OneToMany(mappedBy = "tutorial")
	private List<Session>		session				= new ArrayList<>();

}
