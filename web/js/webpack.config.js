//webpack.config.js
var webpack = require('webpack');

var commonsPlugin =
    new webpack.optimize.CommonsChunkPlugin('common.js');
var minChunkSizePlugin = new webpack.optimize.MinChunkSizePlugin({});
var uglifyJsPlugin = new webpack.optimize.UglifyJsPlugin({
    compress: {
        warnings: false
    }
});

module.exports = {
    entry: {
        //test: "./src/test.js",
        index: "./src/index.js"
    },
    output: {
        path: 'dist',
        filename: '[name].js'
    },
    module: {
        loaders: [
            { test: /\.css$/, loader: 'style!css!' }
        ]
    },
    plugins: [
        commonsPlugin,
        //uglifyJsPlugin,
        minChunkSizePlugin
    ],
    resolve: {
        // 现在可以写 require('file') 代替 require('file.coffee')
        extensions: ['', '.js', '.json', '.coffee']
    }
};

