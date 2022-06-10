export default {

    oidc: {
        clientId: '0oa58ho8etX8SgAnh5d7',
        issuer: 'https://dev-91389498.okta.com/oauth2/default',
        redirectUri: 'https://localhost:4200/login/callback', //Oddly this one was set to http chnage if neccesary. 
        scopes: ['openid', 'profile', 'email']
    }

}

