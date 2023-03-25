<template>
    <div class="chatbox">
        <div class="chatbox-header">
            <div class="chatbox-agent">
                <img src="../../assets/zoey_cropped.png" class="chatbox__zoey-photo">
                <span>Chat with Zoey</span>
            </div>
        
            <div class="chatbox-close">
                <span>x</span>
            </div>
        </div>
        <div class="chat-box-list-container">
            <ul class="chatbox-conversation" id="messages" ref="messagelist">
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
</template>

<script>
export { default } from "./ChatBot";
</script>


<style lang="css">
@import "./ChatBot.css";
</style>
