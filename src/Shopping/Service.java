package Shopping;

import java.math.BigDecimal;

public class Service implements ProductInterface{
	private String name;
	private String description;
	private BigDecimal cost;
	private boolean fixed;
	private static int counter=0;
	private String img;
	private int id;
	
	public Service(String name, String description, BigDecimal cost,
			boolean fixed,String img) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.fixed = fixed;
		this.id=counter++;
		this.img=img;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public boolean getFixed() {
		return fixed;
	}
	public void setFixed(boolean typeOfPayment) {
		this.fixed = typeOfPayment;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String isInstanceOf() {
		return this.getClass().toString();
	}

}
