package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Moneylender extends Card implements ActionType {

	public Moneylender() {
		super();
		cardImage.setImageResource(R.drawable.moneylender);
	}

	@Override
	public void executeAction() {

	}
}
