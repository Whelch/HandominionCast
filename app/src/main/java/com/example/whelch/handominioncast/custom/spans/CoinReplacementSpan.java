package com.example.whelch.handominioncast.custom.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

import com.example.whelch.handominioncast.App;
import com.example.whelch.handominioncast.R;

/**
 * Used to insert an image of a coin with text on top of it.
 */
public class CoinReplacementSpan extends ReplacementSpan {

	private static float IMAGE_SCALAR = 1.2f;
	private static Typeface timesBoldTypeface = Typeface.createFromAsset(App.getContext().getAssets(), "fonts/times_bold.ttf");

	private Drawable coinImage;
	private int size;
	private String coinText;

	public CoinReplacementSpan(int lineHeight, String coinText) {
		super();
		this.size = Math.round(lineHeight * IMAGE_SCALAR);
		this.coinText = coinText;
		coinImage = App.getContext().getResources().getDrawable(R.drawable.treasure_icon);
	}

	@Override
	public int getSize(Paint paint, CharSequence text, int start, int end, FontMetricsInt fm) {
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

		coinImage.setBounds(xStart, yStart - size, xStart + size, yStart);
		coinImage.draw(canvas);
		if(coinText != null) {
			int textSize = Math.round(paint.measureText(coinText));
			paint.setTypeface(timesBoldTypeface);
			canvas.drawText(coinText, x + (size*.5f) - (textSize * .5f), y, paint);
		}
	}
}
