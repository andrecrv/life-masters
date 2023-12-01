const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/api',
    createProxyMiddleware({
      target: 'http://localhost:9002', // Adjust to your Spring Boot server
      changeOrigin: true,
    })
  );
};