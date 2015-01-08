import java.util.Random;

public class Piet extends Thread {
	
	private String color;

	public Piet() {
		
		Random random = new Random();
		int randomInt = random.nextInt(2);
		switch(randomInt) {
			case 0:
				this.color = "zwart";
				break;
			case 1:
				this.color = "stroopwafel";
				break;
			case 2:
				this.color = "regenboog";
				break;
		}
	}
	
	public String getColor() {
		return color;
	}

}
