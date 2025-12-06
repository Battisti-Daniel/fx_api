package validations;

import java.util.Map;

import database.migrations.Get;

public class ValidateLogin {
    
    private String username;
    private String password;

    public ValidateLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        Get get = new Get();
        Map<String, String> acc = get.getAccount("account", this.username, this.password);
        
        if (acc == null || acc.isEmpty()) {
            return false;
        }
        
        if (!acc.get("account").equals(this.username)) {
            return false;
        }
        
        return true;
    }
}
