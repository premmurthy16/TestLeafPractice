package week1.homework.com;

public class PrimeOrNot {

	public static void main(String[] args) {
	
		int n=100;
				
		
		int j=1;
		
		int k=2;
		
		System.out.print("Prime Numbers are:");
		System.out.print(k);
		for(int i=2;i<=n;i++){
			
			int a=i%k;
			
			
			if(a!=0){
				
				
				System.out.print(","+i);
				
			 
			}
			
			
			
		}
			
			
			
			
	}
}
