package acme.entities;

import acme.framework.data.AbstractForm;

public class Dashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer totalActivities;
	private Double avgActivitieTime;
	private Double devActivitieTime;
	private Double minActivitieTime;
	private Double maxActivitieTime;
	private Double avgCourseTime;
	private Double devCourseTime;
	private Double minCourseTime;
	private Double maxCourseTime;

}
