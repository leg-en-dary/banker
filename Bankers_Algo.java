import java.util.Scanner;

public class Bankers_Algo 
{
	public static void main(String args[])
	{
		int i,k,j,p,r=0;
		int allocation[][];
		int need[][];
		int max[][];
		int avl[];
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter total number of processes:");
		p=scan.nextInt();
		System.out.println("Enter total number of Resourses:");
		r=scan.nextInt();
			
		allocation=new int[p][r];
		need=new int [p][r];
		max=new int [p][r];
		avl=new int [r];
		
		System.out.println("Enter Allocation matrix :");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				allocation[i][j]=scan.nextInt();
			}
		}
		System.out.println("Enter Max matrix :");
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				max[i][j]=scan.nextInt();
			}
		}
		System.out.println("Enter Avl matrix :");
		for(i=0;i<r;i++)
		{
			avl[i]=scan.nextInt();
		}
		
		//need=max-allocaation;
		
		for(i=0;i<p;i++)
		{
			for(j=0;j<r;j++)
			{
				need[i][j]=max[i][j]-allocation[i][j];
			}
		}		
		
		int flag1=0;
		int count=0;
		int flag[]=new int[p];
		int t=0;
		int ord[]=new int[p];
		
		for(i=0;i<p;i++)
		{
				flag[i]=-1;
		}		
		
		while(count<p)
		{
			for(i=0;i<p;i++)
			{
					if(flag[i]==-1)
					{
							flag1=0;
			
							for(j=0;j<r;j++)
							{
								if(need[i][j]>avl[j])
								{
										flag1=1;
								}
							}
							if(flag1==0)
							{
								for(j=0;j<r;j++)
								{
										avl[j]=avl[j]+allocation[i][j];
								}								
								count++;
								ord[t++]=i;
								flag[i]=1;
							}
					}
			}
		}
		
		System.out.println("Process run order :");
		
		for(i=0;i<p;i++)
		{
				System.out.println(ord[i]+"\t");
		}
	}
}










