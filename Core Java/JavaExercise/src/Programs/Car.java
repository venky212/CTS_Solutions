package Programs;

public class Car {
	String make;
	String model;
	int year;
	//Constructor Creation
	public Car (String make, String model, int year) {
		this.make=make;
		this.model=model;
		this.year=year;
	}
	//Method Creation
	public void displayDetails() {
		System.out.println("Make of the car : " + make);
		System.out.println("Model of the car : " + model);
		System.out.println("Year of the car : " + year);
		
	}

	public static void main(String[] args) {
		//object creation
		Car obj =new Car("Audi", "Royal Blue", 2025);
		obj.displayDetails();

	}

}
