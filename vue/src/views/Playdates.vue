<template>
  <div>
      <playdates-section />
      <pets-filter/>
  </div>
</template>

<script>
import PlaydatesSection from '../components/playdates/PlaydatesSection.vue';
import PetsFilter from '../components/playdates/PetsFilter.vue';

export default {
  components: {
    PlaydatesSection,
    PetsFilter
  }
}

</script>

<style>

</style>