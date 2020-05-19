/*
Names: Alex Westcott and Ben Petro

Due Date: May 3 2017

Course: CS 113

Assignment: Ch 37

Description: KnightVision GUI using SQL to access a database
*/

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KnightVisionGUI extends JFrame implements ActionListener{

   //=================Global Components====================
	Statement stmt;
	
   // STUDENT COMPONENTS
   JButton bStudentFind = new JButton("Find");
   JButton bStudentAdd = new JButton("Add");
   JButton bStudentDelete = new JButton("Delete");
   JButton bStudentUpdate = new JButton("Update");
   JButton bStudentClear = new JButton("Clear");
   
   JTextField tStudentID = new JTextField();
   JTextField tFirstName = new JTextField();
   JTextField tLastName = new JTextField();
   JTextField tMajor = new JTextField();
   JTextField tYear = new JTextField();
   JTextField tAdvisor = new JTextField();
   JTextField tPhone = new JTextField();
   JTextField tEmail = new JTextField();
   JTextField tRelation = new JTextField();
      
   JTextPane jtxtInfo = new JTextPane();
   JScrollPane jscpInfo = new JScrollPane(jtxtInfo);
   
   // GRADE COMPONENTS
   JButton bGradeFind = new JButton("Find");
   JButton bGradeAdd = new JButton("Add");
   JButton bGradeDelete = new JButton("Delete");
	JButton bGradeUpdate = new JButton("Update");
	JButton bGradeClear = new JButton("Clear");
   
   		
   JTextField tGradeStudentID = new JTextField();
   JTextField tGradeCourseID = new JTextField();
   JTextField tGradeSemester = new JTextField();
   JTextField tGradeYear = new JTextField();
   JTextField tGradeGrade = new JTextField();
      
   JTextPane jtxtInfoGrade = new JTextPane();
   JScrollPane jscpInfoGrade = new JScrollPane(jtxtInfoGrade);
   
   // COURSE COMPONENTS
   JButton bCourseFind = new JButton("Find");
   JButton bCourseAdd = new JButton("Add");
	JButton bCourseDelete = new JButton("Delete");
	JButton bCourseUpdate = new JButton("Update");
	JButton bCourseClear = new JButton("Clear");
   
   JTextField tCourseCourseID = new JTextField();
   JTextField tCourseName = new JTextField();
   JTextField tCourseCredits = new JTextField();
   JTextField tCourseDescription = new JTextField();
   JTextField tCoursePrerequisite = new JTextField();
      
   JTextPane jtxtInfoCourse = new JTextPane();
   JScrollPane jscpInfoCourse = new JScrollPane(jtxtInfoCourse);
   
   // DEGREE COMPONENTS
   JButton bDegreeFind = new JButton("Find");
   JButton bDegreeAdd = new JButton("Add");
	JButton bDegreeDelete = new JButton("Delete");
	JButton bDegreeUpdate = new JButton("Update");
	JButton bDegreeClear = new JButton("Clear");
   
   JTextField tDegreeDegreeID = new JTextField();
   JTextField tDegreeDescription = new JTextField();
   JTextField tDegreeDirector = new JTextField();
   JTextField tDegreeNumOfCourses = new JTextField();
      
   JTextPane jtxtInfoDegree = new JTextPane();
   JScrollPane jscpInfoDegree = new JScrollPane(jtxtInfoDegree);
   
   // DEGREECOURSE COMPONENTS
   JButton bDegreeCourseAdd = new JButton("Add");
	JButton bDegreeCourseDelete = new JButton("Delete");
	JButton bDegreeCourseClear = new JButton("Clear");
   
   JTextField tDegreeCourseCourseID = new JTextField();
   JTextField tDegreeCourseDegreeID = new JTextField();
      
   JTextPane jtxtInfoDegreeCourse = new JTextPane();
   JScrollPane jscpInfoDegreeCourse = new JScrollPane(jtxtInfoDegreeCourse);
      
   public static void main(String[] args){
      KnightVisionGUI frame = new KnightVisionGUI();
      frame.setTitle("KnightVision");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 500);
      frame.setVisible(true);
   }//end main
   
	public void initializeDB(){
		try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection connection = DriverManager.getConnection("jdbc:odbc:KnightVision");
	stmt = connection.createStatement();
		}
	catch(Exception ex){
		ex.printStackTrace();
		}
	}
	
	
   public void actionPerformed(ActionEvent e){
      //==============STUDENT==============
      if(e.getSource() == bStudentFind){
      	try{
				String id = tStudentID.getText();
				String queryString = "SELECT * FROM Student WHERE StudentID = "+id+"";
				System.out.println(queryString);
				
				ResultSet rset = stmt.executeQuery(queryString);
				if(rset.next()){
					String lastName = rset.getString(3);
					String firstName = rset.getString(2);
					String major = rset.getString(4);
					String year = rset.getString(5);
					String advisor = rset.getString(6);
					String phone = rset.getString(7);
					String email = rset.getString(8);
					String rStatus = rset.getString(9);
					
					tLastName.setText(lastName);
					tFirstName.setText(firstName);
					tMajor.setText(major);
					tYear.setText(year);
					tAdvisor.setText(advisor);
					tPhone.setText(phone);
					tEmail.setText(email);
					tRelation.setText(rStatus);
					jtxtInfo.setText("Name: "+firstName+" "+lastName+"\nMajor: "+major+"\nYear: "+year+"\nAdvisor: "+advisor+"\nPhone: "+phone+"\nEmail: "+email+"\nRelationship: "+rStatus);
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bStudentAdd){
   		try{
				int id = Integer.parseInt(tStudentID.getText());
				String firstName = tFirstName.getText();
				String lastName = tLastName.getText();
				String major = tMajor.getText();
				String year = tYear.getText();
				String advisor = tAdvisor.getText();
				String phone = tPhone.getText();
				String email = tEmail.getText();
				String rStatus = tRelation.getText();
				
				String queryString = "INSERT INTO Student VALUES ("+id+", '"+firstName+"', '"+lastName+"', '"+major+"', '"+year+"', '"+advisor+"', '"+phone+"', '"+email+"', '"+rStatus+"')";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bStudentDelete){
   		try{
				int id = Integer.parseInt(tStudentID.getText());
				String queryString = "DELETE * FROM Student WHERE StudentID = "+id+"";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bStudentUpdate){
			try{
				int id = Integer.parseInt(tStudentID.getText());
				String firstName = tFirstName.getText();
				String lastName = tLastName.getText();
				String major = tMajor.getText();
				String advisor = tAdvisor.getText();
				String phone = tPhone.getText();
				String email = tEmail.getText();
				String rStatus = tRelation.getText();
				String year = tYear.getText();
				
	   		String queryString = "UPDATE Student SET Major = '"+major+"', Year = '"+year+"', Advisor = '"+advisor+"', PhoneNumber = '"+phone+"', Email = '"+email+"', RStatus = '"+rStatus+"' WHERE StudentID = "+id+"";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bStudentClear){
   		tStudentID.setText("");
			tFirstName.setText("");
			tLastName.setText("");
			tMajor.setText("");
			tYear.setText("");
			tAdvisor.setText("");
			tPhone.setText("");
			tEmail.setText("");
			tRelation.setText("");
      }

      //==============STUDENT==============
      
      //==============GRADE==============
      if(e.getSource() == bGradeFind){
   		try{
				int id = Integer.parseInt(tGradeStudentID.getText());
				String queryString = "SELECT * FROM Grade WHERE StudentID = "+id+"";
				System.out.println(queryString);
				ResultSet rset = stmt.executeQuery(queryString);
				if(rset.next()){
					String courseID = rset.getString(2);
					String semester = rset.getString(3);
					String year = rset.getString(4);
					String grade = rset.getString(5);
					
					tGradeCourseID.setText(courseID);
					tGradeSemester.setText(semester);
					tGradeYear.setText(year);
					tGradeGrade.setText(grade);
					jtxtInfoGrade.setText("Course ID: "+courseID+"\nSemester: "+semester+"\nYear: "+year+"\nGrade: "+grade);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bGradeAdd){
   		try{
				int id = Integer.parseInt(tGradeStudentID.getText());
				String courseID = tGradeCourseID.getText();
				String semester = tGradeSemester.getText();
				String year = tGradeYear.getText();
				String grade = tGradeGrade.getText();
				
				String queryString = "INSERT INTO Grade VALUES ("+id+", '"+courseID+"', '"+semester+"', '"+year+"', '"+grade+"')";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bGradeDelete){
   		try{
				int id = Integer.parseInt(tGradeStudentID.getText());
				
				String queryString = "DELETE * FROM Grade WHERE StudentID = "+id+"";
				
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bGradeUpdate){
   		try{
				int id = Integer.parseInt(tGradeStudentID.getText());
				String courseID = tGradeCourseID.getText();
				String semester = tGradeSemester.getText();
				String year = tGradeYear.getText();
				String grade = tGradeGrade.getText();
				
	   		String queryString = "UPDATE Grade SET Semester = '"+semester+"', Year = '"+year+"', Grade = '"+grade+"' WHERE StudentID = "+id+"";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bGradeClear){
   		tGradeStudentID.setText("");
			tGradeCourseID.setText("");
			tGradeSemester.setText("");
			tGradeYear.setText("");
			tGradeGrade.setText("");
      }
      //==============GRADE==============
      
      //==============COURSE==============
      if(e.getSource() == bCourseFind){
   		try{
				String courseId = tCourseCourseID.getText();
				String queryString = "SELECT * FROM Course WHERE CourseID = '"+courseId+"'";
				System.out.println(queryString);
				ResultSet rset = stmt.executeQuery(queryString);
				if(rset.next()){
					String name = rset.getString(2);
					String credits = rset.getString(3);
					String description = rset.getString(4);
					String prerequisite = rset.getString(5);
					
					tCourseName.setText(name);
					tCourseCredits.setText(credits);
					tCourseDescription.setText(description);
					tCoursePrerequisite.setText(prerequisite);
					jtxtInfoCourse.setText("Name: "+name+"\nCredits: "+credits+"\nDescription: "+description+"\nPrerequisite: "+prerequisite);
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bCourseAdd){
   		try{
				String courseId = tCourseCourseID.getText();
				String name = tCourseName.getText();
				String credits = tCourseCredits.getText();
				String description = tCourseDescription.getText();
				String prerequisite = tCoursePrerequisite.getText();
				
				String queryString = "INSERT INTO Course VALUES ('"+courseId+"', '"+name+"', '"+credits+"', '"+description+"', '"+prerequisite+"')";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bCourseDelete){
   		try{
				String courseId = tCourseCourseID.getText();
				
				String queryString = "DELETE * FROM Course WHERE CourseID = '"+courseId+"'";
				
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bCourseUpdate){
   		try{
				String courseID = tCourseCourseID.getText();
				String name = tCourseName.getText();
				String credits = tCourseCredits.getText();
				String description = tCourseDescription.getText();
				String prerequisite = tCoursePrerequisite.getText();
				
	   		String queryString = "UPDATE Course SET Name = '"+name+"', Credits = '"+credits+"', Description = '"+description+"', Prerequisite = '"+prerequisite+"' WHERE CourseID = '"+courseID+"'";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bCourseClear){
   		tCourseCourseID.setText("");
			tCourseName.setText("");
			tCourseCredits.setText("");
			tCourseDescription.setText("");
			tCoursePrerequisite.setText("");
      }
      //==============COURSE==============
      
      //==============DEGREE==============
      if(e.getSource() == bDegreeFind){
   		try{
				String degreeId = tDegreeDegreeID.getText();
				String queryString = "SELECT * FROM Degree WHERE DegreeID = '"+degreeId+"'";
				System.out.println(queryString);
				ResultSet rset = stmt.executeQuery(queryString);
				if(rset.next()){
					String description = rset.getString(2);
					String director = rset.getString(3);
					String numOfCourses = rset.getString(4);
					
					tDegreeDescription.setText(description);
					tDegreeDirector.setText(director);
					tDegreeNumOfCourses.setText(numOfCourses);
					jtxtInfoDegree.setText("Description: "+description+"\nDirector: "+director+"\nNumber of Courses: "+numOfCourses);

				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeAdd){
   		try{
				String degreeID = tDegreeDegreeID.getText();
				String director = tDegreeDirector.getText();
				String description = tDegreeDescription.getText();
				String numOfCourses = tDegreeNumOfCourses.getText();
				
				
				String queryString = "INSERT INTO Degree VALUES ('"+degreeID+"', '"+description+"', '"+director+"', '"+numOfCourses+"')";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeDelete){
   		try{
				String degreeId = tDegreeDegreeID.getText();
				
				String queryString = "DELETE * FROM Degree WHERE DegreeID = '"+degreeId+"'";
				
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeUpdate){
   		try{
				String degreeID = tDegreeDegreeID.getText();
				String director = tDegreeDirector.getText();
				String description = tDegreeDescription.getText();
				String numOfCourses = tDegreeNumOfCourses.getText();
				
	   		String queryString = "UPDATE Degree SET Description = '"+description+"', Director = '"+director+"', NumberOfCourses = '"+numOfCourses+"' WHERE DegreeID = '"+degreeID+"'";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeClear){
   		tDegreeDegreeID.setText("");
			tDegreeDirector.setText("");
			tDegreeDescription.setText("");
			tDegreeNumOfCourses.setText("");
      }
      //==============DEGREE==============
      
      //==============DEGREE-COURSE==============
      if(e.getSource() == bDegreeCourseAdd){
			try{
				String degreeId = tDegreeCourseDegreeID.getText();
				String courseId = tDegreeCourseCourseID.getText();
				
				
				String queryString = "INSERT INTO DegreeCourse VALUES ('"+courseId+"', '"+degreeId+"')";
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeCourseDelete){
   		try{
				String courseId = tDegreeCourseCourseID.getText();
				
				String queryString = "DELETE * FROM DegreeCourse WHERE CourseID = '"+courseId+"'";
				
				System.out.println(queryString);
				stmt.executeUpdate(queryString);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
      }
      if(e.getSource() == bDegreeCourseClear){
   		tDegreeCourseCourseID.setText("");
			tDegreeCourseDegreeID.setText("");
      }
      //==============DEGREE-COURSE==============
   }//End actionPerformed
   
   public KnightVisionGUI(){
      JTabbedPane jtpMain = new JTabbedPane();
		initializeDB();
      //===========Student Tab==============
      JPanel pStudent = new JPanel(new GridLayout(2,1));
      add(pStudent);
      JPanel pStudentTextFields = new JPanel(new GridLayout(9, 2));
      JPanel pStudentSouth = new JPanel(new GridLayout(2,1));
		JPanel pStudentButtons = new JPanel(new GridLayout(1,6));
      
      JLabel lStudentID = new JLabel("Student ID:");
      pStudentTextFields.add(lStudentID);
      pStudentTextFields.add(tStudentID);
      
      JLabel lFirstName = new JLabel("First Name:");
      pStudentTextFields.add(lFirstName);
      pStudentTextFields.add(tFirstName);
      
      JLabel lLastName = new JLabel("Last Name:");
      pStudentTextFields.add(lLastName);
      pStudentTextFields.add(tLastName);
      
      JLabel lMajor = new JLabel("Major:");
      pStudentTextFields.add(lMajor);
      pStudentTextFields.add(tMajor);
      
      JLabel lYear = new JLabel("Year:");
      pStudentTextFields.add(lYear);
      pStudentTextFields.add(tYear);
      
      JLabel lAdvisor = new JLabel("Advisor:");
      pStudentTextFields.add(lAdvisor);
      pStudentTextFields.add(tAdvisor);
      
      JLabel lPhone = new JLabel("Phone:");
      pStudentTextFields.add(lPhone);
      pStudentTextFields.add(tPhone);
      
      JLabel lEmail = new JLabel("Email:");
      pStudentTextFields.add(lEmail);
      pStudentTextFields.add(tEmail);
      
      JLabel lRelation = new JLabel("Relation Status:");
      pStudentTextFields.add(lRelation);
      pStudentTextFields.add(tRelation);
      
      bStudentFind.addActionListener(this);
      bStudentAdd.addActionListener(this);
      bStudentDelete.addActionListener(this);
      bStudentUpdate.addActionListener(this);
      bStudentClear.addActionListener(this);
      
		pStudentButtons.add(bStudentFind);
		pStudentButtons.add(bStudentAdd);
		pStudentButtons.add(bStudentDelete);
		pStudentButtons.add(bStudentUpdate);
		pStudentButtons.add(bStudentClear);
      
      pStudent.add(pStudentTextFields);
      pStudentSouth.add(jscpInfo);
		pStudentSouth.add(pStudentButtons);
      pStudent.add(pStudentSouth);
      jtpMain.add(pStudent, "Student", 0);
      //================
		//==========Grade Tab=================
		
		JPanel pGrade = new JPanel(new GridLayout(2,1));
		JPanel pGradeTextFields = new JPanel(new GridLayout(5,2));
		JPanel pGradeSouth = new JPanel(new GridLayout(2,1));
		JPanel pGradeButtons = new JPanel(new GridLayout(1,5));
      
		JLabel lGradeStudentID = new JLabel("Student ID:");
		pGradeTextFields.add(lGradeStudentID);
		pGradeTextFields.add(tGradeStudentID);
		
		JLabel lGradeCourseID = new JLabel("Course ID:");
		pGradeTextFields.add(lGradeCourseID);
		pGradeTextFields.add(tGradeCourseID);
		
		JLabel lGradeSemester = new JLabel("Semester:");
		pGradeTextFields.add(lGradeSemester);
		pGradeTextFields.add(tGradeSemester);
		
		JLabel lGradeYear = new JLabel("Year:");
		pGradeTextFields.add(lGradeYear);
		pGradeTextFields.add(tGradeYear);
		
		JLabel lGradeGrade = new JLabel("Grade:");
		pGradeTextFields.add(lGradeGrade);
		pGradeTextFields.add(tGradeGrade);
      
      bGradeFind.addActionListener(this);
      bGradeAdd.addActionListener(this);
      bGradeDelete.addActionListener(this);
      bGradeUpdate.addActionListener(this);
      bGradeClear.addActionListener(this);
		
		pGradeButtons.add(bGradeFind);
      pGradeButtons.add(bGradeAdd);
      pGradeButtons.add(bGradeDelete);
      pGradeButtons.add(bGradeUpdate);
      pGradeButtons.add(bGradeClear);
		
		pGrade.add(pGradeTextFields);
		pGrade.add(pGradeSouth);
		pGradeSouth.add(jscpInfoGrade);
		pGradeSouth.add(pGradeButtons);
		
		jtpMain.addTab("Grade", pGrade);
		//==========================
		//==========Course Tab=================
		
		JPanel pCourse = new JPanel(new GridLayout(2,1));
		JPanel pCourseTextFields = new JPanel(new GridLayout(5,2));
		JPanel pCourseSouth = new JPanel(new GridLayout(2,1));
		JPanel pCourseButtons = new JPanel(new GridLayout(1,5));
      
		JLabel lCourseCourseID = new JLabel("Course ID:");
		pCourseTextFields.add(lCourseCourseID);
		pCourseTextFields.add(tCourseCourseID);
		
		JLabel lCourseName = new JLabel("Name:");
		pCourseTextFields.add(lCourseName);
		pCourseTextFields.add(tCourseName);
		
		JLabel lCourseCredits = new JLabel("Credits:");
		pCourseTextFields.add(lCourseCredits);
		pCourseTextFields.add(tCourseCredits);
		
		JLabel lCourseDescription = new JLabel("Description:");
		pCourseTextFields.add(lCourseDescription);
		pCourseTextFields.add(tCourseDescription);
		
		JLabel lCoursePrerequisite = new JLabel("Prerequisite:");
		pCourseTextFields.add(lCoursePrerequisite);
		pCourseTextFields.add(tCoursePrerequisite);
      
      bCourseFind.addActionListener(this);
      bCourseAdd.addActionListener(this);
      bCourseDelete.addActionListener(this);
      bCourseUpdate.addActionListener(this);
      bCourseClear.addActionListener(this);
		
      pCourseButtons.add(bCourseFind);
      pCourseButtons.add(bCourseAdd);
      pCourseButtons.add(bCourseDelete);
      pCourseButtons.add(bCourseUpdate);
      pCourseButtons.add(bCourseClear);
		
		pCourse.add(pCourseTextFields);
		pCourse.add(pCourseSouth);
		pCourseSouth.add(jscpInfoCourse);
		pCourseSouth.add(pCourseButtons);
		
		jtpMain.addTab("Course", pCourse);
		//==========================
		//==========Degree Tab=================
		
		JPanel pDegree = new JPanel(new GridLayout(2,1));
		JPanel pDegreeTextFields = new JPanel(new GridLayout(5,2));
		JPanel pDegreeSouth = new JPanel(new GridLayout(2,1));
		JPanel pDegreeButtons = new JPanel(new GridLayout(1,5));
      
		JLabel lDegreeDegreeID = new JLabel("Degree ID:");
		pDegreeTextFields.add(lDegreeDegreeID);
		pDegreeTextFields.add(tDegreeDegreeID);
		
		JLabel lDegreeDescription = new JLabel("Description:");
		pDegreeTextFields.add(lDegreeDescription);
		pDegreeTextFields.add(tDegreeDescription);
		
		JLabel lDegreeDirector = new JLabel("Director:");
		pDegreeTextFields.add(lDegreeDirector);
		pDegreeTextFields.add(tDegreeDirector);
		
		JLabel lDegreeNumOfCourses = new JLabel("Number of Courses:");
		pDegreeTextFields.add(lDegreeNumOfCourses);
		pDegreeTextFields.add(tDegreeNumOfCourses);
      
      bDegreeFind.addActionListener(this);
      bDegreeAdd.addActionListener(this);
      bDegreeDelete.addActionListener(this);
      bDegreeUpdate.addActionListener(this);
      bDegreeClear.addActionListener(this);
		
      pDegreeButtons.add(bDegreeFind);
      pDegreeButtons.add(bDegreeAdd);
      pDegreeButtons.add(bDegreeDelete);
      pDegreeButtons.add(bDegreeUpdate);
      pDegreeButtons.add(bDegreeClear);
		
		pDegree.add(pDegreeTextFields);
		pDegree.add(pDegreeSouth);
		pDegreeSouth.add(jscpInfoDegree);
		pDegreeSouth.add(pDegreeButtons);
		
		jtpMain.addTab("Degree", pDegree);
		//==========================
		//==========DegreeCourse Tab=================
		
		JPanel pDegreeCourse = new JPanel(new GridLayout(2,1));
		JPanel pDegreeCourseTextFields = new JPanel(new GridLayout(5,2));
		JPanel pDegreeCourseSouth = new JPanel(new GridLayout(2,1));
		JPanel pDegreeCourseButtons = new JPanel(new GridLayout(1,5));
      
		JLabel lDegreeCourseCourseID = new JLabel("Course ID:");
		pDegreeCourseTextFields.add(lDegreeCourseCourseID);
		pDegreeCourseTextFields.add(tDegreeCourseCourseID);
		
		JLabel lDegreeCourseDegreeID = new JLabel("Degree ID:");
		pDegreeCourseTextFields.add(lDegreeCourseDegreeID);
		pDegreeCourseTextFields.add(tDegreeCourseDegreeID);
      
      bDegreeCourseAdd.addActionListener(this);
      bDegreeCourseDelete.addActionListener(this);
      bDegreeCourseClear.addActionListener(this);
		
      pDegreeCourseButtons.add(bDegreeCourseAdd);
      pDegreeCourseButtons.add(bDegreeCourseDelete);
      pDegreeCourseButtons.add(bDegreeCourseClear);
		
		pDegreeCourse.add(pDegreeCourseTextFields);
		pDegreeCourse.add(pDegreeCourseSouth);
		pDegreeCourseSouth.add(jscpInfoDegreeCourse);
		pDegreeCourseSouth.add(pDegreeCourseButtons);
		
		jtpMain.addTab("Degree Course", pDegreeCourse);
		//==========================
      add(jtpMain);
   }
}//end KnightVisionGUI