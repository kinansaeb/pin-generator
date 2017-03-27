package de.dpma.service;

import java.util.GregorianCalendar;

public class Example {

	public Example() {
		
	}
	
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();	
		
		String avaId = "40000000";
		String fingerprint = "90FC99A7D309938A1D296579A0DEA57EB7A1B9DB".toLowerCase();
		
		String art ="REGISTRATION_CONFIRMATION";
		
		String erg = Verifier.getPIN(art, fingerprint, avaId, cal);
		System.out.println(erg);
	}

}
