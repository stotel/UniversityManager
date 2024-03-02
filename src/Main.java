public class Main {

    public static void main(String[] args) {
        NaUKMA UNI = new NaUKMA();
        while (true) {
            System.out.println("Оберіть дію:");
            System.out.println("1. Створити/видалити/редагувати факультет");
            System.out.println("2. Створити/видалити/редагувати кафедру факультета");
            System.out.println("3. Додати/видалити/редагувати студента/викладача до кафедри");
            System.out.println("4. Знайти студента/викладача за ПІБ, курсом або групою");
            System.out.println("5. Вивести всіх студентів впорядкованих за курсами");
            System.out.println("6. Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом");
            System.out.println("7. Вивести всіх студентів кафедри впорядкованих за курсами");
            System.out.println("8. Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом");
            System.out.println("9. Вивести всіх студентів кафедри вказаного курсу");
            System.out.println("10. Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("0. Вихід");
            switch (DataInput.getInt("your option:")) {
                case 1:
                    System.out.println("Виберіть дію з факультетом:");
                    System.out.println("1. Створити");
                    System.out.println("2. Видалити");
                    System.out.println("3. Редагувати");
                    switch (DataInput.getInt("your option:",1,3)) {
                        case 1:
                            // Створити факультет
                            break;
                        case 2:
                            // Видалити факультет
                            break;
                        case 3:
                            // Редагувати факультет
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Виберіть дію з кафедрою:");
                    System.out.println("1. Створити");
                    System.out.println("2. Видалити");
                    System.out.println("3. Редагувати");
                    switch (DataInput.getInt("your option:",1,3)) {
                        case 1:
                            // Створити кафедру
                            break;
                        case 2:
                            // Видалити кафедру
                            break;
                        case 3:
                            // Редагувати кафедру
                            break;
                    }
                    break;
                case 3:
                    // Додати/видалити/редагувати студента/викладача до кафедри
                    break;
                case 4:
                    // Знайти студента/викладача за ПІБ, курсом або групою
                    break;
                case 5:
                    // Вивести всіх студентів впорядкованих за курсами
                    break;
                case 6:
                    // Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом
                    break;
                case 7:
                    // Вивести всіх студентів кафедри впорядкованих за курсами
                    break;
                case 8:
                    // Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом
                    break;
                case 9:
                    // Вивести всіх студентів кафедри вказаного курсу
                    break;
                case 10:
                    // Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом
                    break;
                case 0:
                    System.out.println("До побачення!");
                    return;
                default:
                    System.out.println("incorrect variant!");
                    break;
            }
        }
    }
}