package DTO;

import java.util.Date;

public class Member {
    private int id_member;
    private String account;
    private String password;
    private String fullname;
    private String phone;
    private int permission;
    private Date create_at;

    public Member() {
    }

    public Member(String fullname) {
        this.fullname = fullname;
    }

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Member(String account, String password, int permission) {
        this.account = account;
        this.password = password;
        this.permission = permission;
    }

    public Member(int id_member, String account, String password, String fullname, String phone, int permission) {
        this.id_member = id_member;
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.permission = permission;
    }

    public Member(int id_member, String account, String password, String fullname, String phone, int permission, Date create_at) {
        this.id_member = id_member;
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.permission = permission;
        this.create_at = create_at;
    }

    public Member(String account, String password, String fullname, String phone, int permission, Date create_at) {
        this.account = account;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.permission = permission;
        this.create_at = create_at;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id_member=" + id_member +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", permission=" + permission +
                ", create_at=" + create_at +
                '}';
    }

}
