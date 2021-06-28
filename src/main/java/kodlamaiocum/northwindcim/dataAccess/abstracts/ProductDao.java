package kodlamaiocum.northwindcim.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaiocum.northwindcim.entities.concretes.Product;
import kodlamaiocum.northwindcim.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> {
	
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);//İki alana göre getircem Where ! ikiside olcak
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);//veya ürün ismi o olan veya o olan ! iksinden biri olsa yeter
	//select*from  products where productName=abc   and category_id =1 or category_id	
	//select*from  products where category_id  in(1,2,3,4) veya bunlardan birini
	List<Product> getByCategoryIn(List<Integer>categories); //Birden fazla göndereceğim için
	
	List<Product> getByProductNameContains(String productName);//ürün ismine göre arama
	List<Product> getByProductNameStartsWith(String productName);
	
	//JPQL
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> GetByNameAndCategory(String productName,int categoryId);//select *from products where product_name=bisey and category_Id=biseyProductWithCategoryDto
	
	
	//JPQL // ONETOMANY GIT yıldız yerine yazdığım için öncesinde select arkada bu constructor ı çalıştıracaktır
	
	                     //burdaki paketteki alanlara Fromdan sonrasını aktarıcaz          category ile categoryle ilişkilenmiş productlardan
	@Query("Select new  kodlamaiocum.northwindcim.entities.dtos.ProductWithCategoryDto"
			+"(p.id,p.productName,c.categoryName)"
			+"From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();//select p.product_id,p.product_name from Category c inner join Product p on c.category_id=p.category_id

	
	

	
}
