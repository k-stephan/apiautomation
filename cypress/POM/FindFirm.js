
const findfirmelements =require("../fixtures/WebElements.json")

class findfirm
{
    
    

    clickfindfirm()
    {
        cy.get(findfirmelements.findfirmlocators.findfirmmenu).contains(' Firm ').click({force:true})

    }

    FindFirmProfile()
    {
        cy.get(findfirmelements.findfirmlocators.findfirmprofile).each(($el,index,$list)=>{
                             
        if ($el.text()===findfirmelements.findfirmlocators.txtfirmprofile) 
            
            {
                cy.wrap($el).click({force:true})
            }

        })
        
    }

}
export default findfirm;