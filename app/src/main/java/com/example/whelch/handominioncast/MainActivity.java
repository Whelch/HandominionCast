package com.example.whelch.handominioncast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.whelch.handominioncast.exceptions.PreexistingGameSessionException;
import com.example.whelch.handominioncast.components.GameSession;
import com.example.whelch.handominioncast.components.controllers.player.HandController;

public class MainActivity extends Activity {

	private HandController handContrller;
	private View handView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		handView = findViewById(R.id.hand_view);

		try {
			new GameSession(this);
			setHandViewVisibility(true);
		} catch (PreexistingGameSessionException e) {
			e.printStackTrace();
		}
	}

	public void setHandViewVisibility(boolean visible) {
		handView.setVisibility(visible ? View.VISIBLE : View.GONE);
	}
}
