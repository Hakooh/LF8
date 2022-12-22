import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/festival'

export default {
    data() {
        return {
            festivals: [],
        }
    },
    mounted() {
        axios.get(BASE_URL+'/all')
            .then((response) => {
                // @ts-ignore
                this.festivals = response.data
            })
    }
}