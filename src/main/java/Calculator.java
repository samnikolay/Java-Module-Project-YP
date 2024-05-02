import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    /* Класс хронит в себе добавленные товары и общую сумму за эти товары */

    ArrayList<Goods> goodsList = new ArrayList<>(); // Создаем массив для имен продуктов
    double summa; // Создаем переменную под общую сумму

    public  Calculator() {
        Scanner scanner = new Scanner(System.in); // Подключаем сканер
        while(true) {
            String goodsName;
            System.out.println("Введите товар или команду [Завершить]:"); // Просим пользователя ввести название товара или завершить подсчет
            goodsName = scanner.next(); // Сканируем введенный текст

            if(goodsName.equalsIgnoreCase("Завершить")) { // Сравниваем строку с командой завершения
                break; // если пользователь ввел "Завершить", то останавливаем цикл
            }
            else if (goodsName.trim().isEmpty()) { // Режем пробелы и проверяем на пустоту
                System.out.println("Ошибка! Название товара не должно быть пустым."); // Если пользователь не ввел название и нажал Enter
                continue;
            }
            else { // Иначе (если все ОК) добавляем товар и просим пользователя ввести цену товара
                Goods goods = new Goods(goodsName);
                while(true) { // Цикл нужен, чтобы запрашивать цену товара у пользователя, пока тот не введет корректное значение
                    double price; // Для цены товаров
                    try {
                        Scanner scannerPrice = new Scanner(System.in); // Подключаем сканер (если этого не сделать, до зацикливается)
                        scannerPrice.useLocale(Locale.US); // В ТЗ сказано, что при вводе/выводе число должно разделяться точкой
                        System.out.println("Введите его цену в формате Рубли.Копейки:"); // Спрашиваем цену у пользователя
                        price = scannerPrice.nextDouble(); // Сканирует ответ

                        if(price >=0) { // если цена корректная
                            goods.price = price;
                            goodsList.add(goods);
                            summa += price;
                            break; // Останавливаем цикл с запросом цены
                        }
                        else { // Иначе выводим сообщение об ошибке
                            System.out.println("Ошибка. Цена не может быть отрицательной");
                        }

                    }
                    catch(Exception ex) {
                        System.out.println("Ошибка! Цена должна быть числом в формате Рубли.Копейки.");
                    }
                }
            }
        }
    }

    void printGoods() {
        Formatter formatter = new Formatter(); // Создаем экземпляр класса форматтера

        System.out.println("Добавленные товары:\n");
        for (Goods goods : goodsList) {
            System.out.println(goods.name + "-"+ formatter.numberFormat(goods.price));
        }
        System.out.println("Общая сумма "+ formatter.numberFormat(summa)); // Выводим общую сумму за все товары
    }
    void divideSumma(int people) {
        Formatter formatter = new Formatter(); // Создаем экземпляр класса форматтера
        System.out.println("Каждый должен заплатить "+ formatter.numberFormat(summa / people)); // Выводим результат
    }
}
