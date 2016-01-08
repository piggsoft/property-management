var $ = require("jquery");

var checkActionResult = function(opts) {

};

var action = function(opts) {
    $.ajax({
        url: opts.url,
        data: opts.data,
        dataType: 'jsonp',
        success: function(data) {
            checkActionResult.call(data, opts);
        },
        error: function() {
            if (opts.error) {
                opts.error.apply(this, this.arguments);
            }
        }
    });
};

var isString = function(obj) {
    return Object.prototype.toString.call(obj) === "[object String]";
};

module.exports = {
    action: action,
    isString: isString
};