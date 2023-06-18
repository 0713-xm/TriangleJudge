//功能函数
//Triangle.java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Triangle extends JFrame implements ActionListener {

    int a, b, c;//三角形的三条边
    double d, f, g;
    JTextField text1, text2, text3, text4;
    JButton button1, button2, button3;
    JLabel label1, label2, label3, label4,label5,label6,label7;
    Box basebox, box1, box2, box3;


    public Triangle() {
        super("三角形黑盒测试程序");
        setLayout(new FlowLayout());
        text1 = new JTextField(14);
        text2 = new JTextField(14);
        text3 = new JTextField(14);
        text4 = new JTextField(14);
        label1 = new JLabel("A");
        label2 = new JLabel("B");
        label3 = new JLabel("C");
        label4 = new JLabel("形状");
        label5 = new JLabel("请输入三个1至200的整数:");
        label6 = new JLabel("         ");
        label7 = new JLabel("         ");
        button1 = new JButton("判断形状");
        button2 = new JButton("重新输入");

        box1 = Box.createVerticalBox();
        box1.add(label5);
        box1.add(Box.createVerticalStrut(10));
        box1.add(label1);
        box1.add(Box.createVerticalStrut(10));
        box1.add(label2);
        box1.add(Box.createVerticalStrut(10));
        box1.add(label3);
        box1.add(Box.createVerticalStrut(20));
        box1.add(label4);
        box2 = Box.createVerticalBox();
        box2.add(label6);
        box2.add(Box.createVerticalStrut(4));
        box2.add(text1);
        box2.add(Box.createVerticalStrut(4));
        box2.add(text2);
        box2.add(Box.createVerticalStrut(4));
        box2.add(text3);
        box2.add(Box.createVerticalStrut(20));
        box2.add(text4);
        box3 = Box.createVerticalBox();
        box3.add(label7);
        box3.add(Box.createVerticalStrut(8));
        box3.add(button1);
        box3.add(Box.createVerticalStrut(8));
        box3.add(button2);

        basebox = Box.createHorizontalBox();
        basebox.add(box1);
        basebox.add(Box.createHorizontalStrut(10));
        basebox.add(box2);
        basebox.add(Box.createHorizontalStrut(15));
        basebox.add(box3);

        add(basebox);
        button1.addActionListener(this);
        button2.addActionListener(this);
        setBounds(0, 50, 500, 180);

        //设置背景图片
        setSize(500, 300);  //设置大小
        //设置位置
        setLocation(800, 400);
        //点关闭按钮时退出
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (text1.getText().isEmpty() || text2.getText().isEmpty() || text3.getText().isEmpty()) {  //判断输入是否为空
            JOptionPane.showMessageDialog(null, "参数输入非法！");
        } else if( text1.getText().matches("[0-9]+")
                || text2.getText().matches("[0-9]+")
                || text3.getText().matches("[0-9]+")){   //输入为整数的情况
            a = Integer.parseInt(text1.getText());
            b = Integer.parseInt(text2.getText());
            c = Integer.parseInt(text3.getText());
            if (e.getSource() == button1) {

                if ((a < 1 || a > 200) || (b < 1 || b > 200) || (c < 1 || c > 200)) {
                    JOptionPane.showMessageDialog(null, "参数输入超限！");
                } else {
                    if ((a + b > c && a + c > b && b + c > a)) {  //判断是否能构成三角形
                        if (a == b && a == c && b == c) {
                            text4.setText("等边三角形");
                        } else if (a == b || a == c || b == c) {
                            text4.setText("等腰三角形");
                        } else {
                            text4.setText("一般三角形");
                        }
                    } else {
                        text4.setText("不能构成三角形");
                    }
                }

            }
        }else{
            JOptionPane.showMessageDialog(null, "参数输入非法！");
        }
        if (e.getSource() == button2) {  //清除数据
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
        }


        if (e.getSource() == button3) {
            System.exit(0);  //关闭程序
        }
    }
}
