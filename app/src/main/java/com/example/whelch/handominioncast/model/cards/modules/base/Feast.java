package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Feast extends Card implements ActionType {

	public Feast() {
		super();
		cardImage.setImageResource(R.drawable.feast);
	}

	@Override
	public void executeAction() {

	}
}
