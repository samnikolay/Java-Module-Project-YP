import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PeopleCounter peopleCounter = new PeopleCounter(); // Создаем экземпляр класса счетчика людей
        Calculator calc = new Calculator(); // Создаем экземпляр класса калькулятора
        calc.printGoods(); // Выводим все добавленные товары на экран
        calc.divideSumma(peopleCounter.peopleNumber); // Выводим итоговую сумму на одного человека
    }
}