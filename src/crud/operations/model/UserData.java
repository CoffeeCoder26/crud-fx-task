/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.operations.model;

/**
 *
 * @author Abo Agiza
 */
public class UserData {
    
    private int UserId;
    private String UserName;
    private String UserEmail;
    private int UserAge;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public int getUserAge() {
        return UserAge;
    }

    public void setUserAge(int UserAge) {
        this.UserAge = UserAge;
    }

    @Override
    public String toString() {
        return "UserData{" + "UserId=" + UserId + ", UserName=" + UserName + ", UserEmail=" + UserEmail + ", UserAge=" + UserAge + '}';
    }
    
    
    
    
}
