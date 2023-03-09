package acme.entities;

import acme.framework.data.AbstractForm;

public class Dashboard extends AbstractForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int totalActivities;
	private double avgActivitieTime;
	private double devActivitieTime;
	private double minActivitieTime;
	private double maxActivitieTime;
	private double avgCourseTime;
	private double devCourseTime;
	private double minCourseTime;
	private double maxCourseTime;

}
