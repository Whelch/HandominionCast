package com.example.whelch.handominioncast.custom.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/**
 * Draws a line across the text line, filling the entire space
 */
public class HorizontalLineReplacementSpan extends ReplacementSpan {

	private int width;

	public HorizontalLineReplacementSpan(int textViewWidth) {
		super();
		width = textViewWidth;
	}

	@Override
	public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
		return 400;
	}

	@Override
	public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
		int lineHeight = Math.abs(top-bottom);
		int strokeWidth = lineHeight/10;
		int lineYPosition = bottom-(lineHeight/2) + (strokeWidth/2);

		paint.setStrokeWidth(strokeWidth);
		canvas.drawLine(x, lineYPosition, x+400, lineYPosition, paint);
	}
}
