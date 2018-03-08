package de.adesso.wickedcharts.showcase;
/**
 *   Copyright 2012-2013 Wicked Charts (http://wicked-charts.googlecode.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */


import java.io.Serializable;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.springframework.stereotype.Component;

import de.adesso.wickedcharts.wicket7.chartjs.Chart;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.highcharts.theme.DarkBlueTheme;
import de.adesso.wickedcharts.highcharts.theme.GrayTheme;
import de.adesso.wickedcharts.highcharts.theme.GridTheme;
import de.adesso.wickedcharts.highcharts.theme.SkiesTheme;
import de.adesso.wickedcharts.showcase.configurations.*;
import de.adesso.wickedcharts.showcase.configurations.gridlines.GridLinesBasicConfiguration;
import de.adesso.wickedcharts.showcase.configurations.gridlines.GridLinesChartAreaConfiguration;
import de.adesso.wickedcharts.showcase.configurations.gridlines.GridLinesDisplayFalseConfiguration;
import de.adesso.wickedcharts.showcase.configurations.gridlines.GridLinesDisplayFalseNoBorderConfiguration;
import de.adesso.wickedcharts.showcase.configurations.gridlines.GridLinesTicksConfiguration;
import de.adesso.wickedcharts.showcase.configurations.legendposition.*;
import de.adesso.wickedcharts.showcase.links.ChartjsShowcaseLink;
import de.adesso.wickedcharts.showcase.links.HighchartsShowcaseLink;
import de.adesso.wickedcharts.showcase.links.UpdateChartJsLink;


public class HomepageChartJs extends WebPage implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public HomepageChartJs(final PageParameters parameters) {

