
package acme.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistic {

	protected static final long	serialVersionUID	= 1L;

	Integer						total;
	Double						media;
	Double						min;
	Double						max;
	Double						desviacion;

}
