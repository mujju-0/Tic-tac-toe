package Game;

import java.util.LinkedHashMap;
import java.util.Scanner; 
public class GameManager 
{
	static Scanner sc = new Scanner(System.in);
	
	int position;
	char[] game = new char[9];
	static char current = 'X';	

	int scoreX = 0;
	int scoreY = 0;
	
	LinkedHashMap<Character, Integer> setscore = new LinkedHashMap<Character,Integer >();
	
	
	void StartGame() {
		
		while(true) {
			bord();
			position = sc.nextInt();
			if(Isvalid(position)) {
				
				if(Iswinner()) {
					bord();
					System.out.println("Player "+current+" win");
					System.out.println(Score(current));
					System.out.println(setscore);
					return;
				}
				
				if(Isbordfull()) {
					bord();
					System.out.println("Match is Draw");
					return;
				}
			}else {
				System.out.println("Player already Played here.");
				StartGame();
			}
			Swipe();	
			}
		}
	

//	To check is move valid or not
	boolean Isvalid(int position) 
	{
		if(position < 0 || position >10) {
			System.out.println("Choose a valid option");
			return false;
		}
		
		int index = --position;
		if(game[index] == '\u0000') {
			game[index] = current;
			return true;
		}
		
		return false;
	}
	
//	To check anyone wine or not

	boolean Iswinner()
	{	
		return  getwinner(0, 1, 2)||
				getwinner(3, 4, 5)||
				getwinner(6, 7, 8)||
				getwinner(0, 3, 6)||
				getwinner(1, 4, 7)||
				getwinner(2, 5, 8)||
				getwinner(0, 4, 8)||
				getwinner(2, 4, 6);
			
	}
	
	boolean getwinner(int a, int b, int c) {
		return game[a] == current && game[b] == current && game[c] == current;
	}

	String Score(char player) {

		
		if(current == 'X') {
			scoreX++;
			setscore.put(current,scoreX);
			return player+" "+scoreX;
		}else {
			scoreY++;
			setscore.put(current,scoreY);
			return player+" "+scoreY;
		}
		
//		return player+" "+score;
	}
//	To check board is full or not
	
	boolean Isbordfull() 
	{
		for(int i = 0; i<=game.length-1; i++) 
		{
			if((game[i] == '\u0000')) 
			{
				return false;
			}
			
		}
		return true;
	}
	
//	Swipe the current player to another player
	void Swipe()
	{
		if(current == 'X') {
		current = 'O';
		System.out.println(" Player O Turn");
	}
	else {
		current = 'X';
		System.out.println(" Player X Turn");
	}
	}	
	
//	Printing the Bord
	void bord() 
	{
		
		System.out.println("|"+game[0] +"|"+game[1]+"|"+game[2]+"|");
		System.out.println("--------");
		System.out.println("|"+game[3] +"|"+game[4]+"|"+game[5]+"|");
		System.out.println("--------");
		System.out.println("|"+game[6] +"|"+game[7]+"|"+game[8]+"|");
		System.out.println("--------");
	
		
	}
	

	public static void main(String[] args) 
	{
		GameManager gm = new GameManager();
		gm.StartGame();
		
	
		while(true) {
			System.out.println("Do you wanna play again Type ==> 1. OR exit ==> 0");
			int ask = sc.nextInt();
			
			switch(ask) {
			case 1:
				gm.Restart();
				gm.StartGame();
				break;
			case 0:
				return;
		}
		}
	}


	void Restart() {
		for(int i = 0; i < game.length; i++) {
			game[i] = '\u0000';
		}
	}
}


// 1.Start() 2.printboard() 3.Isvalid() 4.IsWinner() 5.Isdrwa() 
