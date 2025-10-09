public class Main {
    public static void main(String[] args) {

        Table table1 = new Table("Дерево", 12000.0, "Коричневый", 4, 1.5);
        Table table2 = new Table("Дерево", 17000.0, "Коричневый", 4, 2.0);
        Chair chair1 = new Chair("Металл", 30000.0, "Чёрный", true, 0.4);
        Bed bed1 = new Bed("ДСП", 25000.0, "Белый", "Двуспальная", true);

        table1.displayInfo();
        System.out.println();
        table2.displayInfo();
        System.out.println();
        chair1.displayInfo();
        System.out.println();
        bed1.displayInfo();
        System.out.println();

        System.out.println("Всего создано стулов: " + Table.getTableCount());
        System.out.println();

        Furniture[] furniture = {table1, chair1, bed1};
        for (Furniture item : furniture) {
            item.use();
            item.displayInfo();
            System.out.println();
        }
    }
}