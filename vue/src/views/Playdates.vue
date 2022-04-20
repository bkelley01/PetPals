<template>
  <div>
    <div id="create-playdate-div">
      <h2>Need Your Own Playdate?</h2>
      <button id="create-playdate" @click="$router.push('/playdates/create')">Create Playdate</button>
    </div>
    <div>
      <h2>{{showPetsOrPlaydates ? "Looking For A Specific PetPal?" : "Looking To Join An Existing Playdate?"}}</h2>
      <button id="switch-btn" v-on:click="flipShowPetsOrPlaydates">{{showPetsOrPlaydates ? "Search Pets" : "Search Playdates"}}</button>
    </div>
    <div id="playdates-div">
      <div id="playdates-section-div" v-show="showPetsOrPlaydates">
        <playdate-filter />
      </div>
      <div id="playdates-filter-div" v-show="!showPetsOrPlaydates">
        <pets-filter/>
      </div>
    </div>
  </div>
</template>

<script>
// import PlaydatesSection from '../components/playdates/PlaydatesSection.vue';
import PetsFilter from '../components/playdates/PetsFilter.vue';
import PlaydateFilter from '@/components/playdates/PlaydateFilter.vue';  //TODO possibly delete playdatessection.vue

export default {
  components: {
    PlaydateFilter,
    PetsFilter
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
  padding: 20px;
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
    background-color: #42B72A;
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

  #switch-btn {
    display: block;
    margin: auto;
    background-color: #3399FF;
    width: 250px;
    height: 40px;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
  }

</style>