import { mapMutations } from "vuex";


const BASE_URL = 'http://localhost:8080/api/auth'
export default{
    data: () => {
        return {
            email: "",
            password: "",
        }
    },
    methods:
    {
        ...mapMutations(["setToken"]),
        async login() { 
            const response = await fetch(BASE_URL+"/signin", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    email: this.email,
                    password: this.password
                })
            });
            const { token } = await response.json();
            this.setToken(token);
            this.$router.push("/")
        }
    },
};