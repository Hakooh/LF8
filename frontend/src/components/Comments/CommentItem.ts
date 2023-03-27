import { defineComponent } from 'vue';
import StarRating from 'vue-star-rating';

export default defineComponent({
    components: {
        StarRating,
    },
    props: {
        comment: {
            required: true,
            type: Object,
        }
    },
    data: function() {
        return {
            state: 'default',
            data: {
                body: this.comment.body,
                rating: this.comment.rating,
            }
        }
    },
    methods: {
        resetEdit() {
            this.state = 'default';
            this.data.body = this.comment.comment;
        },
        saveEdit() {
            this.state = 'default';
            this.$emit('comment-updated', {
                'id': this.comment.id,
                'body': this.data.body,
            });
        },
        deleteComment() {
            this.$emit('comment-deleted', {
                'id': this.comment.id,
            });
        },
    },
});