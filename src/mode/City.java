package mode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;

public class City implements Serializable {
    private int idCity;
    private String nameCity;
    public static String[] list_tinh = {
            "An Giang",
            "Bà Rịa – Vũng Tàu",
            "Bạc Liêu",
            "Bắc Giang",
            "Bắc Kạn",
            "Bắc Ninh",
            "Bến Tre",
            "Bình Dương",
            "Bình Định",
            "Bình Phước",
            "Bình Thuận",
            "Cà Mau",
            "Cao Bằng",
            "Cần Thơ",
            "Đà Nẵng",
            "Đắk Lắk",
            "Đắk Nông",
            "Điện Biên",
            "Đồng Nai",
            "Đồng Tháp",
            "Gia Lai",
            "Hà Giang",
            "Hà Nam",
            "Hà Nội",
            "Hà Tĩnh",
            "Hải Dương",
            "Hải Phòng",
            "Hậu Giang",
            "Hòa Bình",
            "Thành phố Hồ Chí Minh",
            "Hưng Yên",
            "Khánh Hòa",
            "Kiên Giang",
            "Kon Tum",
            "Lai Châu",
            "Lạng Sơn",
            "Lào Cai",
            "Lâm Đồng",
            "Long An",
            "Nam Định",
            "Nghệ An",
            "Ninh Bình",
            "Ninh Thuận",
            "Phú Thọ",
            "Phú Yên",
            "Quảng Bình",
            "Quảng Nam",
            "Quảng Ngãi",
            "Quảng Ninh",
            "Quảng Trị",
            "Sóc Trăng",
            "Sơn La",
            "Tây Ninh",
            "Thái Bình",
            "Thái Nguyên",
            "Thanh Hóa",
            "Thừa Thiên Huế",
            "Tiền Giang",
            "Trà Vinh",
            "Tuyên Quang",
            "Vĩnh Long",
            "Vĩnh Phúc",
            "Yên Bái"};

    public City(int idCity, String nameCity) {
        this.idCity = idCity;
        this.nameCity = nameCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (idCity != city.idCity) return false;
        return nameCity.equals(city.nameCity);
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + nameCity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", nameCity='" + nameCity + '\'' +
                '}';
    }

    public static ArrayList<City> getCity(){
        ArrayList<City> listCity = new ArrayList<>();
        int id = 1;
        for (String cityName : list_tinh) {
            City city = new City(id++,cityName);
            listCity.add(city);
        }
        return listCity;
    }

    public static String getCityForId(int id){
        return getCity().get(id).getNameCity();
    }

    public static int getCityForName(String name){

        for(int i = 0;i<list_tinh.length;i++){
            if(name.equals(list_tinh[i])) return i;
        }
        return 1;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}
