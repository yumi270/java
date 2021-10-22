package board.app.sample.bean.board;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class BoardCommentListBean implements Serializable {

    private ArrayList<BoardCommentRecordBean> boardCommentList;

    public BoardCommentListBean(){
        boardCommentList = new ArrayList<BoardCommentRecordBean>();
    }

    public void addBoardCommentRecord(BoardCommentRecordBean record){
        boardCommentList.add(record);
    }

    public int getBoardCommentListSize(){
        return boardCommentList.size();
    }

    public ArrayList<BoardCommentRecordBean> getBoardCommentList() {
        return boardCommentList;
    }

    public void setBoardCommentList(ArrayList<BoardCommentRecordBean> boardCommentList) {
        this.boardCommentList = boardCommentList;
    }
}
