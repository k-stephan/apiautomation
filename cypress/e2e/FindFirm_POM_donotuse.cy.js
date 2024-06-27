import findfirm from "../POM/FindFirm.js"


describe('Firm Search', function() 
{
    
    
    it('FindFirm', function()
    {
        //cy.exec("D:\Workspace\Microsoft VS Code\CYPRESSQA\cypress\POM\BaseLogin.js");

        const ff= new findfirm();
        ff.clickfindfirm()
        ff.FindFirmProfile()   

    })
    

})