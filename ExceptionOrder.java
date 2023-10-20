package com.company;

import java.util.Scanner;

public class ExceptionOrder{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите название блюда: ");
            String dish = scanner.nextLine();

            System.out.print("Введите количество порций: ");
            int quantity = scanner.nextInt();

            GoodOrder(quantity);

            System.out.println("Заказ: " + dish);
            System.out.println("Количество порций: " + quantity);
        } catch (FailOrder e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static void GoodOrder(int quantity) throws FailOrder {
        if (quantity < 0) {
            throw new FailOrder("Количество порций не может быть отрицательным.");
        }
        if (quantity > 20) {
            throw new FailOrder("Превышено максимальное допустимое количество порций (20).");
        }
    }
}

class FailOrder extends Exception {
    private String error;

    public FailOrder(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error;
    }
}