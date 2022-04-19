<template>
  <div class="container">
    <div class="title">
      <h2>{{ compUser.username }}'s Pets</h2>
    </div>
    <button @click="toggleManagePets" v-if="!this.$store.state.showManagePetsOption" v-show="compUser.username === this.$store.state.user.username " class="pets-blue-btns">
      Manage Pets
    </button>
    <div id="pets-add-cancel-container">
      <button @click="openAddPets" v-if="this.$store.state.showManagePetsOption && !this.addPetIsOpen" v-show="compUser.username === this.$store.state.user.username " class="pets-blue-btns">
      Add Pet
      </button>
      <button @click="toggleManagePets" v-if="this.$store.state.showManagePetsOption" v-show="compUser.username === this.$store.state.user.username " class="pets-blue-btns">
      Cancel
      </button>
    </div>
    <add-pet v-if="addPetIsOpen" />
    <div id="pet-card-container">
      <pet-card v-for="pet in userPets" :key="pet.petId" :pet="pet" />
    </div>
  </div>
</template>

<script>
import PetCard from "@/components/profile/PetCard.vue";
import petService from '@/services/PetService.js';
import AddPet from '../AddPet.vue';
import userService from '@/services/UserService.js'

export default {
  components: { PetCard, AddPet },
  name: "my-pets",
  data() {
    return {
      addPetIsOpen: false,
      userList: [],
      userPets: []
    }
  },
  computed: {
    compUser() {
      return this.userList.find(
        (p) => p.username.toLowerCase() == this.$route.params.username.toLowerCase());
    },
    // userPets() {
    //   let pets = [];
    //   petService.getUserPets(this.compUser.username).then(r => {
    //     pets = r.data;
    //   });
    //   return pets;
    // }
  },
  methods: {
    toggleManagePets() {
      if (this.addPetIsOpen) {
        this.addPetIsOpen = !this.addPetIsOpen;
      }
      this.$store.commit('TOGGLE_MANAGE_PETS');
    },

    openAddPets() {
      this.addPetIsOpen = true;
    },

    closeManageBtns() {
      this.addPetClicked = false;
    }
  },
  created() {
    petService.getUserPets( this.$route.params.username).then(response => {
      this.userPets = response.data;
    });
    userService.getAllUsers().then(r => {
      this.userList = r.data;
    })
  }
};
</script>

<style scoped>
.title {
  width: 50%;
}

.container {
  width: 100%;
  background: white;
  /* border: 1px solid #eecd22ff; */
  margin-top: 15px;
  padding-bottom: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

button {
  cursor: pointer;
}

.pets-blue-btns {
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  background-color: #3399FF;
  color: white;
  margin-bottom: 10px;
}


#pet-card-container {
  width: 100%;
}

#pets-add-cancel-container {
  width: 160px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

@media screen and (min-width: 768px) {
  #pet-card-container {
    /* width: 300px; */
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    width: 100%;
    flex-wrap: wrap;
  }
}
</style>