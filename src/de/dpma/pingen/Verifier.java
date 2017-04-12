package de.dpma.pingen;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;

public class Verifier {
	// private static Log logger = LogFactory.getLog(Verifier.class);

	public Verifier() {
	}

	public static String getPIN(String art, String fingerprint, String avaId, GregorianCalendar cal) {
		SimpleDateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
		String datum = dt1.format(cal.getTime());

		String basis = fingerprint + avaId + art + datum;

		return createPIN(basis, 8);
	}

	private static String createPIN(String pPINBasis, int pStellen) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pPINBasis.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			byte[] byteData = md.digest();

			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xFF & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			String encoded = DatatypeConverter.printBase64Binary(hexString.toString().getBytes("UTF-8"));
			return encoded.substring(0, pStellen).toUpperCase();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDdProUnlockPIN(String fingerprint) {
		String basis = fingerprint;
		basis.trim();
		basis.toLowerCase();

		return createPIN(basis, 8);
	}
}