import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class CosN extends CosM implements Serializable{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new CosmeticsJFrame();
	}
}
class CosmeticsJFrame extends JFrame  implements ActionListener {	 
	 /**
	 * 
	 */
	public static final long serialVersionUID = -7885065351613428261L;

	public static final String String = null;

	public static final String a = null;
	
	//String khtj;
	
	JPanel jp0;
	JPanel jp1;
	JPanel jp2;
	
	// 品牌输入文本框
    JTextField pinpai;
	
    private JButton jb0;
    private JButton jb1;
    
    public JComboBox combox_sehao;// 色号组合框，数据项类型为String
    public JComboBox combox_jiagequjian;// 价格区间组合框，数据项类型为String
    public JComboBox combox_fuse;// 肤色组合框，数据项类型为String

    public static String sehao[]={"请选择色号","小金条09","小金条21","圆管80","方管72","黑管416","黑管407","黑管409","黑管425","红管500","红管200","红管205","红管206","黑管302","黑管500","黑管400","marrakesh","cockney","dubonnet"};// 存储色号
    public static String jiagequjian[]={"请选择价格","50-100","100-150","150-200","200-250","250-300","300-350","350-400","400-450"};// 存储价格
    public static String fuse[]={"请选择肤色","黄一白","黄二白","黄黑皮","粉一白","粉二白","自然色"};// 存储肤色
	
    public CosmeticsJFrame()// 构造方法
    {
    	// 设置品牌输入框
    	pinpai = new JTextField("请输入品牌");
    	pinpai.setOpaque(false);// 设置背景透明
    	pinpai.setBorder(null);// 取消边框
    	pinpai.setFont(new Font("宋体",Font.BOLD,20));// 设置文本框字体属性
    	
    	jb0 = new JButton(new ImageIcon("./imgs/搜索.png"));
    	jb0.setContentAreaFilled(false);// 设置按钮背景为透明
		jb0.setBorder(null);
    	jb1 = new JButton(new ImageIcon("./imgs/帮助.png"));
    	jb1.setContentAreaFilled(false);// 设置按钮背景为透明
		jb1.setBorder(null);
    	
    	jp1 = new JPanel();
    	jp1.setOpaque(false); //把JPanel设置为透明
    	jp1.setLayout(new GridLayout(2, 2, 80, 74));
    	
    	jp1.add(pinpai);
    	jp1.add(this.combox_sehao=new JComboBox(CosmeticsJFrame.sehao));// 将色号组合框添加到jp1
    	jp1.add(this.combox_jiagequjian=new JComboBox(CosmeticsJFrame.jiagequjian));
    	jp1.add(this.combox_fuse=new JComboBox(CosmeticsJFrame.fuse));
    	
    	//combox_sehao.setOpaque(false);// 设置背景透明
    	//combox_sehao.setBorder(null);// 取消边框
    	combox_sehao.setBackground(Color.WHITE);
    	combox_sehao.setForeground(Color.black);
    	//combox_jiagequjian.setOpaque(false);// 设置背景透明
    	//combox_jiagequjian.setBorder(null);// 取消边框
    	combox_jiagequjian.setBackground(Color.WHITE);
    	combox_jiagequjian.setForeground(Color.black);
    	//combox_fuse.setOpaque(false);// 设置背景透明
    	//combox_fuse.setBorder(null);// 取消边框
    	combox_fuse.setBackground(Color.WHITE);
    	combox_fuse.setForeground(Color.black);

    	this.combox_sehao.addActionListener(this);// 为组合框添加监听
    	this.combox_jiagequjian.addActionListener(this);
    	this.combox_fuse.addActionListener(this);
    	
    	jp2 = new JPanel();
    	jp2.setOpaque(false); //把JPanel设置为透明
    	jp2.setLayout(new GridLayout(1, 2, 80, 0));
    	jp2.add(jb0);
    	jp2.add(jb1);
    	jb0.addActionListener(this);// 设置监听
    	jb1.addActionListener(this);// 设置监听
    	
    	this.setTitle("口红推荐系统");
	    ImageIcon icon = new ImageIcon("imgs\\图标.png");
	    this.setIconImage(icon.getImage());     // 给窗体设置图标方法
	    this.setLayout(null); // 取消布局管理
    	this.setBounds(420,163,1080,755);// 设置窗口位置及大小
    	
    	setBak(); //调用背景方法
        Container c = getContentPane(); //获取JFrame面板
        jp0 = new JPanel(); //创建一个JPanel
        jp0.setOpaque(false); //把JPanel设置为透明
        c.add(jp0);
    	
    	jp1.setBounds(263,262,547,132);
    	jp2.setBounds(318,485,438,45);
    	
    	c.add(jp1);
        c.add(jp2);
        this.setResizable(false);
    	this.setVisible(true);
    }
    
    public void setBak(){// 背景方法
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\搜索界面.png"); //添加图片
        JLabel background = new JLabel(img); 
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
   
	@Override
	public void actionPerformed(ActionEvent e) {// 动作事件处理方法
		// TODO Auto-generated method stub         	
		if(e.getSource()==jb0){// 单击搜索按钮
			
			String seh=(String)this.combox_sehao.getSelectedItem();// 获得色号
			String jiag=(String)this.combox_jiagequjian.getSelectedItem();// 获得价格
			String fus=(String)this.combox_fuse.getSelectedItem();// 获得肤色
			
			Mysql s=new Mysql();
			s.ConnectSQL();
			s.sousuo(pinpai.getText(),seh,jiag,fus);
			//s.sousuo(fus,jiag,seh,pinpai.getText());
			this.pinpai.setText("");
			/*
			this.combox_sehao.getSelectedItem();
			this.combox_jiagequjian.getSelectedItem();
			this.combox_fuse.getSelectedItem();
			*/
			}else if(e.getSource()==jb1)// 单击帮助按钮
			{
				new HelpJFrame();// 打开帮助界面
			}
	}	
}