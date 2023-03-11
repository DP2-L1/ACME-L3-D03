
package acme.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.framework.data.AbstractEntity;

public class Configuration extends AbstractEntity {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Pattern(regexp = "[A-Z]{3}")
	protected String			defaultCurrency;

	@NotBlank
	protected String			acceptedCurrencies;

}
