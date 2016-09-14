package com.example.whelch.handominioncast.custom.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

import com.example.whelch.handominioncast.App;
import com.example.whelch.handominioncast.R;

/**
 * Used to insert an image of a Victory Point.
 */
public class VPReplacementSpan extends ReplacementSpan {

	private static float IMAGE_SCALAR = 1.2f;

	private Drawable vpImage;
	private int size;

	public VPReplacementSpan(int lineHeight) {
		super();
		this.size = Math.round(lineHeight * IMAGE_SCALAR);
		vpImage = App.getContext().getResources().getDrawable(R.drawable.victory_icon);
	}

	@Override
	public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
		if(fm != null) {
			int spacing = paint.getFontMetricsInt(fm);
			if(spacing != size) {
				int adjustment = size-spacing;
				int addTop = (int) Math.ceil(adjustment*.5f);
				int addBottom = (int) Math.floor(adjustment*.5f);
				fm.top = fm.top - addTop;
				fm.ascent = fm.ascent - addTop;
				fm.bottom = fm.bottom + addBottom;
				fm.descent = fm.descent + addBottom;
			}
		}
		return size;
	}

	@Override
	public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
		int xStart = Math.round(x);
		int yStart = bottom;

		vpImage.setBounds(xStart, yStart - size, xStart + size, yStart);
		vpImage.draw(canvas);
	}
}
