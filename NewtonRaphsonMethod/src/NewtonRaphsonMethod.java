import javax.swing.JOptionPane;
import java.util.Scanner;
public class NewtonRaphsonMethod {

	public static void main(String[] args) 
	{
		String input = JOptionPane.showInputDialog("Enter initial estimate:");
		Scanner scanner = new Scanner( input );
		double number = scanner.nextDouble();
		input = JOptionPane.showInputDialog("Enter the required precision:");
		scanner.close();
		scanner = new Scanner( input );
		double precision = scanner.nextDouble();
		JOptionPane.showMessageDialog(null, "The root found was " + findRoot( number, precision ));
		scanner.close();
	}
	
	public static double findRoot( double initialGuess, double precision )
	{
		double root = initialGuess;
		while ((Math.abs(f(root))) > precision)
		{
			root = root - f(root)/fPrime(root);
		}
		return root;
	}
	
	public static double f( double x )
	{
		return 3.0*x*x + 5.0*x -8.0;
	}
	
	public static double fPrime( double x )
	{
		return 6*x + 5;
	}

	}


