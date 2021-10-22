package board.app.sample.bean.board;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class BoardCommentRecordBean implements Serializable {

    private int commentId;

    private int threadId;

    private String threadComment = "";

    private String postUserName = "";

    private String postDateTime = "";

    ArrayList<String> errorMessages;

    public BoardCommentRecordBean() {
        errorMessages = new ArrayList<>();
    }

    public boolean checkValue(){
        errorMessages.clear();
        
        if(threadComment == null || "".equals(threadComment)){
            //threadCommentの必須チェック
            errorMessages.add("threadCommentを入力してください。");
        } else if (threadComment.length() > 1000){
            //threadCommentの桁数チェック
            errorMessages.add("threadCommentは1000文字以下で入力してください。");
        }
        
        if(errorMessages.size() > 0){
            return false;
        } 
        return true;
    }

    public int getCommentId() {
        return this.commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public String getThreadComment() {
        return this.threadComment;
    }

    public void setThreadComment(String threadComment) {
        this.threadComment = threadComment;
    }

    public String getPostUserName() {
        return this.postUserName;
    }

    public void setPostUserName(String postUserName) {
        this.postUserName = postUserName;
    }

    public String getPostDateTime(){
        return this.postDateTime;
    }

    public void setPostDateTime(String postDateTime){
        this.postDateTime = postDateTime;
    }

    public ArrayList<String> getErrorMessages() {
        return this.errorMessages;
    }
    
    public void setErrorMessages(ArrayList<String> errorMessages){
        this.errorMessages = errorMessages;
    }
}

