import java.awt.*;
import java.util.ArrayList;
class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		int k=0;
		//Your logic here
		for(Button b: buttons) {
			if(b == buttonClicked) {
				if((emptyCellId == (k+1))||(emptyCellId == (k-1))||(emptyCellId == (k+4))||(emptyCellId == (k-4))) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = k;
					break;	
				}
				
			}k++;		
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		int index[] = new int[16];
		
		//Your logic here
		int k=arr.length;
		while(k!=0) {
		int a = getRandomNumber();
		if(a>=15) {
			a=a%15+1;
		}
		if(index[a] == 0){
            if (arr[k - 1] == 0) {
                arr[--k] = a;
            } else {
                k--;
            }
            index[a] = 1;
        }
		
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1)
				return false;
		}

		return winner;
	}
}