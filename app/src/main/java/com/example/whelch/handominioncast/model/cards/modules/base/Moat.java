package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;
import com.example.whelch.handominioncast.model.cards.types.ReactionType;

public class Moat extends Card implements ActionType, ReactionType {

	public Moat() {
		super();
		cardImage.setImageResource(R.drawable.moat);
	}

	@Override
	public void executeAction() {

	}
	@Override
	public void executeReaction() {

	}
}
