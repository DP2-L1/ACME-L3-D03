package acme.form;

import java.util.Map;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long serialVersionUID = 1L;

	// Attributes -------------------------------------------------------------

	// Número total de directivos con cada rol

	private Integer totalCompanies;
	private Integer totalAssistants;
	private Integer totalAuditors;
	private Integer totalLecturers;
	private Integer totalConsumers;
	private Integer totalProviders;

	// Proporción de personas con una dirección de correo electrónico y un enlace

	private Double ratioLinkAndEmail;

	// Proporciones de boletines críticos y no críticos"

	private Double ratioCriticalBulletins;
	private Double ratioNonCriticalBulletins;

	// Promedio, mínimo, máximo y desviación estándar del presupuesto en las ofertas
	// agrupadas por moneda

	private Map<String, Double> avgBudgetByCurrency;
	private Map<String, Double> minBudgetByCurrency;
	private Map<String, Double> maxBudgetByCurrency;
	private Map<String, Double> devBudgetByCurrency;

	// Promedio, mínimo, máximo y desviación estándar
	// del numero de notas publicadas en las últimas 10 semanas

	private Double avgLast10WeeksNotes;
	private Double minLast10WeeksNotes;
	private Double maxLast10WeeksNotes;
	private Double devLast10WeeksNotes;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
