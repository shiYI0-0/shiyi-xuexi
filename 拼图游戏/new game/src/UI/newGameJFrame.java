package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.Random;

public class newGameJFrame extends JFrame implements KeyListener, ActionListener {
//    JFrame界面、窗体
//    子类，也表示界面、窗体
//    规定：GameJFrame游戏主界面
//    以后跟游戏相关的所有逻辑都写在这个类中

//    创建成员变量
    //        4.创建二维数组
//    目的：用来管理数据
//    加载图片的时候，会根据二维数组中的数据进行加载
    int[][] data=new int[4][4];
//    记录空白方
//    块在二维数组中的位置
    int x=0;
    int y=0;
//    定义一个变量，记录当前展示图片的路径
    String path="D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\tupianer\\";
//    定义一个二维数组，存储正确的数据
    int[][] win={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
};
//    定义一个变量用来统计部步数
    int step=0;

    //        创建选项下面的条目对象
    JMenuItem replayItem=new JMenuItem("重新游戏");
    JMenuItem reLogItem=new JMenuItem("重新登录");
    JMenuItem closeItem=new JMenuItem("关闭游戏");

    JMenuItem accountItem=new JMenuItem("微信号");

//    新加功能美女，运动，动物
    JMenuItem beauty=new JMenuItem("美女");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem motion=new JMenuItem("运动");
//  随机数
//  美女
    int suiji=0;
//    动物
    int suiji2=0;
//    运动
    int suiji3=0;

    Random r2=new Random();

    public newGameJFrame(){
//        初始化界面
        initJFrame();//抽取成方法，方便以后查错

//      初始化菜单
        initJMenuBar();

//        初始化数据（打乱）
        initdata();

//      初始化图片（根据打乱之后的结果去加载图片）
        initImage();


//    让显示出来，建议写在最后
       this.setVisible(true);

    }



//    初始化数据（打乱）
    private void initdata() {
        //   1.定义一个一维数组
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//    打乱数组中数据的顺序
//        遍历数组得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换、
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
//            获取随机索引
            int index=r.nextInt(tempArr.length);
//            拿着遍历的每一个数据，跟随机索引上面的进行交换
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;

        }

//        5.给二维数组添加数
//        解法一
//        遍历一维数组tempArr得到每一个元素，把每一个元素依次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i]==0){

                x=i/4;
                y=i%4;
            }
                data[i/4][i%4]=tempArr[i];


        }



    }

    //      初始化图片
