package board.app.sample.bean.user;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class UserListBean implements Serializable {

    private ArrayList<UserRecordBean> userList;

    public UserListBean(){
        userList = new ArrayList<UserRecordBean>();
    }

    public void addUserRecord(UserRecordBean record){
        userList.add(record);
    }

    public int getListSize(){
        return userList.size();
    }

    public ArrayList<UserRecordBean> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserRecordBean> userList) {
        this.userList = userList;
    }
}