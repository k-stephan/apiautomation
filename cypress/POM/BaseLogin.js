const locators =require("../fixtures/WebElements.json")

class login
{

    setusername(username)
    {
        cy.get(locators.loginlocators.txtusername).clear().type(username)  
           
    }

    setpassword(password)
    {
        cy.get(locators.loginlocators.txtpassword).clear().type(password)
    }
    
    clicklogin()
    {
        cy.get(locators.loginlocators.clklogin).click()
        
            if (cy.get(locators.loginlocators.recurrmodelalert).should('contain','Recurring Reports Expiring Soon')) 
                {
                    cy.get(locators.loginlocators.btnclose).click()
                }
    }

    validate_login()
    {
        cy.url().should('contain','Dashboard')
    }
   
}
export default login;