/// <reference types="Cypress" />
import login from "../POM/BaseLogin.js"
import findfirm from "../POM/FindFirm.js"

describe('Base_Login(smoke)', ()=>
{

    before(() => {

        Cypress.session.clearAllSavedSessions
        cy.visit(Cypress.env('baseUrl'))
        
    })


    it('Login_pom smoke', ()=>
        {
                cy.fixture('Login_Credentials').then(function(data)
                {
                    const nl=new login();
                    nl.setusername(data.username)
                    nl.setpassword(data.password)
                    nl.clicklogin()
                    nl.validate_login()
                })
                                  
        })

    it('FindFirm', function()
        {    
            const ff= new findfirm();
            ff.clickfindfirm()
            ff.FindFirmProfile()   
            cy.wait(10000)
    
        })

});