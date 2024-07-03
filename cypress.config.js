/// <reference types="Cypress" />

const { defineConfig } = require("cypress");
const sqlServer = require('cypress-sql-server');
const oracledb = require("oracledb");

oracledb.initOracleClient({ libDir: "D:/Oracle12c/product/12.2.0/client_1/bin"});

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {

      on('task',
        {
          sqlQuery: (query) => {
            return queryData(query, config.env.db);
          },

        });

      /*config.db = {
        userName: "mars",
        password: "mars",
        server: "192.168.169.60:1721/IND510",
        options: {
            database: "ora19_mob_qa1.phxa.com",
            encrypt: true,
            rowCollectionOnRequestCompletion : true
        }
    }*/

      // implement node event listeners here
      

      require('@cypress/grep/src/plugin')(config);
      return config;

    },
    experimentalStudio: true,

    testIsolation: false,

    //"nodeVersion": "system",
    "env": {
      "db": {
          "user": "mars",
          "password": "mars",
          "connectString" : "192.168.169.60:1721/IND510"
      }
    }
     
  },

})

const queryData = async(query, dbconfig) => {
  let conn;
  try{
      conn = await oracledb.getConnection(dbconfig);
      return result = await conn.execute(query);
  }catch(err){
      console.log("Error===>"+err)
      return err
  } finally{
    if(conn){
      try{
        conn.close();
      }catch(err){
        console("Error===>"+err);
      }
    }
  }
}
