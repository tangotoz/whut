package com.tango.console.role;

public class Browser extends AbstractUser {
    public Browser(String name, String password, String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        String tipSystem = "欢迎进入档案浏览员的菜单";
        String tipMenu = "请选择菜单:";
        StringBuilder builder = new StringBuilder();
        builder.append("==========").append(tipSystem).append("========\n")
                .append("================").append("1.下载文件").append("================\n").
                append("================").append("2.文件列表").append("================\n").
                append("================").append("3.修改密码").append("================\n")
                .append("================").append("4.退   出").append("================\n").append(tipMenu);

        System.out.print(builder.toString());
    }
}
