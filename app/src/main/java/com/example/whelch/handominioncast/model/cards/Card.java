package com.example.whelch.handominioncast.model.cards;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.whelch.handominioncast.components.GameSession;

import java.util.function.Consumer;

public abstract class Card implements OnClickListener {
	private static LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);

	static {
		cardLayoutParams.setMargins(20, 0, 20, 0);
	}

	protected ImageView cardImage;
	protected int cost;

	private Consumer<Card> clickCallback;

	protected Card() {
		cardImage = new ImageView(GameSession.getCurrentGameSession().getActivity());
		cardImage.setAdjustViewBounds(true);
		cardImage.setLayoutParams(cardLayoutParams);
		cardImage.setOnClickListener(this);
		cardImage.setClickable(false);
	}

	public ImageView getImageView() {
		return cardImage;
	}

	public int getCost() { return cost; }

	public void setClickable(boolean clickable) {
		this.cardImage.setClickable(clickable);
	}

	public void setClickCallback(Consumer<Card> callback) {
		this.clickCallback = callback;
	}

	@Override
	public void onClick(View view) {
		if(clickCallback != null) {
			clickCallback.accept(this);
		}
	}
}
