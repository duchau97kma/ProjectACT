package DTO;

public class OrderDetails {
    private int id_order;
    private int id_tour;
    private Tour tour;
    private Order order;
    private double totalPrice;
    private int totalUser;
    public OrderDetails() {
    }

    public OrderDetails(int id_order, int id_tour, double totalPrice, int totalUser) {
        this.id_order = id_order;
        this.id_tour = id_tour;
        this.totalPrice = totalPrice;
        this.totalUser = totalUser;
    }

    public OrderDetails(Tour tour, Order order, double totalPrice, int totalUser) {
        this.tour = tour;
        this.order = order;
        this.totalPrice = totalPrice;
        this.totalUser = totalUser;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalUser() {
        return totalUser;
    }

    public void setTotalUser(int totalUser) {
        this.totalUser = totalUser;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "tour=" + tour.getNameTour() +
                ", order=" + order.getId_order() +
                ", totalPrice=" + totalPrice +
                ", totalUser=" + totalUser +
                '}';
    }
    //    public OrderDetails(int id_order, int id_tour, double totalPrice, int totalUser) {
//        this.id_order = id_order;
//        this.id_tour = id_tour;
//        this.totalPrice = totalPrice;
//        this.totalUser = totalUser;
//    }
//
//    public int getId_order() {
//        return id_order;
//    }
//
//    public void setId_order(int id_order) {
//        this.id_order = id_order;
//    }
//
//    public int getId_tour() {
//        return id_tour;
//    }
//
//    public void setId_tour(int id_tour) {
//        this.id_tour = id_tour;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public int getTotalUser() {
//        return totalUser;
//    }
//
//    public void setTotalUser(int totalUser) {
//        this.totalUser = totalUser;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderDetails{" +
//                "id_order=" + id_order +
//                ", id_tour=" + id_tour +
//                ", totalPrice=" + totalPrice +
//                ", totalUser=" + totalUser +
//                '}';
//    }
}
