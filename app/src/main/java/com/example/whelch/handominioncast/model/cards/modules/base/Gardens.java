package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.VictoryType;

public class Gardens extends Card implements VictoryType {

	public Gardens() {
		super();
		cardImage.setImageResource(R.drawable.gardens);
	}

	@Override
	public int getVictoryValue() {
		return 0;
	}
}
