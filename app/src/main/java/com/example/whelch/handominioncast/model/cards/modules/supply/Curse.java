package com.example.whelch.handominioncast.model.cards.modules.supply;

import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.CurseType;

public class Curse extends Card implements CurseType {

	@Override
	public int getVictoryValue() {return -1;}
}
