var config = require("./config");
var $ = require("jquery");
var utils = require("./utils");
require("./css/common.css");
require("normalize.css");
require("./css/bootstrap.css");
require("bootstrap");
var header = require("html!./common.html");

$(function() {
    $("body").prepend(header);
});
