package studentApp;

import java.util.Scanner;

import java.sql.*;

class student {
    String name, clas, address, city, id;
    int roll_no, mobile_no;
    private Statement stmt;

    public void Enterdata() throws Exception {
        Scanner o = new Scanner(System.in);
        System.out.println("Enter Student name: ");
        name = o.nextLine();
        System.out.println("Enter Student Roll_no: ");
        roll_no = o.nextInt();
        System.out.println("Enter Student Class : ");
        clas = o.next(); 
        System.out.println("Enter Student Mobile_no : ");
        mobile_no = o.nextInt();
        System.out.println("Enter Student Gmail_id : ");
        id = o.next(); 
        o.nextLine(); 
        System.out.println("Enter Student Address : ");
        address = o.nextLine();
        System.out.println("Enter Student city : ");
        city = o.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                + "/student?useSSL=false&allowPublicKeyRetrieval=true", "root", "ravi123");

        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
        ps.setString(1, name);
        ps.setInt(2, roll_no);
        ps.setString(3, clas);
        ps.setInt(4, mobile_no);
        ps.setString(5, id);
        ps.setString(6, address);
        ps.setString(7, city);
        int i=ps.executeUpdate();
        if(i>0) {
             
        }
        ps.close();
        System.out.println("Data Successfully Inserted");
        con.close();
    }

    void delete() {
        try {
            int roll_no;
            System.out.println("Enter the roll number of the student whose data you want to delete : ");
            Scanner o=new Scanner(System.in);
            roll_no=o.nextInt();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    + "/student?useSSL=false&allowPublicKeyRetrieval=true", "root", "ravi123");

            String sql = "DELETE FROM student WHERE roll_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roll_no);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data Successfully Deleted");
            } else {
                System.out.println("No data found with the given ID");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void search() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter roll number to search for: ");
            int rollNumber = scanner.nextInt();
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true", "root", "ravi123");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE roll_no=?");
            ps.setInt(1, rollNumber);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Record found:");
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Roll Number: " + rs.getInt("roll_no"));
                System.out.println("Class: " + rs.getString("class"));
                System.out.println("Mobile No: " + rs.getInt("Moblie_no")); // Updated column name
                System.out.println("ID: " + rs.getString("Gmail_Id"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("City: " + rs.getString("city"));
            } else {
                System.out.println("No record found with the given roll number.");
            }
            
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void up_date() throws Exception {
    	int ch;
    	  System.out.println("What do you want to Up_date Enter your Choice \n1.Name \n2.Class :\n 3.Moblie No : \n 4.Id : \n 5.Address \n 6. City ");
     
        Scanner o = new Scanner(System.in);
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true", "root", "ravi123"); {
              
      System.out.println("What do you want to Up_date Enter your Choice \n1.Name \n2.Class :\n 3.Moblie No : \n 4.Id : \n 5.Address \n 6. City ");
      ch=o.nextInt();
      switch(ch) {
      case 1:
    	  String sql = "UPDATE student SET name=? WHERE roll_no=?";
          System.out.println("Enter Student name: ");
          o.nextLine();
          name = o.nextLine();
          try { 
          	PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1, name);
              ps.setInt (2,44);
//             
              int i = ps.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
      case 2:
    	  String sql1= "UPDATE student SET class=? WHERE roll_no=?";
          System.out.println("Enter Student class : ");
          o.nextLine();
          clas = o.nextLine();
          try { 
          	PreparedStatement ps0 = con.prepareStatement(sql1);
              ps0.setString(1, clas);
              ps0.setInt (2,44);
//             
              int i = ps0.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps0.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
      case 3:
    	  String sql2 = "UPDATE student SET mobile_no=? WHERE roll_no=?";
          System.out.println("Enter Student Moblie_no: ");
          mobile_no = o.nextInt();
          try { 
          	PreparedStatement ps1 = con.prepareStatement(sql2);
              ps1.setInt(4, mobile_no);
              ps1.setInt (2,44);
//             
              int i = ps1.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps1.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
      case 4:
    	  String sql3 = "UPDATE student SET id=? WHERE roll_no=?";
          System.out.println("Enter Student id: ");
          id = o.nextLine();
          try { 
          	PreparedStatement ps2 = con.prepareStatement(sql3);
              ps2.setString(5, id);
              ps2.setInt (2,44);
//             
              int i = ps2.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps2.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
      case 5:
    	  String sql4 = "UPDATE student SET id=? WHERE roll_no=?";
          System.out.println("Enter Student name: ");
          id = o.nextLine();
          try { 
          	PreparedStatement ps3 = con.prepareStatement(sql4);
              ps3.setString(6, address);
              ps3.setInt (2,44);
//             
              int i = ps3.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps3.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
      case 6:
    	  String sql5= "UPDATE student SET address=? WHERE roll_no=?";
          System.out.println("Enter Student address: ");
          address = o.nextLine();
          try { 
          	PreparedStatement ps4 = con.prepareStatement(sql5);
              ps4.setString(6, address);
              ps4.setInt (2,44);
//             
              int i = ps4.executeUpdate();
              if (i > 0) {
                  System.out.println("Data Successfully Updated");
              } else {
                  System.out.println("No data found with the given Roll Number");
              }
              ps4.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
          break;
     
      } 
             }
      
             
             }
       
       
    

    void display() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:"
                    + "3306/student?useSSL=false&allowPublicKeyRetrieval=true", "root", "ravi123");
            stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student ");

            while (rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getInt(2) + "  " + rs.getString(3)+ " "
                        + ""+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    }
      


public class StudentData {
    static Scanner scanner = new Scanner(System.in);
    static String password = "Ravi@123";
    static student s = new student();

    public static void main(String[] args) {

        enterPassword();
        showMenu();
    }

    public static void enterPassword() {
        System.out.print("ENTER PASSWORD: ");
        String enteredPassword = scanner.nextLine();
        if (enteredPassword.equals(password) == false) {
            System.out.println("WRONG PASSWORD!!! TRY AGAIN");
            enterPassword();
        }
    }

    public static void showMenu() {
        try {
            while (true) {
                System.out.println("---------------------------");
                System.out.println("   **** MAIN MENU ***** ");
                System.out.println();
                System.out.println("Press 1 to Enter Record");
                System.out.println("Press 2 to Show Record");
                System.out.println("Press 3 to Search Record");
                System.out.println("Press 4 to Update Record");
                System.out.println("Press 5 to Delete Record");
                System.out.println("Press 6 to Exit");
                System.out.println("---------------------------");

                System.out.print("My Choice is: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        s.Enterdata();
                        break;
                    case 2:
                        s.display();
                        break;
                    case 3:
                      s.search();  // Call search() method for searching record
                        break;
                    case 4:
                        s.up_date();
                        break;
                    case 5:
                        s.delete();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("WRONG CHOICE!!! TRY AGAIN");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
