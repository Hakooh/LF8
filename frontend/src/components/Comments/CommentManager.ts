import comment from './CommentItem.vue';
import StarRating from 'vue-star-rating';

export default {
    components: {
        comment,
        StarRating
    },
    data: function() {
        return {
            comments: [
                {
                    id: 1,
                    body: "Test123",
                    edited: false,
                    created_at: new Date().toLocaleString(),
                    rating: 4,
                    author: {
                        id: 1,
                        name: 'Kevin',
                    }
                },
                {
                    id: 2,
                    body: "test456",
                    edited: false,
                    created_at: new Date().toLocaleString(),
                    rating: 2,
                    author: {
                        id: 2,
                        name: 'Heinitz',
                    }
                }
            ],
            data: [
                {
                    body:"",
                    rating: 4,
                }
            ]
        }
    },
    methods: {

        updateComment($event) {
            let index = this.comments.findIndex((element) => {
                return element.id === $event.id;
            });
            this.comments[index].body = $event.body;
        },

        deleteComment($event) {
            let index = this.comments.findIndex((element) => {
                return element.id === $event.id;
            });

            this.comments.splice(index, 1);
        },

        saveComment() {
            let newComment = {
                id: this.comments[this.comments.length - 1].id + 1,
                body: this.data.body,
                edited: false,
                created_at: new Date().toLocaleString(),
                rating: this.data.rating,
                author: {
                    id: "this.user.id",
                    name: "this.user.name",
                }
            }
            this.comments.push(newComment);

            this.data.body = '';
        },

        setRating: function(rating) {
            this.rating = rating;
        }
    },

    props: {
        user: {
            required: true,
            type: Object,
        },
    }
}