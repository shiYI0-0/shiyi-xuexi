package UI;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class newLoginJfame extends JFrame implements ActionListener {
    int aaa=0;
//    LoginJfame表示登录界面
//    以后登录界面就写在这儿就可以了

//    创建一个内测号集合
    static ArrayList<USER> list=new ArrayList<>();
    static {
        list.add(new USER("yuanhaoran","020829"));
        list.add(new USER("chenshiyao","020110"));
        System.out.println(list.get(1).getUser()+" "+list.get(1).getMima());
    }
//   把创建用户名输入框放在所有方法外
    JTextField username = new JTextField();
//    密码输入框
    JPasswordField password = new JPasswordField();
//    验证码输入框
    JTextField code = new JTextField();
    String codestr=yzm();//获取到随机生成的验证码

    JButton login=new JButton();//登录按钮

    JButton rightCode=new JButton();//获取到的验证码的那个条目

    JButton register=new JButton();//注册条目




    public newLoginJfame() {
//        初始化界面
        initJFrame();

//        在这个界面中添加内容
        initView();

//    让当前界面显示出来，建议写在最后
        this.setVisible(true);
//        this.setDefaultCloseOperation(1);

    }

    public void initJFrame() {
        //        在创建登录界面的时候，同时给这个界面去设置一些信息
//        比如，宽高，直接展示出来
        this.setSize(488, 430);
        //    设置界面的标题
        this.setTitle("十一拼图登录界面");
//        设置关闭模式
        this.setDefaultCloseOperation(3);

//        设置页面置顶，现在默认页面在左上角
        this.setAlwaysOnTop(true);//true表示一直在最上方
//        设置页面居中
        this.setLocationRelativeTo(null);
        //        取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
    }

    public void initView() {
//      1.  添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\yhm.jpg"));

        usernameText.setBounds(116, 135, 47, 17);

        this.getContentPane().add(usernameText);

//        2. 添加用户名输入框
//        JTextField username = new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

//        3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\mima.jpg"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

//        4.添加密码输入框
//        JPasswordField password = new JPasswordField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

//        5.添加验证码文字
        JLabel codeText = new JLabel(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\yanzhengma.jpg"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //        6.添加验证码输入框
//        JTextField code = new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

//        验证码
//        String codestr=yzm();//获取到随机生成的验证码
//        JLabel rightCode=new JLabel();
//        设置内容
        rightCode.setText(codestr);
//        位置和宽高
        rightCode.setBounds(280,246,100,60);

//        去除按钮边框
        rightCode.setBorderPainted(false);
//        去除按钮背景
        rightCode.setContentAreaFilled(false);
        this.getContentPane().add(rightCode);
        rightCode.addActionListener(this);
//        添加验证码的刷新组件


//        5.添加登录按钮
//       创建一个按键login
//        JButton login=new JButton();
        login.setBounds(115,310,128,47);
        login.setIcon(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\登录.jpg"));
//        去除按钮边框
        login.setBorderPainted(false);
//        去除按钮背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);
//        把登录按钮绑定事件
        login.addActionListener(this);

//        6.添加注册按钮
//        JButton register=new JButton();
        register.setBounds(264,310,128,47);
        register.setIcon(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\注册.jpg"));
//        去除按钮边框
        register.setBorderPainted(false);
        //        去除按钮背景
        register.setContentAreaFilled(false);

        this.getContentPane().add(register);
        register.addActionListener(this);








//      7.添加背景图片
        JLabel background=new JLabel(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\登录界面背景.jpg"));//
        background.setBounds(0,0,470,390);
        this.getContentPane().add(background);


    }

    public static String yzm() {

        //分析：
        //1.把大写字母和小写字母都放在数组当中
        char[] az = new char[52];
        //ASCLL码表：
        for (int i = 0; i < az.length; i++) {
            if (i <= 25) {
                az[i] = (char) (i + 97);
            } else {
                az[i] = (char) (i + 65 - 26);
            }


        }
//        for (int i = 0; i < az.length; i++) {
//            System.out.print(az[i]+" ");
//        }


        //2随机抽取4次
        //随机抽取数组中的索引
        String arr = "";
        Random csy = new Random();
        for (int i = 0; i < 4; i++) {
            int random3 = csy.nextInt(az.length);
            arr = arr + az[random3];
        }
//        System.out.print();
//        int random1= csy.nextInt(az.length);
//        int random2= csy.nextInt(az.length);
//        int random4= csy.nextInt(az.length);
//        //利用随机索引获取随机元素
//        System.out.print(az[random3]);

//        System.out.print(az[random1]);
//        System.out.print(az[random2]);
//        System.out.print(az[random4]);


        //3.随机抽取一个数字0~9

        int yhr = csy.nextInt(10);
        String YZM=arr+yhr;
        System.out.print(arr + yhr);//0-9
return YZM;
    }
//点击登录
//    需求：
//    1.要判断用户名和密码还有验证码是否正确,若正确就跳转到newGameJFrame游戏界面
    @Override
    public void actionPerformed(ActionEvent e) {

        //        获取当前被点击条目的对象
        Object objj = e.getSource();
        if (objj==login){
        System.out.println("点击登录");
        String Shuruyhm = username.getText();//获取用户名输入框的内容
        String Shurumima = new String(password.getPassword());//获取密码输入框内容
        String Shuruyzm = code.getText();//获取验证码输入框的内容
//        if (Shuruyhm==list.get(0).user&&Shurumima==list.get(0).mima&&codestr==Shuruyzm){
//            System.out.println("登录成功");
//        }else {
//            System.out.println("登录失败");
//        }
//
        if (Shuruyhm.equals(list.get(0).user) && Shurumima.equals(list.get(0).mima) && codestr.equals(Shuruyzm)) {
            System.out.println("登录成功");
//            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            System.exit(0);
            //    让当前界面显示出来，建议写在最后
            this.setVisible(false);
            new newGameJFrame();


        } else if (Shuruyhm.equals(list.get(1).user) && Shurumima.equals(list.get(1).mima) && codestr.equals(Shuruyzm)) {
            System.out.println("登录成功");
//            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            System.exit(0);
            //    让当前界面显示出来，建议写在最后
            this.setVisible(false);
            new newGameJFrame();
        } else {
            aaa+=1;
            System.out.println("登录失败");
//    this.getContentPane().removeAll();
            //        登录失败
        new newtishi();


        }
        System.out.println(codestr);
//        System.out.println(list.get(0).user);

//        System.out.println(Shuruyzm);
    } else if(rightCode==objj){//                 切换验证码
            String newcodestr=yzm();
            codestr=newcodestr;

            //        验证码
//        String codestr=yzm();//获取到随机生成的验证码
//        JLabel rightCode=new JLabel();
//        设置内容
            rightCode.setText(codestr);
//        位置和宽高
            rightCode.setBounds(280,246,100,60);

//        去除按钮边框
            rightCode.setBorderPainted(false);
//        去除按钮背景
            rightCode.setContentAreaFilled(false);
//            this.getContentPane().add(rightCode);
        }else if (objj==register){
            System.out.println("点击注册");
            new newzhuce();

        }


    }



}

class USER{
    String  user;
    String mima;

    public USER(String user, String mima) {
        this.user = user;
        this.mima = mima;
    }

    public USER() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }


}





 class newzhuce extends JFrame {
     public newzhuce() {
         this.setSize(244, 215);//设置宽高
         this.setTitle("提示");//设置界面标题
         this.setDefaultCloseOperation(2);//关闭模式
         this.setAlwaysOnTop(true);//设置页面置顶


         //        设置页面居中
         this.setLocationRelativeTo(null);
         //        取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
         this.setLayout(null);

         JLabel shibai = new JLabel();//登录失败提示框
         shibai.setText("注册页面尚未开发，仅限内部号");
//        位置和宽高
         shibai.setBounds(20, 60, 200, 50);
         this.getContentPane().add(shibai);


         this.setVisible(true);
     }
 }