//    添加图片的时候，就需要按照二维数组中管理的数据添加图片
    private void initImage() {

//        清空已经出现的所有图片
        this.getContentPane().removeAll();
//        对ictory方法的结果进行判断
        if (victory()) {
//            显示true,显示胜利的图片
            JLabel winJLabel=new JLabel(new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\tupianer\\goodnice.jpg"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

//        创建一个JLable用来管理文字
        JLabel stepCount=new JLabel("移动次数"+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

//        外循环把内循环重复执行了4次
//        int number=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
//                获取当前要加载的序号
                int num=data[i][j];
                //        创建一个JLabel的对象（管理容器）
//                System.out.println(num);//测试是否num加载序号正确

                JLabel jLabel=new JLabel();
                if (suiji==0&&suiji2==0&&suiji3==0){
                  ImageIcon  II = new ImageIcon(  path+num+".jpg");
                  jLabel=new JLabel(II);
                    //              指定图片位置
                    jLabel.setBounds(105 * j+83, 105 * i+134, 105, 105);//i=0时就为第一张图片，然后依次往后，这就是底盘排的
//          把图片添加边框
                    jLabel.setBorder(new BevelBorder(1));
//           或者==     jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        把管理容器添加到界面中
//        this.add(jLabel);
                    this.getContentPane().add(jLabel); //先获取到里面的隐藏容器，再添加给隐藏容器当中



                }else if (suiji2>0&suiji==0&&suiji3==0){//动物
                    System.out.println("suiji2222222222222222222222222222222222222222");
                    ImageIcon III=new ImageIcon(path+"\\dw"+suiji2+"\\"+num+".jpg");
                    jLabel=new JLabel(III);
                    //              指定图片位置
                    jLabel.setBounds(105 * j+83, 105 * i+134, 105, 105);//i=0时就为第一张图片，然后依次往后，这就是底盘排的
//          把图片添加边框
                    jLabel.setBorder(new BevelBorder(1));
//           或者==     jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        把管理容器添加到界面中
//        this.add(jLabel);
                    this.getContentPane().add(jLabel); //先获取到里面的隐藏容器，再添加给隐藏容器当中
                }else if (suiji>0&&suiji2==0&&suiji3==0){
                    System.out.println("suiji111111111111111111111111111111111111111111111111111");
                    ImageIcon III=new ImageIcon(path+"\\yaoyao"+suiji+"\\"+num+".jpg");
                    jLabel=new JLabel(III);
                    //              指定图片位置
                    jLabel.setBounds(105 * j+83, 105 * i+134, 105, 105);//i=0时就为第一张图片，然后依次往后，这就是底盘排的
//          把图片添加边框
                    jLabel.setBorder(new BevelBorder(1));
//           或者==     jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        把管理容器添加到界面中
//        this.add(jLabel);
                    this.getContentPane().add(jLabel); //先获取到里面的隐藏容器，再添加给隐藏容器当中

                }else if (suiji3>0&&suiji2==0&&suiji==0){
                    System.out.println("suiji3333333333333333333333333333333333333333");
                    ImageIcon III=new ImageIcon(path+"\\YD"+suiji3+"\\"+num+".jpg");
                    jLabel=new JLabel(III);
                    //              指定图片位置
                    jLabel.setBounds(105 * j+83, 105 * i+134, 105, 105);//i=0时就为第一张图片，然后依次往后，这就是底盘排的
//          把图片添加边框
                    jLabel.setBorder(new BevelBorder(1));
//           或者==     jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
//        把管理容器添加到界面中
//        this.add(jLabel);
                    this.getContentPane().add(jLabel); //先获取到里面的隐藏容器，再添加给隐藏容器当中

                }else {
                    System.out.println("什么都没有执行"+suiji3+suiji+suiji2);
                }

            }
        }


//        先添加的图片在上面后添加的图片在下面
//        添加背景图片
//        ImageIcon bg=new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\newbeijing.jpg");
  ImageIcon bg=new ImageIcon("拼图游戏\\image\\newbeijing.jpg");
//        创建管理容器
        JLabel background=new JLabel(bg);//也可以像下面一样两行并为一行
//        设置图片位置
        background.setBounds(83,40,419,558);
//        把背景图片添加到界面之中
//        通过getContentPane获取到其中的隐藏容器
        this.getContentPane().add(background);

//        刷新一下界面
        this.getContentPane().repaint();
}


    private void initJMenuBar() {
        //        初始化菜单
//        创建整个菜单对象
        JMenuBar jMenuBar=new JMenuBar();

//        创建菜单上面的两个选项的对象（功能 和 关于我们）
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
//        作业：创建更换图片的功能
        JMenu ReplaceImage=new JMenu("更换图片");




//        将每一个选项下面的条目添加到选项中
//        新加更换图片选项ReplaceImage
        functionJMenu.add(ReplaceImage);

//        更换图片下新加运动，美女，动物
        ReplaceImage.add(beauty);
        ReplaceImage.add(animal);
        ReplaceImage.add(motion);

        functionJMenu.add(replayItem);
        functionJMenu.add(reLogItem);
        functionJMenu.add(closeItem);


        aboutJMenu.add(accountItem);

//        给条目绑定事件
        replayItem.addActionListener(this);
        reLogItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        beauty.addActionListener(this);
       motion.addActionListener(this);
        animal.addActionListener(this);

//        将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

//        给整个界面设置菜单
        this.setJMenuBar(jMenuBar);//把上面的菜单放到界面之中
    }

    private void initJFrame() {
        //        设置界面的宽高
        this.setSize(603,680);
//    设置界面的标题
        this.setTitle("十一拼图单机版yhr.1.0");

//        设置页面置顶，现在默认页面在左上角
        this.setAlwaysOnTop(true);//true表示一直在最上方
//        设置页面居中
        this.setLocationRelativeTo(null);

//        游戏的设置关闭模式
        this.setDefaultCloseOperation(3);//每一种数字都是一种关闭模式

//        取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
//        给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        按住不松时会调用这个方法
        int code=e.getKeyCode();
        System.out.println(code);
        if (code==65){
//            把界面中所有的图片删除
            this.getContentPane().removeAll();

//            初始图片
            if (suiji==0&&suiji3==0&&suiji2==0) {
//            加载第一张完整的图片
                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));

//            设置位置
                all.setBounds(83,134,420,420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);

//                随机更换的图片键盘A加载查看原图
            } else if (suiji==1) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon( path+"\\yaoyao"+suiji+"\\"+"all"+suiji+".jpg"));
