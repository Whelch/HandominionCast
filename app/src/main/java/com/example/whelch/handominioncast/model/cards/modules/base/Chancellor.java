package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Chancellor extends Card implements ActionType {

	public Chancellor() {
		super();
		cardImage.setImageResource(R.drawable.chancellor);
	}

	@Override
	public void executeAction() {

	}
}
