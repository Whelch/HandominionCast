package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Woodcutter extends Card implements ActionType {

	public Woodcutter() {
		super();
		cardImage.setImageResource(R.drawable.woodcutter);
	}

	@Override
	public void executeAction() {

	}
}
