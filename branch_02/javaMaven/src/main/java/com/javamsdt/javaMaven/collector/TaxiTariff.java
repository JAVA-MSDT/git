package com.javamsdt.javaMaven.collector;

public class TaxiTariff {

	private int destinationNumber;
	private double tariffPerKillo;
	private String driverName;

	public TaxiTariff() {
		super();
	}

	public TaxiTariff(int destinationNumber, double tariffPerKillo, String driverName) {
		super();
		this.destinationNumber = destinationNumber;
		this.tariffPerKillo = tariffPerKillo;
		this.driverName = driverName;
	}

	public int getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(int destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	public double getTariffPerKillo() {
		return tariffPerKillo;
	}

	public void setTariffPerKillo(double tariffPerKillo) {
		this.tariffPerKillo = tariffPerKillo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "TaxiTariff [destinationNumber=" + destinationNumber + ", tariffPerKillo=" + tariffPerKillo
				+ ", driverName=" + driverName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destinationNumber;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tariffPerKillo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxiTariff other = (TaxiTariff) obj;
		if (destinationNumber != other.destinationNumber)
			return false;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (Double.doubleToLongBits(tariffPerKillo) != Double.doubleToLongBits(other.tariffPerKillo))
			return false;
		return true;
	}

}
