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
    
	// �˺������ı���
    JTextField jtf;
    // ���������ı���
    JPasswordField jpf;
	// ��ť
	private JButton jb0, jb1;
	
	public CosMsFrame() {// ���췽��

		// �����˺����������
		jtf = new JTextField("������3-6λ�û���");
		jtf.setOpaque(false);// ���ñ���͸��
		jtf.setBorder(null);// ȡ���߿�
		jtf.setFont(new Font("����",Font.BOLD,20));// �����ı�����������
		jpf = new JPasswordField();
		jpf.setOpaque(false);
		jpf.setBorder(null);
		jpf.setFont(new Font("����",Font.BOLD,20));
		// ���ð�ť
		jb0 = new JButton(new ImageIcon("./imgs/ע��2.png"));
		jb0.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb0.setBorder(null);
		jb0.addActionListener(this);// ���ü���
		jb1 = new JButton(new ImageIcon("./imgs/��¼2.png"));	
		jb1.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb1.setBorder(null);
		jb1.addActionListener(this);
		// �������
		jp1 = new JPanel();
		// ������
		jp1.setOpaque(false); //��JPanel����Ϊ͸��
    	jp1.setLayout(new GridLayout(2, 1, 0, 42));// ���ò��ָ�ʽ
    	jp1.add(jtf);
    	jp1.add(jpf);
	    // �������  
		jp2 = new JPanel();
		jp2.setOpaque(false); //��JPanel����Ϊ͸��
    	jp2.setLayout(new GridLayout(1, 2, 28, 0));// ���ò��ָ�ʽ
    	// ������
    	jp2.add(jb0);
    	jp2.add(jb1); 
	        
		// չʾ���
		this.setTitle("�ں��Ƽ�ϵͳ");
		//this.FormBorderStyle(false);
	    ImageIcon icon = new ImageIcon("imgs\\ͼ��.png");
	    this.setIconImage(icon.getImage());     // ����������ͼ�귽��
	    this.setLayout(null); // ȡ�����ֹ���(���Բ��֣�
	    this.setBounds(420,163,1080,755);         // ���ô���λ�ü���С
	    	
	    setBak(); // ���ñ�������
	    Container c = getContentPane(); // ��ȡJFrame���
	    jp0 = new JPanel(); // ����һ��JPanel
	    jp0.setOpaque(false); // ��JPanel����Ϊ͸��
	    c.add(jp0);// ��jp0��ӵ�c���
	    	
	    jp1.setBounds(456,320,270,127);// ����jp1��λ�ü���С
	    jp2.setBounds(340,485,438,45);
	    	
	    c.add(jp1);
	    c.add(jp2);
		this.setResizable(false);// ��ֹ��������
	    this.setVisible(true); // ��ʾ����
	 }
	
	public void setBak(){// ��������
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\��¼����2.png"); //���ͼƬ
        JLabel background = new JLabel(img);// ����һ����ǩ���������洴����ͼƬ������ñ�ǩ
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// Ϊ���������ȣ������������Ҫʱ�����ص�;Ϊǰ�洴���ı�ǩ ���ò����ȣ����ｫ������Ϊ����ײ�
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());// ����label��ǩ��������λ�ã��������ñ�ǩ�Ĵ�С��ͼƬһ��
    }

	@Override
	public void actionPerformed(ActionEvent e) {// �����¼�������
		// TODO Auto-generated method stub
		if(e.getSource()==jb0){// ����ע�ᰴť
			this.logon();// ����ע�᷽��
			}else if(e.getSource()==jb1)// ������¼��ť
			{
				this.login();// ���õ�¼����
				//this.setVisible(false); 
			}
	}
	// ע�᷽��
    public void logon() {
    	String regex1="\\w{3,6}"; // �û���������3-6λ
 		boolean flag1=jtf.getText().matches(regex1);
 		
 		String regex2="\\w{6}"; // ���������6λ
 		boolean flag2=jpf.getText().matches(regex2);
 		
 	    if(flag1==false || flag2==false)
 		{
 			JOptionPane.showMessageDialog(null, "�û�����������д����,�û�������Ϊ3-6λ��ĸ_��������"+"\n"+"�������Ϊ6λ��ĸ_��������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
 			jtf.setText("");
 			jpf.setText("");
 		}else
 		{			
 		// ����ע�᷽��,�ȼ��Ҫע����û����Ƿ����
 		 Mysql co=new Mysql();
 		    co.ConnectSQL();
 		    co.ZhuceVerify(jtf.getText()); 
            co.UserRegis(jtf.getText(),jpf.getText());
            
 		    this.jtf.setText("");// ����ı���
 		    this.jpf.setText("");
 			}
	}

	//��¼����
	public void login() {
		Mysql s=new Mysql();
		s.ConnectSQL();
		s.SQLverify(jtf.getText(), jpf.getText());
		
		this.jtf.setText("");
		this.jpf.setText("");
	}
}
