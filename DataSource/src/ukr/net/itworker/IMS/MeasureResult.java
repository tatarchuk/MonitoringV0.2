package ukr.net.itworker.IMS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeasureResult {
	
	public MeasureResult() {
		
	}
	
	public MeasureResult(double temperatureValue, double humidityValue) {
		this.temperatureValue = temperatureValue;
		this.humidityValue = humidityValue;
	}
	
	private Date currentDate = new Date();	
	private DateFormat currentDateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");	
	
	private String currentDateTimeValue = currentDateTimeFormat.format(currentDate);
	
	private double temperatureValue = 0.0;
	private double humidityValue = 0.0;		

	public double getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(double temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public double getHumidityValue() {
		return humidityValue;
	}

	public void setHumidityValue(double humidityValue) {
		this.humidityValue = humidityValue;
	}	
	
	public String getCurrentDateTimeValue() {
		return currentDateTimeValue;
	}

	public void setCurrentDateTimeValue(String currentDateTimeValue) {
		this.currentDateTimeValue = currentDateTimeValue;
	}	

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return currentDateTimeValue + '\t' + temperatureValue + '\t' + humidityValue + '\n';
	}

}
