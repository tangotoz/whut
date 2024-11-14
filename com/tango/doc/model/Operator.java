package com.tango.doc.model;

public class Operator extends AbstractUser {
    public Operator(String name, String password, String role) {
        super(name, password, role);
    }

    public void showMenu() {
        String tipSystem = "欢迎进入档案浏览员的菜单";
        String tipMenu = "请选择菜单:";

        StringBuilder builder = new StringBuilder();
        builder.append("==========").append(tipSystem).append("========\n")
                .append("================").append("1.上传文件").append("================\n")
                .append("================").append("2.下载文件").append("================\n")
                .append("================").append("3.文件列表").append("================\n")
                .append("================").append("4.修改密码").append("================\n")
                .append("================").append("5.退   出").append("================\n")
                .append(tipMenu);

        System.out.print(builder.toString());
    }

}
