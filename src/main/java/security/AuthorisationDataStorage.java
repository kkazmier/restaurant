package security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public final class AuthorisationDataStorage {
    private static AuthorisationDataStorage authorisationDataStorageInstance = null;

    private Map<String, String> passwords = new HashMap<>();
    private Map<String, String> pins = new HashMap<>();

    private AuthorisationDataStorage(){

    }

    public static AuthorisationDataStorage getInstance(){
        if(authorisationDataStorageInstance == null){
            synchronized (AuthorisationDataStorage.class){
                if (authorisationDataStorageInstance == null){
                    authorisationDataStorageInstance = new AuthorisationDataStorage();
                }
            }
        }
        return authorisationDataStorageInstance;
    }
}
