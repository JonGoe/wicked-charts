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
import java.util.List;

import de.adesso.wickedcharts.showcase.configurations.base.ShowcaseConfiguration;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.request.mapper.parameter.INamedParameters;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import de.adesso.wickedcharts.wicket7.chartjs.Chart;
import de.adesso.wickedcharts.chartjs.ChartConfiguration;
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

        Chart chart = this.getChartFromParams(parameters);
        this.add(chart);

        //Add the optional markup
        Fragment optionalMarkup = new Fragment("optionalMarkup","defaultTooltip",this);
        chart.getParent().add(optionalMarkup);
        ((ShowcaseConfiguration)chart.getChartConfiguration()).modfiyIndividualMarkup((Fragment)chart.getParent().get("optionalMarkup"));
        ((Fragment) chart.getParent().get("optionalMarkup")).detach();
        optionalMarkup = (Fragment) chart.getParent().get("optionalMarkup");
        this.add(optionalMarkup);
        optionalMarkup.setOutputMarkupId(true);

        //Add links to the charts and the code container
        addNavigationLinks();
        addCodeContainer(parameters);
        this.addChartLinks();
    }

	private Label addCodeContainer(final PageParameters parameters) {
        ChartConfiguration chartConfig = getChartFromParams(parameters).getChartConfiguration();
        Label codeContainer = new Label("code", new StringFromResourceModel(
                chartConfig.getClass(), chartConfig.getClass().getSimpleName()
                + ".java"));
        codeContainer.setOutputMarkupId (true);
        this.add(codeContainer);
        return codeContainer;
	}
	
	private void addNavigationLinks() {
		this.add(new HighchartsShowcaseLink());
		this.add(new ChartjsShowcaseLink());
	}
	
	private void addChartLinks() {
        this.add(new UpdateChartJsLink("LineChartBasic", "lineBasic"));
		this.add(new UpdateChartJsLink("BarChartVertical" , "barVertical"));
        this.add(new UpdateChartJsLink("LineChartMultiAxis", "lineMultiAxis"));
        this.add(new UpdateChartJsLink("LineChartSteppedBefore", "lineSteppedBefore"));
        this.add(new UpdateChartJsLink("LineChartSteppedAfter", "lineSteppedAfter"));
        this.add(new UpdateChartJsLink("LineChartInterpolated", "lineInterpolated"));
        this.add(new UpdateChartJsLink("LineStyles", "lineStyles"));
        this.add(new UpdateChartJsLink("PointStyles", "pointStyles"));
        this.add(new UpdateChartJsLink("PointSizes", "pointSizes"));
        this.add(new UpdateChartJsLink("BarChartHorizontal", "barHorizontal"));
        this.add(new UpdateChartJsLink("BarChartStacked", "barStacked"));
        this.add(new UpdateChartJsLink("BarChartStackedGroup", "barStackedGroup"));
        this.add(new UpdateChartJsLink("BarChartMultiAxis", "barMultiAxis"));
        this.add(new UpdateChartJsLink("PieChart", "pie"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartFalse", "areaBoundariesFalse"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartStart", "areaBoundariesStart"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartEnd", "areaBoundariesEnd"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartOrigin", "areaBoundariesOrigin"));
        this.add(new UpdateChartJsLink("LineChartStacked", "lineStacked"));
        this.add(new UpdateChartJsLink("LineChartDataset", "lineDataset"));
        this.add(new UpdateChartJsLink("RadarChart", "radar"));
        this.add(new UpdateChartJsLink("DoughnutChart", "doughnut"));
        this.add(new UpdateChartJsLink("PolarAreaChart", "polarArea"));
        this.add(new UpdateChartJsLink("ScatterChart", "scatter"));
        this.add(new UpdateChartJsLink("ScatterChartMultiAxis", "scatterMultiAxis"));
        this.add(new UpdateChartJsLink("ComboBarLineChart", "comboBarLine"));
        this.add(new UpdateChartJsLink("LegendPositionTop", "legendPositionTop"));
        this.add(new UpdateChartJsLink("LegendPositionRight", "legendPositionRight"));
        this.add(new UpdateChartJsLink("LegendPositionBottom", "legendPositionBottom"));
        this.add(new UpdateChartJsLink("LegendPositionLeft", "legendPositionLeft"));
        this.add(new UpdateChartJsLink("StepSize", "stepSize"));
        this.add(new UpdateChartJsLink("MinMax", "minMax"));
        this.add(new UpdateChartJsLink("MinMaxSuggested", "minMaxSuggested"));
        this.add(new UpdateChartJsLink("GridLinesBasic", "gridLinesBasic"));
        this.add(new UpdateChartJsLink("GridLinesDisplayFalse", "gridLinesDisplayFalse"));
        this.add(new UpdateChartJsLink("GridLinesDisplayFalseNoBorder", "gridLinesDisplayFalseNoBorder"));
        this.add(new UpdateChartJsLink("GridLinesChartArea", "gridLinesArea"));
        this.add(new UpdateChartJsLink("GridLinesTicks", "gridLinesTicks"));
        this.add(new UpdateChartJsLink("GridLinesStyle", "gridLinesStyle"));
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
        this.add(new UpdateChartJsLink("TooltipCallbacks", "tooltipCallbacks"));
        this.add(new UpdateChartJsLink("TooltipBorder", "tooltipBorder"));
        this.add(new UpdateChartJsLink("TooltipHtmlLine", "tooltipHtmlLine"));
        this.add(new UpdateChartJsLink("TooltipHtmlPie", "tooltipHtmlPie"));
        this.add(new UpdateChartJsLink("TooltipHtmlPoints", "tooltipHtmlPoints"));
        this.add(new UpdateChartJsLink("LegendPointStyle", "legendPointStyle"));
        this.add(new UpdateChartJsLink("LineChartProgressBar", "lineProgressBar"));
        this.add(new UpdateChartJsLink("TooltipAverage", "tooltipAverage"));
        this.add(new UpdateChartJsLink("TooltipNearest", "tooltipNearest"));
        this.add(new UpdateChartJsLink("DataLabellingChart", "dataLabelling"));
	}
    
    private Chart getChartFromParams(final PageParameters params) {
        String chartString = null;
        List<INamedParameters.NamedPair> pairs = params.getAllNamed();
        Chart config;
        if(params.getAllNamed().size() == 0){
            PageParameters temp = new PageParameters();
            temp.add("chart", "lineBasic");
            setResponsePage(HomepageChartJs.class, temp);
            return new Chart("chart", new LineChartBasicConfiguration());
        }
        chartString = params.getAllNamed().get(0).getValue();

        if(chartString == null) {
    		return new Chart("chart", new LineChartBasicConfiguration()); 
    	}
        switch(chartString) {

            case "barVertical":
                config = new Chart("chart", new BarChartVerticalConfiguration());
                break;

            case "barHorizontal":
                config = new Chart("chart", new BarChartHorizontalConfiguration());
                break;

            case "barMultiAxis":
                config = new Chart("chart", new BarChartMultiAxisConfiguration());
                break;

            case "barStacked":
                config = new Chart("chart", new BarChartStackedConfiguration());
                break;

            case "barStackedGroup":
                config = new Chart("chart", new BarChartStackedGroupConfiguration());
                break;

            case "lineBasic":
                config = new Chart("chart", new LineChartBasicConfiguration());
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

            case "areaBoundariesStart":
                config = new Chart("chart", new AreaLineBoundariesChartStartConfiguration());
                break;

            case "areaBoundariesEnd":
                config = new Chart("chart", new AreaLineBoundariesChartEndConfiguration());
                break;

            case "areaBoundariesOrigin":
                config = new Chart("chart", new AreaLineBoundariesChartOriginConfiguration());
                break;

            case "areaBoundariesFalse":
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
                config = new Chart("chart", new ComboBarLineChartConfiguration());
                break;

            case "stepSize":
                config = new Chart("chart", new LinearStepSizeConfiguration());
                break;

            case "minMax":
                config = new Chart("chart", new MinMaxConfiguration());
                break;

            case "minMaxSuggested":
                config = new Chart("chart", new MinMaxSuggestedConfiguration());
                break;

            case "lineLogarithmic":
                config = new Chart("chart", new LogarithmicLineChartConfiguration());
                break;

            case "scatterLogarithmic":
                config = new Chart("chart", new LogarithmicScatterChartConfiguration());
                break;

            case "timeLine":
                config = new Chart("chart", new TimeLineConfiguration());
                break;

            case "timePoint":
                config = new Chart("chart", new TimePointConfiguration());
                break;

            case "timeSeries":
                config = new Chart("chart", new TimeSeriesConfiguration());
                break;

            case "timeCombo":
                config = new Chart("chart", new TimeComboConfiguration());
                break;

            case "gridLinesBasic":
                config = new Chart("chart", new GridLinesBasicConfiguration());
                break;

            case "gridLinesDisplayFalse":
                config = new Chart("chart", new GridLinesDisplayFalseConfiguration());
                break;

            case "gridLinesDisplayFalseNoBorder":
                config = new Chart("chart", new GridLinesDisplayFalseNoBorderConfiguration());
                break;

            case "gridLinesArea":
                config = new Chart("chart", new GridLinesChartAreaConfiguration());
                break;

            case "gridLinesTicks":
                config = new Chart("chart", new GridLinesTicksConfiguration());
                break;

            case "gridLinesStyle":
                config = new Chart("chart", new GridLineStylesConfiguration());
                break;

            case "multiLineLabels":
                config = new Chart("chart", new MultilineLabelsConfiguration());
                break;

            case "filteringLabels":
                config = new Chart("chart", new FilteringLabelsConfiguration());
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
                config = new Chart("chart", new LineChartBasicConfiguration());
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
