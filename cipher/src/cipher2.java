import javax.swing.JOptionPane;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class cipher2 
{	public static final String ALPHABET_PLUS_SPACE = "abcdefghijklmnopqrstuvwxyz " ;
	public static void main(String[] args) 
	{	try
		{	boolean finishedCiphering = false ;
			do 
			{	
				char [] cipherMapping = ALPHABET_PLUS_SPACE.toCharArray();
				String input= JOptionPane.showInputDialog(null 
						,"Please enter your secret message or type 'QUIT' to exit");
				Scanner inputMessage = new Scanner (input);
				String message = inputMessage.nextLine();
				String end = "QUIT" ;
				if (end.equals(message))						
				{
					JOptionPane.showMessageDialog(null, "Goodbye");
					finishedCiphering= true;
				}
				if (finishedCiphering ==false)
				{
					JOptionPane.showMessageDialog(null ,"'" + decrypt (encrypt (message, 
							createCipher(cipherMapping)),cipherMapping)+ "'");
					inputMessage.close();
				}
			}
			while (finishedCiphering== false);
		}
		catch(NullPointerException exception )
		{
			JOptionPane.showMessageDialog(null,"Thanks for ciphering");
		}
		catch(NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "please enter a valid message");
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			JOptionPane.showMessageDialog(null,
					"please enter a valid message which does not contain an integer");
		}
	}
	public static char[]createCipher (char []cipherMapping ) 
	{
		if (cipherMapping!=null)
		  {
		    Random generator = new Random();
		    for (int index=0; index<(cipherMapping.length); index++ )
		    {
		      int secondIndex = generator.nextInt(cipherMapping.length-1); // terrible variable name
		      char temp = cipherMapping[index];
		      cipherMapping[index] = cipherMapping[secondIndex];
		      cipherMapping[secondIndex] = temp ;
		    }
		  }
		return cipherMapping;
	}
	public static String encrypt (String message,char[] createCipher)
	{ 
		try 
		{
			int position = 0;
			String messageLower = message.toLowerCase();
			char[] messageArray = messageLower.toCharArray();
			for(int index = 0;index<(messageArray.length); index++)
			{
				if (messageArray[index]==' ')
				{
					position = 26;
				}
				else 
				{
					position = messageArray[index]-'a' ; 
				}
				messageArray[index]= createCipher[position];
			}
			String encryptedMessage = new String (messageArray);
			JOptionPane.showMessageDialog(null,"'"+ encryptedMessage+ "'");
			return encryptedMessage ;
		}
		catch (ArrayIndexOutOfBoundsException exception )
		{
			throw new ArrayIndexOutOfBoundsException();
		}		
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