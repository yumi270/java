package board.app.sample.bean.user;

import java.io.Serializable;
import java.util.ArrayList;

// serialVersionUIDを書かずにワーニングを抑止するアノテーション
@SuppressWarnings("serial")
public class UserRecordBean implements Serializable {

    private int id;

    private String name = "";

    private String email = "";

    ArrayList<String> errorMessages;

    public UserRecordBean() {
        errorMessages = new ArrayList<>();
    }

    public boolean checkValue(){
        errorMessages.clear();
        
        if(name == null || "".equals(name)){
            //nameの必須チェック
            errorMessages.add("nameを入力してください。");
        } else if (name.length() > 32){
            //nameの桁数チェック
            errorMessages.add("nameは32文字以下で入力してください。");
        }

        if(email == null || "".equals(email)){
            //emailの必須チェック
            errorMessages.add("emailを入力してください。");
        } else if (email.length() > 32){
            //emailの桁数チェック
            errorMessages.add("emailは32文字以下で入力してください。");
        }
        
        if(errorMessages.size() > 0){
            return false;
        } 
        return true;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<String> getErrorMessages() {
        return this.errorMessages;
    }
    
    public void setErrorMessages(ArrayList<String> errorMessages){
        this.errorMessages = errorMessages;
    }
}