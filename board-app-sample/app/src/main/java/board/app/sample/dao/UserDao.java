package board.app.sample.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import board.app.sample.bean.user.UserListBean;
import board.app.sample.bean.user.UserRecordBean;

public class UserDao extends CommonDao {

    //usersテーブルの全件select処理
    public UserListBean getUserListBean() throws Exception {
        UserListBean userListBean = new UserListBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT id, name, email from users");
            while(rs.next()) {
                UserRecordBean record = new UserRecordBean();
                record.setId(rs.getInt("id"));
                record.setName(rs.getString("name"));
                record.setEmail(rs.getString("email"));
                userListBean.addUserRecord(record);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return userListBean;
    }

    //usersテーブルの1件select処理
    public UserRecordBean getUserRecordBean(int id) throws Exception {
        UserRecordBean userRecordBean = new UserRecordBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT id, name, email from users where id = " + id);
            rs.next();
            userRecordBean.setId(rs.getInt("id"));
            userRecordBean.setName(rs.getString("name"));
            userRecordBean.setEmail(rs.getString("email"));
        } catch(Exception e){
            e.printStackTrace();
        }
        return userRecordBean;
    }

    //usersテーブルへのinsert処理
    public int addUserInfo(UserRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "INSERT users (name, email) values ('" + record.getName() + "', '" + record.getEmail() + "')";
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //usersテーブルへのupdate処理
    public int updateUserInfo(UserRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "update users set name = ('" + record.getName() + "'),email = ('" + record.getEmail() + "') where id = (" + record.getId() + ")";
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //usersテーブルへのdelete処理
    public int deleteUserInfo(int id) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "delete from users where id = (" + id + ")";
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
