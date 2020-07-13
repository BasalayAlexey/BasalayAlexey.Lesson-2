package AlexeyBasalay.HomeWork.lesson2.HomeWork2;
//Имеются три числа - день, месяц и год, вводимые пользователем с
//консоли.
//    Вывести дату следующего дня в формате &quot;День.Месяц.Год&quot;.
//    Учесть переход на следующий месяц, а также следующий год.
//    Форматирование строки &quot;День.Месяц.Год&quot; вынести в отдельную
//функцию.

import java.util.Scanner;

import static java.lang.System.*;

public class lesson2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        out.println("Введите день: ");
        int day = scanner.nextInt();
        out.println("Введите месяц: ");
        int month = scanner.nextInt();
        out.println("Введите год: ");
        int year = scanner.nextInt();

        if (isDateValid(day, month, year)) {
            printNextDay(day, month, year);
        } else {
            out.println("Не правильная дата");
        }
    }

    public static boolean isDateValid(int day, int month, int year) {
        if (day <= 0 || month <= 0 || month > 12 || year <= 0) {
            return false;
        }
        boolean result;
        if (month == 2) {
            if (isLeapYear(year)) {
                result = day <= 29;
            } else {
                result = day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            result = day <= 30;
        } else {
            result = day <= 31;
        }

        return result;
        }


    public static void printNextDay(int day, int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day == 29) {
                    out.println(formatDate(1, month + 1, year));
                } else {
                    out.println(formatDate(day + 1, month, year));
                }
            } else {
                if (day == 28) {
                    out.println(formatDate(1, month + 1, year));
                } else {
                    out.println(formatDate(day + 1, month, year));
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 30) {
                out.println(formatDate(1, month + 1, year));
            } else {
                out.println(formatDate(day + 1, month, year));
            }
        } else {
            if (day == 31) {
                if (month == 12) {
                    out.println(formatDate(1, 1, year + 1));
                } else
                    out.println(formatDate(1, month + 1, year));
            } else out.println(formatDate(day + 1, month, year));
        }
    }

    public static String formatDate(int day, int month, int year) {
        return day + "." + month + "." + year;
    }

    public static boolean isLeapYear(int year) {
        return ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0));
    }
    }
