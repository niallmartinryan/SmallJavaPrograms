import javax.swing.JOptionPane;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class cipher 
{	public static final int ALPHABET_PLUS_SPACE_SIZE =27;
	public static final String ALPHABET_PLUS_SPACE = "abcdefghijklmnopqrstuvwxyz " ;
	
	public static void main(String[] args) 
	{
		boolean finishedCiphering = false ;
		do 
		{	
			char [] cipherMapping = ALPHABET_PLUS_SPACE.toCharArray();
			Scanner inputMessage = new Scanner (System.in);
			System.out.print("Please enter your secret message or type QUIT(all caps) to exit");
			String message = inputMessage.nextLine();
			if (message == "QUIT")
			{
				finishedCiphering= true;
			}
			System.out.println(decrypt (encrypt (message, createCipher(cipherMapping)),cipherMapping));
			
			inputMessage.close();
		}
		while (finishedCiphering== false);

	}
	public static char[]createCipher (char []cipherMapping ) 
	{
		if (cipherMapping!=null)
		  {
		    Random generator = new Random();
		    for (int index=0; index<cipherMapping.length; index++ )
		    {
		      int secondIndex = generator.nextInt(cipherMapping.length);
		      char temp = cipherMapping[index];
		      cipherMapping[index] = cipherMapping[secondIndex];
		      cipherMapping[secondIndex] = temp ;
		    }
		  }
		return cipherMapping;
	}
	public static String encrypt (String message,char[] createCipher)
	{	
		int position = 0;
		String messageLower = message.toLowerCase();
		char[] messageArray = messageLower.toCharArray();
		for(int index = 0;index<messageArray.length; index++)
		{
			if (messageArray[index]==' ')
			{
				position = 26;
			}
			else 
			{
				position = messageArray[index]-'a' ; // don't have to minus one, because array starts at 0
			}
			messageArray[index]= createCipher[position];
		}
		String encryptedMessage = new String (messageArray);
		System.out.println(encryptedMessage);
		return encryptedMessage ;
	}
	
	public static String decrypt (String encript ,char []cipherMapping )
	{	
		char [] cipherMappingOriginal = ALPHABET_PLUS_SPACE.toCharArray();
		int position = 0;
		int counter = 0;
		char [] encryptMessage = encript.toCharArray();
		for(int index = 0;index<encryptMessage.length;index++)
		{
			while(encryptMessage[index]!=cipherMapping[counter])
			{	
				
				counter++;
			}
			position = counter;
			counter = 0;
			encryptMessage[index]= cipherMappingOriginal[position];
			
		}
		String decryptedMessage =new String (encryptMessage);
		return decryptedMessage;
	}
	
	
}
