<template>
  <div>
    <h2>Message Forum</h2>
    <div id="messages-container">
      <div id="message-btn-container">
        <button
          id="create-message-btn"
          @click="showCreatePlaydate = !showCreatePlaydate"
        >
          Create Message
        </button>
        <button id="filter-messages-btn" @click="showFilters = !showFilters">
          Filter Messages<i class="fas fa-filter"></i>
        </button>
      </div>
      <form id="create-message-form" v-if="showCreatePlaydate === true">
        <h3>Create Message</h3>
        <textarea
          id="message-text-area"
          type="text-area"
          placeholder="Please enter a message"
          v-model="newMessage.messageText"
        >
        </textarea>
        <p id="tag-pets">Want to tag your pets?</p>
        <div id="pets-to-tag">
          <span v-for="(pet, index) in userPets" :key="pet.petId">
            <input
              type="checkbox"
              :value="pet.petName"
              v-model="petsTagged[index]"
            />
            <label>{{ pet.petName }}</label>
          </span>
        </div>
        <button id="submit-message-btn" @click="createMessage()">Submit</button>
      </form>
      <form v-if="showFilters === true" id="messages-filter-form">
        <input
          type="text"
          id="username-filter"
          placeholder="Username"
          v-model="userChoices.username"
        />
        <input
          type="text"
          id="pet-name-filter"
          placeholder="Pet Name"
          v-model="userChoices.petName"
        />
      </form>
      <message-card
        v-for="message in filteredMessages"
        :key="message.messageId"
        :message="message"
      />
    </div>
  </div>
</template>

<script>
import MessageCard from "@/components/message-board/MessageCard.vue";
import messageService from "@/services/MessageService.js";
import petService from "@/services/PetService.js";

export default {
  components: { MessageCard },
  data() {
    return {
      messageList: [],
      userPets: [],
      userChoices: {
        username: "",
        petName: "",
      },
      newMessage: {
        senderUsername: this.$store.state.user.username,
        messageText: "",
        petNames: [],
      },
      petsTagged: [],
      showFilters: false,
      showCreatePlaydate: false,
    };
  },

  computed: {
    filteredMessages() {
      let fm = this.messageList;

      if (this.userChoices.username != "") {
        fm = fm.filter((curMessage) => {
          return curMessage.senderUsername
            .toLowerCase()
            .includes(this.userChoices.username.toLowerCase());
        });
      }

      if (this.userChoices.petName != "") {
        fm = fm.filter((curMessage) => {
          let shouldInclude = false;

          curMessage.petNames.forEach((element) => {
            if (
              element
                .toLowerCase()
                .includes(this.userChoices.petName.toLowerCase())
            ) {
              shouldInclude = true;
            }
          });

          return shouldInclude;
        });
      }

      return fm;
    },
  },

  methods: {
    createMessage() {
      if (this.petsTagged.length > 0) {
        for (let i = 0; i < this.petsTagged.length; i++) {
          if (this.petsTagged[i] === true) {
            // this.newMessage.petNames[i] = this.userPets[i].petName;
            this.newMessage.petNames.push(this.userPets[i].petName);
          }
        }
      }

      if (this.newMessage.messageText) {
        messageService.createMessage(this.newMessage).then((response) => {
          if (response.status === 201) {
            alert("Successfully posted message");
          } else {
            alert("Unable to post message");
          }
        });
      } else {
        alert("Message text is empty. Unable to post message");
      }
    },
  },

  created() {
    messageService.getAllMessages().then((response) => {
      this.messageList = response.data;
    });

    petService.getUserPets(this.$store.state.user.username).then((response) => {
      this.userPets = response.data;
    });
  },
};
</script>

<style>
#filter-messages-btn {
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  background-color: #3399ff;
  color: white;
  margin-bottom: 10px;
  cursor: pointer;
  margin-left: 5px;
}

#messages-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

input[type="text"] {
  font-size: 16px;
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
  border-color: #d1d1d1;
  width: 40%;
}

#message-btn-container {
  display: flex;
  flex-direction: row;
}

#create-message-btn {
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  background-color: #3399ff;
  color: white;
  margin-bottom: 10px;
  cursor: pointer;
}

#create-message-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 300px;
  margin: auto;
  margin-bottom: 15px;
  row-gap: 5%;
  background-color: white;
  padding: 20px;
  border-radius: 10px;
  justify-content: space-around;
}

#message-text-area {
  height: 100px;
  width: 80%;
  border-radius: 10px;
  padding: 10px;
  margin-top: 10px;
}

#submit-message-btn {
  border-radius: 5px;
  height: 40px;
  border: none;
  margin-top: 3%;
  font-size: 16px;
  background-color: #42b72a;
  color: white;
  cursor: pointer;
}

#tag-pets {
  text-decoration: underline;
  cursor: pointer;
}

#pets-to-tag {
  display: flex;
  flex-direction: column;
  width: auto;
}

#pets-to-tag > span {
  justify-content: left;
}
</style>