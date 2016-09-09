package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;

public class Village extends Card implements ActionType {

	public Village() {
		super();
		cardImage.setImageResource(R.drawable.village);
	}

	@Override
	public void executeAction() {

	}
}
