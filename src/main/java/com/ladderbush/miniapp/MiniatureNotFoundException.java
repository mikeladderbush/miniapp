package com.ladderbush.miniapp;

class MiniatureNotFoundException extends RuntimeException {

	MiniatureNotFoundException(Long id) {
		super("Could not find Miniature " + id);
	}
}