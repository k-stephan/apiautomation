/// <reference types="Cypress" />

describe('Login', function()
{
  it('Login', function()
  {
    
    cy.visit(Cypress.env('baseUrl'))
    cy.url().should('contain','marsqa1')
    cy.url().should('include','marsqa1.phxa.com')
    cy.get(".k-input-inner[placeholder='UserId']").clear   
    cy.get(".k-input-inner[placeholder='UserId']").type("SFSMARSW")   
 
  })

  it('Password', function()
  {
    cy.get(".k-input-inner[type='password']").clear   
    cy.get(".k-input-inner[type='password']").type("mars2")
   
  })

  it('Click', function()
  { 
    cy.get("span:nth-child(2)#btnLogin").click()
    //cy.wait(5000)  

  })

});


describe('Landing Page', function()
{

  it('Dashboard', function()
  { 
    cy.url().should('contain','Dashboard')
    cy.get("#dynamicModalLabel1").should('contain','Recurring Reports Expiring Soon')
    cy.get("#btnClose0").click()
    //cy.wait(3000)  
    cy.get("#imgMarsLogo").should('have.attr','src','https://marsqa1.phxa.com/MARSWeb/images/Logo/HomePage_Logo.png')   

  })


});
