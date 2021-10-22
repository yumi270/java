package board.app.sample.bean.board;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class BoardThreadListBean implements Serializable {

    private ArrayList<BoardThreadRecordBean> boardThreadList;

    public BoardThreadListBean(){
        boardThreadList = new ArrayList<BoardThreadRecordBean>();
    }

    public void addBoardThreadRecord(BoardThreadRecordBean record){
        boardThreadList.add(record);
    }

    public int getBoardThreadListSize(){
        return boardThreadList.size();
    }

    public ArrayList<BoardThreadRecordBean> getBoardThreadList() {
        return boardThreadList;
    }

    public void setBoardThreadList(ArrayList<BoardThreadRecordBean> boardThreadList) {
        this.boardThreadList = boardThreadList;
    }
}
