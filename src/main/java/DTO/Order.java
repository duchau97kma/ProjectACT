package DTO;

import java.util.Date;

public class Order {
    private int id_order;
    private int id_member;
    private Member member;
    private Date orderDate;
    private int status;

    public Order() {
    }

    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order(Date orderDate, int status) {
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(int id_order, int id_member, Date orderDate, int status) {
        this.id_order = id_order;
        this.id_member = id_member;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(int id_order, Member member, int status) {
        this.id_order = id_order;
        this.member = member;
        this.status = status;
    }

    public Order(int id_order, Member member, Date orderDate, int status) {
        this.id_order = id_order;
        this.member = member;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(int id_order) {
        this.id_order = id_order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", member=" + member.getFullname() +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }


    //    public Order(int id_order, int id_member, Date orderDate, int status) {
//        this.id_order = id_order;
//        this.id_member = id_member;
//        this.orderDate = orderDate;
//        this.status = status;
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
//    public int getId_member() {
//        return id_member;
//    }
//
//    public void setId_member(int id_member) {
//        this.id_member = id_member;
//    }
//
//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id_order=" + id_order +
//                ", type=" + id_member +
//                ", orderDate=" + orderDate +
//                ", status=" + status +
//                '}';
//    }
}
