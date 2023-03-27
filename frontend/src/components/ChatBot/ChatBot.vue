<template charset="utf-8">
    <div v-if=isChatboxVisible class="chatbox" >
        <div class="chatbox-header" @click=closeChatbox()>
            <div class="chatbox-agent">
                <img src="../../assets/zoey_cropped.png" class="chatbox__zoey-photo">
                <span>Chat with Zoey</span>
            </div>
        </div>
        <div class="chat-box-list-container">
            <ul class="chatbox-conversation" id="messages" ref="messagelist">
                <li class="chatbox-conversation__message chatbox-conversation__message--chat-bot-zoey">
                    <div class="chatbox-message__content">
                        <p>Hey ich bin Zoey, deine virtuelle Assistentin!</p>
                        <p>Stelle mir gerne Fragen, wenn du Hilfe brauchst oder Feedback für uns hast 😊</p>
                    </div>
                </li>
                <li class="chatbox-conversation__message"
                    v-for="(message, idx) in messages"
                    :key="idx"
                    :class="'chatbox-conversation__message--' + message.author">
                    <div class="chatbox-message__content">
                        <p>{{ message.text }}</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="chatbox-footer">
            <textarea
            class="chatbox-text"
            type="text"
            cols="70" 
            v-model="message" 
            @keydown.enter="sendMessage"
            />
                <button @click="sendMessage" class="chatbox-btn chatbox-btn--send" alt="Send"><img src="../../assets/send.webp" class="send-image"></button>
            </div>
    </div>
        <div @click="showChatbox()" v-else class="chatbox-closed">
            <div class="chatbox-closed__header">
                <div class="chatbox-agent">
                    <img src="../../assets/zoey_cropped.png" class="chatbox__zoey-photo">
                    <span>Chat with Zoey</span>
                </div>
        </div>
</div>

</template>

<script>
export { default } from "./ChatBot";
</script>


<style lang="css">
@import "./ChatBot.css";
</style>
