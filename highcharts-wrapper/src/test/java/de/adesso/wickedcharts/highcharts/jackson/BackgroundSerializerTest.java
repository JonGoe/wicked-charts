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

import org.junit.Test;

import de.adesso.wickedcharts.highcharts.jackson.JsonRenderer;
import de.adesso.wickedcharts.highcharts.options.Background;
import de.adesso.wickedcharts.highcharts.options.color.HexColor;

public class BackgroundSerializerTest extends AbstractSerializerTest {

  @Test
  public void testDefaultBackground() {
    // given
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(Background.DEFAULT_BACKGROUND);

    // then
    assertIgnoreWhitespaces("{}", json);
  }

  @Test
  public void testBackground() {
    // given
    Background b = new Background().setBackgroundColor(HexColor.fromString("#FFFFFF"));
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(b);

    // then
    assertIgnoreWhitespaces("{\"backgroundColor\" : \"#ffffff\" }", json);
  }

}
