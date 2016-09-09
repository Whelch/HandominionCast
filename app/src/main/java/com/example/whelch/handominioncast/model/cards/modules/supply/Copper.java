package com.example.whelch.handominioncast.model.cards.modules.supply;

import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.TreasureType;

public class Copper extends Card implements TreasureType {

	@Override
	public int getTreasureValue() {return 1;}
}
