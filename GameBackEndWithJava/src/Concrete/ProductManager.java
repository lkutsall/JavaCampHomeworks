package Concrete;

import Abstract.ProductService;

public class ProductManager implements ProductService {

	@Override
	public void add(Product product) {
		System.out.println("The " + product.getProductName() + ", added to your cart successfully with the price: " + product.price + "$");
		
	}

	@Override
	public void update(Product product) {
		System.out.println("The " + product.getProductName() + ", updated.");
		
	}

	@Override
	public void delete(Product product) {
		System.out.println("The " + product.getProductName() + ", deleted.");
		
	}

}
