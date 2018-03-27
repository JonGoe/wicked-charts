package de.adesso.wickedcharts.chartjs.chartoptions;

import java.io.Serializable;

import lombok.experimental.Accessors;

/**
 * Defines the time format options
 *
 * @see <a
 *      http://www.chartjs.org/docs/latest/axes/cartesian/time.html#configuration-options">http://www.chartjs.org/docs/latest/axes/cartesian/time.html#configuration-options</a>
 */
@Accessors(chain = true)
@lombok.Data
class TimeFormat implements Serializable{
	private static final long serialVersionUID = 1L;
	private String format;
	private String timeFormat;
	private String tooltipFormat;
	private TimeFormatRound round;
}