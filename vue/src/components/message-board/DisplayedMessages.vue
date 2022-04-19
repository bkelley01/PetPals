<template>
  <div>
    <h2>Message Forum</h2>
    <div id="messages-container">
      <button id="filter-messages-btn" @click="showFilters = !showFilters">Filter Messages<i class="fas fa-filter"></i> </button>
      <form v-if="showFilters === true" id="messages-filter-form">
        <input type="text" id="username-filter" placeholder="Username" v-model="userChoices.username" />
        <input type="text" id="pet-name-filter" placeholder="Pet Name" v-model="userChoices.petName" />
      </form>
      <message-card v-for="message in filteredMessages" :key="message.messageId" :message="message" />
    </div>
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
      userChoices: {
        username: "",
        petName: ""
      },
      showFilters: false
    }
  },
  
  computed: {
    filteredMessages() {
      let fm = this.messageList;
      
      if(this.userChoices.username != "") {
        fm = fm.filter(curMessage => {
          return curMessage.senderUsername.toLowerCase().includes(this.userChoices.username.toLowerCase());
        });
      }

      if (this.userChoices.petName != ""){
        fm = fm.filter(curMessage => {
          let shouldInclude = false;
          
          curMessage.petNames.forEach(element => {
            
            if (element.toLowerCase().includes(this.userChoices.petName.toLowerCase())) {
              shouldInclude = true;
            }
            
          });

          return shouldInclude;
        });
      }


      return fm;
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
  #filter-messages-btn {
    border-radius: 5px;
    height: 40px;
    border: none;
    font-size: 16px;
    background-color: #3399FF;
    color: white;
    margin-bottom: 10px;
    cursor: pointer;
  }

  #messages-container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  input[type="text"] {
  font-size:16px;
  padding-left: 10px;
  }

  #messages-filter-form {
    display: flex;
    flex-direction: row;
    width: 300px;
    margin: auto;
    margin-bottom: 15px;
    row-gap: 5%;
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    justify-content: space-around;
  }

  #username-filter {
    border-radius: 5px;
    border-width: thin;
    height: 40px;
    border-style: solid;
    border-color: #d1d1d1;
    margin-right: 3%;
    width: 40%;
  }

  #pet-name-filter {
    border-radius: 5px;
    border-width: thin;
    border-style: solid;
    height: 40px;
    border-color:#d1d1d1;
    width: 40%;
  }

</style>