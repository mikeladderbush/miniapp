package com.ladderbush.miniapp.ErrorHandling;

class MiniatureNotFoundException extends RuntimeException {

	MiniatureNotFoundException(Long id) {
		super("Could not find Miniature " + id);
	}
}