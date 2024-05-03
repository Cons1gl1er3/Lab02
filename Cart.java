
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println(disc.getTitle() + " has been added to cart.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc '" + disc.getTitle() + "' has been removed from cart.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find '" + disc.getTitle() + "'");
        }
    }
	
    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
    
    public String repeatString(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
    
    public void displayCartItems() {
        int maxTitleLength = 0;
        // First, find the maximum length of titles in the array to determine column width
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null) {
                int titleLength = itemOrdered[i].getTitle().length();
                if (titleLength > maxTitleLength) {
                    maxTitleLength = titleLength;
                }
            }
        }

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null) {
                String output = String.format("%d  %-"+ maxTitleLength + "s $%.2f", (i + 1), itemOrdered[i].getTitle(), itemOrdered[i].getCost());
                System.out.println(output);
            }
        }
    }
}