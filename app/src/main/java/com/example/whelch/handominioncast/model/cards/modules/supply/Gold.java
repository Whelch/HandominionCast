package com.example.whelch.handominioncast.model.cards.modules.supply;

import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.TreasureType;

public class Gold extends Card implements TreasureType {

	@Override
	public int getTreasureValue() {return 3;}
}
