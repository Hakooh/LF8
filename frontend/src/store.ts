import { createStore } from 'vuex';

export default createStore({
    state: {
        user: null,
        token: null,
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
            console.log(state.token)
        },
    },
    actions: {},
    getters: {
        isLoggedIn(state) {
            return !!state.token;
        },
    },
})