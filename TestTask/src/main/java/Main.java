import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите строку вида: число[строка]");
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String inputString = scanner.nextLine();

            if (UnpackingString.validationCheck(inputString)) {

                System.out.println(UnpackingString.stringTransformation(inputString.toCharArray()));

            } else {

                System.out.println("Некорректный ввод, повторите!");

            }
        }
    }
}
