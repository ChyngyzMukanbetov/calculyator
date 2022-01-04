package com.company;

import calculyator.ArabicToRoman;

import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        System.out.println("Введите выражение римскими или арабскими цифрами, НЕ вводите знак = : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String operation = str.replaceAll("\\s+", "");
        String[] subStr;
        subStr = str.split("[+-/*]");
        int num1 = 0;
        Integer num42 = 123;
        int num2 = 0;
        int result = 0;
        boolean num1IsRoman = false;

        if (subStr.length != 2) {
            System.out.println("К сожалению калькулятор работает только с элементарными выражениями, не более 1 операции +, -, / или *");
            System.exit(0);
        } else {
            switch (subStr[0]) {
                case "I":
                    num1 = 1;
                    num1IsRoman = true;
                    break;
                case "II":
                    num1 = 2;
                    num1IsRoman = true;
                    break;
                case "III":
                    num1 = 3;
                    num1IsRoman = true;
                    break;
                case "IV":
                    num1 = 4;
                    num1IsRoman = true;
                    break;
                case "V":
                    num1 = 5;
                    num1IsRoman = true;
                    break;
                case "VI":
                    num1 = 6;
                    num1IsRoman = true;
                    break;
                case "VII":
                    num1 = 7;
                    num1IsRoman = true;
                    break;
                case "VIII":
                    num1 = 8;
                    num1IsRoman = true;
                    break;
                case "IX":
                    num1 = 9;
                    num1IsRoman = true;
                    break;
                case "X":
                    num1 = 10;
                    num1IsRoman = true;
                    break;
                default:
                    try {
                        num1 = Integer.parseInt(subStr[0]);

                    } catch (NumberFormatException e) {
                        System.out.println("Введите целые числа от 1 до 10 включительно");
                        e.printStackTrace();
                        System.exit(1);
                    }
            }
            //System.out.println(num1); //Проверка правильности конвертации num1
            if (num1IsRoman == true) {
                switch (subStr[1]) {
                    case "I":
                        num2 = 1;
                        break;
                    case "II":
                        num2 = 2;
                        break;
                    case "III":
                        num2 = 3;
                        break;
                    case "IV":
                        num2 = 4;
                        break;
                    case "V":
                        num2 = 5;
                        break;
                    case "VI":
                        num2 = 6;
                        break;
                    case "VII":
                        num2 = 7;
                        break;
                    case "VIII":
                        num2 = 8;
                        break;
                    case "IX":
                        num2 = 9;
                        break;
                    case "X":
                        num2 = 10;
                        break;
                    default:
                        System.out.println("Не смещивайте Арабские и римские цифры");
                        System.exit(2);
                }
            } else {
                try {
                    num2 = Integer.parseInt(subStr[1]);

                } catch (NumberFormatException e) {
                    System.out.println("Введите целые числа от 1 до 10 включительно, не смещивайте Арабские и римские цифры");
                    e.printStackTrace();
                    System.exit(3);
                }
            }
            //System.out.println(num2); //Проверка правильности конвертации num2

            String operators[] = operation.split("[a-zA-Z0-9]+");
            String operator = operators[1];
            //System.out.println(operator);

            if (num1 <= 10 & num2 <= 10 & num1 >= 0 & num2 >= 0) {
                if ("+".equals(operator)) {
                    result = num1 + num2;
                } else if ("-".equals(operator)) {
                    if (num1IsRoman == true && num1 <= num2) {
                        System.out.print("В римских цислах Результат не может быть отрицательным и равен 0");
                        System.exit(4);
                    } else {
                        result = num1 - num2;
                    }
                } else if ("*".equals(operator)) {
                    result = num1 * num2;
                } else if ("/".equals(operator)) {
                    if (num2 == 0) {
                        System.out.println("На ноль делить нельзя");
                        System.exit(5);
                    } else {
                        result = num1 / num2;
                    }
                } else {
                    throw new Error("Такой операции не существует");
                }
                if (num1IsRoman == false) {
                    System.out.print("Результат = " + result);
                } else {
                    ArabicToRoman romanResult = new ArabicToRoman();
                    System.out.println("Результат = " + romanResult.integerToRoman(result));

                }
            }
        }
    }
}



