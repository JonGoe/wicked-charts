package de.adesso.wickedcharts.showcase.configurations;

import java.util.Arrays;

/**
 * 
 * A sample that shows how a stacked bar chart configuration looks.
 *
 */

import de.adesso.wickedcharts.chartjs.chartoptions.AxesScale;
import de.adesso.wickedcharts.chartjs.chartoptions.ChartType;
import de.adesso.wickedcharts.chartjs.chartoptions.Data;
import de.adesso.wickedcharts.chartjs.chartoptions.Dataset;
import de.adesso.wickedcharts.chartjs.chartoptions.Legend;
import de.adesso.wickedcharts.chartjs.chartoptions.Options;
import de.adesso.wickedcharts.chartjs.chartoptions.Position;
import de.adesso.wickedcharts.chartjs.chartoptions.ScaleLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.Scales;
import de.adesso.wickedcharts.chartjs.chartoptions.Title;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.SimpleColor;
import de.adesso.wickedcharts.chartjs.chartoptions.label.TextLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.valueType.IntegerValue;
import de.adesso.wickedcharts.showcase.configurations.base.ShowcaseConfiguration;

/**
 *
 * A sample that shows how a stack bar chart configuration looks.
 *
 * @see <a href="http://www.chartjs.org/samples/latest/charts/bar/stacked.html">http://www.chartjs.org/samples/latest/charts/bar/stacked.html</a>
 *
 * @author anedomansky
 * @author maximAtanasov
 */
@SuppressWarnings("serial")
public class BarChartStackedConfiguration extends ShowcaseConfiguration {
	public BarChartStackedConfiguration() {
    	setType(ChartType.STACKED_BAR);
		
		Data data = new Data()
				.setLabels(TextLabel.of("January", "February", "March", "April", "May", "June", "July"));
		setData(data);
		
		Dataset dataset1 = new Dataset()
				.setLabel("Dataset 1")
				.setBackgroundColor(SimpleColor.RED_TRANSPARENT)
				.setBorderColor(SimpleColor.RED)
				.setBorderWidth(1)
				.setData(IntegerValue.of(randomIntegerList(7)))
				.setFill(false)
				.setStack("1");
		
		
		
		Dataset dataset2 = new Dataset()
				.setLabel("Dataset 2")
				.setBackgroundColor(SimpleColor.BLUE_TRANSPARENT)
				.setBorderColor(SimpleColor.BLUE)
				.setBorderWidth(1)
				.setData(IntegerValue.of(randomIntegerList(7)))
				.setFill(false)
				.setStack("1");
		
		Dataset dataset3 = new Dataset()
				.setLabel("Dataset 3")
				.setBackgroundColor(SimpleColor.GREEN_TRANSPARENT)
				.setBorderColor(SimpleColor.GREEN)
				.setBorderWidth(1)
				.setData(IntegerValue.of(randomIntegerList(7)))
				.setFill(false)
				.setStack("1");
		
		data.setDatasets(Arrays.asList(dataset1,dataset2, dataset3));
		
		Options options = new Options()
				.setResponsive(true)
				.setLegend(new Legend()
						.setPosition(Position.TOP))
				.setTitle(new Title()
						.setDisplay(true)
						.setText("Chart.js Bar Chart - Stacked"))
				.setScales(new Scales()
						.setXAxes(new AxesScale()
								.setDisplay(true)
								.setStacked(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Month")))
						.setYAxes(new AxesScale()
								.setDisplay(true)
								.setStacked(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Value"))))
				;
		setOptions(options);
	}

}
