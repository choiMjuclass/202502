package lms;

public class LMain {

	// components
	private LFrame lFrame;
	
	// constructor
	public LMain() {
		this.lFrame = new LFrame();
	}	
	private void initialize() {
		this.lFrame.initialize();
		this.lFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		LMain lMain = new LMain();
		lMain.initialize();
	}
}
