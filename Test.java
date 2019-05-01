/*
   *This Tutorial is an example for how to access SQL databases using Java Data 
    Base connectivity (JDBC).
   *For this perticular project MySQL is used as the DBMS and the MySQL Java Driver 
    is used for stablishing the connection. 
   *Moreover, to give a practical idea about the situation, KeyBoard inputs is used
    to retrieve data from the MySQL.

Software versions       : MySQL - 8.0
MySQL Java Connector/J  : 8.0.15 (Latest Version at the tutorial is created)

Author @ BUDDHIKA ABEYSEKERA
Check out me on: LinkedIn: https://www.linkedin.com/in/babey/
                 GitHub: https://github.com/mbabeysekera/
*/
package test; // This name is alternative. Might different from yours
import java.sql.*; // Load all the features from the package
import java.util.Scanner;//Add java KeyBoard input Scanner Package
public class Test {

    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/sql_store"; //Set the URL to the DB
        String userName = "root"; //User Name (Mine is root)
        String pass = "1234"; //Password of the DB (eg: 1234)
        Class.forName("com.mysql.cj.jdbc.Driver"); //Load the MySQL Driver
        
        //Then Set the connection
        Connection con = DriverManager.getConnection(url, userName, pass);
        Statement st = con.createStatement();
        
        //getDetails method returns the parameters to load. here only two arguments 
        //are used. But can be changed according to your preference.
        String[] arg = getDetails();
        ResultSet rs = st.executeQuery("select " + arg[0] + 
                                        " from customers where customer_id = "+ arg[1] + ";");
        rs.next(); //After the data fetching, It is a must to shift 1 row
        
        String dat = rs.getString(1); //Store the data in "dat"
        //Here getString(1) means this program will only fetch 1 column.
        //Thats why the number in it is "1". If you need you can even put the column name
        //String dat = rs.getString(arg[0]); // arg[0] is the column name.
        
        System.out.println(dat);

        st.close();//Close the Statement
        con.close();//Close the connection
    }
    
    /*
        Following fucnction is used to set the inputs. 
    */
    public static String[] getDetails() {
        String[] detailsDB = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Set the Field Name : ");
        detailsDB[0] = sc.nextLine();
        System.out.println("Set the Customer ID : ");
        detailsDB[1] = sc.nextLine();
        return detailsDB; //Returns the array of input data to the main method.
    }
    
}
