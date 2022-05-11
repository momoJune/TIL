package self;

public class Abstract {
	public static void main(String[] args) {
		Italian ital = new Italian();
		한국인 park = new 한국인();
		System.out.println(park.sayHi()); 
		System.out.println(park.sayBye()); 
		System.out.println(ital.sayHi()); 
		System.out.println(ital.sayBye()); 
		
		House basicHouse = new BasicHouse();
		
		basicHouse.openDoor();
		basicHouse.closeDoor();
		
		House myHouse = new MyHouse();
		Door myDoor = new MyDoor();
		myHouse.setDoor(myDoor);
		
		myHouse.openDoor();
		myHouse.closeDoor();
		
	}
}

class Person{
	public String sayHi() {
		return "hi";
	}
	public String sayBye() {
		return "bye?";
	}
}

class 한국인 extends Person{
	public String sayHi() {
		return "ㅎㅇ";
	}
} 

class Italian extends Person{}

abstract class House{
	private String roof = "house roof";
	private String wall = "house wall";
	private Door door;
	
	void setDoor(Door door) {
		this.door = door;
	}
	
	Door getDoor() {
		return door;
	}
	
	void openDoor() {
		System.out.println("door opened");
	}
	
	void closeDoor() {
		System.out.println("door closed");
	}
	
}

class BasicHouse extends House{
	
}

class MyHouse extends House{
	
	@Override
	void openDoor() {
		getDoor().openDoor();
	}
	@Override
	void closeDoor() {
		getDoor().closeDoor();
	}
}






