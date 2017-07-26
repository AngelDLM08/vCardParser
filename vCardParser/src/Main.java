/**
 * Created by Angel on 26.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new VCard("Фамилия","Имя","Отчество","+71234567890","Компания","Должность"));
        System.out.println(new VCard().setFam("Фамилия").setName("Имя").setOtc("Отчество").setTel_cell("+71234567890").setOrg("Компания").setTitle("Должность"));
    }
}
