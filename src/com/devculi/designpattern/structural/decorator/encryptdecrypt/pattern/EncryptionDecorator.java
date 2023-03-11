package com.devculi.designpattern.structural.decorator.encryptdecrypt.pattern;

public class EncryptionDecorator extends MessageDecorator {

	public EncryptionDecorator(Message message) {
		super(message);
	}

	@Override
	public String getContent() {
		System.out.println(" Encrypting message ...");
		return "Encrypted " + super.getContent();
	}
	

}
