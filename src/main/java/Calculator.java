public class Calculator {
    /* Класс хронит в себе добавленные товары и общую сумму за эти товары */
    String goodsString = "Добавленные товары:\n"; // Задаем начальную строку
    double summa; // Создаем переменную под общую сумму
    Formatter formatter = new Formatter(); // Создаем экземпляр класса форматтера
    void addGoods(String name,double price) {
        goodsString = goodsString + name +" - "+ price +" "+ formatter.wordEnd(price) +"\n"; // Добавляем название товара и цену в строку
        summa += price; // Складываем цены в общую сумму
    }

    double divideSumma(double summa, int people) {
        return summa / people; // Возвращаем результат (такое сокращение предложила IDE)
    }
}
