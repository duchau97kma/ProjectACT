package DTO;

public class Item {
    private Tour tour;
    private int totalMember;

    public Item() {
    }

    public Item(Tour tour) {
        this.tour = tour;

    }

    public Item(Tour tour, int totalMember) {
        this.tour = tour;
        this.totalMember = totalMember;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }
}
