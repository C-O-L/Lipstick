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

	
	// 将连接数据库的方法封装为一个方法
	public void ConnectSQL()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //加载驱动
			
			ct=DriverManager.getConnection("jdbc:mysql://localhost/comms?user=root&password=980519"); //得到连接
			
			System.out.println("已成功连接数据库...");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 注册用户的方法
	public void UserRegis(String a,String b)
	{
		// 创建火箭车
		try {
			ps=ct.prepareStatement("insert into user_passwd values(?,?)");
			ps.setString(1,a);
			ps.setString(2,b);
			
			//执行
			int i=ps.executeUpdate();
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "注册成功","提示消息",JOptionPane.WARNING_MESSAGE);   
			}else
			{
				JOptionPane.showMessageDialog(null, "注册失败","提示消息",JOptionPane.ERROR_MESSAGE);
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
	
    // 登录验证方法
	public void SQLverify(String a,String b)
	{
		// 创建火箭车
		try {
			ps=ct.prepareStatement("select * from user_passwd where user=? and passwd=? ");
			ps.setString(1, a);
			ps.setString(2, b);
			
			// ResultSet结果集,返回一张表行的结果集
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = rs.getString(1);
				passwd = rs.getString(2);
				//JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
				System.out.println("成功获取到用户名和密码from数据库");
				//System.out.println(user + "\t" + passwd + "\t");
				   
				new CosmeticsJFrame();// 打开用户选择界面
			}else
			{
				JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
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
	
	// 注册验证方法，判断用户名是否已经存在
	public void ZhuceVerify(String a)
	{
		try {
			ps=ct.prepareStatement("select * from user_passwd where user=?");
			ps.setString(1, a);
			
			rs=ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
			}else
			{
           // 进行注册
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
	
	// 搜索方法
	public void sousuo(String b,String c,String e,String g) {
			// 创建火箭车
			try {
				ps = ct.prepareStatement("select * from khxx where 品牌 like ? and 色号 like ? and 价格 like \"%\"?\"%\" and 适合肤色 like \"%\"?\"%\"");
				ps.setString(1, b);
				ps.setString(2, c);
				ps.setString(3, e);
				ps.setString(4, g);
				// ResultSet结果集
				rs = ps.executeQuery();
				if(rs.next())	
				{
					pp = rs.getString(1);
					sh = rs.getString(2);
					sdsm = rs.getString(3);
					bcsm = rs.getString(4);
					//photo = rs.getString(5);
					one = pp +"," + sh+","+sdsm;
					two = "\n此款产品"+bcsm;
					//three = photo;
					
					new Khtj();
					
					Khtj cs = new Khtj();
					cs.one(one);
					cs.two(two);
					//cs.photo(three);
				}else
				{
					JOptionPane.showMessageDialog(null, "沒有搜索到相关信息，请重新选择", "提示消息", JOptionPane.WARNING_MESSAGE);
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