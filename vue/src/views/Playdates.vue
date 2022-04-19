<template>
  <div>
    <pet-mini-card />
    <playdates-section />
     <pets-filter/>
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
  }
}

</script>

<style>

</style>