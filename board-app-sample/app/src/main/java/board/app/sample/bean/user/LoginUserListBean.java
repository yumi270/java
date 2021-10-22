package board.app.sample.bean.user;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class LoginUserListBean implements Serializable {

    private ArrayList<LoginUserRecordBean> loginUserList;

    public LoginUserListBean(){
        loginUserList = new ArrayList<LoginUserRecordBean>();
    }

    public void addLoginUserRecord(LoginUserRecordBean record){
        loginUserList.add(record);
    }

    public int getLoginUserListSize(){
        return loginUserList.size();
    }

    public ArrayList<LoginUserRecordBean> getLoginUserList() {
        return loginUserList;
    }

    public void setLoginUserList(ArrayList<LoginUserRecordBean> loginUserList) {
        this.loginUserList = loginUserList;
    }
}