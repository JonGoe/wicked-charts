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


import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.adesso.wickedcharts.showcase.configurations.gridlines.*;
import de.adesso.wickedcharts.showcase.links.UpdateThemeLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.INamedParameters;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import de.adesso.wickedcharts.wicket7.chartjs.Chart;
import de.adesso.wickedcharts.showcase.configurations.*;
import de.adesso.wickedcharts.showcase.configurations.legendposition.*;
import de.adesso.wickedcharts.showcase.links.ChartjsShowcaseLink;
import de.adesso.wickedcharts.showcase.links.HighchartsShowcaseLink;
import de.adesso.wickedcharts.showcase.links.UpdateChartJsLink;

public class HomepageChartJs extends WebPage implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public HomepageChartJs(final PageParameters parameters) {
        addCharts(parameters);
        addNavigationLinks();
        addChartLinks();
    }

    private void addCharts(PageParameters parameters){

        List<Chart> charts = getChartFromParams(parameters);

        //Add Charts
        if(charts.size() > 1){
            List<SmallChartComponent> components = new ArrayList<>();
            for(Chart i : charts){
                components.add(new SmallChartComponent(i));
            }
            add( new ListView<SmallChartComponent>( "components", components ){
                protected void populateItem(ListItem item)
                {
                    item.add( (SmallChartComponent)item.getModelObject() );
                }
            });
        }else {
            List<ChartComponent> components = new ArrayList<>();
            for (Chart i : charts) {
                components.add(new ChartComponent(i));
            }
            add( new ListView<ChartComponent>( "components", components ){
                protected void populateItem(ListItem item)
                {
                    item.add( (ChartComponent)item.getModelObject() );
                }
            });
        }

        //Add Code Components
        List<CodeComponent> code_components = new ArrayList<>();
        for(Chart i : charts){
            code_components.add(new CodeComponent(i));
        }
        add( new ListView<CodeComponent>( "code_components", code_components ){
            protected void populateItem(ListItem item){
                item.add( (CodeComponent)item.getModelObject() );
            }
        });
    }
	
	private void addNavigationLinks() {
		this.add(new HighchartsShowcaseLink());
		this.add(new ChartjsShowcaseLink());
	}
	
	private void addChartLinks() {
        this.add(new UpdateChartJsLink("LineChartBasic", "lineBasic"));
		this.add(new UpdateChartJsLink("BarChartVertical" , "barVertical"));
        this.add(new UpdateChartJsLink("LineChartMultiAxis", "lineMultiAxis"));
        this.add(new UpdateChartJsLink("LineChartStepped", "lineStepped"));
        this.add(new UpdateChartJsLink("LineChartInterpolated", "lineInterpolated"));
        this.add(new UpdateChartJsLink("LineStyles", "lineStyles"));
        this.add(new UpdateChartJsLink("PointStyles", "pointStyles"));
        this.add(new UpdateChartJsLink("PointSizes", "pointSizes"));
        this.add(new UpdateChartJsLink("BarChartHorizontal", "barHorizontal"));
        this.add(new UpdateChartJsLink("BarChartStacked", "barStacked"));
        this.add(new UpdateChartJsLink("BarChartStackedGroup", "barStackedGroup"));
        this.add(new UpdateChartJsLink("BarChartMultiAxis", "barMultiAxis"));
        this.add(new UpdateChartJsLink("PieChart", "pie"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChart", "areaLineBoundaries"));
        this.add(new UpdateChartJsLink("LineChartStacked", "lineStacked"));
        this.add(new UpdateChartJsLink("LineChartDataset", "lineDataset"));
        this.add(new UpdateChartJsLink("RadarChart", "radar"));
        this.add(new UpdateChartJsLink("DoughnutChart", "doughnut"));
        this.add(new UpdateChartJsLink("PolarAreaChart", "polarArea"));
        this.add(new UpdateChartJsLink("ScatterChart", "scatter"));
        this.add(new UpdateChartJsLink("ScatterChartMultiAxis", "scatterMultiAxis"));
        this.add(new UpdateChartJsLink("ComboBarLineChart", "comboBarLine"));
        this.add(new UpdateChartJsLink("LegendPosition", "legendPosition"));
        this.add(new UpdateChartJsLink("StepSize", "stepSize"));
        this.add(new UpdateChartJsLink("MinMax", "minMax"));
        this.add(new UpdateChartJsLink("GridLines", "gridLines"));
        this.add(new UpdateChartJsLink("MultilineLabels", "multiLineLabels"));
        this.add(new UpdateChartJsLink("LogarithmicLineChart", "lineLogarithmic"));
        this.add(new UpdateChartJsLink("LogarithmicScatterChart", "scatterLogarithmic"));
        this.add(new UpdateChartJsLink("BubbleChart", "bubble"));
        this.add(new UpdateChartJsLink("FilteringLabels", "filteringLabels"));
        this.add(new UpdateChartJsLink("TimeLine", "timeLine"));
        this.add(new UpdateChartJsLink("NonNumeric", "nonNumeric"));
        this.add(new UpdateChartJsLink("TimePoint", "timePoint"));
        this.add(new UpdateChartJsLink("TimeSeries", "timeSeries"));
        this.add(new UpdateChartJsLink("TimeCombo", "timeCombo"));
        this.add(new UpdateChartJsLink("OtherRadar", "radar2"));
        this.add(new UpdateChartJsLink("Tooltip", "tooltip"));
        this.add(new UpdateChartJsLink("TooltipHtml", "tooltipHtml"));
        this.add(new UpdateChartJsLink("LegendPointStyle", "legendPointStyle"));
        this.add(new UpdateChartJsLink("LineChartProgressBar", "lineProgressBar"));
        this.add(new UpdateChartJsLink("DataLabellingChart", "dataLabelling"));
	}
    
    private List<Chart> getChartFromParams(final PageParameters params) {
        String chartString;
        List<Chart> config = new ArrayList<>();

        //Get the parameters of the page
        List<INamedParameters.NamedPair> pairs = params.getAllNamed();

        //If the showcase is started without any parameters
        //set the parameters to lineBasic and give us a line Chart
        if(params.getAllNamed().size() == 0){
            PageParameters temp = new PageParameters();
            temp.add("chart", "lineBasic");
            setResponsePage(HomepageChartJs.class, temp);
            config.add(new Chart("chart", new LineChartBasicConfiguration()));
            return config;
        }

        chartString = params.getAllNamed().get(0).getValue();
        if(chartString == null) {
    		config.add(new Chart("chart", new LineChartBasicConfiguration()));
    		return config;
    	}

        switch(chartString) {

            case "barVertical":
                config.add(new Chart("chart", new BarChartVerticalConfiguration()));
                break;

            case "barHorizontal":
                config.add(new Chart("chart", new BarChartHorizontalConfiguration()));
                break;

            case "barMultiAxis":
                config.add(new Chart("chart", new BarChartMultiAxisConfiguration()));
                break;

            case "barStacked":
                config.add(new Chart("chart", new BarChartStackedConfiguration()));
                break;

            case "barStackedGroup":
                config.add(new Chart("chart", new BarChartStackedGroupConfiguration()));
                break;

            case "lineBasic":
                config.add(new Chart("chart", new LineChartBasicConfiguration()));
                break;

            case "lineMultiAxis":
                config.add(new Chart("chart", new LineChartMultiAxisConfiguration()));
                break;

            case "lineStepped":
                config.add(new Chart("chart", new LineChartSteppedBeforeConfiguration()));
                config.add(new Chart("chart", new LineChartSteppedAfterConfiguration()));
                break;

            case "lineInterpolated":
                config.add(new Chart("chart", new LineChartInterpolatedConfiguration()));
                break;

            case "lineStyles":
                config.add(new Chart("chart", new LineStylesConfiguration()));
                break;

            case "pointStyles":
                config.add(new Chart("chart", new PointStylesConfiguration()));
                break;

            case "pointSizes":
                config.add(new Chart("chart", new LineChartWithDifferentPointSizesConfiguration()));
                break;

            case "areaLineBoundaries":
                config.add(new Chart("chart", new AreaLineBoundariesChartStartConfiguration()));
                config.add(new Chart("chart", new AreaLineBoundariesChartEndConfiguration()));
                config.add(new Chart("chart", new AreaLineBoundariesChartOriginConfiguration()));
                config.add(new Chart("chart", new AreaLineBoundariesChartFalseConfiguration()));
                break;

            case "lineDataset":
                config.add(new Chart("chart", new LineChartAreaDatasetConfiguration()));
                break;

            case "lineStacked":
                config.add(new Chart("chart", new LineChartStackedConfiguration()));
                break;

            case "radar":
                config.add(new Chart("chart", new RadarChartConfiguration()));
                break;

            case "scatter":
                config.add(new Chart("chart", new ScatterChartConfiguration()));
                break;

            case "scatterMultiAxis":
                config.add(new Chart("chart", new ScatterChartMultiAxisConfiguration()));
                break;

            case "doughnut":
                config.add(new Chart("chart", new DoughnutChartConfiguration()));
                break;

            case "pie":
                config.add(new Chart("chart", new PieChartConfiguration()));
                break;

            case "polarArea":
                config.add(new Chart("chart", new PolarAreaChartConfiguration()));
                break;

            case "radar2":
                config.add(new Chart("chart", new OtherRadarChartConfiguration()));
                break;

            case "comboBarLine":
                config.add(new Chart("chart", new ComboBarLineChartConfiguration()));
                break;

            case "stepSize":
                config.add(new Chart("chart", new LinearStepSizeConfiguration()));
                break;

            case "minMax":
                config.add(new Chart("chart", new MinMaxConfiguration()));
                config.add(new Chart("chart", new MinMaxSuggestedConfiguration()));
                break;

            case "lineLogarithmic":
                config.add(new Chart("chart", new LogarithmicLineChartConfiguration()));
                break;

            case "scatterLogarithmic":
                config.add(new Chart("chart", new LogarithmicScatterChartConfiguration()));
                break;

            case "timeLine":
                config.add(new Chart("chart", new TimeLineConfiguration()));
                break;

            case "timePoint":
                config.add(new Chart("chart", new TimePointConfiguration()));
                break;

            case "timeSeries":
                config.add(new Chart("chart", new TimeSeriesConfiguration()));
                break;

            case "timeCombo":
                config.add(new Chart("chart", new TimeComboConfiguration()));
                break;

            case "gridLines":
                config.add(new Chart("chart", new GridLinesBasicConfiguration()));
                config.add(new Chart("chart", new GridLinesDisplayFalseConfiguration()));
                config.add(new Chart("chart", new GridLinesDisplayFalseNoBorderConfiguration()));
                config.add(new Chart("chart", new GridLinesChartAreaConfiguration()));
                config.add(new Chart("chart", new GridLinesTicksConfiguration()));
                config.add(new Chart("chart", new GridLineStylesConfiguration()));
                break;

            case "multiLineLabels":
                config.add(new Chart("chart", new MultilineLabelsConfiguration()));
                break;

            case "filteringLabels":
                config.add(new Chart("chart", new FilteringLabelsConfiguration()));
                break;

            case "nonNumeric":
                config.add(new Chart("chart", new NonNumericConfiguration()));
                break;

            case "legendPosition":
                config.add(new Chart("chart", new LegendPositionTopConfiguration()));
                config.add(new Chart("chart", new LegendPositionRightConfiguration()));
                config.add(new Chart("chart", new LegendPositionBottomConfiguration()));
                config.add(new Chart("chart", new LegendPositionLeftConfiguration()));
                break;

            case "legendPointStyle":
                config.add(new Chart("chart", new LegendPointStyleConfiguration()));
                break;

            case "tooltip":
                config.add(new Chart("chart", new TooltipBorderConfiguration()));
                config.add(new Chart("chart", new TooltipCallbacksConfiguration()));
                config.add(new Chart("chart", new TooltipAverageConfiguration()));
                config.add(new Chart("chart", new TooltipNearestConfiguration()));
                break;

            case "tooltipHtml":
                config.add(new Chart("chart", new TooltipHtmlLineConfiguration()));
                config.add(new Chart("chart", new TooltipHtmlPieConfiguration()));
                config.add(new Chart("chart", new TooltipHtmlPointsConfiguration()));
                break;

            case "bubble":
                config.add(new Chart("chart", new BubbleChartConfiguration()));
                break;

            case "lineProgressBar":
                config.add(new Chart("chart", new LineChartProgressBarConfiguration()));
                break;

            case "dataLabelling":
                config.add(new Chart("chart", new DataLabellingChartConfiguration()));
                break;

            default:
                config.add(new Chart("chart", new LineChartBasicConfiguration()));
                break;
        }
        return config;
    }
}
