package com.tango.doc.model;

public class Administrator extends AbstractUser {
    public Administrator(String name, String password, String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        String tipSystem = "欢迎进入档案浏览员的菜单";
        String tipMenu = "请选择菜单:";

        StringBuilder builder = new StringBuilder();
        builder.append("==========").append(tipSystem).append("========\n")
                .append("================").append("1.新增用户").append("================\n")
                .append("================").append("2.删除用户").append("================\n")
                .append("================").append("3.修改用户").append("================\n")
                .append("================").append("4.用户列表").append("================\n")
                .append("================").append("5.下载文件").append("================\n")
                .append("================").append("6.文件列表").append("================\n")
                .append("================").append("7.修改密码").append("================\n")
                .append("================").append("8.退   出").append("================\n")
                .append(tipMenu);

        System.out.print(builder.toString());
    }
}
