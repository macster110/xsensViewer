package main;

import comms.SerialMessageParser;
import comms.SerialMessageParser.DataTypes;

/**
 * Holds sensor data. Orientation data and depth data. 
 * @author Jamie Macaulay
 *
 */
public class SensorData {
	
	public DataTypes flag;

	/**
	 * Constructor for angles. 
	 * @param angles - angles. lengfth of 3 is euler angles in degrres. Length of 4 is a quaternion. 
	 */
	public SensorData(double[] data, DataTypes flag) {
		this.flag=flag; 
		if (flag==DataTypes.EULAR_ANGLES) eularAngles=data; 
		if (flag==DataTypes.QUATERNION) quaternion=data; 
		if (flag==DataTypes.RGBDATA) rgb=data; 
		if (flag==DataTypes.PRESSURE_TEMPERATURE) {
			this.pressure=data[0];
			this.temperature=data[1]; 
		}
		if (flag==DataTypes.BATTERYDATA) batteryLevel=data[0]; 


	}
	
	/**
	 * Constructor for PTData. 
	 * @param pressure - the pressure data in mbar;
	 * @param temperature -the temperature in celsuis; 
	 */
	public SensorData(double pressure, double temperature) {
		this.pressure=pressure; 
		this.temperature=temperature; 
	}

	
	/**
	 * Constructor for battery data. 
	 * @param pressure - the pressure data in mbar;
	 * @param temperature -the temperature in celsuis; 
	 */
	public SensorData(double batteryLevel) {
		this.batteryLevel=batteryLevel; 
	}


	/**
	 * Euler angles in degrees
	 */
	public double[] eularAngles; 
	
	/**
	 * Quaternion orientation data.
	 */
	public double[] quaternion;
	
	/**
	 * Pressure in mbar
	 */
	public Double pressure; 
	
	/**
	 * The temperature in celsius 
	 */
	public Double temperature; 
	
	/**
	 * The battery 
	 */
	public Double batteryLevel; 
	
	/**
	 * Red, green and blue measurements. 
	 */
	public double[] rgb; 


}
