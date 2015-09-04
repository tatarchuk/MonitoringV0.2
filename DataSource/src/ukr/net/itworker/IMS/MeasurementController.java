package ukr.net.itworker.IMS;

import java.util.StringTokenizer;

public class MeasurementController {

	private String port = "COM1";
	private int rate = 9600;
	private int bits = 8;
	private int stopBits = 1;
	private int parity = 0;
	
	public MeasurementController(String port, int rate, int bits, int stopBits, int parity) {
		this.port = port;
		this.rate = rate;
		this.bits = bits;
		this.stopBits = stopBits;
		this.parity = parity;
	}
	
	public MeasurementController() {
		
	}
	
	public String getRawData() {
		String rawString = "";		
		rawString = SerialIO.readData((byte) 'A', port, rate, bits, stopBits, parity);
		return rawString;
	}
	
	public MeasureResult getMeasureResult() {
		StringTokenizer splitter = new StringTokenizer(getRawData(), "\t\n");
		String[] splittedResult = {"0.00", "0.00"};
		int index = 0;
		while (splitter.hasMoreElements()) {
			splittedResult[index] = splitter.nextToken();
			index++;
		}
		double temperatureValue = 0.00;
		double humidityValue = 0.00;		
		try {
			temperatureValue = Double.parseDouble(splittedResult[0]);
			humidityValue = Double.parseDouble(splittedResult[1]);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		}
		return new MeasureResult(temperatureValue, humidityValue);
	}
	
}
