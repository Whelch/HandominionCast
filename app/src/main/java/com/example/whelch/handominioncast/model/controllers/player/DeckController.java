package com.example.whelch.handominioncast.model.controllers.player;

import com.example.whelch.handominioncast.model.cards.Card;

import java.util.List;

public class DeckController {
	private List<Card> deck;

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void addCardToBottom(Card card) {
		this.deck.add(0, card);
	}

	public void addCardToTop(Card card) {
		deck.add(card);
	}

	public Card draw() {
		if(deck.size() > 0) {
			return deck.remove(deck.size() - 1);
		} else {
			return null;
		}
	}
}
