var config = require("./config");
var $ = require("jquery");
var utils = require("./utils");
$(function() {

    function changeIframeSrc(src) {
        $("#" + config.iframeId).attr("src", src);
    }

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
    })
});
