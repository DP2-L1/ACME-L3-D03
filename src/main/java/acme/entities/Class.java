
package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Class extends AbstractEntity {

	// Serialisation identifier ---------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Atributes ------------------------------------------------------------

	protected String			aula;

	@ManyToOne
	protected Course			course;

	@ManyToOne
	protected Lecture			lecture;

}
