<template>
  <div id="container">
    <div class="pet-card" :key="pet.petId">
      <!-- <div id="first-letter">{{ pet.name.charAt(0) }}</div> -->
      <div id="first-letter">{{ pet.petName.charAt(0) }}</div>
      <div id="pet-details-container">
        <h3 id="name">{{ pet.petName }}</h3>
        <p id="type">{{ pet.petType }}</p>
        <ul>
          <li
          class="personalities"
          v-for="(personality, index) in pet.personalities"
          :key="index"
        >
          {{ personality }}
        </li>
        </ul>
        <!-- <span
          id="personalities"
          v-for="(personality, index) in pet.personalities"
          :key="index"
        >
          {{ personality }}
          <span id="vertical-bar" v-if="index != pet.personalities.length - 1">
            |
          </span>
        </span> -->
      </div>
    </div>
    <button id="archive-btn" v-if="this.$store.state.showManagePetsOption" v-on:click='deactivatePet'>Archive</button>
  </div>
</template>

<script>
import petService from '@/services/PetService.js';

export default {
  name: "pet-card",
  props: ["pet"],
  data() {
    return {
      userPet: {
        petId: 0,
        petName: "",
        petPersonalities: [],
        petType: "",
      },
      userList: []
    }
  },
  methods: {
    deactivatePet() {
      petService.deactivatePet(this.pet.petId);
      this.$router.go()
    },
    reloadPage() {
      window.location.reload();
    }
  },
  computed: {
    compUser() {
      if (this.$route.name === 'profile') {
        return this.userList.find(p => {
          p.username.toLowerCase() === this.$route.params.username.toLowerCase();
        });
      } 
      return true;
    },
  },
  created() {
    petService.getUserPets(this.$route.params.username).then(response => {
      this.userPet.petId = response.data.petId;
    });
    this.userList = this.$store.state.userList;
  },
  
};
</script>

<style>
.pet-card {
  margin: auto;
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 15px;
  width: 80%;
  border: 1px solid #d1d1d1;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  background-color: white;
}

#first-letter {
  /* border: 3px solid #40a8a0ff; */
  line-height: 40px;
  padding: 20px;
  border-radius: 50%;
  font-size: 2em;
  height: 40px;
  width: 40px;
 color: white;
 background-color: #40a8a0;
}

h3 {
  margin: 0px;
}

.personalities {
  list-style-type: none;
  width: 100%;
}

ul {
  padding: 0;
}

li {
  margin: 0px;
}

@media screen and (min-width: 768px) {
  .pet-card {
    width: 300px;
    /* margin: 5px; */
  }
}

#archive-btn {
  background-color: red;
  border-radius: 5px;
  height: 40px;
  border: none;
  font-size: 16px;
  color: white;
  margin-bottom: 10px;
}

#archive-btn:hover {
  cursor: pointer;
}
</style>