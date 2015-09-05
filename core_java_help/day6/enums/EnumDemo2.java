package enums;

// An enumeration of Colors 
enum Colors1 {
	RED(10), YELLOW(5), GREEN(3), BLUE(7), ORANGE(8);

	private int temperature;

	Colors1(int temperature) {
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}

class EnumDemo2 {
	public static void main(String args[]) {
		// to disp all vals of enum
		for (Colors1 c : Colors1.values())
			System.out.printf("Name %s toString %s ordinal %d Temp. %d%n ",
					c.name(), c, c.ordinal(), c.getTemperature());
	}
}
