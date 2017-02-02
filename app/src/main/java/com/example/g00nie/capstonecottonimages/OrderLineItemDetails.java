package com.example.g00nie.capstonecottonimages;

/**
 * Created by aleja on 2/2/2017.
 */

public class OrderLineItemDetails {
    int OrderID,
            Quantity,
            LineItemID;
    String ProductID;
    double Price;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getLineItemID() {
        return LineItemID;
    }

    public void setLineItemID(int lineItemID) {
        LineItemID = lineItemID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
