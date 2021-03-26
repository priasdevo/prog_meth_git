package logicEntities.base;

public class Affinity {
	private double fireAffinity;
	private double waterAffinity;
	private double windAffinity;
	private double earthAffinity;
	private double darkAffinity;
	private double lightAffinity;
	private double arcaneAffinity;
	
	public Affinity(double fireAffinity, double waterAffinity, double windAffinity, double earthAffinity,
			double darkAffinity, double lightAffinity, double arcaneAffinity) {
		super();
		this.fireAffinity = fireAffinity;
		this.waterAffinity = waterAffinity;
		this.windAffinity = windAffinity;
		this.earthAffinity = earthAffinity;
		this.darkAffinity = darkAffinity;
		this.lightAffinity = lightAffinity;
		this.arcaneAffinity = arcaneAffinity;
	}
	public double getFireAffinity() {
		return fireAffinity;
	}
	public void setFireAffinity(double fireAffinity) {
		this.fireAffinity = fireAffinity;
	}
	public double getWaterAffinity() {
		return waterAffinity;
	}
	public void setWaterAffinity(double waterAffinity) {
		this.waterAffinity = waterAffinity;
	}
	public double getWindAffinity() {
		return windAffinity;
	}
	public void setWindAffinity(double windAffinity) {
		this.windAffinity = windAffinity;
	}
	public double getEarthAffinity() {
		return earthAffinity;
	}
	public void setEarthAffinity(double earthAffinity) {
		this.earthAffinity = earthAffinity;
	}
	public double getDarkAffinity() {
		return darkAffinity;
	}
	public void setDarkAffinity(double darkAffinity) {
		this.darkAffinity = darkAffinity;
	}
	public double getLightAffinity() {
		return lightAffinity;
	}
	public void setLightAffinity(double lightAffinity) {
		this.lightAffinity = lightAffinity;
	}
	public double getArcaneAffinity() {
		return arcaneAffinity;
	}
	public void setArcaneAffinity(double arcaneAffinity) {
		this.arcaneAffinity = arcaneAffinity;
	}
	
}
