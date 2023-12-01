// Fetch API

const BASE_URL = 'http://localhost:9002';
const AUTH_USER = btoa('user:$2a$10$1iHtzX.r3uVfjgK.iVkuFee39NtkD//gKL9oYSnC9xZGRA8RGX.Bu') // user credentials

const fetchData = async (endpoint, method = 'GET', data = null) => {
    const url = `${BASE_URL}/${endpoint}`;
    const headers = {
        'Authorization': `Basic ${AUTH_USER}`, // Basic Authentication for authorized CRUD operations
        'Content-Type': 'application/json',
    };

    const options = {
        method,
        headers,
        credentials: 'include',
        withCredentials: true,
        body: data ? JSON.stringify(data) : null,
    };

    try {
        const response = await fetch(url, options);
        const result = await response.json();

        if (!response.ok) {
            console.log("Something went wrong");
        }

        return result;
    } catch (error) {
        console.log("Network error");
    }
};

export default fetchData;