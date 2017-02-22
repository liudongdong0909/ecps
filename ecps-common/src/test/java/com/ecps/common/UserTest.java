package com.ecps.common;

/**
 * 测试类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-22 上午 09:47
 */
public class UserTest {

    private Integer age;

    private String name;

    private Byte sex;

    private   String address;

    public UserTest() {
    }

    public UserTest(Integer age, String name, Byte sex, String address) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
