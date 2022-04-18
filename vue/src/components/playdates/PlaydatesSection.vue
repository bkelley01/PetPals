<template>
  <div id="playdates-section-container">
      <button @click="() => {this.$router.push('/playdates/create')}">Create Playdate </button>
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
</style>