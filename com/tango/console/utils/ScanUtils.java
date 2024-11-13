package com.tango.console.utils;

import java.util.Scanner;

public class ScanUtils {
    private static Scanner scanner = new Scanner
    (System.in);


    // num -- 菜单选项的数量
    public static int readMenuSelection(int num) {
        char selection;
        char limit = new String(num + "").charAt(0);
        while (true) {
            selection = readKeyBoard(1).charAt(0);

            if (selection < '1' || selection > limit) {
                System.out.print("输入错误，请重新输入:");
                continue;
            } else
                break;
        }
        return selection - '0';
    }

    public static char readConfrimationSelection() {
        char confirmation;
        while (true) {
            confirmation = readKeyBoard(1).toUpperCase().charAt(0);
            if (confirmation == 'Y' || confirmation == 'N') {
                break;
            } else {
                System.out.print("输入错误,请重新输入:");
            }
        }
        return confirmation;
    }

    public static String readString(String tips) {
        System.out.print(tips);
        return scanner.nextLine();
    }

    private static String readKeyBoard(int limit) {
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度错误(不大于" + limit + ")" + ", 请重新输入:");
                continue;
            } else
                break;
        }
        return line;
    }
}
