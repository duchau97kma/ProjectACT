package DTO;

public class ItemReport {
    private String date;
    private double totalPrice;

    public ItemReport() {
    }

    public ItemReport(String date, double totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    @Override
    public String toString() {
        return "ItemReport{" +
                "date='" + date + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }

}
