import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Help extends CosM{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HelpJFrame();
	}
}

class HelpJFrame extends JFrame  implements ActionListener {
	private static final long serialVersionUID = -7885065351613428261L;
	JPanel jp0;// 放置背景
	JPanel jp2;// 放置按钮
	
    private JButton jb0;
    
    public HelpJFrame(){ // 构造方法
    	jb0 = new JButton(new ImageIcon("./imgs/返回.png"));
    	jb0.setContentAreaFilled(false);// 设置按钮背景为透明
		jb0.setBorder(null);
    	
    	jp2 = new JPanel();
    	jp2.setOpaque(false); //把JPanel设置为透明
    	jp2.setLayout(new GridLayout(1, 1, 0, 0));
    	jp2.add(jb0);
    	jb0.addActionListener(this);// 设置监听
    	
    	// 展示组件
    	this.setTitle("Help");
        ImageIcon icon = new ImageIcon("imgs\\图标.png");
    	this.setIconImage(icon.getImage());     // 给窗体设置图标方法
    	this.setLayout(null); // 取消布局管理
    	this.setBounds(420,163,1080,755);         // 设置窗口位置及大小
    		    	
    	setBak(); //调用背景方法
    	Container c = getContentPane(); //获取JFrame面板
    	jp0 = new JPanel(); //创建个JPanel
    	jp0.setOpaque(false); //把JPanel设置为透明
        c.add(jp0);
    		    	
    	jp2.setBounds(780,570,150,33);
    	
    	c.add(jp2);
    	this.setResizable(false);
    	this.setVisible(true); 
    }
    
    public void setBak(){// 背景方法
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\帮助界面.png"); //添加图片
        JLabel background = new JLabel(img); 
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

	@Override
	public void actionPerformed(ActionEvent e) {// 动作事件处理方法
		// TODO Auto-generated method stub         
		
		if(e.getSource()==jb0){// 单击返回按钮
			this.setVisible(false); 
			}
	}
}
