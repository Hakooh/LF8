import axios from 'axios'



const BASE_URL = 'http://localhost:8080/api/auth'
export default{
    data() {
        return {
            username: "",
            password: "",
        }
    },
    methods:
    {
        login123() {
            axios.get(BASE_URL+"/signin")
            .then(response => console.log(response))
        },
        login() { 
            fetch(BASE_URL+"/signin", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Access-Control-Allow-Origin": "https://localhost:3000"
                },
                body: JSON.stringify({
                    username: "test",
                    password: "test2"
                })
            })
        }
    }
};