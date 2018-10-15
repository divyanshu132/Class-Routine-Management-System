package geek;
import java.sql.*;
import java.util.*;


public class TimeTable 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Routine","root","root");
		Statement stmt=conn.createStatement();
		
		String[] theory=new String[30];
		String[] lab=new String[30];
		
		int[] theory_credit=new int[30];
		int[] lab_credit=new int[30];
		
		int[] pcode=new int[30];
		int la=0;int th=0;
		
		String sql = "SELECT subject_code, credit, professor_code FROM info";
	    ResultSet rs = stmt.executeQuery(sql);
	     
	    while(rs.next())
	    {
	       int n=rs.getInt("professor_code");
	       if(n==0)
	       {
	    	   lab[la]= rs.getString("subject_code");
	    	   lab_credit[la] = rs.getInt("credit");
	    	   la++;
	       }
	       else
	       {
	    	   theory[th]= rs.getString("subject_code");
	    	   theory_credit[th] = rs.getInt("credit");
	    	   pcode[th]=rs.getInt("professor_code");
	    	   th++;
	       }
	    }
	    rs.close();
	    int[] classes=new int[th];
	    int[] branch=new int[th];
	    int[] sem=new int[th];
	    
	    for(int i=0;i<th;i++)
	    {
	    	classes[i]=theory_credit[i]/2;
	    	
	    	// Get the branch
	    	// branch[i]=0 -> Cse 
	    	// branch[i]=1 -> Ece
	    	if(theory[i].charAt(0)=='c')
	    	{
	    		branch[i]=0;
	    	}
	    	else if(theory[i].charAt(0)=='e')
	    	{
	    		branch[i]=1;
	    	}
	    }
	    String[] gotoclass1=new String[th];
	    String[] gotoclass2=new String[th];
	    int[] cse_classes=new int[th];
	    int[] ece_classes=new int[th];
	    
	    int c1=0;int c2=0;   // c1->number of cse subjects.  c2-> number of ece subjects.  
	    
	    for(int i=0;i<th;i++)
	    {
	    	if(branch[i]==0)
	    	{
	    		gotoclass1[c1]=theory[i];
	    		cse_classes[c1]=classes[i];
	    				c1++;
	    	}
	    	else if(branch[i]==1)
	    	{
	    		gotoclass2[c2]=theory[i];
	    		ece_classes[c2]=classes[i];
	    				c2++;
	    	}
	    }
	    String[] fgotoclass1=new String[c1];
	    int[] fcse_classes=new int[c1];
	    int k=0;
	    
	    for(int i=0;i<c1;i++)
	    {
	    	for(int j=0;j<c1;j++)
	    	{
	    		if(k<3 && gotoclass1[j].charAt(2)=='2')
	    		{
	    			fgotoclass1[k]=gotoclass1[j];
	    			fcse_classes[k]=cse_classes[j];
	    			gotoclass1[j]="hello";
	    			k++;
	    		}
	    		else if(k==3 && gotoclass1[j].charAt(2)=='1')
	    		{
	    			fgotoclass1[k]=gotoclass1[j];
	    			fcse_classes[k]=cse_classes[j];
	    			gotoclass1[j]="hello";
	    			k++;
	    		}
	    		else if(k>3 && gotoclass1[j].charAt(2)=='3')
	    		{
	    			fgotoclass1[k]=gotoclass1[j];
	    			fcse_classes[k]=cse_classes[j];
	    			gotoclass1[j]="hello";
	    			k++;
	    		}
	    	}
	    }

	    // For class_room1.
	    
	    
	    for(int i=0;i<c1;i++)
	    {
	    	int j=fcse_classes[i];
	    	if(j==3)
	    	{
	    		//Monday(1), Wednesday(3), Friday(5)
	    		if(i==0)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==1)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==2)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					     "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==3)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==4)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==5)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==6)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==7)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    	}
	    	else if(j==4)
	    	{
	    		//Monday(1), Wednesday(3), Thursday(4), Friday(5)
	    		
	    		if(i==0)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
							 "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    	    stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 8to9=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==1)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		    
	    		    sql1="UPDATE class_room1 "+
							 "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
		    		stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 9to10=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==2)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
							 "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					     "SET 10to11=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==3)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
					     "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 4to5=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==4)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 1to2=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==5)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 2to3=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==6)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 3to4=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==7)
	    		{
	    			String sql1="UPDATE class_room1 "+
							    "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room1 "+
						 "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room1 "+
					    "SET 11to12=" + "\""+ fgotoclass1[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    	}
	    }
	    
	    // For class_room2
	    
	    
	    String[] fgotoclass2=new String[c2];
	    int[] fece_classes=new int[c2];
	    int p=0;
	    
	    for(int i=0;i<c2;i++)
	    {
	    	for(int j=0;j<c2;j++)
	    	{
	    		if(p<3 && gotoclass2[j].charAt(2)=='2')
	    		{
	    			fgotoclass2[p]=gotoclass2[j];
	    			fece_classes[p]=ece_classes[j];
	    			gotoclass2[j]="hello";
	    			p++;
	    		}
	    		else if(p==3 && gotoclass2[j].charAt(2)=='1')
	    		{
	    			fgotoclass2[p]=gotoclass2[j];
	    			fece_classes[p]=ece_classes[j];
	    			gotoclass2[j]="hello";
	    			p++;
	    		}
	    		else if(p>3 && gotoclass2[j].charAt(2)=='3')
	    		{
	    			fgotoclass2[p]=gotoclass2[j];
	    			fece_classes[p]=ece_classes[j];
	    			gotoclass2[j]="hello";
	    			p++;
	    		}
	    	}
	    }
	    
	    /*for(int i=0;i<c2;i++)
	    {
	    	System.out.print(fgotoclass2[i]+" ("+ece_classes[i]+")"+"\t");
	    }*/
	    
	    
	    
	    
	    for(int i=0;i<c2;i++)
	    {
	    	int j=ece_classes[i];
	    	if(j==3)
	    	{
	    		//Monday(1), Wednesday(3), Friday(5)
	    		if(i==0)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==1)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==2)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					     "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==3)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==4)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==5)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==6)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==7)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    	}
	    	else if(j==4)
	    	{
	    		//Monday(1), Wednesday(3), Thursday(4), Friday(5)
	    		
	    		if(i==0)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
							 "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    	    stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 8to9=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==1)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
	    		    stmt.executeUpdate(sql1);
	    		    
	    		    sql1="UPDATE class_room2 "+
							 "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
		    		stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 9to10=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==2)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
							 "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					     "SET 10to11=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==3)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
					     "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 11to12=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==4)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 1to2=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==5)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 2to3=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==6)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 3to4=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    		
	    		if(i==7)
	    		{
	    			String sql1="UPDATE class_room2 "+
							    "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=1";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=3";
		    		stmt.executeUpdate(sql1);
		    		
		    		sql1="UPDATE class_room2 "+
						 "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=4";
	    		    stmt.executeUpdate(sql1);
	    		
	    		    sql1="UPDATE class_room2 "+
					    "SET 4to5=" + "\""+ fgotoclass2[i] + "\"" + " WHERE id=5";
    		        stmt.executeUpdate(sql1);
	    		}
	    	}
	    }
	    
	    
	    //For labs
	    
	    int[] lab_branch=new int[la];
	    for(int i=0;i<la;i++)
	    {	
	    	// Get the branch
	    	// branch[i]=0 -> Cse 
	    	// branch[i]=1 -> Ece
	    	if(lab[i].charAt(0)=='c')
	    	{
	    		lab_branch[i]=0;
	    	}
	    	else if(lab[i].charAt(0)=='e')
	    	{
	    		lab_branch[i]=1;
	    	}
	    }
	    String[] gotocselab=new String[la];
	    String[] gotoecelab=new String[la];
	    int[] cse_lab_credit=new int[la];
	    int[] ece_lab_credit=new int[la];
	    
	    int c=0;int e=0;   // c->number of cse labs.  c2-> number of ece labs.  
	    
	    for(int i=0;i<la;i++)
	    {
	    	if(lab_branch[i]==0)
	    	{
	    		gotocselab[c]=lab[i];
	    		cse_lab_credit[c]=lab_credit[i];
	    				c++;
	    	}
	    	else if(lab_branch[i]==1)
	    	{
	    		gotoecelab[e]=lab[i];
	    		ece_lab_credit[e]=lab_credit[i];
	    				e++;
	    	}
	    }
	    
	    int count=0;int count1=0;int flag=0;int flag1=0;
	    for(int i=0;i<c;i++)
	    {
	    	if(cse_lab_credit[i]==6 && gotocselab[i].charAt(2)=='3')
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 8to9=" + "\""+ gotocselab[i] + "\"" + ", 9to10=" + "\""+ gotocselab[i] + "\"" + ", 10to11=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=1";
    		        stmt.executeUpdate(sql1);
    		        
    		        sql1="UPDATE cse_lab "+
    					    "SET 8to9=" + "\""+ gotocselab[i] + "\"" + ", 9to10=" + "\""+ gotocselab[i] + "\"" + ", 10to11=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=5";
        		        stmt.executeUpdate(sql1);
	    	}
	    	
	    	if(cse_lab_credit[i]==6 && gotocselab[i].charAt(2)=='2')
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 2to3=" + "\""+ gotocselab[i] + "\"" + ", 3to4=" + "\""+ gotocselab[i] + "\"" + ", 4to5=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=1";
    		        stmt.executeUpdate(sql1);
    		        
    		        sql1="UPDATE cse_lab "+
    					    "SET 2to3=" + "\""+ gotocselab[i] + "\"" + ", 3to4=" + "\""+ gotocselab[i] + "\"" + ", 4to5=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=5";
        		        stmt.executeUpdate(sql1);
	    	}
	    	if(cse_lab_credit[i]==4 && gotocselab[i].charAt(2)=='2' && count==0)
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 1to2=" + "\""+ gotocselab[i] + "\"" + ", 2to3=" + "\""+ gotocselab[i] + "\"" + ", 3to4=" + "\""+ gotocselab[i] + "\"" + ", 4to5=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=2";
    		        stmt.executeUpdate(sql1);
    		        flag=1;
	    	}
	    	
	    	if(cse_lab_credit[i]==4 && gotocselab[i].charAt(2)=='2' && count==1)
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 1to2=" + "\""+ gotocselab[i] + "\"" + ", 2to3=" + "\""+ gotocselab[i] + "\"" + ", 3to4=" + "\""+ gotocselab[i] + "\"" + ", 4to5=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=4";
    		        stmt.executeUpdate(sql1);
    		        flag=1;
	    	}
	    	
	    	if(cse_lab_credit[i]==3 && gotocselab[i].charAt(2)=='3' && count1==0)
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 8to9=" + "\""+ gotocselab[i] + "\"" + ", 9to10=" + "\""+ gotocselab[i] + "\"" + ", 10to11=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=2";
    		        stmt.executeUpdate(sql1);
    		        flag1=1;
	    	}
	    	
	    	if(cse_lab_credit[i]==3 && gotocselab[i].charAt(2)=='3')
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 8to9=" + "\""+ gotocselab[i] + "\"" + ", 9to10=" + "\""+ gotocselab[i] + "\"" + ", 10to11=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=4";
    		        stmt.executeUpdate(sql1);
	    	}
	    	
	    	if(cse_lab_credit[i]==3 && gotocselab[i].charAt(2)=='1')
	    	{
	    		String sql1="UPDATE cse_lab "+
					    "SET 8to9=" + "\""+ gotocselab[i] + "\"" + ", 9to10=" + "\""+ gotocselab[i] + "\"" + ", 10to11=" + "\""+ gotocselab[i] + "\"" + "  WHERE id=3";
    		        stmt.executeUpdate(sql1);
	    	}
	    	if(flag==1)
	    	{
	    		count++;
	    	    flag=0;
	    	}
	    	if(flag1==1)
	    	{
	    		count1++;
	    		flag1=0;
	    	}
	    	
	    }
	    
	    
	    // Ece_lab
	    
	    int ecount=0;int ecount1=0;flag=0;flag1=0;
	    
	    for(int i=0;i<e;i++)
	    {
	    	if(gotoecelab[i].charAt(2)=='3' && ecount==0)
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 8to9=" + "\""+ gotoecelab[i] + "\"" + ", 9to10=" + "\""+ gotoecelab[i] + "\"" + ", 10to11=" + "\""+ gotoecelab[i] + "\"" + "  WHERE id=1";
    		        stmt.executeUpdate(sql1);
    		        flag=1;
	    	}
	    	
	    	if(gotoecelab[i].charAt(2)=='2' && ecount1==0)
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 2to3=" + "\""+ gotoecelab[i] + "\"" + ", 3to4=" + "\""+ gotoecelab[i] + "\"" + ", 4to5=" + "\""+ gotoecelab[i] + "\"" + "  WHERE id=1";
    		        stmt.executeUpdate(sql1);
    		        flag1=1;
	    	}
	    	if(gotoecelab[i].charAt(2)=='2' && ecount1==1)
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 1to2=" + "\""+ gotoecelab[i] + "\"" + ", 2to3=" + "\""+ gotoecelab[i] + "\"" + ", 3to4=" + "\""+ gotoecelab[i] + "\"" + " WHERE id=3";
    		        stmt.executeUpdate(sql1);
    		        flag1=1;
	    	}
	    	
	    	if(gotoecelab[i].charAt(2)=='3' && ecount==1)
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 8to9=" + "\""+ gotoecelab[i] + "\"" + ", 9to10=" + "\""+ gotoecelab[i] + "\"" + ", 10to11=" + "\""+ gotoecelab[i] + "\"" + "  WHERE id=3";
    		        stmt.executeUpdate(sql1);
    		        flag=1;
	    	}
	    	
	    	if(gotoecelab[i].charAt(2)=='3' && ecount==2)
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 8to9=" + "\""+ gotoecelab[i] + "\"" + ", 9to10=" + "\""+ gotoecelab[i] + "\"" + ", 10to11=" + "\""+ gotoecelab[i] + "\"" + "  WHERE id=5";
    		        stmt.executeUpdate(sql1);
    		        flag=1;
	    	}
	    	
	    	if(gotoecelab[i].charAt(2)=='1')
	    	{
	    		String sql1="UPDATE ece_lab "+
					    "SET 8to9=" + "\""+ gotoecelab[i] + "\"" + ", 9to10=" + "\""+ gotoecelab[i] + "\"" + ", 10to11=" + "\""+ gotoecelab[i] + "\"" + "  WHERE id=4";
    		        stmt.executeUpdate(sql1);
	    	}
	    	if(flag==1)
	    	{
	    		ecount++;
	    	    flag=0;
	    	}
	    	if(flag1==1)
	    	{
	    		ecount1++;
	    		flag1=0;
	    	}
	    }	
	}
}

