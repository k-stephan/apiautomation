/// <reference types="Cypress" />

describe('First Test Case', function()
{
  it('test case 1', function()
  {
    cy.visit(Cypress.env('baseUrl'))
    cy.title().should('exist','Login to MARS')
    
  })

  it('test case 2', function()
  {
    //cy.visit('https://marsqa1.phxa.com/MARSWeb2/Login?returnUrl=%2FDashboard')
    cy.get("head").contains('Login to MARS')
    
  })

  it('test case 3', function()
  {
    //cy.visit('https://marsqa1.phxa.com/MARSWeb2/Login?returnUrl=%2FDashboard')
    cy.title().should('eq','Login to MARS | MARSWeb marsqa1.phxa.com')
    
  })

});
