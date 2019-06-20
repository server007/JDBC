package my;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;  
import javax.servlet.jsp.tagext.TagSupport;  
import java.io.*;
import java.util.*;
import java.sql.*;
public class Db extends TagSupport
{	JspWriter out;	String tablename;
	public void setTablename(String tablename)
	{
	  this.tablename=tablename;
	  
	}
	public String getTablename()
	{ return tablename;
	}
	
	public int doStartTag()throws JspException
		{	out=pageContext.getOut();
			try{
  				Statement s=Conn_db.con.createStatement();
				ResultSet rs=s.executeQuery("select * from "+tablename);
				ResultSetMetaData rsmd=rs.getMetaData();
				int count=rsmd.getColumnCount();
				out.println("<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr>");
				for(int i=1;i<=count;i++)
					out.println("<th>"+rsmd.getColumnName(i)+"</th>");
				out.println("</tr>");
				while(rs.next())
			{
				
				 out.println("<tr>");
				for(int j=1;j<=count;j++)
					out.println("<td>"+rs.getString(j)+"</td>");
				
				out.println("</tr>");
				
			}
			out.println("</table></body></html>");
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