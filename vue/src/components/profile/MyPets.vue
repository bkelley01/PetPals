<template>
  <div class="container">
    <div class="title">
      <h2>{{ fakeUser.username }}'s Pets</h2>
    </div>
    <button @click="toggleManagePets" v-show="fakeUser.username === this.$store.state.user.username " id="manage-pets-btn">
      Manage Pets
    </button>
    <div id="pet-card-container">
      <pet-card v-for="pet in userPets" :key="pet.petId" :pet="pet" />
    </div>
  </div>
</template>

<script>
import PetCard from "@/components/profile/PetCard.vue";
import petService from '@/services/PetService.js';

export default {
  components: { PetCard },
  name: "my-pets",
  data() {
    return {
      userPets: []
    }
  },
  computed: {
    fakeUser() {
      return this.$store.state.fakeUsers.find(
        (p) => p.username == this.$route.params.username
      );
    },
  },
  methods: {
    toggleManagePets() {
      this.$store.commit('TOGGLE_MANAGE_PETS');
      console.log(this.$store.state.showManagePetsOption);
    }
  },
  created() {
    petService.getUserPets(this.fakeUser.username).then(response => {
      this.userPets = response.data;
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

#manage-pets-btn {
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