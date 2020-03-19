import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorListener;


public class Khtj extends Mysql implements ActionListener{
	public static final long serialVersionUID = -7885065351613428261L;
	public static final String String = null;
	public static final String a = null;
	public static final String b = null;
	
	JPanel jp0;// 放置背景
	JPanel jp1;// 放置图片组件
	JPanel jp2;// 放置第一行文字
	JPanel jp3;// 放置第二行文字
	JPanel jp4;// 放置返回按钮
	
	private JButton jb0;
	
	//public JLabel jl1 = new JLabel(new ImageIcon(""));// 放置口红图片
	public JLabel jl2 = new JLabel("", JLabel.LEFT);// 第一行文字
	public JLabel jl3 = new JLabel("", JLabel.LEFT);// 第二行文字
	
    public Khtj(){ // 构造方法
    	jb0 = new JButton(new ImageIcon("./imgs/返回2.png"));
    	jb0.setContentAreaFilled(false);// 设置按钮背景为透明
		jb0.setBorder(null);
		jb0.addActionListener(this);// 设置监听
    	
        jl2.setFont(new Font("宋体", Font.BOLD, 21));// 设置字体样式,字体加粗
		jl2.setForeground(Color.black);// 设置字体颜色
		
	    jl3.setFont(new Font("宋体", Font.BOLD, 18));
	 	jl3.setForeground(Color.black);
    	/*
    	jp1 = new JPanel();
    	jp1.setOpaque(false); //把JPanel设置为透明
    	jp1.setLayout(new GridLayout(1, 1, 0, 0));
    	jp1.add(jl1);
    	*/
    	jp2 = new JPanel();
    	jp2.setOpaque(false);
    	jp2.setLayout(new GridLayout(1, 1, 0, 0));
    	jp2.add(jl2);
    	
    	jp3 = new JPanel();
    	jp3.setOpaque(false);
    	jp3.setLayout(new GridLayout(1, 1, 0, 0));
    	jp3.add(jl3);
    	
    	jp4 = new JPanel();
    	jp4.setOpaque(false);
    	jp4.setLayout(new GridLayout(1, 1, 0, 0));
    	jp4.add(jb0);
    	
    	// 展示组件
    	this.setTitle("口红推荐");
    	this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imgs\\图标.png");
    	this.setIconImage(icon.getImage());     // 给窗体设置图标方法
    	this.setLayout(null); // 取消布局管理
    	this.setBounds(420,163,1080,755);         // 设置窗口位置及大小
    		    	
    	setBak(); //调用背景方法
    	Container c = getContentPane(); //获取JFrame面板
    	jp0 = new JPanel(); //创建一个JPanel
    	jp0.setOpaque(false); //把JPanel设置为透明
        c.add(jp0);
        	
    	//jp1.setBounds(50,60,243,400);
    	jp2.setBounds(260,276,500,100);
    	jp3.setBounds(260,355,500,100);
    	jp4.setBounds(800,570,127,48);
    	    	
    	//c.add(jp1);
    	c.add(jp2);
    	c.add(jp3);
    	c.add(jp4);
    	this.setResizable(false);
    	this.setVisible(true); 
    }
    
    public void setBak(){// 背景方法
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\推荐界面.png"); //添加图片
        JLabel background = new JLabel(img); 
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    
    public void one(String a){// 将数据库中查到的内容传过来
    	System.out.println(a);// 验证
    	jl2.setText(a);
 	    jl2.repaint(); 
    }
    
    public void two(String b){// 将数据库中查到的内容传过来
    	System.out.println(b);// 验证
    	jl3.setText(b);
 	    jl3.repaint(); 
    }
    /*
    public void photo(String c){
    	jl1.setText(c);
    	jl1.repaint(); 
    }
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb0){// 单击返回按钮
			this.setVisible(false); 
			}
	}
}