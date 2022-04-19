<template>
  <div id="playdates-section-container">
      <!-- <h2>Need Your Own Playdate?</h2>
      <button id="create-playdate" @click="() => {this.$router.push('/playdates/create')}">Create Playdate</button> -->
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

  /* #create-playdate {
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
  } */

</style>