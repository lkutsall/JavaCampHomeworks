package Abstract;

import Concrete.Product;

public interface ProductService {

	void add(Product product);
	void update(Product product);
	void delete(Product product);
}
