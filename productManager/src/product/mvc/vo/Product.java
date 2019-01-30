package product.mvc.vo;

public class Product {

	private String productid;
	private String pname;
	private int price;
	private String description;
	
	public Product() {}
	
	public Product(String productid, String pname, int price, String description) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.price = price;
		this.description = description;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", pname=" + pname + ", price=" + price + ", description="
				+ description + "]";
	}

	
}
