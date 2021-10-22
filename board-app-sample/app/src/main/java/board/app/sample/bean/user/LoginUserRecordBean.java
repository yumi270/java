package board.app.sample.bean.user;

import java.io.Serializable;
import java.util.ArrayList;

import board.app.sample.dao.LoginUserDao;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class LoginUserRecordBean implements Serializable {

    private String userId = "";

    private String userName = "";

    private String password = "";

    private String email = "";

    private String adminFlag = "";

    ArrayList<String> errorMessages;

    public LoginUserRecordBean() {
        errorMessages = new ArrayList<>();
    }

    public boolean loginConfirm() throws Exception {
        errorMessages.clear();

        LoginUserDao dao = new LoginUserDao();
        if(dao.isExistUserIDandPassword(userId, password)) {
            return true;
        } else {
            errorMessages.add("ログインに失敗しました");
            return false;
        }
    }

    public boolean checkValue(){
        errorMessages.clear();
        
        if(userId == null || "".equals(userId)){
            //nameの必須チェック
            errorMessages.add("userIdを入力してください。");
        } else if (userId.length() > 20){
            //nameの桁数チェック
            errorMessages.add("userIdは20文字以下で入力してください。");
        }

        if(userName == null || "".equals(userName)){
            //nameの必須チェック
            errorMessages.add("userNameを入力してください。");
        } else if (userName.length() > 20){
            //nameの桁数チェック
            errorMessages.add("userNameは20文字以下で入力してください。");
        }

        if(password == null || "".equals(password)){
            //nameの必須チェック
            errorMessages.add("passwordを入力してください。");
        } else if (password.length() > 20){
            //nameの桁数チェック
            errorMessages.add("passwordは20文字以下で入力してください。");
        }

        if(email == null || "".equals(email)){
            //emailの必須チェック
            errorMessages.add("emailを入力してください。");
        } else if (email.length() > 256){
            //emailの桁数チェック
            errorMessages.add("emailは256文字以下で入力してください。");
        }

        if(adminFlag == null || "".equals(adminFlag)){
            //adminFlagの必須チェック
            errorMessages.add("権限を入力してください。");
        } else if(!"0".equals(adminFlag) && !"1".equals(adminFlag)){
            errorMessages.add("adminFlagの値が適切ではありません。");
        }
        
        if(errorMessages.size() > 0){
            return false;
        } 
        return true;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminFlag(){
        return this.adminFlag;
    }

    public void setAdminFlag(String adminFlag){
        this.adminFlag = adminFlag;
    }

    public ArrayList<String> getErrorMessages() {
        return this.errorMessages;
    }
    
    public void setErrorMessages(ArrayList<String> errorMessages){
        this.errorMessages = errorMessages;
    }
}