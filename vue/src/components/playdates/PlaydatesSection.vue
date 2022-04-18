<template>
  <div id="playdates-section-container">
      <button>Create Playdate </button>
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