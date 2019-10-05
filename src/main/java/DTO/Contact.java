package DTO;

public class Contact {
    private int id_contact;
    private int id_member;
    private Member member;
    private String content;

    public Contact() {
    }

    public Contact(int id_contact, int id_member, String content) {
        this.id_contact = id_contact;
        this.id_member = id_member;
        this.content = content;
    }

    public Contact(int id_contact, int id_member, Member member, String content) {
        this.id_contact = id_contact;
        this.id_member = id_member;
        this.member = member;
        this.content = content;
    }

    public Contact(int id_member, Member member, String content) {
        this.id_member = id_member;
        this.member = member;
        this.content = content;
    }

    public int getId_contact() {
        return id_contact;
    }

    public void setId_contact(int id_contact) {
        this.id_contact = id_contact;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id_contact=" + id_contact +
                ", id_member=" + id_member +
                ", member=" + member.getFullname() +
                ", content='" + content + '\'' +
                '}';
    }
}
