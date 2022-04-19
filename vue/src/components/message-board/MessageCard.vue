<template>
  <div class="message-card-container">
      <h3 id="user-name">{{message.senderUsername}}</h3>
      <p><span id="numOne"><i class="far fa-calendar-alt"></i> {{curMessageDate}} </span> <span id="numOne"> <i class="far fa-clock"></i> {{curMessageTime}} </span></p>
      <div class="text-container">
        <p class="text-para">{{message.messageText}}</p>
      </div>
      
      <p id="pets-tagged" @click="showPetsTagged = !showPetsTagged">Pets Tagged: {{message.petNames.length}}</p>
      <ul v-if="showPetsTagged === true">
        <li v-for="(pet, index) in message.petNames" :key="index">{{pet}}</li>
      </ul>
  </div>
</template>

<script>
export default {
  props: ["message"],

  data() {
    return {
      showPetsTagged: false,
      curMessage: "",
      curMessageDate: "",
      curMessageTime: ""
    }
  },

  methods: {
    printTimeStamp() {
      // let date = new Date(this.curMessage.messageTimestamp.substring(0,10));
      // let time = this.curMessage.messageTimestamp.substring(11,19);
      console.log("Date of message is " + this.curMessageDate);
      console.log("Time of message is " + this.curMessageTime);
    }
  },

  computed: {
    formattedTime(time) {
      let timeAsDate = new Date(this.playdate.playdateDate + " " + time);
      const options = { hour12: true, hour: "2-digit", minute: "2-digit" };
      let formattedTime = timeAsDate.toLocaleTimeString("en-US", options);
      return formattedTime;
    },


  },

  created() {
    this.curMessage = this.message;

    let date = new Date(this.curMessage.messageTimestamp.substring(0,10));
      //TODO - Figure out why you need to add one to the date
      date.setDate(date.getDate() + 1);
      const options = {
        weekday: "short",
        year: "numeric",
        month: "short",
        day: "numeric",
      };
      let formattedDate = date.toLocaleDateString("en-US", options);
    this.curMessageDate = formattedDate;



    // this.curMessageDate = new Date(this.curMessage.messageTimestamp.substring(0,10));
    
    let time = this.curMessage.messageTimestamp.substring(11,19);
    let timeAsDate = new Date(this.curMessage.messageTimestamp.substring(0,10) + " " + time);
    const options2 = { hour12: true, hour: "2-digit", minute: "2-digit" };
    let formattedTime = timeAsDate.toLocaleTimeString("en-US", options2);
    this.curMessageTime = formattedTime;

  }
  
}
</script>

<style>
  /* .message-card-container {
    border: 1px solid red;
  } */

  .message-card-container {
  /* margin: 5px 0px 5px 0px; */
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  width: 300px;
  border: 2px solid #eecd22ff;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

  #pets-tagged{
    text-decoration: underline;
    cursor: pointer;
  }

  #numOne{
    margin-right: 8px;
  }

  .text-para {
    margin: 8px 0px 8px 0px;
  }
</style>