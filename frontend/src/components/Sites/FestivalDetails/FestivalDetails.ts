import axios from 'axios';
// @ts-ignore
import StarRating from 'vue-star-rating';
import CommentManager from '../../Comments/CommentManager.vue'


const BASE_URL = 'http://localhost:8080/api/festival'

function getIdFromURL() {
    let path = window.location.pathname;

    let segments = path.split("/");

    return segments[2]
}

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
            festival: [],
            msg: "test",
            rating:[]
        }
    },
    mounted() {
        axios.get(BASE_URL+'/Id/'+getIdFromURL())
            .then((response) => {
                // @ts-ignore
                this.festival = response.data
            })
    },
}