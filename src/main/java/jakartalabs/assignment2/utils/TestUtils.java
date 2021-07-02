package jakartalabs.assignment2.utils;

public class TestUtils {

	public static void hardWait(int timeInSeconds) {

		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}