package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Cellar extends Card implements ActionType {

	public Cellar() {
		super();
		cardImage.setImageResource(R.drawable.cellar);
	}

	@Override
	public void executeAction() {
		return;
	}
}
