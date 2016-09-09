package com.example.whelch.handominioncast.model.controllers.player;

import android.widget.LinearLayout;

import com.example.whelch.handominioncast.MainActivity;
import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.GameSession;
import com.example.whelch.handominioncast.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls the drawing of the hand component
 */
public class HandController {

	private LinearLayout handLayout;

	private List<Card> hand = new ArrayList<Card>();

	public HandController() {
		MainActivity activity = GameSession.getCurrentGameSession().getActivity();

		this.handLayout = (LinearLayout)activity.findViewById(R.id.handLayout);
	}

	public void addCard(Card card) {
		hand.add(card);

		this.handLayout.addView(card.getImageView());
	}
}