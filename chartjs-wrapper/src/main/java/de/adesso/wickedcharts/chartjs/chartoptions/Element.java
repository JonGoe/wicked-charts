package de.adesso.wickedcharts.chartjs.chartoptions;

import java.io.Serializable;

import lombok.experimental.Accessors;

/**
 * Defines the properties of elements.
 *
 */
@Accessors(chain = true)
@lombok.Data
public class Element implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Point point;
	private Line line;
}
