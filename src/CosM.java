import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;

public class CosM extends JFrame{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CosMsFrame();
	}
}

class CosMsFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7885065351613428261L;
	JPanel jp0;
	JPanel jp1;
    JPanel jp2;
    
	// 账号输入文本框
    JTextField jtf;
    // 密码输入文本框
    JPasswordField jpf;
	// 按钮
	private JButton jb0, jb1;
	
	public CosMsFrame() {// 构造方法

		// 设置账号密码输入框
		jtf = new JTextField("请输入3-6位用户名");
		jtf.setOpaque(false);// 设置背景透明
		jtf.setBorder(null);// 取消边框
		jtf.setFont(new Font("宋体",Font.BOLD,20));// 设置文本框字体属性
		jpf = new JPasswordField();
		jpf.setOpaque(false);
		jpf.setBorder(null);
		jpf.setFont(new Font("宋体",Font.BOLD,20));
		// 设置按钮
		jb0 = new JButton(new ImageIcon("./imgs/注册2.png"));
		jb0.setContentAreaFilled(false);// 设置按钮背景为透明
		jb0.setBorder(null);
		jb0.addActionListener(this);// 设置监听
		jb1 = new JButton(new ImageIcon("./imgs/登录2.png"));	
		jb1.setContentAreaFilled(false);// 设置按钮背景为透明
		jb1.setBorder(null);
		jb1.addActionListener(this);
		// 创建组件
		jp1 = new JPanel();
		// 添加组件
		jp1.setOpaque(false); //把JPanel设置为透明
    	jp1.setLayout(new GridLayout(2, 1, 0, 42));// 设置布局格式
    	jp1.add(jtf);
    	jp1.add(jpf);
	    // 创建组件  
		jp2 = new JPanel();
		jp2.setOpaque(false); //把JPanel设置为透明
    	jp2.setLayout(new GridLayout(1, 2, 28, 0));// 设置布局格式
    	// 添加组件
    	jp2.add(jb0);
    	jp2.add(jb1); 
	        
		// 展示组件
		this.setTitle("口红推荐系统");
		//this.FormBorderStyle(false);
	    ImageIcon icon = new ImageIcon("imgs\\图标.png");
	    this.setIconImage(icon.getImage());     // 给窗体设置图标方法
	    this.setLayout(null); // 取消布局管理(绝对布局）
	    this.setBounds(420,163,1080,755);         // 设置窗口位置及大小
	    	
	    setBak(); // 调用背景方法
	    Container c = getContentPane(); // 获取JFrame面板
	    jp0 = new JPanel(); // 创建一个JPanel
	    jp0.setOpaque(false); // 把JPanel设置为透明
	    c.add(jp0);// 将jp0添加到c面板
	    	
	    jp1.setBounds(456,320,270,127);// 设置jp1的位置及大小
	    jp2.setBounds(340,485,438,45);
	    	
	    c.add(jp1);
	    c.add(jp2);
		this.setResizable(false);// 禁止窗体缩放
	    this.setVisible(true); // 显示窗体
	 }
	
	public void setBak(){// 背景方法
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\登录界面2.png"); //添加图片
        JLabel background = new JLabel(img);// 创建一个标签，并将上面创建的图片对象给该标签
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 为容器添加深度，允许组件在需要时互相重叠;为前面创建的标签 设置层的深度，这里将其设置为了最底层
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// 调整label标签在容器的位置，并调整该标签的大小与图片一样
    }

	@Override
	public void actionPerformed(ActionEvent e) {// 动作事件处理方法
		// TODO Auto-generated method stub
		if(e.getSource()==jb0){// 单击注册按钮
			this.logon();// 调用注册方法
			}else if(e.getSource()==jb1)// 单击登录按钮
			{
				this.login();// 调用登录方法
				//this.setVisible(false); 
			}
	}
	// 注册方法
    public void logon() {
    	String regex1="\\w{3,6}"; // 用户名必须是3-6位
 		boolean flag1=jtf.getText().matches(regex1);
 		
 		String regex2="\\w{6}"; // 密码必须是6位
 		boolean flag2=jpf.getText().matches(regex2);
 		
 	    if(flag1==false || flag2==false)
 		{
 			JOptionPane.showMessageDialog(null, "用户名或密码填写错误,用户名必须为3-6位字母_或者数字"+"\n"+"密码必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
 			jtf.setText("");
 			jpf.setText("");
 		}else
 		{			
 		// 调用注册方法,先检查要注册的用户名是否存在
 		 Mysql co=new Mysql();
 		    co.ConnectSQL();
 		    co.ZhuceVerify(jtf.getText()); 
            co.UserRegis(jtf.getText(),jpf.getText());
            
 		    this.jtf.setText("");// 清空文本框
 		    this.jpf.setText("");
 			}
	}

	//登录方法
	public void login() {
		Mysql s=new Mysql();
		s.ConnectSQL();
		s.SQLverify(jtf.getText(), jpf.getText());
		
		this.jtf.setText("");
		this.jpf.setText("");
	}
}
