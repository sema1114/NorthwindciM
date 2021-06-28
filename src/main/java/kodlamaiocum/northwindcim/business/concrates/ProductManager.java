package kodlamaiocum.northwindcim.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaiocum.northwindcim.business.abstracts.ProductService;
import kodlamaiocum.northwindcim.core.utilities.results.DataResult;
import kodlamaiocum.northwindcim.core.utilities.results.ErrorDataResult;
import kodlamaiocum.northwindcim.core.utilities.results.Result;
import kodlamaiocum.northwindcim.core.utilities.results.SuccessDataResult;
import kodlamaiocum.northwindcim.core.utilities.results.SuccessResult;
import kodlamaiocum.northwindcim.dataAccess.abstracts.ProductDao;
import kodlamaiocum.northwindcim.entities.concretes.Product;
import kodlamaiocum.northwindcim.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
       try {
    	   return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data Listelendi");
       } catch (Exception e) {
    	   return new ErrorDataResult<List<Product>>(productDao.findAll(),"Data Listelenemedi");
      }
					
	}

	@Override
	public Result add(Product product) {
		
        this.productDao.save(product);
    
		return new SuccessResult("Ürün Eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
 	   return new SuccessDataResult <Product>
 	   (productDao.getByProductName(productName), "Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		// Buraya Business codes eğer listelenmesi için şunun şunun olması lazım yoksa listeleme
		return new SuccessDataResult <Product>
	 	   (productDao.getByProductNameAndCategory_CategoryId(productName,categoryId), "Data Listelendi");	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		 return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi");	
		 }

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		 return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories), "Data Listelendi");	
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		 return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Data Listelendi");	
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int category_id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(productDao.GetByNameAndCategory(productName, category_id),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        
		Pageable pageble=PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageble).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");//by direction hangi yönde //ve .domain
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data Listeleme Başarılı!");
	}

}
