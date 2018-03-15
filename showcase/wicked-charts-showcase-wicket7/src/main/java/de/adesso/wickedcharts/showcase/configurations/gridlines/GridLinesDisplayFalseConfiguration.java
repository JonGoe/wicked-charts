package de.adesso.wickedcharts.showcase.configurations.gridlines;


import de.adesso.wickedcharts.chartjs.chartoptions.Title;

@SuppressWarnings("serial")
public class GridLinesDisplayFalseConfiguration extends GridLinesBasicConfiguration {
	
	public GridLinesDisplayFalseConfiguration() {
		super();
		
		gridLines.setDisplay(false);
		getOptions().setTitle(new Title()
				.setDisplay(true)
				.setText("Gridlines - Display False"));
	}
}