    	Fragment optionalMarkup = new Fragment("optionalMarkup","defaultTooltip",this);
    	optionalMarkup.setOutputMarkupId(true);
    	add(optionalMarkup);
        ChartConfiguration config = this.getConfigurationToDisplay();
        final Chart chart = this.getChartFromParams(parameters);
        this.add(chart);
        addNavigationLinks();
        Label codeContainer = this.addCodeContainer();
        this.addChartLinks(chart, codeContainer, optionalMarkup);
    }

	private Label addCodeContainer() {
        Label codeContainer = new Label("code", new StringFromResourceModel(
        		LineChartBasicConfiguration.class, LineChartBasicConfiguration.class.getSimpleName()
                + ".java"));
        codeContainer.setOutputMarkupId(true);
        this.add(codeContainer);
        return codeContainer;
	}
	
	private void addNavigationLinks() {
		this.add(new HighchartsShowcaseLink());
		this.add(new ChartjsShowcaseLink());
	}
	
	private void addChartLinks(Chart chart, Label codeContainer, Fragment optionalMarkup) { 
		this.add(new UpdateChartJsLink("LineChartBasic", chart, codeContainer,
                new LineChartBasicConfiguration()));
        this.add(new UpdateChartJsLink("LineChartMultiAxis", chart, codeContainer,
                new LineChartMultiAxisConfiguration())); 
        this.add(new UpdateChartJsLink("LineChartSteppedBefore", chart, codeContainer,
                new LineChartSteppedBeforeConfiguration())); 
        this.add(new UpdateChartJsLink("LineChartSteppedAfter", chart, codeContainer,
                new LineChartSteppedAfterConfiguration())); 
        this.add(new UpdateChartJsLink("LineChartInterpolated", chart, codeContainer,
                new LineChartInterpolatedConfiguration())); 
        this.add(new UpdateChartJsLink("LineStyles", chart, codeContainer,
                new LineStylesConfiguration())); 
        this.add(new UpdateChartJsLink("PointStyles", chart, codeContainer,
                new PointStylesConfiguration())); 
        this.add(new UpdateChartJsLink("PointSizes", chart, codeContainer,
                new LineChartWithDifferentPointSizesConfiguration())); 
        this.add(new UpdateChartJsLink("BarChartVertical", chart, codeContainer,
                new BarChartVerticalConfiguration()));
        this.add(new UpdateChartJsLink("BarChartHorizontal", chart, codeContainer,
                new BarChartHorizontalConfiguration()));
        this.add(new UpdateChartJsLink("BarChartStacked", chart, codeContainer,
                new BarChartStackedConfiguration()));
        this.add(new UpdateChartJsLink("BarChartStackedGroup", chart, codeContainer,
                new BarChartStackedGroupConfiguration()));
        this.add(new UpdateChartJsLink("BarChartMultiAxis", chart, codeContainer,
                new BarChartMultiAxisConfiguration()));
        this.add(new UpdateChartJsLink("PieChart", chart, codeContainer,
                new PieChartConfiguration())); 
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartFalse", chart, codeContainer,
                new AreaLineBoundariesChartFalseConfiguration())); 
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartStart", chart, codeContainer,
                new AreaLineBoundariesChartStartConfiguration())); 
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartEnd", chart, codeContainer,
                new AreaLineBoundariesChartEndConfiguration())); 
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartOrigin", chart, codeContainer,
                new AreaLineBoundariesChartOriginConfiguration())); 
        this.add(new UpdateChartJsLink("LineChartStacked", chart, codeContainer,
                new LineChartStackedConfiguration()));
        this.add(new UpdateChartJsLink("LineChartDataset", chart, codeContainer,
                new LineChartAreaDatasetConfiguration()));
        this.add(new UpdateChartJsLink("RadarChart", chart, codeContainer,
                new RadarChartConfiguration()));
        this.add(new UpdateChartJsLink("DoughnutChart", chart, codeContainer,
                new DoughnutChartConfiguration()));
        this.add(new UpdateChartJsLink("PolarAreaChart", chart, codeContainer,
                new PolarAreaChartConfiguration()));
        this.add(new UpdateChartJsLink("ScatterChart", chart, codeContainer,
                new ScatterChartConfiguration()));
        this.add(new UpdateChartJsLink("ScatterChartMultiAxis", chart, codeContainer,
                new ScatterChartMultiAxisConfiguration()));
        this.add(new UpdateChartJsLink("ComboBarLineChart", chart, codeContainer,
                new ComboBarLineChartConfiguration())); 
        this.add(new UpdateChartJsLink("LegendPositionTop", chart, codeContainer,
                new LegendPositionTopConfiguration())); 
        this.add(new UpdateChartJsLink("LegendPositionRight", chart, codeContainer,
                new LegendPositionRightConfiguration())); 
        this.add(new UpdateChartJsLink("LegendPositionBottom", chart, codeContainer,
                new LegendPositionBottomConfiguration())); 
        this.add(new UpdateChartJsLink("LegendPositionLeft", chart, codeContainer,
                new LegendPositionLeftConfiguration())); 
        this.add(new UpdateChartJsLink("StepSize", chart, codeContainer,
                new LinearStepSizeConfiguration())); 
        this.add(new UpdateChartJsLink("MinMax", chart, codeContainer,
                new MinMaxConfiguration())); 
        this.add(new UpdateChartJsLink("MinMaxSuggested", chart, codeContainer,
                new MinMaxSuggestedConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesBasic", chart, codeContainer,
                new GridLinesBasicConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesDisplayFalse", chart, codeContainer,
                new GridLinesDisplayFalseConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesDisplayFalseNoBorder", chart, codeContainer,
                new GridLinesDisplayFalseNoBorderConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesChartArea", chart, codeContainer,
                new GridLinesChartAreaConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesTicks", chart, codeContainer,
                new GridLinesTicksConfiguration())); 
        this.add(new UpdateChartJsLink("GridLinesStyle", chart, codeContainer,
                new GridLineStylesConfiguration())); 
        this.add(new UpdateChartJsLink("MultilineLabels", chart, codeContainer,
                new MultilineLabelsConfiguration()));
        this.add(new UpdateChartJsLink("LogarithmicLineChart", chart, codeContainer,
                new LogarithmicLineChartConfiguration()));
        this.add(new UpdateChartJsLink("LogarithmicScatterChart", chart, codeContainer,
                new LogarithmicScatterChartConfiguration()));
        this.add(new UpdateChartJsLink("BubbleChart", chart, codeContainer,
                new BubbleChartConfiguration()));
        this.add(new UpdateChartJsLink("FilteringLabels", chart, codeContainer,
                new FilteringLabelsConfiguration()));
        this.add(new UpdateChartJsLink("TimeLine", chart, codeContainer,
                new TimeLineConfiguration())); 
        this.add(new UpdateChartJsLink("NonNumeric", chart, codeContainer,
                new NonNumericConfiguration())); 
        this.add(new UpdateChartJsLink("TimePoint", chart, codeContainer,
                new TimePointConfiguration())); 
        this.add(new UpdateChartJsLink("TimeSeries", chart, codeContainer,
                new TimeSeriesConfiguration())); 
        this.add(new UpdateChartJsLink("TimeCombo", chart, codeContainer,
                new TimeComboConfiguration())); 
        this.add(new UpdateChartJsLink("OtherRadar", chart, codeContainer,
                new OtherRadarChartConfiguration()));  
        this.add(new UpdateChartJsLink("TooltipCallbacks", chart, codeContainer,
                new TooltipCallbacksConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipBorder", chart, codeContainer,
                new TooltipBorderConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipHtmlLine", chart, codeContainer,
                new TooltipHtmlLineConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipHtmlPie", chart, codeContainer,
                new TooltipHtmlPieConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipHtmlPoints", chart, codeContainer,
                new TooltipHtmlPointsConfiguration())); 
        this.add(new UpdateChartJsLink("LegendPointStyle", chart, codeContainer,
               new LegendPointStyleConfiguration())); 
        this.add(new UpdateChartJsLink("LineChartProgressBar", chart, codeContainer,
                new LineChartProgressBarConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipAverage", chart, codeContainer,
                new TooltipAverageConfiguration())); 
        this.add(new UpdateChartJsLink("TooltipNearest", chart, codeContainer,
                new TooltipNearestConfiguration()));
        this.add(new UpdateChartJsLink("DataLabellingChart", chart, codeContainer,
                new DataLabellingChartConfiguration()));
	}
	
	private int getSelectedChart() {
        String chart = this.getPageParameters().get("charts").toString();

        if ("line".equals(chart)) {
            return 1;
        } else if ("barChart".equals(chart)) {
            return 2;
        } else if ("gray".equals(chart)) {
            return 3;
        } else if ("darkblue".equals(chart)) {
            return 4;
        } else if ("darkgreen".equals(chart)) {
            return 5;
        } else {
            return 0;
        }
    }
    
    private Chart getChartFromParams(final PageParameters params) {
    	
        String chartString = params.get("charts").toString();
        Chart config;
        if(chartString == null) {
    		return new Chart("chart", new LineChartBasicConfiguration()); 
    	}
        switch(chartString) {
        	
        	case "line":
        		config = new Chart("chart", new LineChartBasicConfiguration());
        		break;

        	case "barVertical":
        		config = new Chart("chart", new BarChartVerticalConfiguration());
        		break;
        	
        	case "barHorizontal":
        		config = new Chart("chart", new BarChartHorizontalConfiguration());
        		break;
        		
        	case "barStacked":
        		config = new Chart("chart", new BarChartStackedConfiguration());
        		break;
        		
        	case "barStackedGroup":
        		config = new Chart("chart", new BarChartStackedGroupConfiguration());
        		break;
        		
        	case "lineMultiAxis":
        		config = new Chart("chart", new LineChartMultiAxisConfiguration());
        		break;
        		
        	case "lineSteppedBefore":
        		config = new Chart("chart", new LineChartSteppedBeforeConfiguration());
        		break;
        		
        	case "lineSteppedAfter":
        		config = new Chart("chart", new LineChartSteppedAfterConfiguration());
        		break;
        		
        	case "lineInterpolated":
        		config = new Chart("chart", new LineChartInterpolatedConfiguration());
        		break;
        		
        	case "lineStyles":
        		config = new Chart("chart", new LineStylesConfiguration());
        		break;
        		
        	case "pointStyles":
        		config = new Chart("chart", new PointStylesConfiguration());
        		break;
        		
        	case "pointSizes":
        		config = new Chart("chart", new LineChartWithDifferentPointSizesConfiguration());
        		break;
        		
        	case "AreaBoundariesStart":
        		config = new Chart("chart", new AreaLineBoundariesChartStartConfiguration());
        		break;
        		
        	case "AreaBoundariesEnd":
        		config = new Chart("chart", new AreaLineBoundariesChartEndConfiguration());
        		break;
        		
        	case "AreaBoundariesOrigin":
        		config = new Chart("chart", new AreaLineBoundariesChartOriginConfiguration());
        		break;
        		
        	case "AreaBoundariesFalse":
        		config = new Chart("chart", new AreaLineBoundariesChartFalseConfiguration());
        		break;
        		
        	case "lineDataset":
        		config = new Chart("chart", new LineChartAreaDatasetConfiguration());
        		break;
        		
        	case "lineStacked":
        		config = new Chart("chart", new LineChartStackedConfiguration());
        		break;
        		
        	case "radar":
        		config = new Chart("chart", new RadarChartConfiguration());
        		break;
        		
        	case "scatter":
        		config = new Chart("chart", new ScatterChartConfiguration());
        		break;
        		
        	case "scatterMultiAxis":
        		config = new Chart("chart", new ScatterChartMultiAxisConfiguration());
        		break;
        		
        	case "doughnut":
        		config = new Chart("chart", new DoughnutChartConfiguration());
        		break;
        		
        	case "pie":
        		config = new Chart("chart", new PieChartConfiguration());
        		break;
        		
        	case "polarArea":
        		config = new Chart("chart", new PolarAreaChartConfiguration());
        		break;
        		
        	case "radar2":
        		config = new Chart("chart", new OtherRadarChartConfiguration());
        		break;
        		
        	case "comboBarLine":
        		config = new Chart("chart", new LinearStepSizeConfiguration());
        		break;
        		
        	case "stepSize":
        		config = new Chart("chart", new MinMaxConfiguration());
        		break;
        		
        	case "minMax":
        		config = new Chart("chart", new MinMaxSuggestedConfiguration());
        		break;
        		
        	case "minMaxSuggested":
        		config = new Chart("chart", new LogarithmicLineChartConfiguration());
        		break;
        		
        	case "logarithimicLine":
        		config = new Chart("chart", new LogarithmicScatterChartConfiguration());
        		break;
        		
        	case "logarithimicScatter":
        		config = new Chart("chart", new TimeLineConfiguration());
        		break;
        		
        	case "timeLine":
        		config = new Chart("chart", new TimePointConfiguration());
        		break;
        	
        	case "timePoint":
        		config = new Chart("chart", new TimeSeriesConfiguration());
        		break;

        	case "timeSeries":
        		config = new Chart("chart", new TimeComboConfiguration());
        		break;
        		
        	case "timeCombo":
        		config = new Chart("chart", new GridLinesBasicConfiguration());
        		break;
        		
        	case "gridLinesBasic":
        		config = new Chart("chart", new GridLinesBasicConfiguration());
        		break;
        		
        	case "gridLinesFalse":
        		config = new Chart("chart", new GridLinesDisplayFalseConfiguration());
        		break;
        		
        	case "gridLinesFalseNoBorder":
        		config = new Chart("chart", new GridLinesDisplayFalseNoBorderConfiguration());
        		break;
        		
        	case "gridLinesArea":
        		config = new Chart("chart", new GridLinesChartAreaConfiguration());
        		break;
        		
        	case "gridLinesStyle":
        		config = new Chart("chart", new GridLineStylesConfiguration());
        		break;
        		
        	case "nonNumeric":
        		config = new Chart("chart", new NonNumericConfiguration());
        		break;
        		
        	case "legendPositionTop":
        		config = new Chart("chart", new LegendPositionTopConfiguration());
        		break;
        		
        	case "legendPositionRight":
        		config = new Chart("chart", new LegendPositionRightConfiguration());
        		break;
        		
        	case "legendPositionBottom":
        		config = new Chart("chart", new LegendPositionBottomConfiguration());
        		break;
        		
        	case "legendPositionLeft":
        		config = new Chart("chart", new LegendPositionLeftConfiguration());
        		break;
        		
        	case "legendPointStyle":
        		config = new Chart("chart", new LegendPointStyleConfiguration());
        		break;
        		
        	case "tooltipCallbacks":
        		config = new Chart("chart", new TooltipCallbacksConfiguration());
        		break;
        		
        	case "tooltipBorder":
        		config = new Chart("chart", new TooltipBorderConfiguration());
        		break;
        		
        	case "tooltipAverage":
        		config = new Chart("chart", new TooltipAverageConfiguration());
        		break;
        		
        	case "tooltipNearest":
        		config = new Chart("chart", new TooltipNearestConfiguration());
        		break;
        		
        	case "tooltipHtmlLine":
        		config = new Chart("chart", new TooltipHtmlLineConfiguration());
        		break;
        		
        	case "tooltipHtmlPie":
        		config = new Chart("chart", new TooltipHtmlPieConfiguration());
        		break;
        		
        	case "tooltipHtmlPoints":
        		config = new Chart("chart", new TooltipHtmlPointsConfiguration());
        		break;
        		
        	case "multiLineLabels":
        		config = new Chart("chart", new MultilineLabelsConfiguration());
        		break;
        		
        	case "bubble":
        		config = new Chart("chart", new BubbleChartConfiguration());
        		break;
        		
        	case "lineProgressBar":
        		config = new Chart("chart", new LineChartProgressBarConfiguration());
        		break;
        		
        	case "dataLabelling":
        		config = new Chart("chart", new DataLabellingChartConfiguration());
        		break;
        		
        	default:
        		config = new Chart("line", new LineChartBasicConfiguration());
        		break;
        }
       return config; 
    }

	private ChartConfiguration getConfigurationToDisplay() {
        ChartConfiguration config = ((ShowcaseSession) this.getSession())
                .getCurrentChartjsConfiguration();
        if (config == null) {
        	config = new LineChartBasicConfiguration();
        }
        return config;
	}
	
}
