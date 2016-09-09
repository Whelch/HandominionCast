package com.example.whelch.handominioncast.exceptions;

public class PreexistingGameSessionException extends Exception {
	public PreexistingGameSessionException() {

	}

	public String toString() {
		return "game session already exists. There can only be one active game session at a time.";
	}
}
