package cn.itcast.pojo;

import java.util.Arrays;

public class User {
    private String name;
    private String userName;
    private Integer id;
    private Integer age;
    private Double income;
    private Boolean isMarry;
    private String[] interests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Boolean getMarry() {
        return isMarry;
    }

    public void setMarry(Boolean marry) {
        isMarry = marry;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", income=" + income +
                ", isMarry=" + isMarry +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }
}
