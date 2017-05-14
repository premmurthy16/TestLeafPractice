/**
 * 
 */
package week1.homework.com;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author admin1
 *
 */
public class Factorial {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//DataInputStream inputNumber=new DataInputStream(System.in);
		
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the inputNumber n");
		
		int facto=1;
		int number=input.nextInt();
		
		if(number==0){
			
			System.out.println("Factorial of 0 is 1");
		}
		else{
		for(int i=1;i<=number;i++){
			
			
			
			facto=facto*i;
		
			
			
			
		}
		
		System.out.print(facto);
	
			
		}
		}
		
       
	}

