import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serializable;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Mysql extends CosM implements Serializable{
	
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	//user_paswd
	String user,passwd;
	//khxx
    String pp;
	String sh;
	String sdsm;
	String fs;
	String jg;
	String bcsm;
	String photo;
	String one,two,three;

	
	// ���������ݿ�ķ�����װΪһ������
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //��������
			
			ct=DriverManager.getConnection("jdbc:mysql://localhost/comms?user=root&password=980519"); //�õ�����
			
			System.out.println("�ѳɹ��������ݿ�...");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ע���û��ķ���
	public void UserRegis(String a,String b)
	{
		// ���������
		try {
			ps=ct.prepareStatement("insert into user_passwd values(?,?)");
			ps.setString(1,a);
			ps.setString(2,b);
			
			//ִ��
			int i=ps.executeUpdate();
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "ע��ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);   
			}else
			{
				JOptionPane.showMessageDialog(null, "ע��ʧ��","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
    // ��¼��֤����
	public void SQLverify(String a,String b)
	{
		// ���������
		try {
			ps=ct.prepareStatement("select * from user_passwd where user=? and passwd=? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			// ResultSet�����,����һ�ű��еĽ����
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = rs.getString(1);
				passwd = rs.getString(2);
				//JOptionPane.showMessageDialog(null, "��¼�ɹ�������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				System.out.println("�ɹ���ȡ���û���������from���ݿ�");
				//System.out.println(user + "\t" + passwd + "\t");
				   
				new CosmeticsJFrame();// ���û�ѡ�����
			}else
			{
				JOptionPane.showMessageDialog(null, "�û�����������������������룡", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// ע����֤�������ж��û����Ƿ��Ѿ�����
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from user_passwd where user=?");
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "���û����Ѿ�����", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}else
			{
           // ����ע��
				CosMsFrame cf=new CosMsFrame();
				this.UserRegis(cf.jtf.getText(),cf.jpf.getText());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ct.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// ��������
	public void sousuo(String b,String c,String e,String g) {
			// ���������
			try {
				ps = ct.prepareStatement("select * from khxx where Ʒ�� like ? and ɫ�� like ? and �۸� like \"%\"?\"%\" and �ʺϷ�ɫ like \"%\"?\"%\"");
				ps.setString(1, b);
				ps.setString(2, c);
				ps.setString(3, e);
				ps.setString(4, g);
				// ResultSet�����
				rs = ps.executeQuery();
				if(rs.next())	
				{
					pp = rs.getString(1);
					sh = rs.getString(2);
					sdsm = rs.getString(3);
					bcsm = rs.getString(4);
					//photo = rs.getString(5);
					one = pp +"," + sh+","+sdsm;
					two = "\n�˿��Ʒ"+bcsm;
					//three = photo;
					
					new Khtj();
					
					Khtj cs = new Khtj();
					cs.one(one);
					cs.two(two);
					//cs.photo(three);
				}else
				{
					JOptionPane.showMessageDialog(null, "�]�������������Ϣ��������ѡ��", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				 try {
						ct.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
	}
}