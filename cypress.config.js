/// <reference types="Cypress" />

const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    testIsolation: false,

    env: {
      baseUrl: 'https://marsqa1.phxa.com/MARSWeb2/login.aspx?',
      },

      
  },
});
