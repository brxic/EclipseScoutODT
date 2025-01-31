const baseConfig = require('@eclipse-scout/cli/scripts/webpack-defaults');

module.exports = (env, args) => {
  args.resDirArray = ['src/main/resources/WebContent', 'node_modules/@eclipse-scout/core/res'];
  const config = baseConfig(env, args);

  config.entry = {
    'contacts': './src/main/js/contacts.ts',
    'login': './src/main/js/login.ts',
    'logout': './src/main/js/logout.ts',
    'contacts-theme': './src/main/js/contacts-theme.less',
    'contacts-theme-dark': './src/main/js/contacts-theme-dark.less'
  };

  return config;
};
