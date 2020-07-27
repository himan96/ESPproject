package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import constant_variables.Constant_variables;
import email.Email_sender;
import pojo_class.Student;
import sms.Controller_SMS;


public class Jdbc_programming 
{
	public static void jdbconnectivity() throws Exception
	{
		String student_name;
		String mobile_number;
		String student_email;
		String birth_date;
		
		ArrayList<Student>student_arralist=new ArrayList<>();
		
		try(Connection con=DB_Connect.getConnect(); Statement statement=con.createStatement(); ResultSet resultset=statement.executeQuery(Constant_variables.JDBC_QUERY);)
		{
			while(resultset.next())
			{
				Student student=new Student();
				student.setSid(resultset.getInt(1));
				student.setSname(resultset.getString(2));
				student.setCity(resultset.getString(3));
				student.setMobnum(resultset.getString(4));
				student.setEmail(resultset.getString(5));
				student.setBdate(resultset.getString(6));
				student_arralist.add(student);
			}
			
			Date currentdate=new Date();
			SimpleDateFormat simple_date=new SimpleDateFormat("yyyy/MM/dd");
			String stringdate=simple_date.format(currentdate);//"2020/07/03"
			String current_date_array[]=stringdate.split("/");
			String current_date=current_date_array[2];
			String current_month=current_date_array[1];
			
			for(Student student_object:student_arralist)
			{
				student_name=student_object.getSname();
				mobile_number=student_object.getMobnum();
				student_email=student_object.getEmail();
				birth_date=student_object.getBdate();
				
				
				String birth_date_array[]=birth_date.split("-");//2020-07-03
				String birthday_date=birth_date_array[2];
				String birthday_month=birth_date_array[1];
				
				String name[]=student_name.split(" ");
				
				if(birthday_date.equals(current_date) && birthday_month.equals(current_month))
				{
					Email_sender.sendmail(student_email,name[0]);
					Controller_SMS.sendSMS(mobile_number,name[0]);
				}	
			}
		} 		
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}
}