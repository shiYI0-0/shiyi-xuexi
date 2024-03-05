package UI;

import javax.swing.*;

public class newRegisterJFrame extends JFrame {
//    注册相关的代码都写在这
    public newRegisterJFrame() {
        this.setSize(488, 500);
        this.setVisible(true);

        //    设置界面的标题
        this.setTitle("十一拼图注册界面");

//        设置页面置顶，现在默认页面在左上角
        this.setAlwaysOnTop(true);//true表示一直在最上方
//        设置页面居中
        this.setLocationRelativeTo(null);

//        游戏的设置关闭模式
        this.setDefaultCloseOperation(3);//每一种数字都是一种关闭模式
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//和上面的关闭效果相同，但是更加见名知义


//    让显示出来，建议写在最后
        this.setVisible(true);
    }
}
