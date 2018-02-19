package de.adesso.wickedcharts.chartjs.charts.configurations;

import java.util.ArrayList;
import java.util.Arrays;
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


public class MinMaxConfigurationTest {
	
	@Test
	public void minMaxConfigurationTest() {
		String result = "{\r\n" + 
				"  \"type\" : \"line\",\r\n" + 
				"  \"data\" : {\r\n" + 
				"    \"labels\" : [ \"January\", \"February\", \"March\", \"April\", \"May\", \"June\", \"July\", \"August\", \"September\", \"October\", \"November\", \"December\" ],\r\n" + 
				"    \"datasets\" : [ {\r\n" + 
				"      \"label\" : \"My First dataset\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(255,99,132)',\r\n" + 
				"      \"borderColor\" : 'rgb(255,99,132)',\r\n" + 
				"      \"data\" : [ 10, 30, 39, 20, 25, 34, -10 ],\r\n" + 
				"      \"fill\" : false\r\n" + 
				"    }, {\r\n" + 
				"      \"label\" : \"My Second dataset\",\r\n" + 
				"      \"backgroundColor\" : 'rgb(54,162,235)',\r\n" + 
				"      \"borderColor\" : 'rgb(54,162,235)',\r\n" + 
				"      \"data\" : [ 100, 33, 22, 19, 11, 49, 30 ],\r\n" + 
				"      \"fill\" : false\r\n" + 
				"    } ]\r\n" + 
				"  },\r\n" + 
				"  \"options\" : {\r\n" + 
				"    \"responsive\" : true,\r\n" + 
				"    \"title\" : {\r\n" + 
				"      \"display\" : true,\r\n" + 
				"      \"text\" : \"Min and Max Settings\"\r\n" + 
				"    },\r\n" + 
				"    \"scales\" : {\r\n" + 
				"      \"yAxes\" : [ {\r\n" + 
				"        \"ticks\" : {\r\n" + 
				"          \"min\" : 10,\r\n" + 
				"          \"max\" : 50\r\n" + 
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
						.setText("Min and Max Settings"))
				.setScales(new Scales()
						.setYAxes(new AxesScale()
								.setTicks(new Ticks()
										.setMin(10)
										.setMax(50))))
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
				.setLabel("My First dataset")
				.setBackgroundColor(SimpleColor.RED)
				.setBorderColor(SimpleColor.RED)
				.setData(IntegerValue.of(Arrays.asList(10, 30, 39, 20, 25, 34, -10)))
				.setFill(false);
		
		Dataset dataset2 = new Dataset()
				.setLabel("My Second dataset")
				.setBackgroundColor(SimpleColor.BLUE)
				.setBorderColor(SimpleColor.BLUE)
				.setData(IntegerValue.of(Arrays.asList(100, 33, 22, 19, 11, 49, 30)))
				.setFill(false);
		
		data.getDatasets().add(dataset1);
		data.getDatasets().add(dataset2);
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