package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Workshop extends Card implements ActionType {

	public Workshop() {
		super();
		cardImage.setImageResource(R.drawable.workshop);
	}

	@Override
	public void executeAction() {

	}
}
