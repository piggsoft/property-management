var config = require("./config");
var $ = require("jquery");
var utils = require("./utils");
require("./css/index.css");
require("./css/common.css");
require("normalize.css");
require("./css/bootstrap.css");
require("bootstrap");
var header = require("html!./common.html");


$(function() {
    $("body").prepend(header);

    function action() {
        utils.action();
    }

    $("." + config.menuClassName).on("click", function() {
        var $this = $(this);
        var name = $this.data("name");
        var menu = config.menu[name];
        if (!menu) {
            console.log("not a menu");
            return;
        }
        if (menu.canSpread) {
            $this.children().show();
            return;
        }
        if (!menu.isRemote) {

        }
    });

});
