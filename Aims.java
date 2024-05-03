
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		// Add to cart
		System.out.println("1. Testing Add Method");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Finction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		// First Display
		anOrder.displayCartItems();
		
		// Remove From Cart
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon");
		
		anOrder.removeDigitalVideoDisc(dvd4);
		anOrder.removeDigitalVideoDisc(dvd3);
		
		// Second Display
		anOrder.displayCartItems();
		
		System.out.println("Total Cost is: " + String.format("%.2f", anOrder.totalCost()));
	}

}
