var utils = require("./utils");

var checkCanUse = function() {
    if(!window || !window.sessionStorage) {
        console.log("session can`t be use");
    }
};

checkCanUse();

var put = function(key, value) {
    window.sessionStorage.setItem(key, utils.isString(value) ? value : JSON.stringify(value));
};
var get = function(key) {
    window.sessionStorage.getItem(key);
};
var remove = function(key) {
    window.sessionStorage.removeItem(key);
};
var clear = function() {
    window.sessionStorage.clear();
};

module.exports = {
    put: put,
    get: get,
    remove: remove,
    clear: clear
};
