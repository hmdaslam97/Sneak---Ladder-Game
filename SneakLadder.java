import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class SneakLadder 
{
	static int ran;
	static int score=0,comScore=0;
	static String name;
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome to snake and ladder.");
		System.out.print("Enter your name:");
		name=scan.next();
		while(true)
		{
			System.out.print("\n"+name+", do you want to roll the dice (Y/N)?:");
			String cond=scan.next().toUpperCase();
			char c=cond.charAt(0);
			switch(c)
			{
			case 'Y':retSneakOrLadder();
					computer();
					if(score==100 || comScore==100)
					{
						System.out.print("\nThe game ends. "+name+"’s score: "+score+". "+"Computer score:"+comScore);
						if(score==100)
						{
							System.out.print(" "+name+" wins!");
						}
						else if(comScore==100)
						{
							System.out.print(" Computer wins!");
						}
						System.exit(0);
					}
				break;
				
			default://Print scores and exit
				System.out.print("\nThe game ends. "+name+"’s score: "+score+". "+"Computer score:"+comScore);
				if(score>comScore)
				{
					System.out.print(" "+name+" wins!");
				}
				else if(score<comScore)
				{
					System.out.print(" Computer wins!");
				}
				else
				{
					System.out.print(" Its a Tie");
				}

				System.exit(0);
			}
		}
	}
	public static void retSneakOrLadder() 
	{
//		for user
		int dice=myRandom();
		int tempScore=score;
		score+=dice;
		System.out.print(name+", your dice shows:"+dice);
		
		if(score>100)
		{
			score=tempScore;
			System.out.print(" Computer's current position becomes "+score+"\n");
		}
		else if(score==100)
		{
			return;
		}//Sneak function
		else if(isPrime(score) && score>11)
		{
			for(int i=score-1;i>11;i--)
			{
				if(isPrime(i))
				{
					score=i+1;
					System.out.print(" It’s a snake. Your current position becomes "+score+"\n");
					break;
				}
			}
		}//ladder function
		else if(score%11==0)
		{
			score+=7*dice;
			if(score>100)
			{
				score=tempScore;
				System.out.print(" Your current position becomes "+score+"\n");
			}
			else if(score==100)
			{
				return;
			}
			else
			{
				System.out.print(" It’s a ladder. Your current position becomes "+score+"\n");
			}
		}
		else
		{
			System.out.print(" Your current position becomes "+score+"\n");
		}
	}
	
	public static void computer()
	{
//		for computer
		int dice=myRandom();
		int tempScore=comScore;
		comScore+=dice;
		System.out.print("Computer’s chance: Dice shows: "+dice);
		if(comScore>100)
		{
			comScore=tempScore;
			System.out.print(" Computer's current position becomes "+comScore+"\n");
		}
		else if(comScore==100)
		{
			return;
		}//Sneak function
		else if(isPrime(comScore) && comScore>11)
		{
			for(int i=comScore-1;i>11;i--)
			{
				if(isPrime(i))
				{
					comScore=i+1;
					System.out.print(" It’s a snake. Computer's current position becomes "+comScore+"\n");
					break;
				}
			}
		
		}//ladder function
		else if(comScore%11==0)
		{
			comScore+=7*dice;
			if(comScore>100)
			{
				comScore=tempScore;
				System.out.print(" Computer's current position becomes "+comScore+"\n");
			}
			else if(comScore==100)
			{
				return;
			}
			else
			{
				System.out.print(" It’s a ladder. Computer's current position becomes "+comScore+"\n");
			}
		}
		else
		{
			System.out.print(" Computer's current position becomes "+comScore+"\n");
		}
	}
	
	
	public static boolean isPrime(int x)
	{
		int count=0;
		for(int i=1;i<=x;i++)
		{
			if(x%i==0)
			{
				count++;
			}
		}
		if(count==2)
			return true;
		return false;
	}
	
	public static int myRandom() 
	{
		int x = ThreadLocalRandom.current().nextInt();
		String s=""+x;
		int rn=x/(int)(Math.pow(10, s.length()-1));
		int count=0;
		if(rn<=6 && rn>=1 && rn!=ran)		
		{
			ran=rn;
			return rn;
		}     
		return	myRandom();
	}
}
