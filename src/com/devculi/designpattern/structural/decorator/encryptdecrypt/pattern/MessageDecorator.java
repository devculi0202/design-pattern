package com.devculi.designpattern.structural.decorator.encryptdecrypt.pattern;

public class MessageDecorator implements Message {
	private Message message;

	public MessageDecorator(Message message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		return message.getContent();

	}
}
