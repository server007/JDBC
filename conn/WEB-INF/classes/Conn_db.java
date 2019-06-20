package my;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;  
import javax.servlet.jsp.tagext.TagSupport;  
import java.io.*;
import java.util.*;
import java.sql.*;
public class Conn_db extends TagSupport
{	JspWriter out;	String drivername,driverURL;
	public static Connection con;
	public void setDrivername(String drivername)
	{
	  this.drivername=drivername;
	  
	}
	public String getDrivername()
	{ return drivername;
	}
	public void setDriverURL(String driverURL)
	{
	  this.driverURL=driverURL;
	   
	}
	public String getDriverURL()
	{ return driverURL;
	}
	public int doStartTag()throws JspException
		{	out=pageContext.getOut();
			try{
  				 Class.forName(drivername); 
				  out.println("REGISTERED"); 
  				 con=DriverManager.getConnection(driverURL,"root","urvashi@");
				   out.println("CONNECTED"); 
			   }
			catch(Exception e)
			{ try{
				out.println(e);
			    }
			   catch(Exception ae)
				{ 
				}
			}
			  
		return EVAL_BODY_INCLUDE;
		}
	public int doEndTag()throws JspException
		{
		return EVAL_PAGE;
		}
}