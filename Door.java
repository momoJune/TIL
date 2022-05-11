package self;

public interface Door {
	void openDoor();
	void closeDoor();
}

class MyDoor implements Door{

	@Override
	public void openDoor() {
		System.out.println("my door opened");
	}

	@Override
	public void closeDoor() {
		System.out.println("my door closed");
	}
	
}