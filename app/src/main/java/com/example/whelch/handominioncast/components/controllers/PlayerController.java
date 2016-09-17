package com.example.whelch.handominioncast.components.controllers;

import com.example.whelch.handominioncast.model.cards.modules.base.Cellar;
import com.example.whelch.handominioncast.components.controllers.player.DeckController;
import com.example.whelch.handominioncast.components.controllers.player.DiscardPileController;
import com.example.whelch.handominioncast.components.controllers.player.HandController;

/**
 * Controls everything to do with a player.
 */
public class PlayerController {

	private DeckController deckController = new DeckController();
	private HandController handController = new HandController();
	private DiscardPileController discardPileController = new DiscardPileController();

	public PlayerController() {
		for(int i = 0; i < 10; i++) {
			Cellar cellar = new Cellar();
			handController.addCard(cellar);
		}
	}
}
