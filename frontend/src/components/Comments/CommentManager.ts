import comment from './CommentItem.vue';
import StarRating from 'vue-star-rating';
import axios from "axios";


const BASE_URL = 'http://localhost:8080/api/shop'

function getIdFromURL() {
    let path = window.location.pathname;

    let segments = path.split("/");

    return segments[3]
}


export default {
    components: {
        comment,
        StarRating
    },
    data: function() {
        return {
            ratings: [],
            data: [
                {
                    body:"",
                    rating: 4,
                }
            ]
        }
    },
    mounted() {
        axios.get(BASE_URL + '/id/' + getIdFromURL())
            .then((response) => {
                // @ts-ignore
                this.ratings = response.data.ratings
            })
    },

    methods: {

        updateComment($event) {
            let index = this.ratings.findIndex((element) => {
                return element.id === $event.id;
            });
            this.ratings[index].comment = $event.body;
        },

        deleteComment($event) {
            let index = this.ratings.findIndex((element) => {
                return element.id === $event.id;
            });

            this.ratings.splice(index, 1);
        },

        saveComment() {
            let newComment = {
                id: this.ratings[this.ratings.length - 1].id + 1,
                comment: this.data.body,
                commentDate: new Date().toISOString().split('T')[0],
                rating: this.data.rating,
                user: {
                    id: 1,
                    firstName: "Kevin",
                },
                shop: {
                    id: 1,
                }
            }
            this.ratings.push(newComment);

            this.data.body = '';

            return axios.post("http://localhost:8080/api/rating/post", newComment
            )
                .then(function(response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        setRating: function(rating) {
            this.rating = rating;
        }
    },

    props: {
        user: {
            required: false,
            type: Object,
        },
    }
}