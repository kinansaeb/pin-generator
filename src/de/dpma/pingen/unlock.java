package de.dpma.pingen;

public class unlock {

	public unlock() {

	}

	public static void main(String[] args) {
		String fingerprint = "90FC99A7D309938A1D296579A0DEA57EB7A1B9DB".toLowerCase();
		String erg = Verifier.getDdProUnlockPIN(fingerprint);
		System.out.println(erg);
	}
}
