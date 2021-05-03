package oopIntro;

public class Main {

	public static void main(String[] args) {

		ProductManager productManager = new ProductManager();
		
		Product product1 = new Product(1, "Lenovo V14", "8 gb ram", 10, 15000);
		
		Product product2 = new Product();
		product2.setId(2);
		product2.setName("Lenovo V15");
		product2.setDetail("16 gb ram");
		product2.setDiscount(10);
		product2.setUnitPrice(16000);
		
		System.out.println(product2.getUnitPriceAfterDiscount());
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Beverages");
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Food");
		
		System.out.println(category1.getName());
		System.out.println(category2.getName());
	}

}
