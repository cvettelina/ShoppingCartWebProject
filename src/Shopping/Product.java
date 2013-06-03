package Shopping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class Product implements ProductInterface {
    private String name;
    private String description;
    private BigDecimal cost;
    private String producer;
    private Date date;
    private static int counter = 0;
    private final int id;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public Product(String name, String description, BigDecimal cost, String producer, String img, int day, int month, int year)
    {
        this.name = name;
        this.description = description;
        this.cost = cost.setScale(2, BigDecimal.ROUND_CEILING);
        this.producer = producer;
        this.date = (new GregorianCalendar(day, month, year)).getTime();
        this.id = counter++;
        this.img = img;
    }

    public Product()
    {
        this.name = null;
        this.description = null;
        this.cost = new BigDecimal(0);
        this.producer = null;
        this.date = null;
        this.id = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "name=" + name + ", description=" + description
                + ", price=" + cost + ", producer=" + producer + ", date="
                + date + " ";
    }

    @Override
    public String isInstanceOf() {
        return this.getClass().toString();// get the name of the class as a string
    }

}
