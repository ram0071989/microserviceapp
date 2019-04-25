package org.strawberry.microserviceapp.homecore.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.strawberry.microserviceapp.homecore.model.UserAccount;
import org.strawberry.microserviceapp.homecore.service.WebService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


/*******************************************************************************
 * @author sriram
 * @version 1.0
 * Class: WebController
 * Description: A sample webcontroller for service web requests
 ******************************************************************************/

@Controller
public class WebController {

    /******************************************************
     *
     * Logger(s)
     *
     *****************************************************/

    private static final Logger logger = LogManager.getLogger( "WebController" );


    /******************************************************
     *
     * Class Attribute(s)
     *
     *****************************************************/

    @Autowired
    private WebService webService;
    private String returnPage = null;


    /******************************************************
     *
     * Public Method(s)
     *
     *****************************************************/

    @GetMapping( path = "/home" )
    public String showHomePage()
    {
        logger.info( "Request received for home page");
        returnPage = "home";
        logger.info( "Navigating to {}", returnPage );
        return returnPage;
    }

    @PostMapping( path = "/showServices" )
    public String showServices( HttpServletRequest request, Model model )
    {
        String userName = request.getParameter( "userName" );
        logger.info( "Received request for userAccount authorization of {}", userName );
        Optional<UserAccount> optionalUserAccount = Optional.ofNullable ( webService.validUserAccount( userName ) );
        if ( optionalUserAccount.isPresent() )
        {
            logger.info( "{} authorized successfully", userName );
            UserAccount userAccount = optionalUserAccount.get();
            model.addAttribute( "userName", userAccount.getUsername() );
            model.addAttribute( "accountNumber", userAccount.getAccountNumber() );
            model.addAttribute( "customerId", userAccount.getCustomerId() );
            returnPage = "servicesMenu";
        }
        else
        {
            model.addAttribute( "message", "Invalid User Account" );
            returnPage = "home";
        }
        return returnPage;
    }
}
