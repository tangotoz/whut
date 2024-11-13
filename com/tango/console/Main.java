package com.tango.console;

import java.util.Enumeration;

import com.tango.console.role.User;
import com.tango.console.service.DataProcessing;
import com.tango.console.utils.ScanUtils;

public class Main {
    public static void main(String[] args) {
        String tipSystem = "档案系统";
        String tipMenu = "请选择菜单:";
        StringBuilder builder = new StringBuilder();
        builder.append("==============").append(tipSystem).append("==============\n").append("==============")
                .append("1.登 录").append("==============\n").append("==============").append("2.退 出")
                .append("==============\n").append(tipMenu);
        String startMenu = builder.toString();

        
        while (true) {
            System.out.print(startMenu);
            int choice = ScanUtils.readMenuSelection(2);
            switch (choice) {
                case 1 -> login();
                case 2 -> exit();
            }
        }
    }
    
    public static void exit() {
        System.out.println("确认退出吗？(Y/N)");
        char confirmation = ScanUtils.readConfrimationSelection();
        if (confirmation == 'Y') {
            System.out.println("退出成功, 谢谢使用");
            System.exit(0);
        }
    }
    
    public static void login() {
        String name, password;

        name = ScanUtils.readString("请输入名字:");
        password = ScanUtils.readString("请输入密码:");

        User user = DataProcessing.search(name, password);

        if (user != null) {
            switch (user.getRole()) {
                case "browser" -> loginAsBrowser(user);
                case "operator" -> loginAsOperator(user);
                case "administrator" -> loginAsAdministrator(user);
            }
        } else {
            System.out.println("登录失败，请检查用户名和密码后重试。");
        }
    }
    
    public static void loginAsBrowser(User user) {
        while (true) {
            user.showMenu();

            int choice = ScanUtils.readMenuSelection(4);
            switch (choice) {
                case 1 -> user.downloadFile(null);
                case 2 -> user.showFileList();
                case 3 -> changePassword(user);
                case 4 -> user.exitSystem();
            }
        }
    }

    public static void loginAsOperator(User user) {
        while (true) {
            user.showMenu();
            int choice = ScanUtils.readMenuSelection(5);
            switch (choice) {
                case 1 -> System.out.println("上传档案...");
                case 2 -> user.downloadFile(null);
                case 3 -> user.showFileList();
                case 4 -> changePassword(user);
                case 5 -> user.exitSystem();
            }
        }
    }

    public static void loginAsAdministrator(User user) {
        while (true) {
            user.showMenu();
            int choice = ScanUtils.readMenuSelection(8);
            switch (choice) {
                case 1 -> insertUser();
                case 2 -> deleteUser();
                case 3 -> updateUser();
                case 4 -> listUsers();
                case 5 -> user.downloadFile(null);
                case 6 -> user.showFileList();
                case 7 -> changePassword(user);
                case 8 -> user.exitSystem();
            }
        }
    }

    public static void changePassword(User user) {
        String oldPassword, newPassword;
        while (true) {
            oldPassword = ScanUtils.readString("请输入旧密码:");
            if (oldPassword.equals(user.getPassword())) {
                break;
            }
            System.out.println("旧密码错误，请重新输入。");
        }
        newPassword = ScanUtils.readString("请输入新密码:");
        user.changeSelfInfo(newPassword);
        System.out.println("密码修改成功。");
    }

    public static void insertUser() {
        String name, password, role;
        name = ScanUtils.readString("请输入新用户名:");
        password = ScanUtils.readString("请输入新用户密码:");
        role = ScanUtils.readString("请输入用户角色(browser/operator/administrator):");
        boolean isInsert = DataProcessing.insert(name, password, role);
        if (isInsert) {
            System.out.println("新用户添加成功。");
        } else {
            System.out.println("用户名重复，添加失败");
        }
    }

    public static void deleteUser() {
        String name;
        name = ScanUtils.readString("请输入要删除的用户名:");
        boolean isDelete = DataProcessing.delete(name);
        if (isDelete) {
            System.out.println("用户" + name + "删除成功");
        } else {
            System.out.println("用户名不存在,删除失败");
        }
    }

    public static void updateUser() {
        String name, password, role;
        name = ScanUtils.readString("请输入要更新的用户名:");
        password = ScanUtils.readString("请输入新密码:");
        role = ScanUtils.readString("请输入新角色(browser/operator/administrator):");
        boolean isUpdate = DataProcessing.update(name, password, role);
        if (isUpdate) {
            System.out.println("用户" + name + "更新成功");
        } else {
            System.out.println("用户名不存在,更新失败");
        }
    }

    public static void listUsers() {
        Enumeration<User> users = DataProcessing.getAllUser();
        while (users.hasMoreElements()) {
            User user = users.nextElement();

            System.out.println("用户名: " + user.getName() + ", 角色: " + user.getRole());
        }
    }
}