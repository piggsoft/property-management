var config = require("./config");
var $ = require("jquery");
var utils = require("./utils");
require("./css/index.css");

var computeHeight = function() {
    var bodyHeight = parseInt($(window).height());
    var headerHeight = parseInt($("header").outerHeight(true));
    var navHeight = bodyHeight - headerHeight;
    var ifarmeHeight = parseInt(navHeight - $("footer").outerHeight(true));
    $("nav").css({height: navHeight + "px"});
    $("iframe").css({height: ifarmeHeight + "px"});
};

$(function() {

    computeHeight();

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
    });

    $(window).resize(function() {
       computeHeight();
    });
});