//                path+"\\yaoyao"+suiji+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83,134,420,420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji==2) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon( path+"\\yaoyao"+suiji+"\\"+"all"+suiji+".jpg"));
//                path+"\\yaoyao"+suiji+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83,134,420,420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji==3) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon( path+"\\yaoyao"+suiji+"\\"+"all"+suiji+".jpg"));
//                path+"\\yaoyao"+suiji+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83,134,420,420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji2==1) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\dw" + suiji2 + "\\" + "all" + suiji2 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji2==2) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\dw" + suiji2 + "\\" + "all" + suiji2 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji2==3) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\dw" + suiji2 + "\\" + "all" + suiji2 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji3==1) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\YD" + suiji3 + "\\" + "all" + suiji3 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji3==2) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\YD" + suiji3 + "\\" + "all" + suiji3 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }else if (suiji3==3) {
//                          加载第一张完整的图片
//                JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
                JLabel all = new JLabel(new ImageIcon(path + "\\YD" + suiji3 + "\\" + "all" + suiji3 + ".jpg"));
//                path+"\\yaoyao"+suiji2+"\\"+num+".jpg"

//            设置位置
                all.setBounds(83, 134, 420, 420);
//            把图片加载进隐藏容器
                this.getContentPane().add(all);
            }



//            加载背景图片
            //        先添加的图片在上面后添加的图片在下面
//        添加背景图片
//        ImageIcon bg=new ImageIcon("D:\\Java 笔记\\Java1项目\\xuexi\\拼图游戏\\image\\newbeijing.jpg");

            ImageIcon bg=new ImageIcon("拼图游戏\\image\\newbeijing.jpg");
//        创建管理容器
            JLabel background=new JLabel(bg);//也可以像下面一样两行并为一行
//        设置图片位置
            background.setBounds(83,40,419,558);
//        把背景图片添加到界面之中
//        通过getContentPane获取到其中的隐藏容器
            this.getContentPane().add(background);
//            刷新界面
            this.getContentPane().repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//          判断游戏是否胜利，如果胜利，此方法需要直接结束，不能在执行下面的移动代码
        if(victory()) {
//            结束方法
        return;//结束
        }
//        对上下左右进行判断
//        左：37 上：38 右：39 下：40
        int code =e.getKeyCode();
