package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Remodel extends Card implements ActionType {

	public Remodel() {
		super();
		cardImage.setImageResource(R.drawable.remodel);
	}

	@Override
	public void executeAction() {

	}
}
