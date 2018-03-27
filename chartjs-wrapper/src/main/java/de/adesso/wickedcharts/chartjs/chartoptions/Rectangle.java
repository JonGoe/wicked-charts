package de.adesso.wickedcharts.chartjs.chartoptions;

import de.adesso.wickedcharts.chartjs.chartoptions.colors.Color;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Defines the rectangle element that is used in bar charts
 *
 * @see <a href="http://www.chartjs.org/docs/latest/configuration/elements.html#rectangle-configuration">http://www.chartjs.org/docs/latest/configuration/elements.html#rectangle-configuration</a>
 */
@Accessors(chain = true)
@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Rectangle extends Element {
	private Number borderWidth;
	private Color backgroundColor;
	private Color borderColor;
	private Position borderSkipped;
}
