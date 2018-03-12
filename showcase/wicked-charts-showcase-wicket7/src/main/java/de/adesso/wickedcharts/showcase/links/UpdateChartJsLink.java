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
package de.adesso.wickedcharts.showcase.links;

import de.adesso.wickedcharts.wicket7.chartjs.Chart;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.showcase.HomepageChartJs;
import de.adesso.wickedcharts.showcase.ShowcaseSession;
import de.adesso.wickedcharts.showcase.StringFromResourceModel;
import de.adesso.wickedcharts.showcase.configurations.base.ShowcaseConfiguration;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UpdateChartJsLink extends AjaxLink<Void> {

    private static final long serialVersionUID = 1L;

    private String chartVal;

    /**
     * Constructs a new Link.
     *
     * @param id            the wicket id of the link
     * @param chart         the container containing the chart
     * @param codeContainer the container containing the code display of the chart's options
     */
    public UpdateChartJsLink(final String id, String val) {
        super(id);
        this.chartVal = val;
    }

    @Override
    public void onClick(final AjaxRequestTarget target) {
        PageParameters params = new PageParameters();
        params.add("chart", chartVal);
        setResponsePage(HomepageChartJs.class, params);
    }
}
