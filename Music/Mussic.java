package Music;

import java.sql.*;
import java.util.Scanner;

public class Mussic {
    public static void main(String[] args)  throws SQLException{
        Scanner in = new Scanner(System.in);
        int musicID;

        try(
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_music", "root", "");
                Statement stmt = con.createStatement();
                ) {

            // 4 chức năng cơ bản thêm sửa xóa dữ liệu

            //            Xóa bản ghi
            String sqlDelete = "delete from music where id = 12";
            System.out.println("XÓA bản ghi" + sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + "music muốn xóa");

//            Thêm bản ghi
            String sqlInsert = "insert into music(id , name , author,year ) value (18, 'ES', 'DANG KIM THI', '2022/03/12')";
            System.out.println("Thêm bản ghi" + sqlInsert + "\n");
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert + "music đc thêm là ");

//          update bản ghi
            String upDATE = "update  music set name = 'Con Mua NganG Qua' where id = 3 ";
            System.out.println("Update bản ghi " + upDATE + "\n");
            int countUpdate = stmt.executeUpdate(upDATE);
            System.out.println(countUpdate + "music đc sửa là");


//           Tìm kiếm theo id
//            System.out.println("Enter ID");
//            musicID = in.nextInt();
//            String select = " select * from music where id = " + musicID;
//



            String select = "select * from music";
            ResultSet rset = stmt.executeQuery(select);

            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                + rset.getString("name") + ","
                + rset.getString("author") + ","
                + rset.getDate("year")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
