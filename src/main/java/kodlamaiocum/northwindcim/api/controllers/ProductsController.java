package kodlamaiocum.northwindcim.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaiocum.northwindcim.business.abstracts.ProductService;
import kodlamaiocum.northwindcim.core.utilities.results.DataResult;
import kodlamaiocum.northwindcim.core.utilities.results.Result;
import kodlamaiocum.northwindcim.entities.concretes.Product;
import kodlamaiocum.northwindcim.entities.dtos.ProductWithCategoryDto;


@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result saveProduct(@RequestBody Product p){
		
		return this.productService.add(p);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult <List<Product>>getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	

	@GetMapping("/getallByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		
		return this.productService.getAll(pageNo-1,pageSize);
	}
	
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}

 }
