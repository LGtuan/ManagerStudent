package mode;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int id;
    private String name;
    private  City city;
    private float point1;
    private float point2;
    private float point3;
    private Date date;
    private boolean sex;

    public Student(){

    }

    public Student(int id, String name, City city, float point1, float point2, float point3, Date date, boolean sex) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.date = date;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (Float.compare(student.point1, point1) != 0) return false;
        if (Float.compare(student.point2, point2) != 0) return false;
        if (Float.compare(student.point3, point3) != 0) return false;
        if (sex != student.sex) return false;
        if (!name.equals(student.name)) return false;
        if (!city.equals(student.city)) return false;
        return date.equals(student.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + (point1 != +0.0f ? Float.floatToIntBits(point1) : 0);
        result = 31 * result + (point2 != +0.0f ? Float.floatToIntBits(point2) : 0);
        result = 31 * result + (point3 != +0.0f ? Float.floatToIntBits(point3) : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + (sex ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", date=" + date +
                ", sex=" + sex +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public float getPoint1() {
        return point1;
    }

    public void setPoint1(float point1) {
        this.point1 = point1;
    }

    public float getPoint2() {
        return point2;
    }

    public void setPoint2(float point2) {
        this.point2 = point2;
    }

    public float getPoint3() {
        return point3;
    }

    public void setPoint3(float point3) {
        this.point3 = point3;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
