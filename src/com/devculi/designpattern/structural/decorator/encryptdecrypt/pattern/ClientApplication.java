package com.devculi.designpattern.structural.decorator.encryptdecrypt.pattern;

public class ClientApplication {
	
	public static void main(String[] args) {
		Message basicMessage = new BasicMessage("Hello world");
		
		Message encryptionMessage  = new EncryptionDecorator(basicMessage);
		encryptionMessage.getContent();
		
		Message decryptionMessage = new DecryptionMessage(basicMessage);
		decryptionMessage.getContent();
		
	}

}
