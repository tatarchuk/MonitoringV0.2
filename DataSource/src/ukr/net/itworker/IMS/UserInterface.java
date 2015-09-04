package ukr.net.itworker.IMS;

import java.util.concurrent.TimeUnit;

public class UserInterface {
	
	private static void freeze(int milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException ex) {
			// Handle an exception
			System.out.println("Delay problem: " + ex);
		}
	}

	public static void main(String[] args) {
		MeasureResultDAO dao = new MeasureResultDAO("admin", "kurs2015");
		while (true) {
			MeasurementController mc = new MeasurementController("COM3", 9600, 8, 1, 0);
			MeasureResult result = mc.getMeasureResult();
			dao.insertMeasureResult(result);
			System.out.println(result.toString());
			freeze(10000);
		}
		
	}

}
