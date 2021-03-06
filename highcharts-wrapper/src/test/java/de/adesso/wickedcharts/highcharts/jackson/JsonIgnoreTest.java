/**
 * Copyright 2012-2018 Wicked Charts (tom.hombergs@gmail.com)
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
package de.adesso.wickedcharts.highcharts.jackson;

import junit.framework.Assert;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.adesso.wickedcharts.highcharts.jackson.JsonRenderer;
import de.adesso.wickedcharts.highcharts.options.ChartOptions;
import de.adesso.wickedcharts.highcharts.options.Options;
import de.adesso.wickedcharts.highcharts.options.SeriesType;

public class JsonIgnoreTest {

  public class MyOptions extends Options {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private String myIgnoredField = "ignored";

    private String myIncludedField = "included";

    public String getMyIgnoredField() {
      return this.myIgnoredField;
    }

    public String getMyIncludedField() {
      return this.myIncludedField;
    }

    public void setMyIgnoredField(String myIgnoredField) {
      this.myIgnoredField = myIgnoredField;
    }

    public void setMyIncludedField(String myIncludedField) {
      this.myIncludedField = myIncludedField;
    }

  }

  @Test
  public void test() {
    // given
    Options options = new MyOptions();
    ChartOptions chartOptions = new ChartOptions();
    chartOptions.setType(SeriesType.AREA);
    options.setChartOptions(chartOptions);
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(options);

    // then
    Assert.assertFalse(json.contains("myIgnoredField"));
    Assert.assertTrue(json.contains("myIncludedField"));
  }

}
