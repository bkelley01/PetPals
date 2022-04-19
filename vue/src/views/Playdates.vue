<template>
  <div>
    <div id="create-playdate-div">
      <h2>Need Your Own Playdate?</h2>
      <button id="create-playdate" @click="() => {this.$router.push('/playdates/create')}">Create Playdate</button>
    </div>

    <div id="pet-mini-cards-div">
      <pet-mini-card />
    </div>
    <div id="playdates-div">
      <div id="playdates-section-div">
        <playdates-section />
      </div>
      <div id="playdates-filter-div">
        <pets-filter/>
      </div>
    </div>
  </div>
</template>

<script>
import PlaydatesSection from '../components/playdates/PlaydatesSection.vue';
import PetsFilter from '../components/playdates/PetsFilter.vue';
import PetMiniCard from '../components/playdates/MiniPetCard.vue';

export default {
  components: {
    PlaydatesSection,
    PetsFilter,
    PetMiniCard
  },
  data() {
    return {
      showPetsOrPlaydates: true
    }
  },
  methods: {
    flipShowPetsOrPlaydates() {
      this.showPetsOrPlaydates = !this.showPetsOrPlaydates;
    }
  }
}

</script>

<style>
#find-toggle-btn {
    display: block;
    background-color: #3399FF;
    width: 250px;
    height: 40px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
}

#create-playdate-div {
  margin: auto;
  margin-bottom: 10px;
  padding: 40px;
  border-radius: 15px;
  width: 300px;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}

#create-playdate {
    display: block;
    background-color: #3399FF;
    width: 250px;
    height: 40px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
  }

</style>