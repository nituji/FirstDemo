package testClassPackage;

public class ArraySwap {

	public static void main(String[] args) 
	
	{
		int a[]= {1,2,3,4};
		int b[]= {4,5,6,7};
		
		for(int i=0;i<=a.length-1;i++)
		{
			a[i]=a[i]+b[i];
			b[i]=a[i]-b[i];
			a[i]=a[i]-b[i];
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:b)
		{
			System.out.print(i+" ");
		}
		
		
	}

}
