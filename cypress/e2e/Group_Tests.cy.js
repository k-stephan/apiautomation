describe('Group TCS Suite Smoke 1', () => {

    it('smoke Test',{ tags: '@smoke' }, () => {
        expect(true).to.be.true
    });

    it('Regression Test' ,{ tags: '@sanity' }, () => {
        expect(2).to.eql(2)
    });

    it('Sprint Test', { tags: '@adhoc' },() => {
        expect("QA Box Let's Test").to.contains("Test")
    });

});