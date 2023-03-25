import axios from 'axios';
import store from '~/store';


const BASE_URL = 'http://localhost:8080/api/festival'

export default {
    data() {
        return {
            festivals: [],
        }
    },
    mounted() {
        axios.get(BASE_URL+'/all', {
            headers: {
                "Authorization": "Bearer "+ store.state.token
            },
        })
            .then((response) => {
                // @ts-ignore
                this.festivals = response.data
            })
    }
}