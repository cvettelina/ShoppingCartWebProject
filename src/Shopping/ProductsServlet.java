package Shopping;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public static List<ProductInterface> productList=new ArrayList<ProductInterface>();//static lists of products and services, which aim is to simulate a database
   public static List<ProductInterface> serviceList=new ArrayList<ProductInterface>();
   private boolean isFirstTime=false;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void addReadyProducts()//method, which adds ready products
    {
    	productList.add(new Product("bread","Hot soft bread",BigDecimal.valueOf(1.05),"Dobrudja","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTCD2g5EQPSmXsCtSLUuEREWp7ssP4vm6A2FJ1rBBNfaqhM2U-N",12,12,2012));
		productList.add(new Product("milk","white from a cow",BigDecimal.valueOf(3.05),"Dobrudja","http://www.giasks.com/wp-content/uploads/2011/10/milk.jpg",5,11,2010));
		productList.add(new Product("chocolate","sweet",BigDecimal.valueOf(6.05),"Dobrudja","http://i.telegraph.co.uk/multimedia/archive/02409/Dairy_milk_2409060b.jpg",1,4,1991));
		productList.add(new Product("apple","red",BigDecimal.valueOf(0.05),"Dobrudja","http://upload.wikimedia.org/wikipedia/commons/0/07/Honeycrisp-Apple.jpg",2,8,1889));
		serviceList.add(new Service("BabySitting","We will care about your child",BigDecimal.valueOf(7.0),false,"http://www.govacationmaya.com/_files/uploads/images/find_a_babysitter_job(1).gif"));
		serviceList.add(new Service("Car Wash","we will wash your car",BigDecimal.valueOf(13.50),true,"http://sunshinecarwashbirthdayclub.com/uploads/CarWash24181927std1-1.jpg"));
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(isFirstTime==false)// if this is the first call of the method we add the ready products to the shop
		{
			addReadyProducts();
			isFirstTime=true;
		}
		request.getSession().setAttribute("productList", productList);
		request.getSession().setAttribute("serviceList", serviceList);
		response.sendRedirect("ShoppinhPage.jsp");
	}

	private boolean addNewProduct(HttpServletRequest request)//adding new product in the list of products
	{
		//getting the input data
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String price=request.getParameter("price");
		String prod=request.getParameter("producer");
		String day=request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String img=request.getParameter("img");
		if(validDate(day,month,year)&&isValidInput(name,desc,price,img))
		{
			productList.add(new Product(name,desc,BigDecimal.valueOf(Double.parseDouble(price)),prod,img,Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year)));
			System.out.println(productList.toString());
			request.getSession().setAttribute("productList", productList);
			return true;
		}
		return false;
	}
	//checking for nulls and empty strings
	private boolean isValidData(String data)
	{
		if(data==null||"".equals(data))
		{
			return false;
		}
		return true;
	}
	private boolean validDate(String day, String month, String year)
	{
		int d,m,y;
		if(!isValidData(day)||!isValidData(month)||!isValidData(year))
		{
			return false;
		}
		if((day.matches("[0-9]*"))&&month.matches("[0-9]*")&&year.matches("[0-9]*"))
		{	
			d=Integer.parseInt(day);
			if(d<=0||d>31)
			{
				return false;
			}
			m=Integer.parseInt(month);
			if(m<=0||m>12)
			{
				return false;
			}
			y=Integer.parseInt(year);
			if(y<1800||y>2013){
				return false;
			}
		}
		else
			return false;
		return true;
	}
	//checking the input again
	private boolean isValidInput(String name,String desc,String price, String img){
		if(!isValidData(name)||(!isValidData(desc))||(!isValidData(price))||(!isValidData(img)))
		{
			return false;
		}
		if(!(price.matches("[0-9]*")))
		{
			return false;
		}
			
		return true;
	}
	private boolean addNewService(HttpServletRequest request)//adding new service in the list of services
	
	{
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String fixed=request.getParameter("fixed");
		String price=request.getParameter("price");
		String img=request.getParameter("img");
		//if the input data is valid we can add the new service to the shop
		if(isValidInput(name,desc,price,img))
		{
			serviceList.add(new Service(name,desc,BigDecimal.valueOf(Double.parseDouble(price)),Boolean.parseBoolean(fixed),img));
			request.getSession().setAttribute("productList", productList);
			System.out.println(Boolean.parseBoolean(fixed));
			return true;
		}
		return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonPressed=request.getParameter("enterService");
		boolean noError=true;
		if(buttonPressed!=null){
			noError=addNewService(request);
		}
		else
			noError=addNewProduct(request);
		
		if(noError)
			response.sendRedirect("ShoppinhPage.jsp");
		else
			response.sendRedirect("ErrorPage.jsp");
	}

}
