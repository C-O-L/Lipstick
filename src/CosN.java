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
	
	// Ʒ�������ı���
    JTextField pinpai;
	
    private JButton jb0;
    private JButton jb1;
    
    public JComboBox combox_sehao;// ɫ����Ͽ�����������ΪString
    public JComboBox combox_jiagequjian;// �۸�������Ͽ�����������ΪString
    public JComboBox combox_fuse;// ��ɫ��Ͽ�����������ΪString

    public static String sehao[]={"��ѡ��ɫ��","С����09","С����21","Բ��80","����72","�ڹ�416","�ڹ�407","�ڹ�409","�ڹ�425","���500","���200","���205","���206","�ڹ�302","�ڹ�500","�ڹ�400","marrakesh","cockney","dubonnet"};// �洢ɫ��
    public static String jiagequjian[]={"��ѡ��۸�","50-100","100-150","150-200","200-250","250-300","300-350","350-400","400-450"};// �洢�۸�
    public static String fuse[]={"��ѡ���ɫ","��һ��","�ƶ���","�ƺ�Ƥ","��һ��","�۶���","��Ȼɫ"};// �洢��ɫ
	
    public CosmeticsJFrame()// ���췽��
    {
    	// ����Ʒ�������
    	pinpai = new JTextField("������Ʒ��");
    	pinpai.setOpaque(false);// ���ñ���͸��
    	pinpai.setBorder(null);// ȡ���߿�
    	pinpai.setFont(new Font("����",Font.BOLD,20));// �����ı�����������
    	
    	jb0 = new JButton(new ImageIcon("./imgs/����.png"));
    	jb0.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb0.setBorder(null);
    	jb1 = new JButton(new ImageIcon("./imgs/����.png"));
    	jb1.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb1.setBorder(null);
    	
    	jp1 = new JPanel();
    	jp1.setOpaque(false); //��JPanel����Ϊ͸��
    	jp1.setLayout(new GridLayout(2, 2, 80, 74));
    	
    	jp1.add(pinpai);
    	jp1.add(this.combox_sehao=new JComboBox(CosmeticsJFrame.sehao));// ��ɫ����Ͽ���ӵ�jp1
    	jp1.add(this.combox_jiagequjian=new JComboBox(CosmeticsJFrame.jiagequjian));
    	jp1.add(this.combox_fuse=new JComboBox(CosmeticsJFrame.fuse));
    	
    	//combox_sehao.setOpaque(false);// ���ñ���͸��
    	//combox_sehao.setBorder(null);// ȡ���߿�
    	combox_sehao.setBackground(Color.WHITE);
    	combox_sehao.setForeground(Color.black);
    	//combox_jiagequjian.setOpaque(false);// ���ñ���͸��
    	//combox_jiagequjian.setBorder(null);// ȡ���߿�
    	combox_jiagequjian.setBackground(Color.WHITE);
    	combox_jiagequjian.setForeground(Color.black);
    	//combox_fuse.setOpaque(false);// ���ñ���͸��
    	//combox_fuse.setBorder(null);// ȡ���߿�
    	combox_fuse.setBackground(Color.WHITE);
    	combox_fuse.setForeground(Color.black);

    	this.combox_sehao.addActionListener(this);// Ϊ��Ͽ���Ӽ���
    	this.combox_jiagequjian.addActionListener(this);
    	this.combox_fuse.addActionListener(this);
    	
    	jp2 = new JPanel();
    	jp2.setOpaque(false); //��JPanel����Ϊ͸��
    	jp2.setLayout(new GridLayout(1, 2, 80, 0));
    	jp2.add(jb0);
    	jp2.add(jb1);
    	jb0.addActionListener(this);// ���ü���
    	jb1.addActionListener(this);// ���ü���
    	
    	this.setTitle("�ں��Ƽ�ϵͳ");
	    ImageIcon icon = new ImageIcon("imgs\\ͼ��.png");
	    this.setIconImage(icon.getImage());     // ����������ͼ�귽��
	    this.setLayout(null); // ȡ�����ֹ���
    	this.setBounds(420,163,1080,755);// ���ô���λ�ü���С
    	
    	setBak(); //���ñ�������
        Container c = getContentPane(); //��ȡJFrame���
        jp0 = new JPanel(); //����һ��JPanel
        jp0.setOpaque(false); //��JPanel����Ϊ͸��
        c.add(jp0);
    	
    	jp1.setBounds(263,262,547,132);
    	jp2.setBounds(318,485,438,45);
    	
    	c.add(jp1);
        c.add(jp2);
        this.setResizable(false);
    	this.setVisible(true);
    }
    
    public void setBak(){// ��������
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("imgs\\��������.png"); //���ͼƬ
        JLabel background = new JLabel(img); 
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
   
	@Override
	public void actionPerformed(ActionEvent e) {// �����¼�������
		// TODO Auto-generated method stub         	
		if(e.getSource()==jb0){// ����������ť
			
			String seh=(String)this.combox_sehao.getSelectedItem();// ���ɫ��
			String jiag=(String)this.combox_jiagequjian.getSelectedItem();// ��ü۸�
			String fus=(String)this.combox_fuse.getSelectedItem();// ��÷�ɫ
			
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
			}else if(e.getSource()==jb1)// ����������ť
			{
				new HelpJFrame();// �򿪰�������
			}
	}	
}