package shopaholicjava;

public class CartProduct {
    private String CID;
    private String PID;
    private String ProductName;
    private String ProductType;
    private String Img;
    private int Quantity;
    private Float Price;


    public CartProduct() {
    }

    public CartProduct(String cartId, Float price, String productId, int quantity) {
        this.CID = cartId;
        this.Price = price;
        this.PID = productId;
        this.Quantity = quantity;
    }

    public String getCartId() {
        return CID;
    }

    public void setCartId(String cartId) {
        this.CID = cartId;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        this.Price = price;
    }
    
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String name) {
        this.ProductName = name;
    }
    
    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String type) {
        this.ProductType = type;
    }
    
    public String getImg() {
        return Img;
    }

    public void setImg(String image) {
        this.Img = image;
    }
    
    public String getProductId() {
        return PID;
    }

    public void setProductId(String productId) {
        this.PID = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + CID + '\'' +
                ", userId='" + Price + '\'' +
                ", productId='" + PID + '\'' +
                '}';
    }
}
