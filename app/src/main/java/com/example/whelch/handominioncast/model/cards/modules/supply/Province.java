package com.example.whelch.handominioncast.model.cards.modules.supply;

import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.VictoryType;

public class Province extends Card implements VictoryType {

	@Override
	public int getVictoryValue() {return 6;}
}
