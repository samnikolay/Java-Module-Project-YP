import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int peopleNumber; // Кол-во людей для разделения счета
        String goods; // Для названий товаров
        double price; // Для цены товаров

        Scanner scanner = new Scanner(System.in); // Подключаем сканер
        scanner.useLocale(Locale.US); // В ТЗ сказано, что при вводе/выводе число должно разделяться точкой
        Calculator calc = new Calculator(); // Создаем экземпляр класса калькулятора
        Formatter formatter = new Formatter(); // Создаем экземпляр класса форматтера

        while(true) {
            System.out.println("На скольких человек необходимо разделить счёт"); // Задаем вопрос пользователю

            peopleNumber = scanner.nextInt(); // Сканируем его ответ
            if (peopleNumber <= 1) { // Проверяем ответ на корректность
                System.out.println("Ошибка. Нельзя разделить счет на введенное количество людей");
            }
            else { // Если ответ корректный, то останавливаем цикл
                break;
            }
        }

        while(true) {
            System.out.println("Введите товар или команду [Завершить]:"); // Просим пользователя ввести название товара или завершить подсчет

            goods = scanner.next(); // Сканируем введенный текст
            if(goods.equalsIgnoreCase("Завершить")) { // Сравниваем строку с командой завершения
                break; // если пользователь ввел "Завершить", то останавливаем цикл
            }
            else { // Иначе просим пользователя ввести цену товара
                while(true) { // Цикл нужен, чтобы запрашивать цену товара у пользователя, пока тот не введет корректное значение
                    System.out.println("Введите его цену в формате Рубли.Копейки:"); // Спрашиваем цену у пользователя
                    price = scanner.nextDouble(); // Сканирует ответ
                    if(price >=0) { // если цена корректная
                        calc.addGoods(goods,price); // добавляем товар в список
                        break; // Останавливаем цикл с запросом цены
                    }
                    else { // Иначе выводим сообщение об ошибке
                        System.out.println("Ошибка. Цена не может быть отрицательной");
                    }
                }
            }
        }

        System.out.println(calc.goodsString); // Выводим строку со списком товаров

        System.out.println("Общая сумма "+ formatter.numberFormat(calc.summa) +" "+ formatter.wordEnd(calc.summa)); // Выводим общую сумму за все товары
        System.out.println("Каждый должен заплатить "+ formatter.numberFormat(calc.divideSumma(calc.summa, peopleNumber))+" "+
                formatter.wordEnd(calc.divideSumma(calc.summa, peopleNumber))); // Выводим сумму, которую должен заплатить каждый

    }
}