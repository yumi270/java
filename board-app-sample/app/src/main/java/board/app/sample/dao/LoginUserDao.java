package board.app.sample.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import board.app.sample.bean.user.LoginUserListBean;
import board.app.sample.bean.user.LoginUserRecordBean;

public class LoginUserDao extends CommonDao {

    //login_usersテーブルの全件select処理
    public LoginUserListBean getLoginUserListBean() throws Exception {
        LoginUserListBean userListBean = new LoginUserListBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT user_id, user_name, password, email, admin_flag from login_users");
            while(rs.next()) {
                LoginUserRecordBean record = new LoginUserRecordBean();
                record.setUserId(rs.getString("user_id"));
                record.setUserName(rs.getString("user_name"));
                record.setPassword(rs.getString("password"));
                record.setEmail(rs.getString("email"));
                record.setAdminFlag(rs.getString("admin_flag"));
                userListBean.addLoginUserRecord(record);
            }
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return userListBean;
    }

    //login_usersテーブルの1件select処理
    public LoginUserRecordBean getLoginUserRecordBean(String userId) throws Exception {
        LoginUserRecordBean record = new LoginUserRecordBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "SELECT user_id, user_name, password, email, admin_flag from login_users where user_id = '" + userId + "' ";
            System.out.println("SQL = " + sql); // debug
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            record.setUserId(rs.getString("user_id"));
            record.setUserName(rs.getString("user_name"));
            record.setPassword(rs.getString("password"));
            record.setEmail(rs.getString("email"));
            record.setAdminFlag(rs.getString("admin_flag"));
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return record;
    }

    //login_usersテーブルにユーザIDとパスワードの組み合わせが存在するか
    public boolean isExistUserIDandPassword(String userId, String password) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "SELECT user_id from login_users where user_id = '" + userId + "' and password = '" + password + "' ";
            System.out.println("SQL = " + sql); // debug
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //login_usersテーブルへのinsert処理
    public int addLoginUserInfo(LoginUserRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "INSERT login_users (user_id, user_name, password, email, admin_flag) values ('" + record.getUserId() + "', '" + record.getUserName() + "', '" + record.getPassword() + "', '" + record.getEmail() + "', '" + record.getAdminFlag() +  "')";
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //login_usersテーブルへのupdate処理
    public int updateLoginUserInfo(LoginUserRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "update login_users set user_name = ('" + record.getUserName() + "'),password = ('" + record.getPassword() + "'),email = ('" + record.getEmail() + "'),admin_flag = ('" + record.getAdminFlag() + "') where user_id = '" + record.getUserId() + "' ";
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //login_usersテーブルへのdelete処理
    public int deleteLoginUserInfo(String userId) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "delete from login_users where user_id = '" + userId + "' ";
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
