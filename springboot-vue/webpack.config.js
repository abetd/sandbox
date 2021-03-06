var path = require('path')
var webpack = require('webpack')
var fs = require('fs')

const vendor = { vendor: ['vue', 'axios']}
const entries = fs.readdirSync('./src/main/js')
                  .filter(a => /\.js$/.test(a))
                  .reduce((acc, x) => {
                    acc[x.slice(0, -3)] = './src/main/js/' + x
                    return acc
                  }, vendor)

module.exports = {
  mode: 'production',
  entry: entries,
  output: {
    path: path.resolve(__dirname, './src/main/resources/static/dist'),
    publicPath: '/js/',
    filename: '[name].js'
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': JSON.stringify(process.env.NODE_ENV)
    })
  ],
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    }
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
    watchContentBase: true,
    port: 3000,
    contentBase: path.join(__dirname, "./src/main/resources/static")
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map'
}
