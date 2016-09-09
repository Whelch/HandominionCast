package com.example.whelch.handominioncast.model.cards;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.whelch.handominioncast.model.GameSession;

public abstract class Card {
	private static LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);

	static {
		cardLayoutParams.setMargins(20, 0, 20, 0);
	}

	protected ImageView cardImage;
	protected int cost;

	protected Card() {
		cardImage = new ImageView(GameSession.getCurrentGameSession().getActivity());
		cardImage.setAdjustViewBounds(true);
		cardImage.setLayoutParams(cardLayoutParams);
	}

	public ImageView getImageView() {
		return cardImage;
	}

	public int getCost() { return cost; }
}
