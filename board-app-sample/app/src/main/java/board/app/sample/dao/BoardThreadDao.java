package board.app.sample.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import board.app.sample.bean.board.BoardThreadListBean;
import board.app.sample.bean.board.BoardThreadRecordBean;

public class BoardThreadDao extends CommonDao {

    //board_thread_tableテーブルの全件select処理
    public BoardThreadListBean getBoardThreadListBean() throws Exception {
        BoardThreadListBean boardThreadListBean = new BoardThreadListBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "SELECT thread_id, thread_title, thread_text, post_user_name, post_date_time from board_thread_table";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BoardThreadRecordBean record = new BoardThreadRecordBean();
                record.setThreadId(rs.getInt("thread_id"));
                record.setThreadTitle(rs.getString("thread_title"));
                record.setThreadText(rs.getString("thread_text"));
                record.setPostUserName(rs.getString("post_user_name"));
                record.setPostDateTime(rs.getString("post_date_time"));
                boardThreadListBean.addBoardThreadRecord(record);
            }
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return boardThreadListBean;
    }

    //board_thread_tableテーブルの1件select処理
    public BoardThreadRecordBean getBoardThreadRecordBean(int threadId) throws Exception {
        BoardThreadRecordBean record = new BoardThreadRecordBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "SELECT thread_id, thread_title, thread_text, post_user_name, post_date_time from board_thread_table where thread_id = " + threadId;
            System.out.println("SQL = " + sql); // debug
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            record.setThreadId(rs.getInt("thread_id"));
            record.setThreadTitle(rs.getString("thread_title"));
            record.setThreadText(rs.getString("thread_text"));
            record.setPostUserName(rs.getString("post_user_name"));
            record.setPostDateTime(rs.getString("post_date_time"));
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return record;
    }

    //board_thread_tableテーブルへのinsert処理
    public int addBoardThread(BoardThreadRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "INSERT board_thread_table (thread_title, thread_text, post_user_name, post_date_time) values ('" + record.getThreadTitle() + "', '" + record.getThreadText() + "', '" + record.getPostUserName() + "', now() )";
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //delete
    public int deleteLoginThreadInfo(BoardThreadRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "delete from board_thread_table where thread_title = '" + record.getThreadTitle() ;
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