//        System.out.println(code);测试打印的按键数字
        if(code==37){
            System.out.println("向左移动");
//            做一个方块已经在最左边的判断
            if (y==3){
                return;
            }
//            逻辑：把空白的上方方的数字往上移动
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
//            每移动一次计步器就增加一次。
            step++;
//            调用方法按照最新的数字加载图片
            initImage();

        } else if (code==40) {
            if (x==0){
                return;
            }
            System.out.println("向下移动");
//            逻辑：把空白的上方方的数字往上移动
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;
//            调用方法按照最新的数字加载图片
            initImage();

        }else if (code==39) {
            if (y==0){
                return;
            }
            System.out.println("向右移动");
//            逻辑：把空白的上方方的数字往上移动
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
//            调用方法按照最新的数字加载图片
            initImage();

        }else if (code==38) {
            if (x==3){
                return;
            }
            System.out.println("向上移动");
//            逻辑：把空白的=下方的数字往上移动
//            x,y 表示空白方块
//            x+1,y y表示空白方块下方的数字

//            把空白方块下面的数字赋值给空白方块
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;
//            调用方法按照最新的数字加载图片
            initImage();
        }else if(code==65){
            initImage();
        } else if (code==87) {
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
//            重新加载图片吗
            initImage();
        }

    }

//    定义boolean的一个方法来判断data数组和win数组是否xiangtonhg
//    全部相同返回true,否则返回false
    private boolean victory(){
        for (int i = 0; i < data.length; i++) {
//            i:依次表示二维数组date里面的索引
//            date[i]:依次表示每一个一维数组
            for (int j = 0; j < data.length; j++) {
//              只要有一个数据不一样就要返回false
                if (data[i][j]!=win[i][j]){
                    return false;

                }
            }
        }
//        循环结束表示全部遍历结束。全部一样就返回ture
        return true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        获取当前被点击条目的对象
        Object obj=e.getSource();
//        判断
        if(obj==replayItem){
            System.out.println("重新游戏");
//            计步器清零
            step=0;
//            再次打乱二维数组中的数据
            initdata();
//            重新加载图片
            initImage();



        }else if(obj==motion){
            System.out.println("运动");
            //            计步器清零
            step=0;
//            切换成随机图片
            suiji3=r2.nextInt(3)+1;

            suiji=0;
            suiji2=0;
//            再次打乱二维数组中的数据
            initdata();
//            重新加载图片
            initImage();




        }else if(obj==beauty){
            System.out.println("美女");
            //            计步器清零
            step=0;
//            切换成随机图片
            suiji=r2.nextInt(3)+1;
            suiji2=0;
            suiji3=0;
//            再次打乱二维数组中的数据
            initdata();
//            重新加载图片
            initImage();

            System.out.println(suiji+"meinvqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");


        }else if(obj==animal){
            System.out.println("动物");
            //            计步器清零
            step=0;
//            切换成随机图片
            suiji2=r2.nextInt(3)+1;
            suiji=0;
            suiji3=0;
//            再次打乱二维数组中的数据
            initdata();
//            重新加载图片
            initImage();

            System.out.println(suiji2+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww动物");


        }else if (obj==reLogItem) {
            System.out.println("重新登录");
//            关闭当前游戏界面
            this.setVisible(false);
//            打开登录界面
            new newLoginJfame();

        } else if (obj==closeItem) {
            System.out.println("关闭游戏");
//            直接关闭虚拟机
            System.exit(0);
        } else if (obj==accountItem) {
            System.out.println("公众号");
//      创建一个弹窗对象
            JDialog jDialog=new JDialog();
//            创建管理容器的对象
            JLabel jlabel=new JLabel(new ImageIcon("拼图游戏\\image\\tupianer\\weixinhao.jpg"));
//            设置位置和宽高
            jlabel.setBounds(0,0,258,258);
//            把图片添加到弹框中
            jDialog.getContentPane().add(jlabel);
//            给弹框设置大小
            jDialog.setSize(344,344);
//            让弹框置顶
            jDialog.setAlwaysOnTop(true);
//            让弹框居中
            jDialog.setLocationRelativeTo(null);
//            弹框不关闭无法操作下面的界面
            jDialog.setModal(true);
//            让弹框显示出来
            jDialog.setVisible(true);
        }

    }
}




