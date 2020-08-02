package security;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public final class AuthorisationDataStorage {
    Logger logger = LoggerFactory.getLogger(AuthorisationDataStorage.class);

    private static AuthorisationDataStorage authorisationDataStorageInstance = null;

    private Map<Long, String> passwords = new HashMap<>();
    private Map<Long, String> pins = new HashMap<>();

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

    public void setPIN(Long id, String pin){
        pins.put(id, pin);
        logger.info("Set up new pin: " + pin);
    }

    public void changePIN(Long id, String pin){
        if(pins.containsKey(id)){
            pins.replace(id, pin);
            logger.info("Change PIN to new value: " + pin);
        } else {
            logger.info("");
        }
    }
}
