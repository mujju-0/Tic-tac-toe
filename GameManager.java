package Project01;
import java.util.Scanner; 
public class GameManager 
{
	static Scanner sc = new Scanner(System.in);
	char turn01;
	char[] game = new char[9];
//	int[] game = new int[9];
	static char current = 'X';
	void bord() {
		for(int i = 1; i <= 3; i++) {			
		System.out.println("| | | |");
		System.out.println("--------");
		}
	}
	
	void Play() {
			if(current == 'X'|| current =='O') {
				char turn01 = current;
				int type = sc.nextByte();
//				if() {}
				switch(type) {
				case 1:
					System.out.println("|"+ turn01+  "| " + "| "+"|");
					System.out.println("---------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 2:
					System.out.println("| "+ "|"+turn01+  "| "+"|");
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 3:
					System.out.println("|"+  " | " + "|"+turn01+"|");
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 4:
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("|"+ turn01+  "| " + "| "+"|");
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 5:
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| "+   "|"+turn01 + "|"+" |");
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 6:
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| "+   "| " + "|"+turn01+"|");
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					break;
				case 7:
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("|"+ turn01+  "| " + "| "+"|");
					System.out.println("------------");
					break;
				case 8:					
					System.out.println("------------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("|"+  " |" + turn01+ "| "+"|");
					break;
				case 9:
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("| | | |");
					System.out.println("--------");
					System.out.println("|"+   " | " + "|"+turn01+"|");
					System.out.println("------------");
					break;
				}
				
		}
			else {
				current = 'O';
			}
	}
	
	char swipe() {
		if(current == 'X') {
			current = 'O';
			System.out.println(" Player O Turn");
			return current;
		}
		else {
			current = 'X';
			System.out.println(" Player X Turn");
			return current;
		}
	}
	
	void check(int type) {
		
	}
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		gm.bord();
		for(int i = 1; i <= 9; i++) {
			gm.Play();
			current = gm.swipe();
		}
	}
}
