package de.adesso.wickedcharts.showcase;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.showcase.configurations.base.ShowcaseConfiguration;
import de.adesso.wickedcharts.wicket7.chartjs.Chart;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.internal.Enclosure;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;

public class CodeComponent extends Panel {

    public CodeComponent(Chart chart)
    {
        super("code");
        ChartConfiguration chartConfig = chart.getChartConfiguration();
        Label codeContainer = new Label("code", new StringFromResourceModel(
                chartConfig.getClass(), chartConfig.getClass().getSimpleName()
                + ".java"));
        codeContainer.setOutputMarkupId (true);
        this.add(codeContainer);
    }
}