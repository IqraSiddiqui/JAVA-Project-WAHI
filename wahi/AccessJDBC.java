import java.io.*;
import java.sql.*;
import java.util.*;

public class AccessJDBC {
	public void access() {
		ArrayList<String> data=new ArrayList<String>();
		try {
			Connection con = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/wahi_server", "root", "iqra12345");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from commands");
			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String command = rs.getString("command");
				data.add(id+" "+command);
			}

			rs.close();
			st.close();
			writetoFile(data);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void writetoFile(ArrayList data){
		try{
		File file = new File("WAHICommands.txt");
        file.createNewFile();
		BufferedWriter out = null;
		out = new BufferedWriter(new FileWriter(file, true));
		for(int i=0;i<data.size();i++){
			//System .out.print(a);
			String a=String.valueOf(data.get(i));
			out.write(a);
			out.newLine();
		}
		out.close();
	}catch(Exception e){
		System.out.println(e);
	}
}
}