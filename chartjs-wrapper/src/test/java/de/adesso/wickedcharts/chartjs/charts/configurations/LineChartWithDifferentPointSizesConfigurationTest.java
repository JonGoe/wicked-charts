package de.adesso.wickedcharts.chartjs.charts.configurations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.chartjs.chartoptions.Animation;
import de.adesso.wickedcharts.chartjs.chartoptions.AxesScale;
import de.adesso.wickedcharts.chartjs.chartoptions.ChartType;
import de.adesso.wickedcharts.chartjs.chartoptions.Data;
import de.adesso.wickedcharts.chartjs.chartoptions.Dataset;
import de.adesso.wickedcharts.chartjs.chartoptions.Element;
import de.adesso.wickedcharts.chartjs.chartoptions.Filler;
import de.adesso.wickedcharts.chartjs.chartoptions.GridLines;
import de.adesso.wickedcharts.chartjs.chartoptions.Hover;
import de.adesso.wickedcharts.chartjs.chartoptions.HoverMode;
import de.adesso.wickedcharts.chartjs.chartoptions.Legend;
import de.adesso.wickedcharts.chartjs.chartoptions.Line;
import de.adesso.wickedcharts.chartjs.chartoptions.Options;
import de.adesso.wickedcharts.chartjs.chartoptions.Plugins;
import de.adesso.wickedcharts.chartjs.chartoptions.Position;
import de.adesso.wickedcharts.chartjs.chartoptions.Rectangle;
import de.adesso.wickedcharts.chartjs.chartoptions.ScaleLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.Scales;
import de.adesso.wickedcharts.chartjs.chartoptions.Ticks;
import de.adesso.wickedcharts.chartjs.chartoptions.Title;
import de.adesso.wickedcharts.chartjs.chartoptions.TooltipMode;
import de.adesso.wickedcharts.chartjs.chartoptions.Tooltips;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.Color;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.SimpleColor;
import de.adesso.wickedcharts.chartjs.chartoptions.colors.StringValueColor;
import de.adesso.wickedcharts.chartjs.chartoptions.fillingmodes.BoundaryFillingMode;
import de.adesso.wickedcharts.chartjs.chartoptions.label.TextLabel;
import de.adesso.wickedcharts.chartjs.chartoptions.valueType.IntegerValue;
import de.adesso.wickedcharts.chartjs.jackson.JsonRenderer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LineChartWithDifferentPointSizesConfigurationTest {
	
	@Test
	public void lineChartWithDifferentPointSizesConfigurationTest() {
		String result = "{\r\n" + 
				"  \"type\" : \"line\",\r\n" + 
				"  \"data\" : {\r\n" + 
				"    \"labels\" : [ \"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\" ],\r\n" + 
				"    \"datasets\" : [ {\r\n" + 
				"      \"label\" : \"dataset - big points\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(255,99,132)',\r\n" + 
				"      \"borderColor\" : 'rgb(255,99,132)',\r\n" + 
				"      \"data\" : [ 0, 1, 2, 3, 4, 5, 6 ],\r\n" + 
				"      \"fill\" : false,\r\n" + 
				"      \"pointRadius\" : [ 15, 15, 15, 15, 15, 15, 15 ],\r\n" + 
				"      \"pointHoverRadius\" : \"10\"\r\n" + 
				"    }, {\r\n" + 
				"      \"label\" : \"dataset - individual point sizes\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(54,162,235)',\r\n" + 
				"      \"borderColor\" : 'rgb(54,162,235)',\r\n" + 
				"      \"data\" : [ 0, 1, 2, 3, 4, 5, 6 ],\r\n" + 
				"      \"fill\" : false,\r\n" + 
				"      \"borderDash\" : [ \"5\", \"5\" ],\r\n" + 
				"      \"pointRadius\" : [ 2, 4, 6, 18, 0, 12, 20 ]\r\n" + 
				"    }, {\r\n" + 
				"      \"label\" : \"dataset - large pointHoverRadius\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(75,192,192)',\r\n" + 
				"      \"borderColor\" : 'rgb(75,192,192)',\r\n" + 
				"      \"data\" : [ 0, 1, 2, 3, 4, 5, 6 ],\r\n" + 
				"      \"fill\" : false,\r\n" + 
				"      \"pointHoverRadius\" : \"30\"\r\n" + 
				"    }, {\r\n" + 
				"      \"label\" : \"dataset - large pointHitRadius\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(255,205,86)',\r\n" + 
				"      \"borderColor\" : 'rgb(255,205,86)',\r\n" + 
				"      \"data\" : [ 0, 1, 2, 3, 4, 5, 6 ],\r\n" + 
				"      \"fill\" : false,\r\n" + 
				"      \"pointHitRadius\" : \"20\"\r\n" + 
				"    } ]\r\n" + 
				"  },\r\n" + 
				"  \"options\" : {\r\n" + 
				"    \"responsive\" : true,\r\n" + 
				"    \"title\" : {\r\n" + 
				"      \"display\" : true,\r\n" + 
				"      \"text\" : \"Chart.js Line Chart with Different Point Sizes\"\r\n" + 
				"    },\r\n" + 
				"    \"tooltips\" : {\r\n" + 
				"      \"mode\" : \"index\",\r\n" + 
				"      \"intersect\" : false\r\n" + 
				"    },\r\n" + 
				"    \"hover\" : {\r\n" + 
				"      \"mode\" : \"nearest\",\r\n" + 
				"      \"intersect\" : true\r\n" + 
				"    },\r\n" + 
				"    \"scales\" : {\r\n" + 
				"      \"xAxes\" : [ {\r\n" + 
				"        \"display\" : true,\r\n" + 
				"        \"scaleLabel\" : {\r\n" + 
				"          \"display\" : true,\r\n" + 
				"          \"labelString\" : \"Month\"\r\n" + 
				"        }\r\n" + 
				"      } ],\r\n" + 
				"      \"yAxes\" : [ {\r\n" + 
				"        \"display\" : true,\r\n" + 
				"        \"scaleLabel\" : {\r\n" + 
				"          \"display\" : true,\r\n" + 
				"          \"labelString\" : \"Value\"\r\n" + 
				"        }\r\n" + 
				"      } ]\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		System.out.println(test());
		assertTrue(test().compareTo(result) == 0);
	}
	
	public static String test() {
		ChartConfiguration config = new ChartConfiguration().setType(ChartType.LINE).setData(exampleData());
		Options options = new Options()
				.setResponsive(true)
				.setTitle(new Title()
						.setDisplay(true)
						.setText("Chart.js Line Chart with Different Point Sizes"))
				.setTooltips(new Tooltips()
						.setMode(TooltipMode.INDEX)
						.setIntersect(false))
				.setHover(new Hover()
						.setMode(HoverMode.NEAREST)
						.setIntersect(true))
				.setScales(new Scales()
						.setXAxes(new AxesScale()
								.setDisplay(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Month")))
						.setYAxes(new AxesScale()
								.setDisplay(true)
								.setScaleLabel(new ScaleLabel()
										.setDisplay(true)
										.setLabelString("Value"))))
				;
		config.setOptions(options);
				
		JsonRenderer renderer = new JsonRenderer();
				
		return renderer.toJson(config);
	}
	
	private static Data exampleData(){
		Data data = new Data();
		data.setDatasets(new ArrayList<Dataset>());
		
		data.setLabels(TextLabel.of("January", "February", "March", "April", "May", "June", "July", "August",
						"September", "October", "November", "December"));
		
		Dataset dataset1 = new Dataset()
				.setLabel("dataset - big points")
				.setBackgroundColor(SimpleColor.RED)
				.setBorderColor(SimpleColor.RED)
				.setData(IntegerValue.of(integerList(7)))
				.setPointRadius(Collections.nCopies(7, 15))
				.setPointHoverRadius("10")
				.setFill(false);
		
		
		Dataset dataset2 = new Dataset()
				.setLabel("dataset - individual point sizes")
				.setBackgroundColor(SimpleColor.BLUE)
				.setBorderColor(SimpleColor.BLUE)
				.setBorderDash(Arrays.asList("5", "5"))
				.setPointRadius(Arrays.asList(2, 4, 6, 18, 0, 12, 20))
				.setData(IntegerValue.of(integerList(7)))
				.setFill(false);
		
		Dataset dataset3 = new Dataset()
				.setLabel("dataset - large pointHoverRadius")
				.setBackgroundColor(SimpleColor.GREEN)
				.setBorderColor(SimpleColor.GREEN)
				.setData(IntegerValue.of(integerList(7)))
				.setPointHoverRadius("30")
				.setFill(false);
		
		
		Dataset dataset4 = new Dataset()
			.setLabel("dataset - large pointHitRadius")
			.setBackgroundColor(SimpleColor.YELLOW)
			.setBorderColor(SimpleColor.YELLOW)
			.setData(IntegerValue.of(integerList(7)))
			.setPointHitRadius("20")
			.setFill(false);
		
				
		data.getDatasets().add(dataset1);
		data.getDatasets().add(dataset2);
		data.getDatasets().add(dataset3);
		data.getDatasets().add(dataset4);
		return data;
	}
	
	public static List<Integer> integerList(int size){
		List<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			dataList.add(i);
		}
		return dataList;
	}
}