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
	
	JPanel jp0;// ���ñ���
	JPanel jp1;// ����ͼƬ���
	JPanel jp2;// ���õ�һ������
	JPanel jp3;// ���õڶ�������
	JPanel jp4;// ���÷��ذ�ť
	
	private JButton jb0;
	
	//public JLabel jl1 = new JLabel(new ImageIcon(""));// ���ÿں�ͼƬ
	public JLabel jl2 = new JLabel("", JLabel.LEFT);// ��һ������
	public JLabel jl3 = new JLabel("", JLabel.LEFT);// �ڶ�������
	
    public Khtj(){ // ���췽��
    	jb0 = new JButton(new ImageIcon("./imgs/����2.png"));
    	jb0.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb0.setBorder(null);
		jb0.addActionListener(this);// ���ü���
    	
        jl2.setFont(new Font("����", Font.BOLD, 21));// ����������ʽ,����Ӵ�
		jl2.setForeground(Color.black);// ����������ɫ
		
	    jl3.setFont(new Font("����", Font.BOLD, 18));
	 	jl3.setForeground(Color.black);
    	/*
    	jp1 = new JPanel();
    	jp1.setOpaque(false); //��JPanel����Ϊ͸��
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
    	
    	// չʾ���
    	this.setTitle("�ں��Ƽ�");
    	this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("imgs\\ͼ��.png");
    	this.setIconImage(icon.getImage());     // ����������ͼ�귽��
    	this.setLayout(null); // ȡ�����ֹ���
    	this.setBounds(420,163,1080,755);         // ���ô���λ�ü���С
    		    	
    	setBak(); //���ñ�������
    	Container c = getContentPane(); //��ȡJFrame���
    	jp0 = new JPanel(); //����һ��JPanel
    	jp0.setOpaque(false); //��JPanel����Ϊ͸��
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
    
    public void setBak(){// ��������
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\�Ƽ�����.png"); //���ͼƬ
        JLabel background = new JLabel(img); 
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    
    public void one(String a){// �����ݿ��в鵽�����ݴ�����
    	System.out.println(a);// ��֤
    	jl2.setText(a);
 	    jl2.repaint(); 
    }
    
    public void two(String b){// �����ݿ��в鵽�����ݴ�����
    	System.out.println(b);// ��֤
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
		if(e.getSource()==jb0){// �������ذ�ť
			this.setVisible(false); 
			}
	}
}