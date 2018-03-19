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

import de.adesso.wickedcharts.highcharts.options.Options;
import de.adesso.wickedcharts.showcase.HomepageHighcharts;
import de.adesso.wickedcharts.wicket7.highcharts.Chart;

import de.adesso.wickedcharts.showcase.ShowcaseSession;
import de.adesso.wickedcharts.showcase.StringFromResourceModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class UpdateHighchartLink extends AjaxLink<Void> {

    private static final long serialVersionUID = 1L;

    private String chartVal;
    private String themeVal;

    /**
     * Constructs a new Link.
     *
     * @param id            the wicket id of the link
     * @param themeVal      the name of the theme that will be used
     */
    public UpdateHighchartLink(final String id, String themeVal) {
        super(id);
        this.chartVal = id;
        this.themeVal = themeVal;
    }


    @Override
    public void onClick(final AjaxRequestTarget target) {
        PageParameters params = new PageParameters();
        params.add("theme", themeVal);
        params.add("chart", chartVal);
        setResponsePage(HomepageHighcharts.class, params);
    }

}