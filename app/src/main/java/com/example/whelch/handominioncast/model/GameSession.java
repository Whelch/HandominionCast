package com.example.whelch.handominioncast.model;

import android.util.Log;

import com.example.whelch.handominioncast.MainActivity;
import com.example.whelch.handominioncast.exceptions.PreexistingGameSessionException;
import com.example.whelch.handominioncast.model.cards.CardDefinition;
import com.example.whelch.handominioncast.model.controllers.PlayerController;

/**
 * A GameSession keeps track of various things like:
 * - The player's state (including DeckController, Hand, DiscardPile, etc...)
 * - The supply cards (including there availability
 * - The ActionType stack
 */
public class GameSession {

	/*****************
	 * STATIC
	 ****************/

	private static GameSession activeGameSession;

	public static GameSession getCurrentGameSession() {
		return activeGameSession;
	}

	/*****************
	 * VARIABLES
	 ****************/

	private MainActivity activity;

	private PlayerController playerController;

	/*****************
	 * CONSTRUCTORS
	 ****************/

	public GameSession(MainActivity activity) throws PreexistingGameSessionException {
		if(activeGameSession != null) {
			throw new PreexistingGameSessionException();
		} else {
			activeGameSession = this;
		}

		this.activity = activity;

		playerController = new PlayerController();

		CardDefinition cardDef = CardDefinition.dictionary.get("Cellar");
		Log.i("TEST", cardDef.description);
	}

	/*****************
	 * METHODS
	 ****************/

	public MainActivity getActivity() {
		return activity;
	}

	/**
	 * Called when this GameSession is no longer in use.
	 * Cleans up all sub-components.
	 */
	public void cleanupAndDestroy() {
		activeGameSession = null;
		// TODO
	}
}
