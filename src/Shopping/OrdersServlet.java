package Shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ShoppingCart myCart = new ShoppingCart();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String remProd = request.getParameter("removeProd");
        String remServ = request.getParameter("removeServ");
        String button = null;
        int remove = 0;
        if (remProd != null)// check which button is pressed
        {
            try {
                remove = Integer.parseInt(remProd);
                button = "Product";
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }// get the product we want to remove (get it from the list with all
             // products)
        } else {
            if (remServ != null) {
                try {
                    remove = Integer.parseInt(remServ);
                    button = "Service";
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }// get the product we want to remove (get it from the list with
                 // all products)
            }
        }
        if (button != null) {
            removeProd(button, remove);
        }
        request.getSession().setAttribute("myCart", myCart);
        response.sendRedirect("ShoppinhPage.jsp");
    }

    private void removeProd(String button, int remove) {
        if (button.equals("Product"))// check which button is pressed
        {
            try {
                myCart.removeProduct(ProductsServlet.productList.get(remove));
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (button.equals("Service")) {
                try {
                    myCart.removeProduct(ProductsServlet.serviceList
                            .get(remove));
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }// get the product we want to remove (get it from the list with
                 // all products)
            }
        }

    }

    private boolean putProduct(int order, HttpServletRequest request) {// adding product in the cart
        int quantity = 0;
        ProductInterface prod = null;
        try {
            prod = ProductsServlet.productList.get(order);
        } catch (IndexOutOfBoundsException e1) {
            e1.printStackTrace();
            return false;
        }
        try {
            quantity = Integer.parseInt(request.getParameter(prod.getName()));
            if (myCart.getProducts().containsKey(prod)) {
                int temp = myCart.getProducts().get(prod);
                myCart.addProduct(prod, quantity + temp);
            } else
                myCart.addProduct(prod, quantity);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean putService(int order, HttpServletRequest request)// adding service in the cart
    {
        int quantity = 0;
        Service serv = (Service) ProductsServlet.serviceList.get(order);
        if (serv.getFixed())// if the price is fixed=>setting quantity to 1
        {
            myCart.addProduct(serv, 1);
        } else {
            try {
                quantity = Integer
                        .parseInt(request.getParameter(serv.getName()));
                if (myCart.getProducts().containsKey(serv)) {
                    int temp = myCart.getProducts().get(serv);
                    myCart.addProduct(serv, quantity + temp);
                } else
                    myCart.addProduct(serv, quantity);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        return true;

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("order");
        int order;
        boolean noErr = true;
        if (button != null) {
            order = Integer.parseInt(button);
            noErr = putProduct(order, request);
        } else {
            order = Integer.parseInt(request.getParameter("service"));
            noErr = putService(order, request);
        }
        request.getSession().setAttribute("myCart", myCart);
        if (noErr)
            response.sendRedirect("ShoppinhPage.jsp");
        else
            response.sendRedirect("ErrorPage.jsp");
    }
}
