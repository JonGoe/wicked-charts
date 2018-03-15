package de.adesso.wickedcharts.showcase.configurations.gridlines;


import de.adesso.wickedcharts.chartjs.chartoptions.Title;

@SuppressWarnings("serial")
public class GridLinesChartAreaConfiguration extends GridLinesBasicConfiguration {
	
	public GridLinesChartAreaConfiguration() {
		super();
		
		gridLines.setDisplay(true)
		.setDrawBorder(true)
		.setDrawOnChartArea(false);
		getOptions().setTitle(new Title()
				.setDisplay(true)
				.setText("Gridlines - Chart Area"));
	}
}
