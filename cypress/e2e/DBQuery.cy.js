describe("Query Oracle database", () => {
    const  str = "select firm_nm from ms_firm where firm_id='3739'";
  
    it("Firm SQL Qry", () => {
      cy.task("sqlQuery", str).then( (result)=> {
       cy.log(result.rows[0])
      });
            
    })
  });