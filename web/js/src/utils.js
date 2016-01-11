var $ = require("jquery");

var checkActionResult = function (opts) {

};

var action = function (opts) {
    $.ajax({
        url: opts.url,
        data: opts.data,
        dataType: 'jsonp',
        success: function (data) {
            checkActionResult.call(data, opts);
        },
        error: function () {
            if (opts.error) {
                opts.error.apply(this, this.arguments);
            }
        }
    });
};

var getParams = function () {
    var params = {};
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        // If first entry with this name
        if (typeof params[pair[0]] === "undefined") {
            params[pair[0]] = decodeURIComponent(pair[1]);
            // If second entry with this name
        } else if (typeof params[pair[0]] === "string") {
            var arr = [params[pair[0]], decodeURIComponent(pair[1])];
            params[pair[0]] = arr;
            // If third or later entry with this name
        } else {
            params[pair[0]].push(decodeURIComponent(pair[1]));
        }
    }
    return params;
};

var generateUrl = function(opts) {
    var url = opts.url;
    var path = opts.path;
    var data = opts.data;
    var _data = $.serialize(data);
    return url + path + "?" + _data;
};

var isString = function (obj) {
    return isNotEmpty(obj) && Object.prototype.toString.call(obj) === "[object String]";
};

var isEmpty = function (obj) {
    return !!obj;
}

var isNotEmpty = function (obj) {
    return !isEmpty(obj);
}


module.exports = {
    action: action,
    isString: isString,
    isEmpty: isEmpty,
    isNotEmpty: isNotEmpty,
    getParams: getParams,
    generateUrl: generateUrl,
    browser: {
        userAgent: navigator.userAgent.toLowerCase(),
        isAndroid: Boolean(navigator.userAgent.match(/android/ig)),
        isIphone: Boolean(navigator.userAgent.match(/iphone|ipod/ig)),
        isIpad: Boolean(navigator.userAgent.match(/ipad/ig)),
        isWeixin: Boolean(navigator.userAgent.match(/MicroMessenger/ig))
    }
};