package pongPackage;

public class UserCreate {

		int coins;
		String name;
		int wins;
		int gamesPlayed;
		int p1PaddleColorID;
		int p2PaddleColorID;
		int bColorID;
		public UserCreate(String n){
			
			name = n;
			coins = 0;
			wins = 0;
			gamesPlayed = 0;
			p1PaddleColorID = 0;
			p2PaddleColorID = 1;
			bColorID = 10;
			
		}
		public UserCreate(String n, int c) {
			name = n;
			coins = c;
			wins = 0;
			gamesPlayed = 0;
		}
		
		String getName() {
			return name;
		}
		
		int getCoins() {
			return coins;
		}
		
		int getWins() {
			return wins;
		}
		
		int getWinPerc() {
			return wins/gamesPlayed;
		}
		
		void gameWon() {
			this.wins++ ;
		}
		void gamePlayed() {
			 this.gamesPlayed ++;
		}
		void addCoins(int num) {
			this.coins = coins + num;
		}
		
		void newP1Paddle(int colorID) {
			this.p1PaddleColorID = colorID;
		}
		void newP2Paddle(int colorID) {
			this.p2PaddleColorID = colorID;
		}
		void newBColor(int colorID) {
			this.bColorID = colorID;
		}
}
