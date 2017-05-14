/**
 * 
 */
package week1.homework.com;

/**
 * @author admin1
 *
 */
public class OddOrEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []x=new int[100];
		
		int j = 0;
		System.out.println("Even"+"  "+"Odd");
		for(int i=100;i<=200;i++){
			
			x[j]=i;
			
			int b=x[j]%2;
			//System.out.print(x[j]);
			
			
			if(b!=0){
				
				
				System.out.print(x[j]);
				
				System.out.println("");
				
				
			}
			
		else {
			
		
			
		//	System.out.print("\n"+"even");
			
		System.out.print(x[j]+"  "+",");
		}
		
		

	}

}}
