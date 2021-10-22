package board.app.sample.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import board.app.sample.bean.board.BoardCommentListBean;
import board.app.sample.bean.board.BoardCommentRecordBean;

public class BoardCommentDao extends CommonDao {

    //board_comment_tableテーブルの全件select処理
    public BoardCommentListBean getBoardCommentListBean(int threadId) throws Exception {
        BoardCommentListBean boardCommentListBean = new BoardCommentListBean();
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "SELECT comment_id, thread_id, thread_comment, post_user_name, post_date_time from board_comment_table where thread_id = " + threadId ;
            System.out.println("SQL=" + sql); // debug
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BoardCommentRecordBean record = new BoardCommentRecordBean();
                record.setCommentId(rs.getInt("comment_id"));
                record.setThreadId(rs.getInt("thread_id"));
                record.setThreadComment(rs.getString("thread_comment"));
                record.setPostUserName(rs.getString("post_user_name"));
                record.setPostDateTime(rs.getString("post_date_time"));
                boardCommentListBean.addBoardCommentRecord(record);
            }
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return boardCommentListBean;
    }

    //board_comment_tableテーブルへのinsert処理
    public int addBoardComment(BoardCommentRecordBean record) throws Exception {
        this.open();
        try (Statement stmt = con.createStatement()){
            String sql = "INSERT board_comment_table (thread_id, thread_comment, post_user_name, post_date_time) values (" + record.getThreadId() + ", '" + record.getThreadComment() + "', '" + record.getPostUserName() + "', now() )";
            System.out.println("SQL=" + sql); // debug
            return stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
