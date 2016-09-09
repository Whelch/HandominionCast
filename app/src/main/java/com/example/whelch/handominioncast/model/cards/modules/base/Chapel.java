package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Chapel extends Card implements ActionType {

	public Chapel() {
		super();
		cardImage.setImageResource(R.drawable.chapel);
	}

	@Override
	public void executeAction() {

	}
}
