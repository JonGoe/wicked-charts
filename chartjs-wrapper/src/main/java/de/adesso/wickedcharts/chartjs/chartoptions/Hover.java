package de.adesso.wickedcharts.chartjs.chartoptions;

import java.io.Serializable;

import lombok.experimental.Accessors;

/**
 * Defines which events trigger chart interactions.
 *
 * @see <a
 *      href="http://www.chartjs.org/docs/latest/general/interactions/?h=hover">http://www.chartjs.org/docs/latest/general/interactions/?h=hover</a>
 *
 */
@Accessors(chain = true)
@lombok.Data
public class Hover implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// interaction options
	private HoverMode mode;
	private Boolean intersect;
	private String axis;
	private Number animationDuration;
}
