import axios from "axios";
import store from "~/store";
import { defineComponent } from "vue";

function replaceUmlauts(string: string) {
  let value;
  value = string
  .toLowerCase()
  .replace(/ä/g, 'ae')
  .replace(/ö/g, 'oe')
  .replace(/ü/g, 'ue');;
  return value
}

export default defineComponent({
  name: "ChatBox",
  data: () => ({
    message: "" as String,
    messages: [] as String[],
    isChatboxVisible: true,
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
          .get("http://localhost:8080/api/chat/send?text=" + replaceUmlauts(this.message), {
            headers: {
              ...(store.state.token
                ? { Authorization: "Bearer " + store.state.token }
                : {}),
            },
          })
          .then((res) => {
            this.message = "";
            this.messages.push({
              text: (decodeURIComponent(JSON.parse(`"${res.data}"`))),
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
