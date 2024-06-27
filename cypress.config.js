/// <reference types="Cypress" />

const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      on('task',
        {
          queryDb: query => { return queryTestDb(query, config) },
        });

      require('@cypress/grep/src/plugin')(config);
      return config;

    },
    
    testIsolation: false,

    env: {
      "baseUrl": "https://marsqa1.phxa.com/MARSWeb2/login.aspx?",
      "db": 
      {
      "user": "mars",
      "password": "mars",
      "connectString" : "192.168.169.60:1721/IND510"
    }

      },
     
  },

});

function queryTestDb(query, config) 
{
  // creates a new mysql connection using credentials from cypress.json env's
  const connection = mysql.createConnection(config.env.db)
  // start connection to db
  connection.connect()
  // exec query + disconnect to db as a Promise
  return new Promise((resolve, reject) => {
      connection.query(query, (error, results) => {
          if (error) reject(error)
          else {
              connection.end()
              return resolve(results)
          }
      })
  })
}
