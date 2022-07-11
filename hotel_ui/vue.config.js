module.exports = {
    devServer: {
        port: 3000,
        open: true,
        proxy: {
            "/api": {
                target: "http://localhost:8081",
                changeOrigin: true,
                pathRewrite: {
                    "^/api": ""
                }
            }
        }
    }
}
