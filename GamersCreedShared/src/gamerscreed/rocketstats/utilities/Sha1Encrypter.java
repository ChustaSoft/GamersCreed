package gamerscreed.rocketstats.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Sha1Encrypter
 * This class provides a method to return a hash in SHA1 of a String.
 *
 * @author: Xavi Rueda
 * @version 1.1, 3-16-2017 
 */
public class Sha1Encrypter {

	public static String generateTokenForUser(String aUsername, String aPassword)
	{
		String tPasswordEncrypted = getHash(aPassword);
		String tUsertoken = getHash(aUsername + tPasswordEncrypted);
		
		return tUsertoken;
	}
	
	
	public static String getHash(String aMessage) 
	{
		MessageDigest tMessageDigest;
		byte[] tBuffer, tDigest;
		StringBuilder tGeneratedHash = new StringBuilder();
		
		tBuffer = aMessage.getBytes();
		try {
			tMessageDigest = MessageDigest.getInstance("SHA1");
			tMessageDigest.update(tBuffer);
			tDigest = tMessageDigest.digest();

			for (byte iAux : tDigest) {
				int iByte = iAux & 0xff;
				if (Integer.toHexString(iByte).length() == 1)
					tGeneratedHash.append("0");
				tGeneratedHash.append(Integer.toHexString(iByte));
			}
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return tGeneratedHash.toString();
	}
}