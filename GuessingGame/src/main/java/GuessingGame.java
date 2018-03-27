import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GuessingGame {

	Jar game;

	public static void main(String[] args) {

		GuessingGame myGame = new GuessingGame();
		myGame.startGame();

	}

	private void startGame() {
		String name = null;
		int maxNum = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			name = getNamePrompt(br);
			maxNum = getMaxNumPrompt(br, name);
			game = new Jar(name, maxNum);
			playGame(br);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void playGame(BufferedReader br) throws IOException {
		System.out.println("Player");
		System.out.println("===================");
		System.out.printf(
				"Your goal is to guess how many %s\'s are in the jar. Your guess should be between 1 and %d \n",
				game.getName(), game.getMaxNumber());
		boolean wonGame = false;
		int guess = -1;
		int numGuess = 0;
		while (!wonGame) {
			System.out.print("Guess: ");
			try {
				guess = Integer.parseInt(br.readLine());
				numGuess += 1;
				if (guess == game.getRandomNumber()) {
					wonGame = true;
				}

				if (guess > game.getRandomNumber()) {
					System.out.println("Your guess is too high");
				} else if (guess < game.getRandomNumber()) {
					System.out.println("Your guess is too low");
				}
				;
			} catch (NumberFormatException e) {
				System.out.print("Please enter a valid number \n");
			}

			if (wonGame) {
				System.out.printf(
						"Congratulations - you guessed there were %d %s\'s in the jar! It took you %d guess to get it right \n",
						guess, game.getName(), numGuess);
			}
		}
	}

	private String getNamePrompt(BufferedReader br) throws IOException {
		System.out.println("Administrator");
		System.out.println("===================");
		System.out.print("Name of items in the jar: ");
		boolean nameProvided = false;
		String itemName = null;
		while (!nameProvided) {
			itemName = br.readLine();

			if (itemName.length() > 0) {

				nameProvided = true;

			}

			else {
				System.out.print("Item name is requied. Please provide a name:  ");
			}
		}

		return itemName;
	}

	private int getMaxNumPrompt(BufferedReader br, String name) throws IOException {
		System.out.printf("Max number of %s in the jar: ", name);
		int maxNum = 0;
		boolean num = false;
		while (!num) {
			try {
				maxNum = Integer.parseInt(br.readLine());
				num = true;
			} catch (NumberFormatException e) {
				System.out.print("Please enter a valid number: ");
			}
		}
		return maxNum;
	}

}
