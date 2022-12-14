import authHeader from './auth-header';


export const userService = {
    login,
    logout,
    getAll
};

const APIURL = 'http://localhost:8080/api/login'


function login(username, password) {
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ username, password })
    };

    return fetch(APIURL, requestOptions)
        .then(handleResponse)
        .then(user => {
            if(user.token) {
                localStorage.setItem('user', JSON.stringify(user));
            }

            return user
        })
}


function logout() {
    localStorage.removeItem('user');
}

function getAll() {
    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };
    return fetch(APIURL, requestOptions).then(handleResponse);
}


function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if(!response.ok) {
            if (response.status === 401) {
                logout();
                location.reload();
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    })
}