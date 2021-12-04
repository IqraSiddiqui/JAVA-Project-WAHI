import java.io.*;
import java.sql.*;
import java.util.*;

public class AccessJDBC {
	public void access() {
		//List data = new ArrayList();
        BufferedWriter out = null;
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/wahi_server", "root", "iqra12345");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from commands");
            File file = new File("WAHICommands.txt");
            file.createNewFile();
			out = new BufferedWriter(new FileWriter(file, true));

			while (rs.next()) {
                out.newLine();
				String id = String.valueOf(rs.getInt("id"));
                out.write(id+" ");
				String command = rs.getString("command");
                out.write(command);
			}
			out.close();
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}