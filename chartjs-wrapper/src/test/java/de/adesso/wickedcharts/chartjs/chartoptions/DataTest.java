package de.adesso.wickedcharts.chartjs.chartoptions;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.adesso.wickedcharts.chartjs.chartoptions.Data;
import de.adesso.wickedcharts.chartjs.chartoptions.label.Label;
import de.adesso.wickedcharts.chartjs.chartoptions.label.TextLabel;


public class DataTest {

	Data testData;
	List<Label> labelList;
	
	@Before
	public void setUp() throws Exception {
		testData = new Data();
		labelList = Arrays.asList(new TextLabel("foo"), new TextLabel("bar"));
	}

	@Test
	public void testSetStringLabels() {
		List<String> list = Arrays.asList("foo","bar");
		testData.setLabels(TextLabel.of(list));
		assertEquals(testData.getLabels(),labelList);
	}


	@Test
	public void testSetLabelList() {
		testData.setLabels(labelList);
		assertEquals(testData.getLabels(),labelList);
	}

}
