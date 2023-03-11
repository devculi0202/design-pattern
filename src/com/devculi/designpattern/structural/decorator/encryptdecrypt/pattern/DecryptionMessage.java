package com.devculi.designpattern.structural.decorator.encryptdecrypt.pattern;

public class DecryptionMessage extends MessageDecorator {

	public DecryptionMessage(Message message) {
		super(message);
	}

	@Override
	public String getContent() {
		System.out.println("Decrypting message");
		return "Decrypted " + super.getContent();
	}

}
