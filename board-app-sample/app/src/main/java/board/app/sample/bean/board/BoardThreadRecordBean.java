package board.app.sample.bean.board;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class BoardThreadRecordBean implements Serializable {

    private int threadId;

    private String threadTitle = "";

    private String threadText = "";

    private String postUserName = "";

    private String postDateTime = "";

    ArrayList<String> errorMessages;

    public BoardThreadRecordBean() {
        errorMessages = new ArrayList<>();
    }

    public boolean checkValue(){
        errorMessages.clear();
        
        if(threadTitle == null || "".equals(threadTitle)){
            //threadTitleの必須チェック
            errorMessages.add("threadTitleを入力してください。");
        } else if (threadTitle.length() > 100){
            //threadTitleの桁数チェック
            errorMessages.add("threadTitleは100文字以下で入力してください。");
        }

        if(threadText == null || "".equals(threadText)){
            //threadTextの必須チェック
            errorMessages.add("threadTextを入力してください。");
        } else if (threadText.length() > 1000){
            //threadTextの桁数チェック
            errorMessages.add("threadTextは1000文字以下で入力してください。");
        }
        
        if(errorMessages.size() > 0){
            return false;
        } 
        return true;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public String getThreadTitle() {
        return this.threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public String getThreadText() {
        return this.threadText;
    }

    public void setThreadText(String threadText) {
        this.threadText = threadText;
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

