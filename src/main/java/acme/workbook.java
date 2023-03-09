package acme;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import acme.entities.Indication;
import acme.framework.data.AbstractEntity;

public class workbook extends AbstractEntity {

	@NotBlank
	@Size(max = 75)
	protected String title;

	@NotBlank
	@Size(max = 100)
	protected String abstracto;

	protected Indication indication;

	protected Date fecha;

	protected String link;
}
