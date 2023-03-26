import axios from "axios";
import store from "~/store";
import { defineComponent } from "vue";

export default defineComponent({
  name: "ChatBox",
  data: () => ({
    message: "" as String,
    messages: [] as String[],
    isChatboxVisible: false,
  }),
  mounted() {
    this.messagelist = this.$refs.messagelist;
  },
  methods: {
    sendMessage() {
      if (this.message.trim() !== "") {
      this.messages.push({
         text: this.message,
         author: "user",
      });
        axios
          .get("http://localhost:8080/api/chat/send?text=" + this.message, {
            headers: {
              ...(store.state.token
                ? { Authorization: "Bearer " + store.state.token }
                : {}),
            },
          })
          .then((res) => {
            this.message = "";
            this.messages.push({
              text: res.data,
              author: "chat-bot-zoey",
            });
          })
          .then(() => {
            this.messagelist.lastElementChild.scrollIntoView({
              behavior: "smooth",
            });
          });
      }
    },
    showChatbox() {
      this.isChatboxVisible = true;
    },

    closeChatbox() {
      this.isChatboxVisible = false;
    }
  },
});
