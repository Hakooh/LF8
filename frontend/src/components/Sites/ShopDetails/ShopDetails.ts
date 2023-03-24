import axios from 'axios';
// @ts-ignore
import StarRating from 'vue-star-rating';
import CommentManager from '../../Comments/CommentManager.vue'


const BASE_URL = 'http://localhost:8080/api/shop'

function getIdFromURL() {
    let path = window.location.pathname;

    let segments = path.split("/");

    return segments[3]
}
// ../../../../frontend/src/assets/zoey_cropped.png
export default {
    components: {
        StarRating,
        CommentManager
    },
    props: {
        id: {
            required: false,
            type: String,
        }
    },
    data() {
        return {
            shops: [],
            rating:[],
        }
    },
    mounted() {
        axios.get(BASE_URL+'/id/'+getIdFromURL())
            .then((response) => {
                // @ts-ignore
                this.shops = response.data
            })
    },
}