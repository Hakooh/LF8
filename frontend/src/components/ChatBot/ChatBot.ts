import axios from "axios"
import store from "~/store"

export default {
    name: 'ChatBox',
    data: () => ({
        message: '',
        messages: []
    }),
    mounted() {
        this.messagelist = this.$refs.messagelist;
    },
    methods: {
        sendMessage() {
            this.messages.push({
                text: this.message,
                author: 'user'
            })
            axios.get("http://localhost:8080/api/chat/send?text="+this.message, {
                headers: {
                    "Authorization": "Bearer "+ store.state.token
                },
            })
            .then(res => {
                this.message = ''
                this.messages.push({
                    text: res.data,
                    author: 'chat-bot-zoey'
                })
                this.messagelist.lastElementChild.scrollIntoView({behavior:"smooth"})
            })
        }
    }
}