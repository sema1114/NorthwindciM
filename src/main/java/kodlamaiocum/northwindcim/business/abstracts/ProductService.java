package kodlamaiocum.northwindcim.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaiocum.northwindcim.core.utilities.results.DataResult;
import kodlamaiocum.northwindcim.core.utilities.results.Result;
import kodlamaiocum.northwindcim.entities.concretes.Product;
import kodlamaiocum.northwindcim.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
   DataResult <List<Product>> getAll();
   DataResult <List<Product>> getAllSorted();//Datayı istediiğim şarta göre sırala
   DataResult <List<Product>> getAll(int pageNo,int pageSize);//SAYFALAMA İÇİN

   Result add(Product product);
   
   DataResult<Product> getByProductName(String productName);
   DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);//İki alana göre getircem Where ! ikiside olcak
   DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);//veya ürün ismi o olan veya o olan ! iksinden biri olsa yeter
	//select*from  products where productName=abc   and category_id =1 or category_id	
	//select*from  products where category_id  in(1,2,3,4) veya bunlardan birini
   DataResult<List<Product>> getByCategoryIn(List<Integer>categories); //Birden fazla göndereceğim için
	
   DataResult<List<Product>> getByProductNameContains(String productName);//ürün ismine göre arama
   DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	//JPQL
	
   DataResult<List<Product>>GetByNameAndCategory(String productName,int category_id);//select *from products where product_name=bisey and category_Id=bisey
   DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails();
	
   
   
}
