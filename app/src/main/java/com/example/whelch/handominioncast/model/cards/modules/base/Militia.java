package com.example.whelch.handominioncast.model.cards.modules.base;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.model.cards.Card;
import com.example.whelch.handominioncast.model.cards.types.ActionType;
import com.example.whelch.handominioncast.model.cards.types.AttackType;

import java.util.function.Function;

public class Militia extends Card implements ActionType, AttackType {

	public Militia() {
		super();
		cardImage.setImageResource(R.drawable.militia);
	}

	@Override
	public void executeAction() {

	}

	@Override
	public Function getAttackAction() {
		return null;
	}
}
