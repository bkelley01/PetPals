<template>
  <div>
    <h2>Message Forum</h2>
    <message-card v-for="message in filteredMessages" :key="message.messageId" :message="message" />
  </div>
</template>

<script>
import MessageCard from "@/components/message-board/MessageCard.vue";
import messageService from '@/services/MessageService.js';

export default {
  components: { MessageCard },
  data() {
    return {
      messageList: [],
    }
  },
  
  computed: {
    filteredMessages() {
      return this.messageList;
    }
    
  },


  created() {
    messageService.getAllMessages().then(response => {
      this.messageList = response.data;
    });
  }


}
</script>

<style>

</style>