import java.util.Random;

public class Jar {

	private String name;

	private int maxNumber;
	private int randomNumber;

	public Jar(String name, int maxNumber) {

		this.name = name;
		this.maxNumber = maxNumber;

		this.fillJar(maxNumber);

	}

	private void fillJar(int maxNumber) {
		this.randomNumber = new Random().nextInt(maxNumber) + 1;

	}

	public String getName() {
		return name;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

}