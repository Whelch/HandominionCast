package com.example.whelch.handominioncast.custom.spans;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {
	private final Typeface typeFace;

	public CustomTypefaceSpan(Typeface type) {
		super("");
		typeFace = type;
	}

	@Override
	public void updateDrawState(TextPaint textPaint) {
		applyCustomTypeFace(textPaint);
	}

	@Override
	public void updateMeasureState(TextPaint paint) {
		applyCustomTypeFace(paint);
	}

	private void applyCustomTypeFace(Paint paint) {
		paint.setTypeface(typeFace);
	}
}