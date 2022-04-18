<template>
  <div id="playdates-section-container">
      <button id="create-playdate"><router-link :to="{ name: 'add-availability' }" id="create-playdate-router">Create Playdate</router-link></button>
      <playdate-filter />
      <!-- <playdates-list /> -->
  </div>
</template>

<script>
import PlaydateFilter from './PlaydateFilter.vue';
// import PlaydatesList from '@/components/playdates/PlaydatesList.vue';

export default {
  components: { 
    PlaydateFilter,
    // PlaydatesList 
    },

}
</script>

<style>
  #playdates-section-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  #create-playdate {
    background-color: #3399FF;
    width: 250px;
    height: 40px;
    margin: auto;
    color: white;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    font-size: 16px;
  }

  #create-playdate-router {
    background-color: #3399FF;
    width: 100px;
    margin: auto;
    color: white;
    text-decoration: none; 
  }
  
</style>