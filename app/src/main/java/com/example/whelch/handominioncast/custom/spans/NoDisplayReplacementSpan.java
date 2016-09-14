package com.example.whelch.handominioncast.custom.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/**
 * Hides the text this span covers
 */
public class NoDisplayReplacementSpan extends ReplacementSpan {
	public NoDisplayReplacementSpan() {

	}

	@Override
	public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
		return 0;
	}

	@Override
	public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {

	}
}
