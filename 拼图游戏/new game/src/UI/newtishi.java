package UI;

import javax.swing.*;

public class newtishi extends JFrame {
    public newtishi(){
        this.setSize(244,215);//设置宽高
        this.setTitle("提示");//设置界面标题
        this.setDefaultCloseOperation(2);//关闭模式
        this.setAlwaysOnTop(true);//设置页面置顶


        //        设置页面居中
        this.setLocationRelativeTo(null);
        //        取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);

        JLabel shibai=new JLabel();//登录失败提示框
        shibai.setText("用户名或者密码错误");
//        位置和宽高
        shibai.setBounds(70, 60, 200, 50);
        this.getContentPane().add(shibai);



        this.setVisible(true);
    }






}
