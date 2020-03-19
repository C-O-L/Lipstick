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
	JPanel jp0;// ���ñ���
	JPanel jp2;// ���ð�ť
	
    private JButton jb0;
    
    public HelpJFrame(){ // ���췽��
    	jb0 = new JButton(new ImageIcon("./imgs/����.png"));
    	jb0.setContentAreaFilled(false);// ���ð�ť����Ϊ͸��
		jb0.setBorder(null);
    	
    	jp2 = new JPanel();
    	jp2.setOpaque(false); //��JPanel����Ϊ͸��
    	jp2.setLayout(new GridLayout(1, 1, 0, 0));
    	jp2.add(jb0);
    	jb0.addActionListener(this);// ���ü���
    	
    	// չʾ���
    	this.setTitle("Help");
        ImageIcon icon = new ImageIcon("imgs\\ͼ��.png");
    	this.setIconImage(icon.getImage());     // ����������ͼ�귽��
    	this.setLayout(null); // ȡ�����ֹ���
    	this.setBounds(420,163,1080,755);         // ���ô���λ�ü���С
    		    	
    	setBak(); //���ñ�������
    	Container c = getContentPane(); //��ȡJFrame���
    	jp0 = new JPanel(); //������JPanel
    	jp0.setOpaque(false); //��JPanel����Ϊ͸��
        c.add(jp0);
    		    	
    	jp2.setBounds(780,570,150,33);
    	
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
		
		if(e.getSource()==jb0){// �������ذ�ť
			this.setVisible(false); 
			}
	}
}
