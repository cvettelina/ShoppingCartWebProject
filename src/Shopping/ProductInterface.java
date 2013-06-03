package Shopping;

import java.math.BigDecimal;

public interface ProductInterface {
	public BigDecimal getCost();
	public String isInstanceOf();
	public String getName();
	public void setName(String name);
	public void setDescription(String description);
	public String getDescription();
	
}
