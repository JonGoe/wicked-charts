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
    	Fragment optionalMarkup = new Fragment("optionalMarkup","defaultTooltip",this);
        Chart chart = this.getChartFromParams(parameters);
        this.add(chart);
        chart.getParent().add(optionalMarkup);
        ((ShowcaseConfiguration)chart.getChartConfiguration()).modfiyIndividualMarkup((Fragment)chart.getParent().get("optionalMarkup"));
        ((Fragment) chart.getParent().get("optionalMarkup")).detach();
        optionalMarkup = (Fragment) chart.getParent().get("optionalMarkup");
        this.add(optionalMarkup);
        optionalMarkup.setOutputMarkupId(true);
        addNavigationLinks();
        Label codeContainer = this.addCodeContainer(parameters);
        this.addChartLinks(chart, codeContainer, optionalMarkup);
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
	
	private void addChartLinks(Chart chart, Label codeContainer, Fragment optionalMarkup) { 
		this.add(new UpdateChartJsLink("LineChartBasic", chart, codeContainer,
                new LineChartBasicConfiguration(), this, "lineBasic"));
		this.add(new UpdateChartJsLink("BarChartVertical", chart, codeContainer,
                new BarChartVerticalConfiguration(), this, "barVertical"));
        this.add(new UpdateChartJsLink("LineChartMultiAxis", chart, codeContainer,
                new LineChartMultiAxisConfiguration(), this, "lineMultiAxis"));
        this.add(new UpdateChartJsLink("LineChartSteppedBefore", chart, codeContainer,
                new LineChartSteppedBeforeConfiguration(), this, "lineSteppedBefore"));
        this.add(new UpdateChartJsLink("LineChartSteppedAfter", chart, codeContainer,
                new LineChartSteppedAfterConfiguration(), this, "lineSteppedAfter"));
        this.add(new UpdateChartJsLink("LineChartInterpolated", chart, codeContainer,
                new LineChartInterpolatedConfiguration(), this, "lineInterpolated"));
        this.add(new UpdateChartJsLink("LineStyles", chart, codeContainer,
                new LineStylesConfiguration(),this, "lineStyles"));
        this.add(new UpdateChartJsLink("PointStyles", chart, codeContainer,
                new PointStylesConfiguration(),this, "pointStyles"));
        this.add(new UpdateChartJsLink("PointSizes", chart, codeContainer,
                new LineChartWithDifferentPointSizesConfiguration(),this, "pointSizes"));
        this.add(new UpdateChartJsLink("BarChartHorizontal", chart, codeContainer,
                new BarChartHorizontalConfiguration(),this, "barHorizontal"));
        this.add(new UpdateChartJsLink("BarChartStacked", chart, codeContainer,
                new BarChartStackedConfiguration(),this, "barStacked"));
        this.add(new UpdateChartJsLink("BarChartStackedGroup", chart, codeContainer,
                new BarChartStackedGroupConfiguration(),this, "barStackedGroup"));
        this.add(new UpdateChartJsLink("BarChartMultiAxis", chart, codeContainer,
                new BarChartMultiAxisConfiguration(),this, "barMultiAxis"));
        this.add(new UpdateChartJsLink("PieChart", chart, codeContainer,
                new PieChartConfiguration(),this, "pie"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartFalse", chart, codeContainer,
                new AreaLineBoundariesChartFalseConfiguration(),this, "areaBoundariesFalse"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartStart", chart, codeContainer,
                new AreaLineBoundariesChartStartConfiguration(),this, "areaBoundariesStart"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartEnd", chart, codeContainer,
                new AreaLineBoundariesChartEndConfiguration(),this, "areaBoundariesEnd"));
        this.add(new UpdateChartJsLink("AreaLineBoundariesChartOrigin", chart, codeContainer,
                new AreaLineBoundariesChartOriginConfiguration(),this, "areaBoundariesOrigin"));
        this.add(new UpdateChartJsLink("LineChartStacked", chart, codeContainer,
                new LineChartStackedConfiguration(),this, "lineStacked"));
        this.add(new UpdateChartJsLink("LineChartDataset", chart, codeContainer,
                new LineChartAreaDatasetConfiguration(),this, "lineDataset"));
        this.add(new UpdateChartJsLink("RadarChart", chart, codeContainer,
                new RadarChartConfiguration(),this, "radar"));
        this.add(new UpdateChartJsLink("DoughnutChart", chart, codeContainer,
                new DoughnutChartConfiguration(),this, "doughnut"));
        this.add(new UpdateChartJsLink("PolarAreaChart", chart, codeContainer,
                new PolarAreaChartConfiguration(),this, "polarArea"));
        this.add(new UpdateChartJsLink("ScatterChart", chart, codeContainer,
                new ScatterChartConfiguration(),this, "scatter"));
        this.add(new UpdateChartJsLink("ScatterChartMultiAxis", chart, codeContainer,
                new ScatterChartMultiAxisConfiguration(),this, "scatterMultiAxis"));
        this.add(new UpdateChartJsLink("ComboBarLineChart", chart, codeContainer,
                new ComboBarLineChartConfiguration(),this, "comboBarLine"));
        this.add(new UpdateChartJsLink("LegendPositionTop", chart, codeContainer,
                new LegendPositionTopConfiguration(),this, "legendPositionTop"));
        this.add(new UpdateChartJsLink("LegendPositionRight", chart, codeContainer,
                new LegendPositionRightConfiguration(),this, "legendPositionRight"));
        this.add(new UpdateChartJsLink("LegendPositionBottom", chart, codeContainer,
                new LegendPositionBottomConfiguration(),this, "legendPositionBottom"));
        this.add(new UpdateChartJsLink("LegendPositionLeft", chart, codeContainer,
                new LegendPositionLeftConfiguration(),this, "legendPositionLeft"));
        this.add(new UpdateChartJsLink("StepSize", chart, codeContainer,
                new LinearStepSizeConfiguration(),this, "stepSize"));
        this.add(new UpdateChartJsLink("MinMax", chart, codeContainer,
                new MinMaxConfiguration(),this, "minMax"));
        this.add(new UpdateChartJsLink("MinMaxSuggested", chart, codeContainer,
                new MinMaxSuggestedConfiguration(),this, "minMaxSuggested"));
        this.add(new UpdateChartJsLink("GridLinesBasic", chart, codeContainer,
                new GridLinesBasicConfiguration(),this, "gridLinesBasic"));
        this.add(new UpdateChartJsLink("GridLinesDisplayFalse", chart, codeContainer,
                new GridLinesDisplayFalseConfiguration(),this, "gridLinesDisplayFalse"));
        this.add(new UpdateChartJsLink("GridLinesDisplayFalseNoBorder", chart, codeContainer,
                new GridLinesDisplayFalseNoBorderConfiguration(),this, "gridLinesDisplayFalseNoBorder"));
        this.add(new UpdateChartJsLink("GridLinesChartArea", chart, codeContainer,
                new GridLinesChartAreaConfiguration(),this, "gridLinesArea"));
        this.add(new UpdateChartJsLink("GridLinesTicks", chart, codeContainer,
                new GridLinesTicksConfiguration(),this, "gridLinesTicks"));
        this.add(new UpdateChartJsLink("GridLinesStyle", chart, codeContainer,
                new GridLineStylesConfiguration(),this, "gridLinesStyle"));
        this.add(new UpdateChartJsLink("MultilineLabels", chart, codeContainer,
                new MultilineLabelsConfiguration(),this, "multiLineLabels"));
        this.add(new UpdateChartJsLink("LogarithmicLineChart", chart, codeContainer,
                new LogarithmicLineChartConfiguration(),this, "lineLogarithmic"));
        this.add(new UpdateChartJsLink("LogarithmicScatterChart", chart, codeContainer,
                new LogarithmicScatterChartConfiguration(),this, "scatterLogarithmic"));
        this.add(new UpdateChartJsLink("BubbleChart", chart, codeContainer,
                new BubbleChartConfiguration(),this, "bubble"));
        this.add(new UpdateChartJsLink("FilteringLabels", chart, codeContainer,
                new FilteringLabelsConfiguration(),this, "filteringLabels"));
        this.add(new UpdateChartJsLink("TimeLine", chart, codeContainer,
                new TimeLineConfiguration(),this, "timeLine"));
        this.add(new UpdateChartJsLink("NonNumeric", chart, codeContainer,
                new NonNumericConfiguration(),this, "nonNumeric"));
        this.add(new UpdateChartJsLink("TimePoint", chart, codeContainer,
                new TimePointConfiguration(),this, "timePoint"));
        this.add(new UpdateChartJsLink("TimeSeries", chart, codeContainer,
                new TimeSeriesConfiguration(),this, "timeSeries"));
        this.add(new UpdateChartJsLink("TimeCombo", chart, codeContainer,
                new TimeComboConfiguration(),this, "timeCombo"));
        this.add(new UpdateChartJsLink("OtherRadar", chart, codeContainer,
                new OtherRadarChartConfiguration(),this, "radar2"));
        this.add(new UpdateChartJsLink("TooltipCallbacks", chart, codeContainer,
                new TooltipCallbacksConfiguration(),this, "tooltipCallbacks"));
        this.add(new UpdateChartJsLink("TooltipBorder", chart, codeContainer,
                new TooltipBorderConfiguration(),this, "tooltipBorder"));
        this.add(new UpdateChartJsLink("TooltipHtmlLine", chart, codeContainer,
                new TooltipHtmlLineConfiguration(),this, "tooltipHtmlLine"));
        this.add(new UpdateChartJsLink("TooltipHtmlPie", chart, codeContainer,
                new TooltipHtmlPieConfiguration(),this, "tooltipHtmlPie"));
        this.add(new UpdateChartJsLink("TooltipHtmlPoints", chart, codeContainer,
                new TooltipHtmlPointsConfiguration(),this, "tooltipHtmlPoints"));
        this.add(new UpdateChartJsLink("LegendPointStyle", chart, codeContainer,
               new LegendPointStyleConfiguration(),this, "legendPointStyle"));
        this.add(new UpdateChartJsLink("LineChartProgressBar", chart, codeContainer,
                new LineChartProgressBarConfiguration(),this, "lineProgressBar"));
        this.add(new UpdateChartJsLink("TooltipAverage", chart, codeContainer,
                new TooltipAverageConfiguration(),this, "tooltipAverage"));
        this.add(new UpdateChartJsLink("TooltipNearest", chart, codeContainer,
                new TooltipNearestConfiguration(),this, "tooltipNearest"));
        this.add(new UpdateChartJsLink("DataLabellingChart", chart, codeContainer,
                new DataLabellingChartConfiguration(),this, "dataLabelling"));
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
