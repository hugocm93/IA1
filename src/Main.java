import Controller.Flow;

public class Main {

	public static void main(String[] args) {
		String aux = OSValidator.detectOS();

		switch(aux){
		case "Windows":
			break;

		case "Mac":
			break;

		case "Linux":
			break;
		}
		Flow.createWindow();
	}
}


