package yongs.temp.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "example_product")
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Product {
	@Id
	private String id;
	private String category;
    private String name;
    private int madein;
    private int shippingfee;
    private long price;    
    private String imageName;
    private String imageUrl;  
	       
	public Product(String id, String category, String name, int madein, int shippingfee, long price, String imageUrl) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.madein = madein;
		this.shippingfee = shippingfee;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMadein() {
		return madein;
	}
	public void setMadein(int madein) {
		this.madein = madein;
	}
	public int getShippingfee() {
		return shippingfee;
	}
	public void setShippingfee(int shippingfee) {
		this.shippingfee = shippingfee;
	}
}
