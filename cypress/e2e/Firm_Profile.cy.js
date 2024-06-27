/// <reference types="Cypress" />


describe('Firm Search', function() 
{

    it('Login', function()
    {
      Cypress.session.clearAllSavedSessions
      cy.visit(Cypress.env('baseUrl'))
      cy.get(".k-input-inner[placeholder='UserId']").clear   
      cy.get(".k-input-inner[placeholder='UserId']").type("SFSMARSW")   
      cy.get(".k-input-inner[type='password']").clear   
      cy.get(".k-input-inner[type='password']").type("mars2")
      cy.get("span:nth-child(2)#btnLogin").click()
      cy.wait(5000)
      cy.url().should('contain','Dashboard')
      cy.get("#dynamicModalLabel1").should('contain','Recurring Reports Expiring Soon')
      cy.get("#btnClose0").click()
      //cy.go('back')
      
      let username=" MARS"

      cy.get(".buttontext[title='MARS']").then(  (x)=>{
            let name=x.text()
            expect(name).to.equal(username)
            cy.get('#navbarDropdown').contains(' Firm ').click({force:true})

            cy.get("div:nth-child(2)>div:nth-child(2)>a.dropdown-item.ng-star-inserted").each(($el,index,$list)=>{

                    cy.log($list.length)

                    for (let index = 0; index < $list.length; index++) 
                    {
                        const element = $list[index];
                        cy.log(element.text);
                        
                    }
                if ($el.text()==="Firm Profile") 
                    
                    {
                        cy.wrap($el).click({force:true})
                    }

            })
            cy.wait(5000)    
            
        })

    })


    

});