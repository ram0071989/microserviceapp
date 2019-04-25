package org.strawberry.microserviceapp.homecore.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.strawberry.microserviceapp.homecore.model.UserAccount;
import org.strawberry.microserviceapp.homecore.repository.UserAccountRepository;

import java.util.List;

@Service
public class WebService {

    /******************************************************
     *
     * Logger(s)
     *
     *****************************************************/

    private static final Logger logger = LogManager.getLogger( "WebService" );

//    private List<UserAccount> userAccountList = new ArrayList<>();

    @Autowired
    private UserAccountRepository userAccountRepository;

    /******************************************************
     *
     * Public Method(s)
     *
     *****************************************************/

    /**
     * Validates a user account
     * @param userName String passed from home.jsp
     * @return UserAccount object with values initialized based on validation
     */
    public UserAccount validUserAccount( String userName )
    {
        /**
         * Call this method when not using a DB and want to use a dummy validation service
         */
//        initData();

//        for ( UserAccount userAccount: userAccountList ) {
//
//            if ( userName.equalsIgnoreCase( userAccount.getUsername() ) )
//            {
//                return userAccount;
//            }
//        }

        logger.info( "Login Authentication request received for username: {}", userName );
        UserAccount userAccount;

        int i=0;
        List<UserAccount> userAccountList = userAccountRepository.findAll();
        logger.info( "{}", userAccountList.size() );
        for ( UserAccount user : userAccountList ) {


            logger.info( "{}: {}", i, user.toString() );
            i++;

        }


        userAccount = userAccountRepository.findByUsername( userName );

        if ( userAccount == null )
        {
            logger.error( "No account found in Mongo" );
        }
        else
        {
            logger.info( userAccount.toString() );
        }

        return userAccount;

    }

    /******************************************************
     *
     * Private Method(s)
     *
     *****************************************************/

    /**
     * Initialize a sample userAccount list to validate against
     */
//    private void initData()
//    {
//        userAccountList.add( new UserAccount( "john", 12345678, 87654321, "John", "Doe" ) );
//        userAccountList.add( new UserAccount( "jane", 23456789, 98765432, "Jane", "Doe" ) );
//    }
}
