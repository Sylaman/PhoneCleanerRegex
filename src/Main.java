import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pattern = ("([0-9])([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})");
        String replacement = "+$1 ($2) $3-$4-$5";

        while (true) {
            System.out.println("Введите номер телефона. Для выхода из программы введите \"0\" ");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Работа программы завершена.");
                scanner.close();
                break;
            }

            //удаляем все лишние символы
            String phoneNumber = input.replaceAll("[^0-9]", "");

            if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
                System.out.println("Неверный формат номера");
                continue;
            }

            if (phoneNumber.length() == 10) {
                phoneNumber = "7".concat(phoneNumber);
            }

            if (phoneNumber.charAt(0) != '7' && phoneNumber.charAt(0) != '8') {
                System.out.println("Неверный формат номера");
                continue;
            }

            if (phoneNumber.charAt(0) == '8') {
                phoneNumber = phoneNumber.replaceFirst("8", "7");
            }

            System.out.println(phoneNumber.replaceAll(pattern, replacement));
        }
    }

}

