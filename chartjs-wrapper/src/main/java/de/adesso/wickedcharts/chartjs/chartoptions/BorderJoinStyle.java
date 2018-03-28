package de.adesso.wickedcharts.chartjs.chartoptions;

import de.adesso.wickedcharts.chartjs.json.JsonValueEnum;

/**
 * Determines how two connecting segments (of lines, arcs or curves) with non-zero lengths in a shape are joined together.
 *
 * @see <a
 *      href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineJoin">https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineJoin</a>
 *
 */
public enum BorderJoinStyle implements JsonValueEnum {
	BEVEL("bevel"),
	ROUND("round"),
	MITER("miter");
	
	
	private String jsonValue;

	private BorderJoinStyle(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	@Override
	public String getJsonValue() {
		return jsonValue;
	}
}
