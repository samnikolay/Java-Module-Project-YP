import java.util.Locale;
import java.util.Scanner;

public class PeopleCounter {
    public  int peopleNumber;  // Кол-во людей для разделения счет

    public PeopleCounter() {
        while(true) {
            System.out.println("На скольких человек необходимо разделить счёт"); // Задаем вопрос пользователю

            try {
                Scanner scanner = new Scanner(System.in); // Подключаем сканер
                scanner.useLocale(Locale.US); // В ТЗ сказано, что при вводе/выводе число должно разделяться точкой
                peopleNumber = scanner.nextInt(); // Сканируем его ответ
                if (peopleNumber <= 1) {
                    System.out.println("Ошибка. Нельзя разделить счет на введенное количество людей");
                }
                else { // Если ответ корректный, то останавливаем цикл
                    break;
                }
            }
            catch(Exception ex) {
                System.out.println("Ошибка! Нужно ввести целое цисло.");
            }
        }
    }


}
