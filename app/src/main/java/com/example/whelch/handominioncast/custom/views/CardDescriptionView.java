package com.example.whelch.handominioncast.custom.views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import jregex.*;

import com.example.whelch.handominioncast.App;
import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.custom.spans.CoinReplacementSpan;
import com.example.whelch.handominioncast.custom.spans.CustomTypefaceSpan;
import com.example.whelch.handominioncast.custom.spans.HorizontalLineReplacementSpan;
import com.example.whelch.handominioncast.custom.spans.NoDisplayReplacementSpan;
import com.example.whelch.handominioncast.custom.spans.VPReplacementSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardDescriptionView extends TextView {

	public CardDescriptionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setFont();
	}

	public CardDescriptionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFont();
	}

	public CardDescriptionView(Context context) {
		super(context);
		setFont();
	}

	private void setFont() {
		if(!isInEditMode()) {
			Typeface customFont = Typeface.createFromAsset(App.getContext().getAssets(), "fonts/times.ttf");
			setTypeface(customFont);
		}
	}

	public void setText(String text) {
		this.setText(text, BufferType.SPANNABLE);
	}

	@Override
	public void setText(final CharSequence text, BufferType type) {
		if(!isInEditMode()) {
			Spannable s = getTextWithImages(text);
			super.setText(s, BufferType.SPANNABLE);
		} else {
			super.setText(text, type);
		}
	}

	private Spannable getTextWithImages(CharSequence text) {
		Spannable spannable = Spannable.Factory.getInstance().newSpannable(text);
		addCoinImages(spannable);
		addVPImages(spannable);
		addHorizontalLines(spannable);
		addBoldSpans(spannable);
		return spannable;
	}

	/**
	 * Regex examples:
	 * {coin}
	 * {coin=3}
	 */
	private void addCoinImages(Spannable spannable) {
		Pattern pattern = Pattern.compile("\\Q{coin\\E(=[0-9])?\\}");
		Matcher matcher = pattern.matcher(spannable);
		while (matcher.find()) {
			String coinText = matcher.group(1) != null ? matcher.group(1).substring(1) : null;
			spannable.setSpan(new CoinReplacementSpan(getLineHeight(), coinText), matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
	}

	/**
	 * Regex examples:
	 * {vp}
	 */
	private void addVPImages(Spannable spannable) {
		Pattern pattern = Pattern.compile("\\Q{vp}\\E");
		Matcher matcher = pattern.matcher(spannable);
		while (matcher.find()) {
			spannable.setSpan(new VPReplacementSpan(getLineHeight()), matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
	}

	/**
	 * Regex examples:
	 * {line-break}
	 */
	private void addHorizontalLines(Spannable spannable) {
		Pattern pattern = Pattern.compile("\\Q{line-break}\\E");
		Matcher matcher = pattern.matcher(spannable);
		while (matcher.find()) {
			spannable.setSpan(new HorizontalLineReplacementSpan(getWidth()), matcher.start(), matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
	}

	/**
	 * Regex examples:
	 * {bold}some text{/bold}
	 * {bold}some text non-terminated
	 */
	private void addBoldSpans(Spannable spannable) {
		jregex.Pattern pattern = new jregex.Pattern("\\{bold\\}(?(?=([\\s\\S]*?\\{\\/bold\\}))([\\s\\S]*?(\\{\\/bold\\}))|([\\s\\S]*))");
		jregex.Matcher matcher = pattern.matcher(spannable.toString());

		while (matcher.find()) {
			spannable.setSpan(new NoDisplayReplacementSpan(), matcher.start(), matcher.start()+6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			if(spannable.subSequence(matcher.end()-7, matcher.end()).toString().equals("{/bold}")) {
				spannable.setSpan(new CustomTypefaceSpan(Typeface.createFromAsset(App.getContext().getAssets(), "fonts/times_bold.ttf")), matcher.start()+6, matcher.end()-7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				spannable.setSpan(new NoDisplayReplacementSpan(), matcher.end()-7, matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			} else {
				spannable.setSpan(new CustomTypefaceSpan(Typeface.createFromAsset(App.getContext().getAssets(), "fonts/times_bold.ttf")), matcher.start()+6, matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
	}
}